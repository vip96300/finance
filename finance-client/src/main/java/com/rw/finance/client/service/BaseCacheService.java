package com.rw.finance.client.service;

/**
 * 
 * @file BaseCacheService.java	
 * @author huanghongfei
 * @date 2017年12月15日 上午10:21:53
 * @declaration
 */
public interface BaseCacheService {

	void set(String key, Object value, long time);

	Object get(String key, Class<?> clazz);
	
	void remove(String key);

	/**
	 * 值累加
	 * @param key
	 * @return
	 */
	long incr(String key);
	
}
