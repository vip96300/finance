package com.rw.finance.client.service.impl;

import com.rw.finance.client.service.AgentAccountService;
import com.rw.finance.common.entity.AgentAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @file AgentAccountServiceImpl.java	
 * @author huanghongfei
 * @date 2017年12月26日 下午8:25:04
 * @declaration
 */
@Service
public class AgentAccountServiceImpl implements AgentAccountService{
	
	@Autowired
	private com.rw.finance.client.dao.AgentAccountMapper agentAccountMapper;

	@Override
	public AgentAccount getByAgentId(long AgentId) {
		return agentAccountMapper.selectByAgentId(AgentId);
	}

	@Override
	public AgentAccount update(AgentAccount agentAccount) {
		agentAccountMapper.updateByPrimaryKey(agentAccount);
		return agentAccount;
	}
	
	
	
}
