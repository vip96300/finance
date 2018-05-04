package com.rw.finance.client.dao;

import com.rw.finance.common.entity.AgentType;
import com.rw.finance.common.entity.AgentTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AgentTypeMapper {
    long countByExample(AgentTypeExample example);

    int deleteByExample(AgentTypeExample example);

    int deleteByPrimaryKey(Long typeId);

    int insert(AgentType record);

    int insertSelective(AgentType record);

    List<AgentType> selectByExample(AgentTypeExample example);

    AgentType selectByPrimaryKey(Long typeId);

    int updateByExampleSelective(@Param("record") AgentType record, @Param("example") AgentTypeExample example);

    int updateByExample(@Param("record") AgentType record, @Param("example") AgentTypeExample example);

    int updateByPrimaryKeySelective(AgentType record);

    int updateByPrimaryKey(AgentType record);
}