package com.rw.finance.client.service;

import org.junit.Test;
import com.rw.finance.client.BaseTest;
import com.rw.finance.client.service.BankInfoService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @file BankInfoServiceTest.java	
 * @author huanghongfei
 * @date 2017年12月15日 下午3:57:59
 * @declaration
 */
public class BankInfoServiceTest extends BaseTest{

	@Autowired
	private BankInfoService bankInfoService;
	
	@Test
	public void listTest(){
		System.err.println(bankInfoService.list().get(0).getBankName());
	}
}
