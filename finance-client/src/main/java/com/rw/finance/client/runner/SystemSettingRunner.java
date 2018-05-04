package com.rw.finance.client.runner;

import com.rw.finance.common.constants.TimeConstants;
import com.rw.finance.client.service.BaseCacheService;
import com.rw.finance.client.dao.SystemSettingMapper;
import com.rw.finance.common.entity.SystemSetting;
import com.rw.finance.common.entity.SystemSettingExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 系统设置缓存启动加载
 * @file SystemSettingCacheRunner.java	
 * @author huanghongfei
 * @date 2017年12月22日 下午6:23:40
 * @declaration
 */
@Component
public class SystemSettingRunner implements CommandLineRunner{

	@Autowired
	private SystemSettingMapper systemSettingMapper;
	
	@Autowired
	private BaseCacheService baseCacheService;
	
	@Override
	public void run(String... args){
		List<SystemSetting> systemSettings=systemSettingMapper.selectByExample(new SystemSettingExample());
		systemSettings.forEach(systemSetting->{
			baseCacheService.set(systemSetting.getDictKey(), systemSetting.getDictVal(),TimeConstants.SYSTEM_SETTING_EXPRIE_TIME);
		});
	}
}
