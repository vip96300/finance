package com.rw.finance.client.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rw.finance.client.annotation.Member;
import com.rw.finance.common.entity.RepayPlan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.rw.finance.common.constants.MemberInfoConstants;
import com.rw.finance.common.constants.RepayPlanConstants;
import com.rw.finance.client.service.RepayPlanService;
import com.rw.finance.common.utils.Result;

/**
 * 
 * @file RepayPlanController.java	
 * @author huanghongfei
 * @date 2017年12月18日 下午3:10:23
 * @declaration
 */
@RestController
@RequestMapping(value="/repay/plan")
public class RepayPlanController {

	@Autowired
	private RepayPlanService repayPlanService;

	private static Logger log=LoggerFactory.getLogger(RepayPlanController.class);
	/**
	 * 全部计划列表
	 * @param cardid
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/all")
	public Result<Object> listByMemberidAndCardid(@RequestAttribute(value="memberid"  )long memberid,
			@RequestParam(value="cardid"  )long cardid,
			@RequestParam(value="page",required=false,defaultValue="0")int page,
			@RequestParam(value="size",required=false,defaultValue="100")int size){
		List<RepayPlan> datas=repayPlanService.listByMemberidAndCardid(memberid, cardid,page,size);
		return new Result<Object>(200,null,datas);
	}
	/**
	 * 根据计划状态获取计划列表
	 * @param cardid
	 * @param status 计划状态
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/listByMemberidAndCardidAndStatus")
	public Result<Object> listByMemberidAndCardidAndStatus(@RequestAttribute(value="memberid"  )long memberid,
			@RequestParam(value="cardid"  )long cardid,
			@RequestParam(value="status"  )int status,
			@RequestParam(value="page",required=false,defaultValue="0")int page,
			@RequestParam(value="size",required=false,defaultValue="100")int size){
		List<RepayPlan> datas=repayPlanService.listByMemberidAndCardidAndStatus(memberid, cardid, status,page,size);
		return new Result<Object>(200,null,datas);
	}
	/**
	 * 执行计划
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/execute")
	public Result<Object> execute(@RequestAttribute(value="memberid"  )long memberid,
			@RequestParam(value="planid"  )long planid){
		repayPlanService.execute(memberid,planid);
		return new Result<Object>(200,null,null);
	}
	/**
	 * 取消计划
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/cancel")
	public Result<Object> cancel(@RequestAttribute(value="memberid"  )long memberid,
			@RequestParam(value="planid"  )long planid){
		repayPlanService.cancel(memberid,planid);
		return new Result<Object>(200,null,null);
	}
}
