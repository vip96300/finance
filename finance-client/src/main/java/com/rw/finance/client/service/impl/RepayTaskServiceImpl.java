package com.rw.finance.client.service.impl;

import com.rw.finance.common.constants.MemberCardConstatns;
import com.rw.finance.common.constants.RepayPlanConstants;
import com.rw.finance.common.constants.RepayTaskConstants;
import com.rw.finance.client.dao.*;
import com.rw.finance.common.entity.*;
import com.rw.finance.client.service.RepayTaskService;
import com.rw.finance.common.utils.DateUtils;
import com.rw.finance.common.utils.MathUtils;
import com.rw.finance.common.utils.NumberUtils;
import com.rw.finance.client.config.SystemSetting;
import org.apache.activemq.ScheduledMessage;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.jms.*;
import java.lang.reflect.Field;
import java.util.*;

/**
 * 
 * @file RepayTaskServiceImpl.java	
 * @author huanghongfei
 * @date 2017年12月15日 下午2:09:44
 * @declaration
 */
@Service
public class RepayTaskServiceImpl implements RepayTaskService{
	
	private static final Logger log=LoggerFactory.getLogger(RepayTaskServiceImpl.class);
	
	@Autowired
	private MemberInfoMapper memberInfoMapper;
	@Autowired
	private MemberLevelMapper memberLevelMapper;
	@Autowired
	private MemberCardMapper memberCardMapper;
	@Autowired
	private RepayPlanMapper repayPlanMapper;
	@Autowired
	private RepayTaskMapper repayTaskMapper;
	@Autowired
	private SystemSetting systemSetting;
	@Autowired
	private PayChannelMapper payChannelMapper;
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	
	
