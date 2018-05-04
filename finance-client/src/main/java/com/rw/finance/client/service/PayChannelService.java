package com.rw.finance.client.service;

import com.rw.finance.common.entity.PayChannel;

import java.util.List;

/**
 * 
 * @file PayChannelService.java	
 * @author huanghongfei
 * @date 2018年2月1日 下午3:50:22
 * @declaration
 */
public interface PayChannelService {
	/**
	 * 获取默认的渠道
	 * @return
	 */
	PayChannel getByIsdef();
	/**
	 * 获取启用的渠道列表
	 * @return
	 */
	List<PayChannel> list();
	
}
