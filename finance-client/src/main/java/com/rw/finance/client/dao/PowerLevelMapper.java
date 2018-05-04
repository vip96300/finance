package com.rw.finance.client.dao;

import com.rw.finance.common.entity.PowerLevel;
import com.rw.finance.common.entity.PowerLevelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PowerLevelMapper {
    long countByExample(PowerLevelExample example);

    int deleteByExample(PowerLevelExample example);

    int deleteByPrimaryKey(Long levelId);

    int insert(PowerLevel record);

    int insertSelective(PowerLevel record);

    List<PowerLevel> selectByExample(PowerLevelExample example);

    PowerLevel selectByPrimaryKey(Long levelId);

    int updateByExampleSelective(@Param("record") PowerLevel record, @Param("example") PowerLevelExample example);

    int updateByExample(@Param("record") PowerLevel record, @Param("example") PowerLevelExample example);

    int updateByPrimaryKeySelective(PowerLevel record);

    int updateByPrimaryKey(PowerLevel record);
}