package com.rw.finance.client.controller;

import com.rw.finance.common.utils.Result;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rw.finance.client.BaseTest;

public class MemberInfoControllerTest extends BaseTest{

	@Autowired
	private MemberInfoController memberInfoController;
	
	//@Test
	public void getRegisterCodeTest(){
		System.err.println(memberInfoController.getRegisterCode("15023343740").getCode());
	}
	
	//@Test
	public void registerTest(){
		//System.out.println(memberInfoController.register("HHF","15023343740","123456","123456","","123456"));
	}
	
	//@Test
	public void findPassword(){
		System.out.println(memberInfoController.findPassword("15023343740","654321","code"));
	}
	
	//@Test
	public void login(){
		System.out.println(memberInfoController.login("15023343740","123456").getData());
	}
	
	//@Test
	public void updPasswordByMemberidAndPassword(){
		System.out.println(memberInfoController.updPasswordByMemberidAndPassowrd(1, "123456","654321").getCode());
	}
	
	//@Test
	public void updPaypwdByMemberidAndPaypwd(){
		System.out.println(memberInfoController.updPaypwdByMemberidAndPaypwd(1, "123456","654321").getCode());
	}
	
	//@Test
	public void findPaypwd(){
		System.out.println(memberInfoController.findPaypwd(1,"654321","123456").getCode());
	}
	
	//@Test
	public void updIsrealTest(){
		System.out.println(memberInfoController.updIsreal(1,1, "huanghongfei", "500221199210021718", "6226011026785669","15023343740","idpath", "idobverse", "idreverse","cardpath"));
	}
	
	@Test
	public void shareCount(){
		Result result=memberInfoController.shareCount(48);
		System.err.println(1);
	}
	
	
}
