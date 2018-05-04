package com.rw.finance.client.service.impl;

import com.google.gson.Gson;
import com.rw.finance.client.bo.RepayTaskBo;
import com.rw.finance.client.config.ActiveMQConfig;
import com.rw.finance.client.service.RepayPlanService;
import com.rw.finance.client.dao.RepayPlanMapper;
import com.rw.finance.client.dao.RepayTaskMapper;
import com.rw.finance.client.service.RepayTaskService;
import com.rw.finance.common.constants.RepayPlanConstants;
import com.rw.finance.common.constants.RepayTaskConstants;
import com.rw.finance.common.entity.RepayPlan;
import com.rw.finance.common.entity.RepayPlanExample;
import com.rw.finance.common.entity.RepayTask;
import com.rw.finance.common.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

/**
 * 
 * @file RepayPlanServiceImpl.java	
 * @author huanghongfei
 * @date 2017年12月15日 下午1:53:46
 * @declaration
 */
@Service
public class RepayPlanServiceImpl implements RepayPlanService{
	
	private static Logger log=LoggerFactory.getLogger(RepayPlanService.class);

	@Autowired
	private RepayPlanMapper repayPlanMapper;
	@Autowired
	private RepayTaskMapper repayTaskMapper;
	@Autowired
	private RepayTaskService repayTaskService;

	@Override
	public List<RepayPlan> listByMemberidAndCardid(long memberid, long cardid, int page, int size) {
		RepayPlanExample example = new RepayPlanExample();
		example.setOrderByClause("create_time desc");
		RepayPlanExample.Criteria criteria=example.createCriteria();
		criteria.andMemberIdEqualTo(memberid);
		criteria.andCardIdEqualTo(cardid);
		return repayPlanMapper.selectByExample(example);
	}

	@Override
	public List<RepayPlan> listByMemberidAndCardidAndStatus(long memberid,long cardid,int status,int page,int size) {
		RepayPlanExample example = new RepayPlanExample();
		example.setOrderByClause("create_time desc");
		example.setOffset((page - 1) * size);
		example.setLimit(size);
		RepayPlanExample.Criteria criteria=example.createCriteria();
		criteria.andMemberIdEqualTo(memberid);
		criteria.andCardIdEqualTo(cardid);
		criteria.andStatusEqualTo(status);
		return repayPlanMapper.selectByExample(example);
	}

	@Override
	public RepayPlan getByMemberidAndPlanid(long memberid,long planid) {
		return repayPlanMapper.selectMemberIdAndPlanId(memberid, planid);
	}

	@Override
	public RepayPlan getByPlanid(long planid) {
		return repayPlanMapper.selectByPrimaryKey(planid);
	}

	@Override
	public void update(RepayPlan repayPlan) {
		repayPlan.setUpdateTime(DateUtils.getTimeStr(new Date()));
		repayPlanMapper.updateByPrimaryKey(repayPlan);
	}

	@Override
	public List<RepayPlan> listByStatus(int status) {
		return repayPlanMapper.selectByStatus(status);
	}

	@Override
	public void execute(long memberId, long planId) {
		RepayPlan repayPlan=this.getByMemberidAndPlanid(memberId, planId);
		//如果当前状态不处于待执行或执行中，说明计划异常或已经完成，返回
		if(repayPlan.getStatus()!= RepayPlanConstants.Status.STATUS0.getStatus()&&repayPlan.getStatus()!=RepayPlanConstants.Status.STATUS1.getStatus()){
			log.info("the repay plan not executing,returned,planId:{}",repayPlan.getPlanId());
			return;
		}
		//如果当前计划状态处于待执行中，设置为执行中
		if(repayPlan.getStatus().intValue()==RepayPlanConstants.Status.STATUS0.getStatus()){
			repayPlan.setStatus(RepayPlanConstants.Status.STATUS1.getStatus());
			this.update(repayPlan);
		}
		List<RepayTask> repayTasks=repayTaskService.listByMemberidAndPlanidAndStatus(memberId, planId, RepayTaskConstants.Status.STATUS0.getStatus());
		for(RepayTask repayTask:repayTasks){
			if(System.currentTimeMillis()>= DateUtils.getTimeByStr(repayTask.getExecuteTime()).getTime()){
				continue;//执行时间已过，放弃执行
			}
			repayTaskService.timingSend(new Gson().toJson(new RepayTaskBo().new Message(repayTask.getPlanId(),repayTask.getTaskId())),ActiveMQConfig.REPAY_TASK_QUEUE,DateUtils.getTimeByStr(repayTask.getExecuteTime()).getTime());
			log.info("added thread to task,taskId:{}",repayTask.getTaskId());
		}
	}

	@Override
	public void cancel(long memberId, long planId) {
		RepayPlan repayPlan=this.getByMemberidAndPlanid(memberId,planId);
		repayPlan.setStatus(RepayPlanConstants.Status.STATUS2.getStatus());
		this.update(repayPlan);
	}

}
