package com.rw.finance.client.service;

import org.junit.Test;
import com.rw.finance.client.BaseTest;
import com.rw.finance.client.service.PayResultService;
import org.springframework.beans.factory.annotation.Autowired;

public class PayResultServiceTest extends BaseTest{

	@Autowired
	private PayResultService payResultService;
	
	@Test
	public void chuangXinPayBack(){
		payResultService.chuangXinPayBack("2201801516425036626836470627251","","","");
	}
}
