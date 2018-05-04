package com.rw.finance.client.service;

import com.rw.finance.common.entity.RepayPlan;

import java.util.List;

/**
 * 
 * @file RepayPlanService.java	
 * @author huanghongfei
 * @date 2017年12月15日 下午1:53:01
 * @declaration
 */
public interface RepayPlanService {

	/**
	 * 当前计划列表，嵌套任务
	 * @param memberid
	 * @param cardid 卡编号
	 * @return
	 */
	List<RepayPlan> listByMemberidAndCardid(long memberid, long cardid, int page, int size);
	/**
	 * 当前计划列表，嵌套任务
	 * @param memberid
	 * @param cardid 卡编号
	 * @return
	 */
	List<RepayPlan> listByMemberidAndCardidAndStatus(long memberid, long cardid, int status, int page, int size);
	/**
	 * @param memberid 会员编号
	 * @param planid 计划编号
	 * @return
	 */
	RepayPlan getByMemberidAndPlanid(long memberid, long planid);
	/**
	 * 
	 * @param planid
	 * @return
	 */
	RepayPlan getByPlanid(long planid);
	/**
	 * 
	 * @param repayPlan
	 */
	void update(RepayPlan repayPlan);
	/**
	 * 获取执行中的计划
	 * @return
	 */
	List<RepayPlan> listByStatus(int status);

	/**
	 * 执行计划
	 * @param memberId
	 * @param planId
	 */
	void execute(long memberId,long planId);

	/**
	 * 取消计划
	 * @param memberId
	 * @param planId
	 */
	void cancel(long memberId,long planId);
}
