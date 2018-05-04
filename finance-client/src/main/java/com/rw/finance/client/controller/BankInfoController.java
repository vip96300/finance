package com.rw.finance.client.controller;

import java.util.List;

import com.rw.finance.client.annotation.Member;
import com.rw.finance.common.entity.BankInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rw.finance.common.constants.MemberInfoConstants;
import com.rw.finance.client.service.BankInfoService;
import com.rw.finance.common.utils.Result;

/**
 * 
 * @file BankSupportController.java	
 * @author huanghongfei
 * @date 2017年12月13日 下午4:23:25
 * @declaration
 */
@RestController
@RequestMapping(value="/bank/info")
public class BankInfoController {

	@Autowired
	private BankInfoService bankInfoService;
	/**
	 * 获取所有银行
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/list")
	public Result<List> list(){
		List<BankInfo> bankInfoList =bankInfoService.list();
		return new Result<List>(200,null, bankInfoList);
	}
}
