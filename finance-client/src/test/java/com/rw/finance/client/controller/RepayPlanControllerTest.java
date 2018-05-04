package com.rw.finance.client.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rw.finance.client.BaseTest;

public class RepayPlanControllerTest extends BaseTest{

	@Autowired
	private RepayPlanController repayPlanController;
	
	//@Test
	public void listByMemberidAndCardidAndEnddateGreater(){
		System.out.println(repayPlanController.listByMemberidAndCardid(1, 4,0,10));
	}
	
	@Test
	public void execute(){
		repayPlanController.execute(29, 432);
	}
	
	//@Test
	public void cancel(){
		repayPlanController.cancel(1L, 1L);
	}
}
