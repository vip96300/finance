package com.rw.finance.client.dao;

import com.rw.finance.common.entity.AgentAccount;
import com.rw.finance.common.entity.AgentAccountExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AgentAccountMapper {
    long countByExample(AgentAccountExample example);

    int deleteByExample(AgentAccountExample example);

    int deleteByPrimaryKey(Long accountId);

    int insert(AgentAccount record);

    int insertSelective(AgentAccount record);

    List<AgentAccount> selectByExample(AgentAccountExample example);

    AgentAccount selectByPrimaryKey(Long accountId);

    int updateByExampleSelective(@Param("record") AgentAccount record, @Param("example") AgentAccountExample example);

    int updateByExample(@Param("record") AgentAccount record, @Param("example") AgentAccountExample example);

    int updateByPrimaryKeySelective(AgentAccount record);

    int updateByPrimaryKey(AgentAccount record);

    @Select("select * from agent_account o where o.agent_id=#{AgentId}")
    @ResultMap(value={"BaseResultMap"})
    AgentAccount selectByAgentId(@Param("AgentId") long AgentId);
}