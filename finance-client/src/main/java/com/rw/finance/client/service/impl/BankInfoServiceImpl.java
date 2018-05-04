package com.rw.finance.client.service.impl;

import com.rw.finance.client.service.BankInfoService;
import com.rw.finance.client.dao.BankInfoMapper;
import com.rw.finance.common.entity.BankInfo;
import com.rw.finance.common.entity.BankInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * @file BankInfoServiceImpl.java	
 * @author huanghongfei
 * @date 2017年12月14日 上午11:53:32
 * @declaration
 */
@Service
public class BankInfoServiceImpl implements BankInfoService{

	@Autowired
	private BankInfoMapper bankInfoMapper;

	@Cacheable
	public List<BankInfo> list() {
		return bankInfoMapper.selectByExample(new BankInfoExample());
	}

	@Cacheable
	public BankInfo getByBankid(long bankid) {
		return bankInfoMapper.selectByPrimaryKey(bankid);
	}

	@Override
	public BankInfo getByBankcodeLike(String bankCode) {
		return bankInfoMapper.selectByBankCodeLike(bankCode);
	}

}
