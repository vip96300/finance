package com.rw.finance.client.task;

import com.google.gson.Gson;
import com.rw.finance.client.bo.RepayTaskBo;
import com.rw.finance.client.config.ActiveMQConfig;
import com.rw.finance.client.config.SystemSetting;
import com.rw.finance.client.service.*;
import com.rw.finance.common.constants.MemberInfoConstants;
import com.rw.finance.common.constants.OrderInfoConstants;
import com.rw.finance.common.constants.RepayPlanConstants;
import com.rw.finance.common.constants.RepayTaskConstants;
import com.rw.finance.common.entity.*;
import com.rw.finance.common.entity.order.RepayTaskOrder;
import com.rw.finance.common.pay.PayResult;
import com.rw.finance.common.pay.PayerBo;
import com.rw.finance.common.pay.PayerFactory;
import com.rw.finance.common.utils.SmsUtils;
import com.rw.finance.common.utils.UuidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @file RepayTaskExecutor.java
 * @author huanghongfei
 * @date 2017年12月19日 下午8:46:40
 * @declaration
 */
@Component
public class RepayTaskExecutor{

	private static final Logger log=LoggerFactory.getLogger(RepayTaskExecutor.class);

	@Autowired
	private MemberInfoService memberInfoService;
	@Autowired
	private RepayTaskService repayTaskService;
	@Autowired
	private RepayPlanService repayPlanService;
	@Autowired
	private BaseCacheService baseCacheService;
	@Autowired
	private MemberCardService memberCardService;
	@Autowired
	private SystemSetting systemSetting;
	@Autowired
	private PayChannelService payChannelService;
	@Autowired
	private OrderInfoService orderInfoService;
	@Autowired
	private MailService mailService;

	@JmsListener(destination = ActiveMQConfig.REPAY_TASK_QUEUE)
	public void receive(String message){
		RepayTaskBo.Message msg=new Gson().fromJson(message,RepayTaskBo.Message.class);
		new RepayTaskThread(msg.getTaskId()).start();
	}

