package com.rw.finance.client.service;

import java.util.Map;

import com.rw.finance.client.BaseTest;
import com.rw.finance.client.service.RepayPlanService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @file RepayPlanServiceTest.java	
 * @author huanghongfei
 * @date 2017年12月19日 下午5:29:56
 * @declaration
 */
public class RepayPlanServiceTest extends BaseTest{

	@Autowired
	private RepayPlanService repayPlanService;
	
	//@Test
	public void current(){
		System.out.println(1);
		repayPlanService.listByMemberidAndCardid(1, 4,0,10);
	}

	
}