	@Transactional(rollbackFor=Exception.class)
	@Override
	public Map<String,Object> generator(long memberid,long cardid,String dates,double money) {
		MemberInfo memberInfo=memberInfoMapper.selectByPrimaryKey(memberid);
		MemberLevel memberLevel=memberLevelMapper.selectByLevelAndChannelId(memberInfo.getLevel(),payChannelMapper.selectByIsDef(1).getChannelId());
		//生成日期中的随机时间
		Set<String> ds=new LinkedHashSet<String>(Arrays.asList(dates.split(",")));
		List<Date> tasks=new ArrayList<Date>();
		for(String d:ds){
			Calendar calendar=Calendar.getInstance();
			calendar.set(Calendar.DATE,Integer.valueOf(d));//设置日期
			if(Calendar.getInstance().get(Calendar.DATE)>=calendar.get(Calendar.DATE)){
				//如果当前时间大于任务起始时间需将任务移交至下一个月
				calendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH)+1);
			}
			//任务开始小时数，每次+1
			int beginHour=RepayPlanConstants.DAY_PLAN_BEGIN_HOUR;
			for(int i=0;i<RepayPlanConstants.DAY_REPAY_COUNT;i++){
				beginHour+=NumberUtils.fieldRandom(1,3);
				calendar.set(Calendar.HOUR_OF_DAY,beginHour);
				//随机出分钟数
				calendar.set(Calendar.MINUTE, NumberUtils.fieldRandom(0,59));
				//随机出秒
				calendar.set(Calendar.SECOND, NumberUtils.fieldRandom(0,59));
				tasks.add(calendar.getTime());
			}
		}
		//任务时间排序
		Collections.sort(tasks);
		//生成任务金额
		List<Double> taskAmounts = new ArrayList<>(tasks.size());//任务金额
		List<Double> actualAmounts = new ArrayList<>(tasks.size());//实际金额
		List<Double> poundages = new ArrayList<>(tasks.size());//对应的手续费
		double repayPoundage = memberLevel.getRepayPoundage();
		// 总手续费
		double poundage = MathUtils.multiply(money, memberLevel.getRepayRate());
		double totalPayRate = 0;// 还款百分比总和
		double[] rates = new double[ds.size()]; // 每笔还款占用百分比
		for (int i = 0; i < ds.size(); i++) {
			rates[i] = RandomUtils.nextDouble(0.4, 0.6); // 每笔还款浮动范围
			totalPayRate = MathUtils.add(totalPayRate, rates[i]);
		}
		for (double rate1 : rates) {
			// 计算还款金额
			double payRate, payTaskMoney, payActualMoney;
			payRate = MathUtils.divide(rate1, totalPayRate);
			payTaskMoney = MathUtils.multiply(money, payRate);
			payActualMoney = MathUtils.multiply(money, payRate) + repayPoundage;

			// 计算消费金额
			double totalBuyRate = 0;
			double[] buyRates = new double[2];
			for (int k = 0; k < buyRates.length; k++) {
				buyRates[k] = RandomUtils.nextDouble(0.4, 0.6); // 每笔消费浮动范围
				totalBuyRate += buyRates[k];
			}

			for (double rate : buyRates) {
				double buyRate = MathUtils.divide(rate, totalBuyRate); // 消费金额百分比
				double buyTaskMoney = MathUtils.multiply(payActualMoney, buyRate); // 消费金额
				double buyPoundage = MathUtils.multiply(buyTaskMoney, memberLevel.getRepayRate()); // 消费手续费
				double buyActualMoney = MathUtils.add(buyTaskMoney, buyPoundage);
				taskAmounts.add(buyTaskMoney);
				actualAmounts.add(buyActualMoney);
				poundages.add(buyPoundage);
			}
			taskAmounts.add(payTaskMoney);
			actualAmounts.add(payActualMoney);
			poundages.add(0D);
		}
		MemberCard memberCard=memberCardMapper.selectByMemberIdAndCardIdAndType(memberid, cardid,MemberCardConstatns.Type.TYPE2.getType());
		if(StringUtils.isEmpty(memberCard)){
			log.error("member card not found,memberid:{},cardid:{}",memberid,cardid);
			return null;
		}
		//生成计划于任务
		RepayPlan repayPlan = new RepayPlan(memberid, memberCard.getCardId(), RepayPlanConstants.Type.TYPE1.getType(), 0, money, ds.size(), DateUtils.getDateStr(tasks.get(0)), DateUtils.getDateStr(tasks.get(tasks.size() - 1)));
		repayPlan.setPoundage(MathUtils.add(poundage, ds.size() * systemSetting.PAY_SYSTEM_RATE()));
		repayPlanMapper.insert(repayPlan);
		List<RepayTask> repayTasks = new ArrayList<RepayTask>();
		int batch = 0;//当前批次，多次扣款加1次还款为1批
		for (int i = 0; i < tasks.size(); i++) {
			RepayTask repayTask = new RepayTask(repayPlan.getPlanId(), batch, memberid,
					taskAmounts.get(i), actualAmounts.get(i),
					RepayTaskConstants.Type.TYPE0.getType(), poundages.get(i), i, DateUtils.getTimeStr(tasks.get(i)));
			if (poundages.get(i).doubleValue() == 0) {//如果没有手续费是还款任务
				repayTask.setTaskType(RepayTaskConstants.Type.TYPE1.getType());
				repayTask.setPoundage(MathUtils.add(repayTask.getPoundage(), repayPoundage));
				batch++;//已经是还款任务，批次递增
			}
			repayTasks.add(repayTask);
		}
		repayTasks.forEach(o->{
			repayTaskMapper.insert(o);
		});
		Map<String, Object> data = new HashMap<>();
		data.put("RepayPlan", this.persist(repayPlan));
		repayTasks.forEach(this::persist);
		data.put("RepayTasks", repayTasks);
		return data;
	}
	/**
	 * 反射保留dubbo后两位
	 * @param obj
	 * @return
	 */
	private Object persist(Object obj){
		Field[] fields=obj.getClass().getDeclaredFields();
		for(Field field:fields){
			if(field.getType()!=Double.class){
				continue;
			}
			field.setAccessible(true);
			try {
				field.set(obj,MathUtils.persist(Double.parseDouble(field.get(obj).toString()), 2));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}
	
	@Override
	public RepayTask getByMemberidAndPlanidAndStatusAndExecutetimeMin(long memberid,long planid, int status) {
		return repayTaskMapper.selectByMemberIdAndPlanIdAndStatusAndExecuteTimeMinOrderByExecuteTime(memberid, planid, status);
	}
	
	@Async
	@Override
	public void update(RepayTask repayTask) {
		repayTaskMapper.updateByPrimaryKey(repayTask);
	}

	@Override
	public List<RepayTask> listByMemberidAndPlanidAndStatus(long memberid,long planid, int status) {
		RepayTaskExample example = new RepayTaskExample();
		example.setOrderByClause("execute_time asc");
		RepayTaskExample.Criteria criteria=example.createCriteria();
		criteria.andMemberIdEqualTo(memberid);
		criteria.andPlanIdEqualTo(planid);
		criteria.andStatusEqualTo(status);
		return repayTaskMapper.selectByExample(example);
	}

	@Override
	public List<RepayTask> listByMemberidAndPlanid(long memberid, long planid) {
		RepayTaskExample example = new RepayTaskExample();
		example.setOrderByClause("execute_time asc");
		RepayTaskExample.Criteria criteria=example.createCriteria();
		criteria.andMemberIdEqualTo(memberid);
		criteria.andPlanIdEqualTo(planid);
		return repayTaskMapper.selectByExample(example);
	}

	@Override
	public RepayTask getByTaskid(long taskid) {
		return repayTaskMapper.selectByPrimaryKey(taskid);
	}

	@Override
	public List<RepayTask> listByMemberidAndPlanidAndBatch(long memberid,long planid, int batch) {
		RepayTaskExample example = new RepayTaskExample();
		RepayTaskExample.Criteria criteria=example.createCriteria();
		criteria.andMemberIdEqualTo(memberid);
		criteria.andPlanIdEqualTo(planid);
		criteria.andBatchEqualTo(batch);
		return repayTaskMapper.selectByExample(example);
	}

	@Override
	public void timingSend(String message, String queueName, Long timeStamp) {
		//获取连接工厂
		ConnectionFactory connectionFactory = this.jmsMessagingTemplate.getConnectionFactory();
		try {
			//获取连接
			Connection connection = connectionFactory.createConnection();
			connection.start();
			//获取session
			Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
			// 创建一个消息队列
			Destination destination = session.createQueue(queueName);
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);
			TextMessage textMessage = session.createTextMessage(message);
			//设置延迟时间
			textMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, timeStamp-System.currentTimeMillis());
			//发送
			producer.send(textMessage);
			session.commit();
			producer.close();
			session.close();
			connection.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