	/**
	 * 任务线程
	 */
	public class RepayTaskThread extends Thread{
		private long taskId;
		public RepayTaskThread(long taskId){
			this.taskId=taskId;
		}
		@Override
		public void run() {
			//获取互斥锁，分布式定时任务
			if(baseCacheService.incr(RepayTaskConstants.REPAY_TASK_SYNC_+this.taskId)!=1){
				log.info("{}{}",RepayTaskConstants.REPAY_TASK_SYNC_,this.taskId);
				return;
			}
			RepayTask repayTask=repayTaskService.getByTaskid(this.taskId);
			MemberInfo memberInfo=memberInfoService.getByMemberid(repayTask.getMemberId());
			RepayPlan repayPlan=repayPlanService.getByPlanid(repayTask.getPlanId());
			if(repayPlan.getStatus().intValue()!=RepayTaskConstants.Status.STATUS1.getStatus()||repayTask.getStatus().intValue()!=RepayTaskConstants.Status.STATUS0.getStatus()){
				log.info("repay plan status:{},repay task status:{} returning",repayPlan.getStatus(),repayTask.getStatus());
				return;//当前计划非执行中或当前任务非未执行
			}
			MemberCard memberCard=memberCardService.getByMemberidAndCardid(repayPlan.getMemberId(), repayPlan.getCardId());
			//扣款-从信用卡
			if(repayTask.getTaskType().intValue()==RepayTaskConstants.Type.TYPE0.getType()){
				log.info("pay begining...");
				String TradeNo=UuidUtil.TradeNoBuilder(OrderInfoConstants.Prefix.RepayTaskOrder.getPrefix());
				PayResult payResult;
				try {
					//需要等待支付回调
					payResult=new PayResult("200",true,"",TradeNo,"",0);
				}catch (Exception e){
					payResult=new PayResult("500",false,"",TradeNo,"",0);
				}
				if(!payResult.getSuccess()){
					repayTask.setStatus(RepayTaskConstants.Status.STATUS2.getStatus());
					repayTaskService.update(repayTask);
					SmsUtils.sendError(memberInfo.getTelephone(),"扣款任务");
					mailService.send(systemSetting.SYSTEM_MAIL_TASK_TO(),"58还款","扣款任务失败,任务ID:"+repayTask.getTaskId()+",原因:"+payResult.getDetails());
				}
				OrderInfo orderInfo=new OrderInfo(repayTask.getMemberId(),memberInfo.getRealName(),TradeNo,repayTask.getTaskAmount(),repayTask.getActualAmount(),payChannelService.getByIsdef().getChannelId(),payResult.getPayTradeNo(), OrderInfoConstants.Type.RepayTaskOrder.getType(), payResult.getDetails(),
						new Gson().toJson(new RepayTaskOrder(repayPlan.getPlanId(),repayTask.getTaskId())));
				if(!payResult.getSuccess()){
					orderInfo.setStatus(OrderInfoConstants.Status.STATUS2.getStatus());
				}
				orderInfo.setRemark(payResult.getDetails());
				orderInfoService.add(orderInfo);
				log.info("current operation pay, repayTask created orderInfo,the orderInfo status:{}",payResult.getSuccess()?OrderInfoConstants.Status.STATUS1.getStatus():OrderInfoConstants.Status.STATUS0.getStatus());
			}
			//还款-到信用卡
			if(repayTask.getTaskType().intValue()==RepayTaskConstants.Type.TYPE1.getType()){
				log.info("repay begining...");
				String TradeNo=UuidUtil.TradeNoBuilder(OrderInfoConstants.Prefix.RepayTaskOrder.getPrefix());
				//-----------------begin
				PayerBo.OrderInfo oi=new PayerBo().new OrderInfo(TradeNo, "", repayTask.getTaskAmount(),0,new PayerFactory().DefaultPayer().getBackUrl(),"");
				List<RepayTask> repayTasks=repayTaskService.listByMemberidAndPlanidAndBatch(repayTask.getMemberId(), repayTask.getPlanId(),repayTask.getBatch());
				Object[] rts=repayTasks.stream().filter(i  -> {return i.getTaskType().intValue() !=RepayTaskConstants.Type.TYPE1.getType();}).toArray();
				List<String> TradeNoList=new ArrayList<>();
				//统计成功任务的总金额
				double OrderAmount=0;
				//获取订单流水号集合
				for(int i=0;i<rts.length;i++){
					OrderInfo orderInfo=orderInfoService.getByDetailsLike("\"taskId\":"+repayTasks.get(i).getTaskId());
					//如果这个订单是空的,查看下一个
					if(StringUtils.isEmpty(orderInfo)){
						continue;
					}
					if(orderInfo.getStatus().intValue()==OrderInfoConstants.Status.STATUS1.getStatus()){
						TradeNoList.add(orderInfo.getTradeNo());
						//统计
						OrderAmount+=orderInfo.getOrderAmount();
					}
				}
				oi.setRemark(org.apache.commons.lang3.StringUtils.join(TradeNoList,","));
				log.info("order list:{}",oi.getRemark());
				//成功的订单数小于扣款任务数，有失败订单，将成功的订单代还回去
				if(TradeNoList.size()<rts.length){
					oi.setBizAmount(OrderAmount);
					log.info("has failed task,new repay task amount:{}",oi.getBizAmount());
				}
				//-----------------end
				PayResult payResult;
				try {
					//创新代付是马上拿到结果，立即修改状态
					payResult=new PayResult("200",true,"",TradeNo,"",0);
				}catch (Exception e){
					payResult=new PayResult("500",false,"",TradeNo,"",0);
				}
				if(!payResult.getSuccess()){
					SmsUtils.sendError(memberInfo.getTelephone(),"还款任务");
					repayPlan.setStatus(RepayTaskConstants.Status.STATUS2.getStatus());
					repayPlanService.update(repayPlan);
				}
				repayTask.setStatus(payResult.getSuccess()?RepayTaskConstants.Status.STATUS1.getStatus():RepayTaskConstants.Status.STATUS2.getStatus());
				repayTaskService.update(repayTask);
				OrderInfo orderInfo=new OrderInfo(repayTask.getMemberId(),memberInfo.getRealName(),TradeNo,repayTask.getTaskAmount(),repayTask.getActualAmount(),payChannelService.getByIsdef().getChannelId(),payResult.getPayTradeNo(), OrderInfoConstants.Type.RepayTaskOrder.getType(), payResult.getDetails(),
						new Gson().toJson(new RepayTaskOrder(repayPlan.getPlanId(),repayTask.getTaskId())));
				orderInfo.setStatus(payResult.getSuccess()?OrderInfoConstants.Status.STATUS1.getStatus():OrderInfoConstants.Status.STATUS2.getStatus());
				orderInfo.setRemark(payResult.getDetails());
				//任务金额被修改，同时修改订单金额
				if(TradeNoList.size()<rts.length){
					orderInfo.setOrderAmount(OrderAmount);
					orderInfo.setRemark("还款任务失败,已修改订单金额");
				}
				orderInfoService.add(orderInfo);
				log.info("current operation repay, repayTask created orderInfo,the orderInfo status:{}",payResult.getSuccess()?OrderInfoConstants.Status.STATUS1.getStatus():OrderInfoConstants.Status.STATUS0.getStatus());
				//验证所有任务是否已执行完,如果执行完后将计划状态设为已完成
				repayTasks=repayTaskService.listByMemberidAndPlanidAndBatch(repayTask.getMemberId(), repayTask.getPlanId(), repayTask.getBatch().intValue()+1);
				if(repayTasks.isEmpty()&&repayPlan.getStatus().intValue()==RepayPlanConstants.Status.STATUS1.getStatus()){
					//已经是还款任务，下一批数据已空,修改状态为已完成
					repayPlan.setStatus(RepayPlanConstants.Status.STATUS9.getStatus());
					repayPlanService.update(repayPlan);
				}
			}
		}
	}

}
