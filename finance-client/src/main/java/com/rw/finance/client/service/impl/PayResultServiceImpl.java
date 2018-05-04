package com.rw.finance.client.service.impl;

import com.google.gson.Gson;
import com.rw.finance.common.constants.*;
import com.rw.finance.client.dao.*;
import com.rw.finance.common.entity.*;
import com.rw.finance.common.entity.order.*;
import com.rw.finance.common.pass.chuangxin.ChuangXinPay;
import com.rw.finance.common.pay.*;
import com.rw.finance.client.service.*;
import com.rw.finance.common.utils.DateUtils;
import com.rw.finance.common.utils.MathUtils;
import com.rw.finance.common.utils.SmsUtils;
import com.rw.finance.common.utils.UuidUtil;
import com.rw.finance.client.config.SystemSetting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * 
 * @file PayResultServiceImpl.java	
 * @author huanghongfei
 * @date 2018年1月12日 上午11:53:13
 * @declaration
 */
@Service
public class PayResultServiceImpl implements PayResultService{

	private static final Logger log=LoggerFactory.getLogger(PayResultServiceImpl.class);
	
	@Autowired
	private OrderInfoMapper orderInfoMapper;
	@Autowired
	private MemberInfoMapper memberInfoMapper;
	@Autowired
	private AgentInfoMapper agentInfoMapper;
	@Autowired
	private RepayPlanMapper repayPlanMapper;
	@Autowired
	private RepayTaskMapper repayTaskMapper;
	@Autowired
	private MemberLevelMapper memberLevelMapper;
	@Autowired
	private SystemSetting systemSetting;
	@Autowired
	private MemberProfitService memberProfitService;
	@Autowired
	private AgentProfitService agentProfitService;
	@Autowired
	private MemberAccountMapper memberAccountMapper;
	@Autowired
	private AgentAccountMapper AgentAccountMapper;
	@Autowired
	private MemberCardMapper memberCardMapper;
	@Autowired
	private PayChannelMapper payChannelMapper;
	@Autowired
	private OrderCountMapper orderCountMapper;
	@Autowired
	private MemberCardService memberCardService;
	@Autowired
	private MailService mailService;

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void chuangXinPayBack(String tradeNo,String cxOrderNo,String dealCode,String dealMsg) {
		com.rw.finance.common.entity.OrderInfo orderInfo=orderInfoMapper.selectByTradeNo(tradeNo);
		if(orderInfo.getStatus().intValue()!=OrderInfoConstants.Status.STATUS0.getStatus()){
			log.info("order info excuted,tradeNo:{}",tradeNo);
		}
		orderInfo.setRemark(dealMsg);
		int status=dealCode.equals("10000")?OrderInfoConstants.Status.STATUS1.getStatus():OrderInfoConstants.Status.STATUS2.getStatus();
		orderInfo.setStatus(status);
		orderInfo.setOutTradeNo(cxOrderNo);
		orderInfo.setUpdateTime(DateUtils.getTimeStr(new Date()));
		orderInfoMapper.updateByPrimaryKey(orderInfo);
		this.success(orderInfo);
	}

	@Override
	public void yeeBaoPayBack(String TradeNo) {
		PayResult payResult=new PayerFactory().YeeBaoPayPayer().queryOrder(new PayerBo().new OrderInfo(TradeNo, "", 0D,0, new YeeBaoPayer().getBackUrl(),""));
		OrderInfo orderInfo=orderInfoMapper.selectByTradeNo(TradeNo);
		if(orderInfo.getStatus().intValue()!=OrderInfoConstants.Status.STATUS0.getStatus()){
			log.info("order info excuted,TradeNo:{}",TradeNo);
			return ;
		}
		orderInfo.setStatus(payResult.getSuccess()?OrderInfoConstants.Status.STATUS1.getStatus():OrderInfoConstants.Status.STATUS2.getStatus());
		orderInfo.setOutTradeNo(StringUtils.isEmpty(payResult.getPayTradeNo())?orderInfo.getOutTradeNo():payResult.getPayTradeNo());
		orderInfo.setUpdateTime(DateUtils.getTimeStr(new Date()));
		orderInfoMapper.updateByPrimaryKey(orderInfo);
		this.success(orderInfo);
	}

	@Override
	public void yeeBao2PayBack(String TradeNo) {
		OrderInfo orderInfo=orderInfoMapper.selectByTradeNo(TradeNo);
		if(orderInfo.getStatus().intValue()!=OrderInfoConstants.Status.STATUS0.getStatus()){
			log.info("order info excuted,TradeNo:{}",TradeNo);
			return ;
		}
		PayResult payResult=new YeeBao2Payer().queryOrder(new PayerBo().new OrderInfo(TradeNo,orderInfo.getOutTradeNo(), 0,0, new YeeBao2Payer().getBackUrl(),""));
		orderInfo.setStatus(payResult.getSuccess()?OrderInfoConstants.Status.STATUS1.getStatus():OrderInfoConstants.Status.STATUS2.getStatus());
		orderInfo.setOutTradeNo(StringUtils.isEmpty(payResult.getPayTradeNo())?orderInfo.getOutTradeNo():payResult.getPayTradeNo());
		orderInfo.setUpdateTime(DateUtils.getTimeStr(new Date()));
		orderInfoMapper.updateByPrimaryKey(orderInfo);
		this.success(orderInfo);
	}

