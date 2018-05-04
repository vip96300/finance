package com.rw.finance.client.service.impl;

import com.rw.finance.client.service.SystemSettingService;
import com.rw.finance.client.dao.SystemSettingMapper;
import com.rw.finance.common.entity.SystemSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * @file SystemSettingServiceImpl.java	
 * @author huanghongfei
 * @date 2017年12月22日 下午6:06:04
 * @declaration
 */
@Service
public class SystemSettingServiceImpl implements SystemSettingService{

	@Autowired
	private SystemSettingMapper systemSettingMapper;

	@Cacheable
	@Override
	public SystemSetting getByDictkey(String dictkey) {
		SystemSetting systemSetting=systemSettingMapper.selectByDictKey(dictkey);
		return systemSetting;
	}

	@Cacheable
	@Override
	public List<SystemSetting> listByIsapp() {
		List<SystemSetting> systemSettingList=systemSettingMapper.selectByIsApp(1);
		return systemSettingList;
	}

}
