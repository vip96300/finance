package com.rw.finance.client.service.impl;

import com.rw.finance.client.service.AgentInfoService;
import com.rw.finance.client.dao.AgentInfoMapper;
import com.rw.finance.common.entity.AgentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @file AgentInfoServiceImpl.java	
 * @author huanghongfei
 * @date 2017年12月26日 下午5:29:11
 * @declaration
 */
@Service
public class AgentInfoServiceImpl implements AgentInfoService{

	@Autowired
	private AgentInfoMapper agentInfoMapper;
	
	@Override
	public AgentInfo getByAgentId(long AgentId) {
		return agentInfoMapper.selectByPrimaryKey(AgentId);
	}

}
