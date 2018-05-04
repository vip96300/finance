package com.rw.finance.client.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rw.finance.client.BaseTest;
import com.rw.finance.client.service.BaseCacheService;

/**
 * 
 * @file MemberCardControllerTest.java
 * @author huanghongfei
 * @date 2017年12月13日 下午5:24:46
 * @declaration
 */
public class MemberCardControllerTest extends BaseTest{

	@Autowired
	private MemberCardController memberCardController;
	@Autowired
	private BaseCacheService baseCacheService;
	/**
	 * 测试获取储蓄卡列表
	 */
	//@Test
	public void listByMemberidAndTypeTest(){
		System.out.println(memberCardController.listByMemberidAndType(29).getData());
	}

	/**
	 * 添加储蓄卡
	 */
	//@Test
	public void add(){
		System.err.println(memberCardController.add(46,29, "6221516530008644030","15023343740").getCode());
	}

	/**
	 * 添加贷记卡
	 */
	@Test
	public void auth(){
		System.err.println(memberCardController.auth(46,8,"6226011026785669","1022","117","25","10","15023343740").getCode());
	}

}
