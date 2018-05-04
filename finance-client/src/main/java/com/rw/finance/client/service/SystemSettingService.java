package com.rw.finance.client.service;

import com.rw.finance.common.entity.SystemSetting;

import java.util.List;

/**
 * 
 * @file SystemSettingService.java	
 * @author huanghongfei
 * @date 2017年12月22日 下午6:04:30
 * @declaration
 */
public interface SystemSettingService {
	/**
	 * 根据key获取
	 * @param dictkey
	 * @return
	 */
	SystemSetting getByDictkey(String dictkey);
	/**
	 * 获取客户端配置列表
	 * @return
	 */
	List<SystemSetting> listByIsapp();
}
