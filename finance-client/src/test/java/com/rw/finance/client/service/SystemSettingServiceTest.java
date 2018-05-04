package com.rw.finance.client.service;

import org.junit.Test;

import com.rw.finance.client.BaseTest;
import com.rw.finance.client.service.SystemSettingService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @file SystemSettingServiceTest.java	
 * @author huanghongfei
 * @date 2018年1月4日 下午12:54:22
 * @declaration
 */
public class SystemSettingServiceTest extends BaseTest{

	@Autowired
	private SystemSettingService systemSettingService;
	
	@Test
	public void listByIsapp(){
		systemSettingService.listByIsapp().forEach(s->{
			System.err.println("key:"+s.getDictKey()+"/value:"+s.getDictVal());
		});
	}
}
