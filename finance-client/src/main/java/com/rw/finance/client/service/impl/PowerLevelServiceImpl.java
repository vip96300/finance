package com.rw.finance.client.service.impl;

import com.rw.finance.client.service.PowerLevelService;
import com.rw.finance.client.dao.PowerLevelMapper;
import com.rw.finance.common.entity.PowerLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 
 * @file PowerLevelServiceImpl.java	
 * @author huanghongfei
 * @date 2017年12月26日 下午8:31:07
 * @declaration
 */
@Component
@Service
public class PowerLevelServiceImpl implements PowerLevelService{

	@Autowired
	private PowerLevelMapper powerLevelMapper;
	
	@Override
	public PowerLevel getByLevelid(long levelid) {
		return powerLevelMapper.selectByPrimaryKey(levelid);
	}

}
