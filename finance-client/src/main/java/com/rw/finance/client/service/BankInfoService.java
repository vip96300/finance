package com.rw.finance.client.service;

import com.rw.finance.common.entity.BankInfo;

import java.util.List;

/**
 * 
 * @file BankInfoService.java	
 * @author huanghongfei
 * @date 2017年12月14日 上午11:53:25
 * @declaration
 */
public interface BankInfoService {
	/**
	 * 获取所有银行
	 * @return
	 */
	List<BankInfo> list();
	/**
	 * 根据编号获取银行
	 * @param bankid
	 * @return
	 */
	BankInfo getByBankid(long bankid);
	/**
	 * 根据银行名称获取
	 * @param BankName
	 * @return
	 */
	BankInfo getByBankcodeLike(String bankCode);
}