	@Override
	public void yeeBao2AgentPayBack(String TradeNo) {
		OrderInfo orderInfo=orderInfoMapper.selectByTradeNo(TradeNo);
		if(orderInfo.getStatus().intValue()!=OrderInfoConstants.Status.STATUS0.getStatus()){
			log.info("order info excuted,TradeNo:{}",TradeNo);
			return ;
		}
		PayResult payResult=new YeeBao2Payer().queryAgentOrder(new PayerBo().new OrderInfo(TradeNo,orderInfo.getOutTradeNo(), 0,0, new YeeBao2Payer().getBackUrl(),""));
		orderInfo.setStatus(payResult.getSuccess()?OrderInfoConstants.Status.STATUS1.getStatus():OrderInfoConstants.Status.STATUS2.getStatus());
		orderInfo.setOutTradeNo(StringUtils.isEmpty(payResult.getPayTradeNo())?orderInfo.getOutTradeNo():payResult.getPayTradeNo());
		orderInfo.setUpdateTime(DateUtils.getTimeStr(new Date()));
		orderInfoMapper.updateByPrimaryKey(orderInfo);
		this.success(orderInfo);
	}

	@Override
	public void jdsoftPayBack(String TradeNo) {
		OrderInfo orderInfo=orderInfoMapper.selectByTradeNo(TradeNo);
		if(orderInfo.getStatus().intValue()!=OrderInfoConstants.Status.STATUS0.getStatus()){
			log.info("order info excuted,TradeNo:{}",TradeNo);
			return ;
		}
		PayResult payResult=new JdsoftPayer().queryOrder(new PayerBo().new OrderInfo(TradeNo,orderInfo.getOutTradeNo(),orderInfo.getOrderAmount(),0, new JdsoftPayer().getBackUrl(),""));
		orderInfo.setStatus(payResult.getSuccess()?OrderInfoConstants.Status.STATUS1.getStatus():OrderInfoConstants.Status.STATUS2.getStatus());
		orderInfo.setOutTradeNo(StringUtils.isEmpty(payResult.getPayTradeNo())?orderInfo.getOutTradeNo():payResult.getPayTradeNo());
		orderInfo.setUpdateTime(DateUtils.getTimeStr(new Date()));
		orderInfoMapper.updateByPrimaryKey(orderInfo);
		//套现订单
		if(orderInfo.getType().intValue()==OrderInfoConstants.Type.MemberBorrowOrder.getType()){
			MemberBorrowOrder memberBorrowOrder=new Gson().fromJson(orderInfo.getDetails(), MemberBorrowOrder.class);
			//绝顶支付是一步操作，直接扣款收款同时成功
			if(orderInfo.getStatus().intValue()==OrderInfoConstants.Status.STATUS1.getStatus()){
				MemberBorrowOrder copyMemberBorrowOrder=new MemberBorrowOrder(memberBorrowOrder.getChannelId(),memberBorrowOrder.getFromCardId(), memberBorrowOrder.getToCardId(), memberBorrowOrder.getPoundage());
				copyMemberBorrowOrder.setFromSucc(0);
				copyMemberBorrowOrder.setToSucc(1);
				orderInfo.setDetails(new Gson().toJson(copyMemberBorrowOrder));
				orderInfoMapper.updateByPrimaryKey(orderInfo);
				//增加会员总收款金额
				memberAccountMapper.addBorrowTotal(orderInfo.getUserId(),orderInfo.getOrderAmount());
				//收款分润
				MemberInfo memberInfo=memberInfoMapper.selectByPrimaryKey(orderInfo.getUserId());
				double memberProfitTotal=0;
				if(payResult.getSuccess()&&!StringUtils.isEmpty(memberInfo.getParentId())){
					memberProfitTotal=this.borrowMemberProfit(memberInfo.getParentId(), memberInfo, orderInfo, 1, 2,memberProfitTotal);
				}
				double agentProfitTotal=0;
				if(payResult.getSuccess()&&!StringUtils.isEmpty(memberInfo.getAgentId())){//代理分润
					agentProfitTotal=this.borrowAgentProfit(memberInfo.getAgentId(), memberInfo, orderInfo, memberProfitTotal,agentProfitTotal,0);
				}
				if(orderInfo.getStatus().intValue()==OrderInfoConstants.Status.STATUS1.getStatus()){
					double companyProfitTotal=MathUtils.subtract(new Gson().fromJson(orderInfo.getDetails(),MemberBorrowOrder.class).getPoundage(),memberProfitTotal);
					companyProfitTotal=MathUtils.subtract(companyProfitTotal, agentProfitTotal);
					orderCountMapper.insert(new OrderCount(orderInfo.getTradeNo(),OrderCountConstants.TradeType.MemberBorrow.getTradeType(), orderInfo.getRealAmount(), memberProfitTotal,agentProfitTotal,companyProfitTotal));
				}
			}
		}
	}

