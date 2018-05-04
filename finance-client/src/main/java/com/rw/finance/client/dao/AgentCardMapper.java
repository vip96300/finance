package com.rw.finance.client.dao;

import com.rw.finance.common.entity.AgentCard;
import com.rw.finance.common.entity.AgentCardExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AgentCardMapper {
    long countByExample(AgentCardExample example);

    int deleteByExample(AgentCardExample example);

    int deleteByPrimaryKey(Long agentCardId);

    int insert(AgentCard record);

    int insertSelective(AgentCard record);

    List<AgentCard> selectByExample(AgentCardExample example);

    AgentCard selectByPrimaryKey(Long agentCardId);

    int updateByExampleSelective(@Param("record") AgentCard record, @Param("example") AgentCardExample example);

    int updateByExample(@Param("record") AgentCard record, @Param("example") AgentCardExample example);

    int updateByPrimaryKeySelective(AgentCard record);

    int updateByPrimaryKey(AgentCard record);
}