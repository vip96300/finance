package com.rw.finance.client.dao;

import com.rw.finance.common.entity.PowerResource;
import com.rw.finance.common.entity.PowerResourceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PowerResourceMapper {
    long countByExample(PowerResourceExample example);

    int deleteByExample(PowerResourceExample example);

    int deleteByPrimaryKey(Long resourceId);

    int insert(PowerResource record);

    int insertSelective(PowerResource record);

    List<PowerResource> selectByExampleWithBLOBs(PowerResourceExample example);

    List<PowerResource> selectByExample(PowerResourceExample example);

    PowerResource selectByPrimaryKey(Long resourceId);

    int updateByExampleSelective(@Param("record") PowerResource record, @Param("example") PowerResourceExample example);

    int updateByExampleWithBLOBs(@Param("record") PowerResource record, @Param("example") PowerResourceExample example);

    int updateByExample(@Param("record") PowerResource record, @Param("example") PowerResourceExample example);

    int updateByPrimaryKeySelective(PowerResource record);

    int updateByPrimaryKeyWithBLOBs(PowerResource record);

    int updateByPrimaryKey(PowerResource record);
}