	/**
	 * 递归计算代理收益
	 * @param AgentId 父代理编号
	 * @param memberInfo 会员信息
	 * @param orderInfo 订单信息
	 * @param memberProfitTotal 计算代理收益时需减去会员总收益
	 * @return 代理总收益
	 */
	private double repayTaskAgentProfit(long AgentId,MemberInfo memberInfo,OrderInfo orderInfo,double memberProfitTotal,double agentProfitTotal,double lastAgentProfitRate){
		AgentInfo parent=agentInfoMapper.selectByPrimaryKey(AgentId);
		if(StringUtils.isEmpty(parent)){
			return agentProfitTotal;
		}
		//代理分润=总费率减去支付平台费率乘以代理等级结算费率
		AgentAccount agentAccount=AgentAccountMapper.selectByAgentId(parent.getAgentId());
		double repayShareRate=agentAccount.getRepayShareRate();
		if(!StringUtils.isEmpty(parent.getParentId())&&memberInfo.getAgentId().longValue()!=AgentId){//非直属代理
			repayShareRate=agentAccount.getRepayShareRate().doubleValue()-lastAgentProfitRate;
			memberProfitTotal=0;//非直属代理不承担会员分润
		}
		//会员还款代理分润比例乘以总金额，再乘以代理分润比例，最后减去会员总分润
		double agentProfit=MathUtils.multiply(MathUtils.multiply(orderInfo.getOrderAmount(),systemSetting.MEMBER_REPAY_AGENT_PROFIT_TOTAL_RATE()),repayShareRate);
		agentProfit=MathUtils.subtract(agentProfit,memberProfitTotal)<0?0:MathUtils.subtract(agentProfit,memberProfitTotal);//直属代理承担会员分润，如果不是直属代理，会员分润为0
		agentProfitTotal=MathUtils.add(agentProfitTotal,agentProfit);
		agentProfitService.add(new AgentProfit(parent.getAgentId(),memberInfo.getMemberId(),orderInfo.getOrderId(),orderInfo.getTradeNo(),agentAccount.getRepayShareRate() ,orderInfo.getOrderAmount(), agentProfit,AgentProfitConstants.Type.RepayTaskProfit.getType()));
		//逻辑结束，递归调用
		if(StringUtils.isEmpty(parent.getParentId())){
			return agentProfitTotal;
		}
		lastAgentProfitRate=agentAccount.getRepayShareRate();
		this.repayTaskAgentProfit(parent.getParentId(),memberInfo,orderInfo,memberProfitTotal,agentProfitTotal,lastAgentProfitRate);
		return agentProfitTotal;
	}
	
