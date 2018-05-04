package com.rw.finance.client.service;

import com.rw.finance.common.entity.AgentAccount;

/**
 * 
 * @file AgentAccountService.java	
 * @author huanghongfei
 * @date 2017年12月26日 下午8:24:08
 * @declaration
 */
public interface AgentAccountService {
	/**
	 * 
	 * @param AgentId
	 * @return
	 */
	AgentAccount getByAgentId(long AgentId);
	/**
	 * 更新
	 * @param agentAccount
	 */
	AgentAccount update(AgentAccount agentAccount);
}
