package com.rw.finance.client.dao;

import com.rw.finance.common.entity.AgentInfo;
import com.rw.finance.common.entity.AgentInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AgentInfoMapper {
    long countByExample(AgentInfoExample example);

    int deleteByExample(AgentInfoExample example);

    int deleteByPrimaryKey(Long AgentId);

    int insert(AgentInfo record);

    int insertSelective(AgentInfo record);

    List<AgentInfo> selectByExample(AgentInfoExample example);

    AgentInfo selectByPrimaryKey(Long AgentId);

    int updateByExampleSelective(@Param("record") AgentInfo record, @Param("example") AgentInfoExample example);

    int updateByExample(@Param("record") AgentInfo record, @Param("example") AgentInfoExample example);

    int updateByPrimaryKeySelective(AgentInfo record);

    int updateByPrimaryKey(AgentInfo record);
}