	/**
	 * 递归调用，计算会员收益
	 * @param memberid 父会员编号
	 * @param memberInfo 会员信息
	 * @param INITIAL_LEVEL 初始化向上等级高度
	 * @param HEIGHT_LEVEL 最高向上等级高度
	 */
	private double repayTaskMemberProfit(long memberid,MemberInfo memberInfo,OrderInfo orderInfo,int INITIAL_LEVEL,int HEIGHT_LEVEL,double memberProfitTotal){
		MemberInfo parent=memberInfoMapper.selectByPrimaryKey(memberid);
		if(StringUtils.isEmpty(parent)){
			return memberProfitTotal;
		}
		double memerProfit=MathUtils.multiply(orderInfo.getOrderAmount(),systemSetting.MEMBER_PROFIT_REPAY_LEVEL_RATE(INITIAL_LEVEL));//用户等级级分润
		memberProfitTotal=MathUtils.add(memberProfitTotal, memerProfit);//叠加会员总收益
		memberProfitService.add(new MemberProfit(
				parent.getMemberId(),
				memberInfo.getMemberId(),//产生这比利润的会员编号
				memberInfo.getTelephone(),//贡献账户
				MemberProfitConstants.BizType.RepayTaskProfit.getBizType(), 
				orderInfo.getOrderAmount(),
				memerProfit, //收益
				orderInfo.getTradeNo(),
				INITIAL_LEVEL++));
		log.info("repayTask created memberProfit:{} by level:{} for memberid:{} in repayTask.taskamount:{}",memerProfit,MemberProfitConstants.Level.LEVEL1.getLevel(),memberInfo.getMemberId(),orderInfo.getOrderAmount());
		if(INITIAL_LEVEL>HEIGHT_LEVEL||StringUtils.isEmpty(parent.getParentId())){
			return memberProfitTotal;//超过最高树的高度，递归结束
		}
		memberProfitTotal=this.repayTaskMemberProfit(parent.getParentId(), memberInfo,orderInfo,INITIAL_LEVEL,HEIGHT_LEVEL,memberProfitTotal);
		return memberProfitTotal;
	}
	/**
	 * 递归向上计算激活的代理收益,只有在线支付激活才存在分润
	 * @param memberInfo
	 * @param memberProfitTotal 会员总分润，计算代理收益时需减去会员总分润
	 * @param lastAgentProfitRate 分润是从低级代理到高级代理的顺序，该参数代表最后一个分润的比例
	 */
	private double activeAgentProfit(long AgentId,MemberInfo memberInfo,OrderInfo orderInfo,double memberProfitTotal,double agentProfitTotal,double lastAgentProfitRate){
		AgentInfo parent=agentInfoMapper.selectByPrimaryKey(AgentId);
		if(StringUtils.isEmpty(parent)){
			return agentProfitTotal;
		}
		AgentAccount agentAccount=AgentAccountMapper.selectByAgentId(parent.getAgentId());//当前代理的账户
		double activeShareRate=agentAccount.getActivateShareRate();
		if(!StringUtils.isEmpty(parent.getParentId())&&memberInfo.getAgentId().longValue()!=AgentId){//非直属代理
			activeShareRate=agentAccount.getActivateShareRate().doubleValue()-lastAgentProfitRate;
			memberProfitTotal=0;//非直属代理不承担会员分润
		}
		double agentProfit=MathUtils.multiply(orderInfo.getOrderAmount(),activeShareRate);//我们承担支付平台费用
		agentProfit=MathUtils.subtract(agentProfit,memberProfitTotal)<0?0:MathUtils.subtract(agentProfit,memberProfitTotal);//直属代理承担会员分润，如果不是直属代理，会员分润为0
		agentProfitTotal=MathUtils.add(agentProfitTotal, agentProfit);
		agentProfitService.add(new AgentProfit(parent.getAgentId(), memberInfo.getMemberId(),orderInfo.getOrderId(),orderInfo.getTradeNo(), agentAccount.getActivateShareRate(), orderInfo.getOrderAmount(), agentProfit, AgentProfitConstants.Type.MemberActiveProfit.getType()));
		if(StringUtils.isEmpty(parent.getParentId())){
			return agentProfitTotal;
		}
		//当前代理分润比例
		lastAgentProfitRate=agentAccount.getActivateShareRate();
		agentProfitTotal=this.activeAgentProfit(parent.getParentId(), memberInfo,orderInfo,memberProfitTotal,agentProfitTotal,lastAgentProfitRate);
		return agentProfitTotal;
	}
	/**
	 * 递归向上计算激活的邀请会员收益，只有在线激活才会存在，向上查找2层
	 * @param memberId
	 * @param memberInfo
	 * @param memberProfitTotal 统计会员总分润
	 */
	private double activeMemberProfit(long memberId,MemberInfo memberInfo,OrderInfo orderInfo,int INITIAL_LEVEL,int HEIGHT_LEVEL,double memberProfitTotal){
		MemberInfo parent=memberInfoMapper.selectByPrimaryKey(memberId);
		if(StringUtils.isEmpty(parent)){
			return memberProfitTotal;
		}
		//用户等级级分润
		double activeProfitRate=memberInfo.getParentId().longValue()==parent.getMemberId().longValue()?systemSetting.MEMBER_PROFIT_ACTIVE_LEVEL_RATE_D(parent.getLevel()):systemSetting.MEMBER_PROFIT_ACTIVE_LEVEL_RATE_DD(parent.getLevel());
		//直属父类？分得下级收益比例：分得下下级收益比例
		double memerProfit=MathUtils.multiply(orderInfo.getOrderAmount(),activeProfitRate);
		memberProfitTotal=MathUtils.add(memberProfitTotal, memerProfit);
		memberProfitService.add(new MemberProfit(
				parent.getMemberId(),
				memberInfo.getMemberId(),
				memberInfo.getTelephone(),
				MemberProfitConstants.BizType.MemberActiveProfit.getBizType(), 
				orderInfo.getOrderAmount(),
				memerProfit,
				orderInfo.getTradeNo(),
				INITIAL_LEVEL++));
		if(INITIAL_LEVEL>HEIGHT_LEVEL||StringUtils.isEmpty(parent.getParentId())){
			//超过最高树的高度，递归结束
			return memberProfitTotal;
		}
		memberProfitTotal=this.activeMemberProfit(parent.getParentId(), memberInfo, orderInfo,INITIAL_LEVEL,HEIGHT_LEVEL,memberProfitTotal);
		return memberProfitTotal;
	}
	/**
	 * 递归计算代理收益
	 * @param AgentId 父代理编号
	 * @param memberInfo 会员信息
	 * @param orderInfo 订单信息
	 * @param memberProfitTotal 计算代理收益时需减去会员总收益
	 */
	private double borrowAgentProfit(long AgentId,MemberInfo memberInfo,OrderInfo orderInfo,double memberProfitTotal,double agentProfitTotal,double lastAgentProfitRate){
		AgentInfo parent=agentInfoMapper.selectByPrimaryKey(AgentId);
		if(StringUtils.isEmpty(parent)){
			return agentProfitTotal;
		}
		//代理分润=总费率减去支付平台费率乘以代理等级结算费率
		AgentAccount agentAccount=AgentAccountMapper.selectByAgentId(parent.getAgentId());
		double BorrowShareRate=agentAccount.getBorrowShareRate();
		if(!StringUtils.isEmpty(parent.getParentId())&&memberInfo.getAgentId().longValue()!=AgentId){//非直属代理
			BorrowShareRate=agentAccount.getBorrowShareRate().doubleValue()-lastAgentProfitRate;
			memberProfitTotal=0;//非直属代理不承担会员分润
		}
		//总利润减去支付平台利润，减去会员分享总分润，最后乘代理分享分润比例
		double agentProfit=MathUtils.multiply(orderInfo.getOrderAmount(),BorrowShareRate);
		agentProfit=MathUtils.subtract(agentProfit,memberProfitTotal)<0?0:MathUtils.subtract(agentProfit,memberProfitTotal);//直属代理承担会员分润，如果不是直属代理，会员分润为0
		agentProfitTotal=MathUtils.add(agentProfitTotal,agentProfit);
		agentProfitService.add(new AgentProfit(parent.getAgentId(),memberInfo.getMemberId(),orderInfo.getOrderId(),orderInfo.getTradeNo(),agentAccount.getBorrowShareRate() ,orderInfo.getOrderAmount(), agentProfit,AgentProfitConstants.Type.MemberBorrowProfit.getType()));
		//逻辑结束，递归调用
		if(StringUtils.isEmpty(parent.getParentId())){
			return agentProfitTotal;
		}
		lastAgentProfitRate=agentAccount.getBorrowShareRate();
		agentProfitTotal=this.borrowAgentProfit(parent.getParentId(),memberInfo,orderInfo,memberProfitTotal,agentProfitTotal,lastAgentProfitRate);
		return agentProfitTotal;
	}
	/**
	 * 会员套现邀请者分润
	 * @param memberid
	 * @param memberInfo
	 * @param INITIAL_LEVEL
	 * @param HEIGHT_LEVEL
	 */
	private double borrowMemberProfit(long memberid,MemberInfo memberInfo,OrderInfo orderInfo,int INITIAL_LEVEL,int HEIGHT_LEVEL,double memberProfitTotal){
		MemberInfo parent=memberInfoMapper.selectByPrimaryKey(memberid);
		if(StringUtils.isEmpty(parent)){
			return memberProfitTotal;
		}
		//邀请用户分润=总费率减去支付平台费率然后乘以1级代理用户分润利率
		double memerProfit=MathUtils.multiply(orderInfo.getOrderAmount(),systemSetting.MEMBER_PROFIT_BORROW_LEVEL_RATE(INITIAL_LEVEL));//用户等级级分润
		memberProfitTotal=MathUtils.add(memberProfitTotal, memerProfit);
		memberProfitService.add(new MemberProfit(
				parent.getMemberId(),
				memberInfo.getMemberId(),//产生这比利润的会员编号
				memberInfo.getTelephone(),//贡献账户
				MemberProfitConstants.BizType.MemberBorrowProfit.getBizType(), 
				orderInfo.getOrderAmount(),
				memerProfit, //收益
				orderInfo.getTradeNo(),
				INITIAL_LEVEL++));
		if(INITIAL_LEVEL>HEIGHT_LEVEL||StringUtils.isEmpty(parent.getParentId())){
			return memberProfitTotal;//超过最高树的高度，递归结束
		}
		memberProfitTotal=this.borrowMemberProfit(parent.getParentId(), memberInfo,orderInfo,INITIAL_LEVEL,HEIGHT_LEVEL,memberProfitTotal);
		return memberProfitTotal;
	}
	/**
	 * 会员提现邀请会员分润
	 * @param memberid
	 * @param memberInfo
	 * @param INITIAL_LEVEL
	 * @param HEIGHT_LEVEL
	 */
	public double cashMemberProfit(long memberid,MemberInfo memberInfo,OrderInfo orderInfo,int INITIAL_LEVEL,int HEIGHT_LEVEL,double memberProfitTotal){
		MemberInfo parent=memberInfoMapper.selectByPrimaryKey(memberid);
		if(StringUtils.isEmpty(parent)){
			return memberProfitTotal;
		}
		//邀请用户分润=总费率减去支付平台费率然后乘以1级代理用户分润利率
		double memerProfit=MathUtils.multiply(orderInfo.getOrderAmount(),systemSetting.MEMBER_PROFIT_CASH_LEVEL_RATE(INITIAL_LEVEL));//用户等级级分润
		memberProfitTotal=MathUtils.add(memberProfitTotal,memerProfit);
		memberProfitService.add(new MemberProfit(
				parent.getMemberId(),
				memberInfo.getMemberId(),//产生这比利润的会员编号
				memberInfo.getTelephone(),//贡献账户
				MemberProfitConstants.BizType.MemberCashProfit.getBizType(), 
				orderInfo.getOrderAmount(),
				memerProfit, //收益
				orderInfo.getTradeNo(),
				INITIAL_LEVEL++));
		if(INITIAL_LEVEL>HEIGHT_LEVEL||StringUtils.isEmpty(parent.getParentId())){
			return memberProfitTotal;//超过最高树的高度，递归结束
		}
		memberProfitTotal=this.cashMemberProfit(parent.getParentId(), memberInfo,orderInfo,INITIAL_LEVEL,HEIGHT_LEVEL,memberProfitTotal);
		return memberProfitTotal;
	}
	
