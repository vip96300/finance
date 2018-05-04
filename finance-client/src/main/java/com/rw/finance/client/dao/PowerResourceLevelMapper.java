package com.rw.finance.client.dao;

import com.rw.finance.common.entity.PowerResourceLevel;
import com.rw.finance.common.entity.PowerResourceLevelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PowerResourceLevelMapper {
    long countByExample(PowerResourceLevelExample example);

    int deleteByExample(PowerResourceLevelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PowerResourceLevel record);

    int insertSelective(PowerResourceLevel record);

    List<PowerResourceLevel> selectByExample(PowerResourceLevelExample example);

    PowerResourceLevel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PowerResourceLevel record, @Param("example") PowerResourceLevelExample example);

    int updateByExample(@Param("record") PowerResourceLevel record, @Param("example") PowerResourceLevelExample example);

    int updateByPrimaryKeySelective(PowerResourceLevel record);

    int updateByPrimaryKey(PowerResourceLevel record);
}