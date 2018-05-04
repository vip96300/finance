package com.rw.finance.client.service.impl;

import com.rw.finance.client.service.LogInfoService;
import com.rw.finance.client.dao.LogInfoMapper;
import com.rw.finance.common.entity.LogInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 
 * @file LogInfoServiceImpl.java	
 * @author huanghongfei
 * @date 2017年12月14日 上午11:51:10
 * @declaration
 */
@Service
public class LogInfoServiceImpl implements LogInfoService{

	@Autowired
	private LogInfoMapper logInfoMapper;
	
	@Async
	@Override
	public void add(LogInfo logInfo) {
		logInfoMapper.insert(logInfo);
	}

	
}