	/**
	 * 处理支付成功逻辑
	 * @return
	 */
	private void success(OrderInfo orderInfo){
		//还款任务订单
		if(orderInfo.getType().intValue()==OrderInfoConstants.Type.RepayTaskOrder.getType()){
			RepayTask repayTask=repayTaskMapper.selectByPrimaryKey(new Gson().fromJson(orderInfo.getDetails(),RepayTaskOrder.class).getTaskId());
			if(repayTask.getTaskType().intValue()==RepayTaskConstants.Type.TYPE1.getType()){
				return;//忽略还款任务回调
			}
			int repayTaskStatus=orderInfo.getStatus().intValue()==RepayTaskConstants.Status.STATUS1.getStatus()?RepayTaskConstants.Status.STATUS1.getStatus():RepayTaskConstants.Status.STATUS2.getStatus();
			repayTask.setStatus(repayTaskStatus);
			repayTaskMapper.updateByPrimaryKey(repayTask);
			MemberInfo memberInfo=memberInfoMapper.selectByPrimaryKey(orderInfo.getUserId());
			//任务失败发送消息给会员
			if(repayTaskStatus!=RepayTaskConstants.Status.STATUS1.getStatus()){
				SmsUtils.sendError(memberInfo.getTelephone(),"还款任务");
				mailService.send(systemSetting.SYSTEM_MAIL_TASK_TO(),"58还款","扣款任务失败,任务ID:"+repayTask.getTaskId());
			}
			//开始计算会员收益,向上查找
			double memberProfitTotal=0;//会员总分润，代理分润时需要在总利润里面扣除会员分享总分润
			if(!StringUtils.isEmpty(memberInfo.getParentId())&&orderInfo.getStatus().intValue()==OrderInfoConstants.Status.STATUS1.getStatus()&&repayTask.getTaskType().intValue()==RepayTaskConstants.Type.TYPE0.getType()){
				memberProfitTotal=this.repayTaskMemberProfit(memberInfo.getParentId(), memberInfo,orderInfo,1,2,memberProfitTotal);
			}
			//开始计算代理收益
			double agentProfitTotal=0;//代理总收益
			if(!StringUtils.isEmpty(memberInfo.getAgentId())&&orderInfo.getStatus().intValue()==OrderInfoConstants.Status.STATUS1.getStatus()&&repayTask.getTaskType().intValue()==RepayTaskConstants.Type.TYPE0.getType()){
				agentProfitTotal=this.repayTaskAgentProfit(memberInfo.getAgentId(),memberInfo,orderInfo,memberProfitTotal,agentProfitTotal,0);
			}
			//统计
			if(orderInfo.getStatus().intValue()==OrderInfoConstants.Status.STATUS1.getStatus()){
				double companyProfitTotal=MathUtils.subtract(repayTask.getPoundage(),MathUtils.add(memberProfitTotal, agentProfitTotal));
				orderCountMapper.insert(new OrderCount(orderInfo.getTradeNo(),OrderCountConstants.TradeType.RepayTask.getTradeType(), orderInfo.getRealAmount(), memberProfitTotal, agentProfitTotal,companyProfitTotal));
				//增加会员总收款金额
				memberAccountMapper.addRepayTotal(orderInfo.getUserId(),orderInfo.getOrderAmount());
			}
		}
		//会员提现订单
		if(orderInfo.getType().intValue()==OrderInfoConstants.Type.MemberCashOrder.getType()){
			MemberAccount memberAccount=memberAccountMapper.selectByMemberId(orderInfo.getUserId());
			if(orderInfo.getStatus().intValue()==OrderInfoConstants.Status.STATUS1.getStatus()){//成功，减去锁定余额
				memberAccount.setLockBalance(MathUtils.subtract(memberAccount.getLockBalance(),orderInfo.getRealAmount()));
				//添加会员提现总金额
				memberAccountMapper.addCashTotal(orderInfo.getUserId(),orderInfo.getOrderAmount());
			}else{//失败，将锁定余额返还到可用余额
				memberAccount.setLockBalance(MathUtils.subtract(memberAccount.getLockBalance(),orderInfo.getRealAmount()));
				memberAccount.setUsableBalance(MathUtils.add(memberAccount.getUsableBalance(), orderInfo.getRealAmount()));
			}
			memberAccountMapper.updateByPrimaryKey(memberAccount);
			//会员提现分润
			MemberInfo memberInfo=memberInfoMapper.selectByPrimaryKey(orderInfo.getUserId());
			double memberProfitTotal=0;
			if(orderInfo.getStatus().intValue()==OrderInfoConstants.Status.STATUS1.getStatus()&&!StringUtils.isEmpty(memberInfo.getParentId())){
				memberProfitTotal=this.cashMemberProfit(memberInfo.getParentId(), memberInfo, orderInfo, 1, 2,memberProfitTotal);
			}
			if(orderInfo.getStatus().intValue()==OrderInfoConstants.Status.STATUS1.getStatus()){
				double companyProfitTotal=MathUtils.subtract(new Gson().fromJson(orderInfo.getDetails(),MemberCashOrder.class).getPoundage(),memberProfitTotal);
				orderCountMapper.insert(new OrderCount(orderInfo.getTradeNo(),OrderCountConstants.TradeType.MemberCash.getTradeType(), orderInfo.getRealAmount(), memberProfitTotal, 0,companyProfitTotal));
			}

		}
		//收款订单(套现)
		if(orderInfo.getType().intValue()==OrderInfoConstants.Type.MemberBorrowOrder.getType()){
			MemberBorrowOrder memberBorrowOrder=new Gson().fromJson(orderInfo.getDetails(), MemberBorrowOrder.class);
			//扣款未成功，并且这次回调为订单交易成功，说明扣款成功
			if(memberBorrowOrder.getFromSucc()==0&&orderInfo.getStatus().intValue()==OrderInfoConstants.Status.STATUS1.getStatus()){
				MemberBorrowOrder copyMemberBorrowOrder=new MemberBorrowOrder(memberBorrowOrder.getChannelId(),memberBorrowOrder.getFromCardId(), memberBorrowOrder.getToCardId(), memberBorrowOrder.getPoundage());
				copyMemberBorrowOrder.setFromSucc(1);
				orderInfo.setDetails(new Gson().toJson(copyMemberBorrowOrder));
				orderInfoMapper.updateByPrimaryKey(orderInfo);
				//扣款成功，向会员储蓄卡账户打钱
				MemberCard memberCard=memberCardMapper.selectByPrimaryKey(memberBorrowOrder.getToCardId());
				String TradeNo=UuidUtil.TradeNoBuilder(OrderInfoConstants.Prefix.MemberBorrowOrder.getPrefix());
				PayerBo.OrderInfo oi=new PayerBo().new OrderInfo(TradeNo,"",orderInfo.getRealAmount(),0,new PayerFactory().DefaultPayer().getBackUrl(),"");
				oi.setRemark(orderInfo.getTradeNo());
				PayResult payResult=new PayerFactory().DefaultPayer().repay(new PayerBo().new UserInfo(memberCard.getIdNumber(),memberCard.getRealName()),
						new PayerBo().new CardInfo(memberCard.getBankName(),memberCard.getProvince(),memberCard.getCity(),memberCard.getAbbreviation(),memberCard.getCardNo(), memberCard.getMobile(), memberCard.getAuthCode(), memberCard.getExpiryDate()),
						oi);
				MemberBorrowOrder repayMemberBorrowOrder=new MemberBorrowOrder(memberBorrowOrder.getChannelId(),memberBorrowOrder.getFromCardId(), memberBorrowOrder.getToCardId(),0);
				MemberInfo memberInfo=memberInfoMapper.selectByPrimaryKey(orderInfo.getUserId());
				if(payResult.getSuccess()){
					repayMemberBorrowOrder.setToSucc(1);
				}else{
					SmsUtils.sendError(memberInfo.getTelephone(),"收款操作");
				}
				OrderInfo repayOrderInfo=new OrderInfo(orderInfo.getUserId(),memberInfo.getRealName(), TradeNo, orderInfo.getRealAmount(), //这次订单为付款给会员
						orderInfo.getOrderAmount(),payChannelMapper.selectByIsDef(1).getChannelId(), "", OrderInfoConstants.Type.MemberBorrowOrder.getType(),"",
						new Gson().toJson(repayMemberBorrowOrder));
				//创新支付会马上拿到同名代付结果
				repayOrderInfo.setStatus(payResult.getSuccess()?OrderInfoConstants.Status.STATUS1.getStatus():OrderInfoConstants.Status.STATUS2.getStatus());
				repayOrderInfo.setRemark(payResult.getDetails());
				orderInfoMapper.insert(repayOrderInfo);
				//增加会员总收款金额
				memberAccountMapper.addBorrowTotal(orderInfo.getUserId(),orderInfo.getOrderAmount());
				double memberProfitTotal=0;
				if(payResult.getSuccess()&&!StringUtils.isEmpty(memberInfo.getParentId())){
					memberProfitTotal=this.borrowMemberProfit(memberInfo.getParentId(), memberInfo, orderInfo, 1, 2,memberProfitTotal);
				}
				double agentProfitTotal=0;
				if(payResult.getSuccess()&&!StringUtils.isEmpty(memberInfo.getAgentId())){//代理分润
					agentProfitTotal=this.borrowAgentProfit(memberInfo.getAgentId(), memberInfo, repayOrderInfo, memberProfitTotal,agentProfitTotal,0);
				}
				if(repayOrderInfo.getStatus().intValue()==OrderInfoConstants.Status.STATUS1.getStatus()){
					double companyProfitTotal=MathUtils.subtract(new Gson().fromJson(orderInfo.getDetails(),MemberBorrowOrder.class).getPoundage(),memberProfitTotal);
					companyProfitTotal=MathUtils.subtract(companyProfitTotal, agentProfitTotal);
					orderCountMapper.insert(new OrderCount(orderInfo.getTradeNo(),OrderCountConstants.TradeType.MemberBorrow.getTradeType(), orderInfo.getRealAmount(), memberProfitTotal,agentProfitTotal,companyProfitTotal));
				}
			}
		}
		//会员在线支付激活订单
		if(orderInfo.getType().intValue()==OrderInfoConstants.Type.MemberActiveOrder.getType()&&orderInfo.getStatus().intValue()==OrderInfoConstants.Status.STATUS1.getStatus()){
			MemberInfo memberInfo=memberInfoMapper.selectByPrimaryKey(orderInfo.getUserId());
			memberInfo.setLevel(new Gson().fromJson(orderInfo.getDetails(),MemberActiveOrder.class).getActiveLevel());
			memberInfo.setLevelTime(MemberInfoConstants.LEVEL_TIME_DEFAULT);
			memberInfo.setActiveTime(DateUtils.getTimeStr(new Date()));
			memberInfoMapper.updateByPrimaryKey(memberInfo);
			double memberProfitTotal=0;
			if(!StringUtils.isEmpty(memberInfo.getParentId())){//分享会员分润
				memberProfitTotal=this.activeMemberProfit(memberInfo.getParentId(), memberInfo,orderInfo, 1, 2,memberProfitTotal);
			}
			double agentProfitTotal=0;
			if(!StringUtils.isEmpty(memberInfo.getAgentId())){//代理分润
				agentProfitTotal=this.activeAgentProfit(memberInfo.getAgentId(), memberInfo,orderInfo,memberProfitTotal,agentProfitTotal,0);
			}
			if(orderInfo.getStatus().intValue()==OrderInfoConstants.Status.STATUS1.getStatus()){
				double companyProfitTotal=MathUtils.subtract(orderInfo.getRealAmount(),memberProfitTotal);
				companyProfitTotal=MathUtils.subtract(companyProfitTotal, agentProfitTotal);
				orderCountMapper.insert(new OrderCount(orderInfo.getTradeNo(),OrderCountConstants.TradeType.MemberActive.getTradeType(), orderInfo.getRealAmount(), memberProfitTotal,agentProfitTotal,companyProfitTotal));
			}
		}
		//代理提现订单(创新支付无异步通知，弃用中)
		if(orderInfo.getType().intValue()==OrderInfoConstants.Type.AgentCashOrder.getType()){
			AgentAccount agentAccount=AgentAccountMapper.selectByAgentId(orderInfo.getUserId());
			if(orderInfo.getStatus().intValue()==OrderInfoConstants.Status.STATUS1.getStatus()){//订单成功，扣除锁定余额
				agentAccount.setLockBalance(MathUtils.subtract(agentAccount.getLockBalance(),orderInfo.getRealAmount()));
			}else{//订单失败，将锁定余额返还到可用余额
				agentAccount.setLockBalance(MathUtils.subtract(agentAccount.getLockBalance(),orderInfo.getRealAmount()));
				agentAccount.setUsableBalance(MathUtils.add(agentAccount.getUsableBalance(),orderInfo.getRealAmount()));
			}
			AgentAccountMapper.updateByPrimaryKey(agentAccount);
		}
		//卡片鉴权订单
		if(orderInfo.getType().intValue()==OrderInfoConstants.Type.MemberCardOrder.getType()){
			MemberCard memberCard=memberCardMapper.selectByPrimaryKey(new Gson().fromJson(orderInfo.getDetails(),MemberCardOrder.class).getCardId());
			if(orderInfo.getStatus().intValue()==OrderInfoConstants.Status.STATUS1.getStatus()){
				//此处判断卡片是否存在是因为可让会员重复添加，且上次添加还未回调的空闲时间
				if(!memberCardService.isExsit(memberCard.getCardNo())){
					memberCard.setStatus(MemberCardConstatns.Status.STATUS1.getStatus());
					memberCardMapper.updateByPrimaryKey(memberCard);
				}
				orderCountMapper.insert(new OrderCount(orderInfo.getTradeNo(),OrderCountConstants.TradeType.MemberCard.getTradeType(), orderInfo.getRealAmount(), 0,0,orderInfo.getRealAmount()));
			}
		}
		//其他订单
		if(orderInfo.getType().intValue()==OrderInfoConstants.Type.OtherOrder.getType()){
			//...
		}
	}


}
