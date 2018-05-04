package com.rw.finance.client.service.impl;

import com.rw.finance.client.service.PayChannelService;
import com.rw.finance.client.dao.MemberLevelMapper;
import com.rw.finance.client.dao.PayChannelMapper;
import com.rw.finance.common.entity.MemberLevel;
import com.rw.finance.common.entity.PayChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

/**
 * 
 * @file PayChannelServiceImpl.java	
 * @author huanghongfei
 * @date 2018年2月1日 下午3:59:08
 * @declaration
 */
@Service
public class PayChannelServiceImpl implements PayChannelService{

	@Autowired
	private PayChannelMapper payChannelMapper;
	@Autowired
	private MemberLevelMapper memberLevelMapper;
	
	@Cacheable
	@Override
	public PayChannel getByIsdef() {
		return payChannelMapper.selectByIsDef(1);
	}
	
	@Cacheable
	@Override
	public List<PayChannel> list() {
		List<PayChannel> payChannels=payChannelMapper.selectByIsEnable(1);
		for(PayChannel payChannel:payChannels){
			List<MemberLevel> memberLevels=memberLevelMapper.selectByChannelId(payChannel.getChannelId());
			payChannel.setMemberLevels(new HashSet<>(memberLevels));
		}
		return payChannels;
	}


}
