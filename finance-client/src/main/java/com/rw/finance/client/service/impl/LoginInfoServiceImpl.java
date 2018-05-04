package com.rw.finance.client.service.impl;

import com.rw.finance.client.service.LoginInfoService;
import com.rw.finance.client.dao.LoginInfoMapper;
import com.rw.finance.common.entity.LoginInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 
 * @file LoginInfoServiceImpl.java	
 * @author huanghongfei
 * @date 2017年12月23日 下午6:22:53
 * @declaration
 */
@Component
@Service
public class LoginInfoServiceImpl implements LoginInfoService{

	@Autowired
	private LoginInfoMapper loginInfoMapper;
	
	@Async
	@Override
	public void add(LoginInfo loginInfo) {
		loginInfoMapper.insert(loginInfo);
	}
}
