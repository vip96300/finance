package com.rw.finance.client.service.impl;

import com.rw.finance.client.service.MemberLevelService;
import com.rw.finance.client.dao.MemberLevelMapper;
import com.rw.finance.common.entity.MemberLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class MemberLevelServiceImpl implements MemberLevelService{

	@Autowired
	private MemberLevelMapper memberLevelMapper;
	
	@Cacheable
	@Override
	public MemberLevel getByLevelAndChannelid(int level, long channelid) {
		return memberLevelMapper.selectByLevelAndChannelId(level, channelid);
	}

}
