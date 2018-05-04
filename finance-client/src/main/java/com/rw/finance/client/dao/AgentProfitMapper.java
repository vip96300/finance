package com.rw.finance.client.dao;

import com.rw.finance.common.entity.AgentProfit;
import com.rw.finance.common.entity.AgentProfitExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AgentProfitMapper {
    long countByExample(AgentProfitExample example);

    int deleteByExample(AgentProfitExample example);

    int deleteByPrimaryKey(Long profitId);

    int insert(AgentProfit record);

    int insertSelective(AgentProfit record);

    List<AgentProfit> selectByExample(AgentProfitExample example);

    AgentProfit selectByPrimaryKey(Long profitId);

    int updateByExampleSelective(@Param("record") AgentProfit record, @Param("example") AgentProfitExample example);

    int updateByExample(@Param("record") AgentProfit record, @Param("example") AgentProfitExample example);

    int updateByPrimaryKeySelective(AgentProfit record);

    int updateByPrimaryKey(AgentProfit record);
}