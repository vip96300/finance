package com.rw.finance.client.service;

import com.rw.finance.common.entity.RepayTask;

import java.util.List;
import java.util.Map;

/**
 * 
 * @file RepayTaskService.java	
 * @author huanghongfei
 * @date 2017年12月15日 下午2:09:51
 * @declaration
 */
public interface RepayTaskService {
	/**
	 * 生成还款计划
	 * @param memberid
	 * @param dates 日期字符串，使用,隔开，例：28,29,30
	 * @param money 还款金额
	 * @return
	 */
	Map<String,Object> generator(long memberid, long cardid, String dates, double money);
	/**
	 *
	 * @param memberid
	 * @param planid
	 * @param status
	 * @return
	 */
	RepayTask getByMemberidAndPlanidAndStatusAndExecutetimeMin(long memberid, long planid, int status);
	/**
	 * 更新
	 * @param repayTask
	 */
	void update(RepayTask repayTask);
	/**
	 * 根据会员编号和计划编号和状态获取任务列表,要大于当前时间
	 * @param memberid
	 * @param planid
	 * @param status
	 * @return
	 */
	List<RepayTask> listByMemberidAndPlanidAndStatus(long memberid, long planid, int status);
	/**
	 * 根据会员编号和计划编号获取任务列表
	 * @param memberid
	 * @param planid
	 * @return
	 */
	List<RepayTask> listByMemberidAndPlanid(long memberid, long planid);
	/**
	 * 根据会员编号，计划编号，批次
	 * @param memberid
	 * @param planid
	 * @param batch
	 * @return
	 */
	List<RepayTask> listByMemberidAndPlanidAndBatch(long memberid, long planid, int batch);
	/**
	 * 根据编号获取
	 * @param taskid
	 * @return
	 */
	RepayTask getByTaskid(long taskid);
	/**
	 * 定时发送消息
	 * @param message
	 * @param queueName 队列名称
	 * @param timeStamp 发送时间的时间戳
	 */
	void timingSend(String message, String queueName, Long timeStamp);
}
