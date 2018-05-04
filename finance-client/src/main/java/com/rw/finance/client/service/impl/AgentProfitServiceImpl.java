package com.rw.finance.client.service.impl;

import com.rw.finance.client.service.AgentProfitService;
import com.rw.finance.client.dao.AgentAccountMapper;
import com.rw.finance.client.dao.AgentProfitMapper;
import com.rw.finance.common.entity.AgentAccount;
import com.rw.finance.common.entity.AgentProfit;
import com.rw.finance.common.utils.MathUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @file AgentProfitServiceImpl.java	
 * @author huanghongfei
 * @date 2017年12月26日 下午5:55:57
 * @declaration
 */
@Service
public class AgentProfitServiceImpl implements AgentProfitService{
	
	@Autowired
	private AgentProfitMapper agentProfitMapper;
	@Autowired
	private AgentAccountMapper agentAccountMapper;
	
	@Async
	@Transactional(rollbackFor=Exception.class)
	@Override
	public void add(AgentProfit agentProfit) {
		agentProfitMapper.insert(agentProfit);
		AgentAccount agentAccount=agentAccountMapper.selectByAgentId(agentProfit.getAgentId());
		//向代理账户加钱
		agentAccount.setUsableBalance(MathUtils.add(agentAccount.getUsableBalance(), agentProfit.getAmount()));
		agentAccountMapper.updateByPrimaryKey(agentAccount);
	}

}
