package com.rw.finance.client.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rw.finance.client.BaseTest;

import java.util.HashMap;
import java.util.Map;

public class PayResultControllerTest extends BaseTest{

	@Autowired
	private PayResultController payResultController;
	
	@Test
	public void chuangXinBack(){
		String TradeNo="201804201518022103031449";
	}

	//@Test
	public void yeeBao2PayBack(){
		Map<String,String> request=new HashMap<String,String>();
	}
}
