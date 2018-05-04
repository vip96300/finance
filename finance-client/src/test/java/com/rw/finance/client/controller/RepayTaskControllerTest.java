package com.rw.finance.client.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rw.finance.client.BaseTest;

public class RepayTaskControllerTest extends BaseTest{

	@Autowired
	private RepayTaskController repayTaskController;
	
	@Test
	public void generator(){
		repayTaskController.generator(29,30, "21,22,23", 50000D);
	}
}
