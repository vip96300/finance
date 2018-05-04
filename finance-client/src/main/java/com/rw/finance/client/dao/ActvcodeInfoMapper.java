package com.rw.finance.client.dao;

import com.rw.finance.common.entity.ActvcodeInfo;
import com.rw.finance.common.entity.ActvcodeInfoExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ActvcodeInfoMapper {
    long countByExample(ActvcodeInfoExample example);

    int deleteByExample(ActvcodeInfoExample example);

    int deleteByPrimaryKey(Long activeId);

    int insert(ActvcodeInfo record);

    int insertSelective(ActvcodeInfo record);

    List<ActvcodeInfo> selectByExample(ActvcodeInfoExample example);

    ActvcodeInfo selectByPrimaryKey(Long activeId);

    int updateByExampleSelective(@Param("record") ActvcodeInfo record, @Param("example") ActvcodeInfoExample example);

    int updateByExample(@Param("record") ActvcodeInfo record, @Param("example") ActvcodeInfoExample example);

    int updateByPrimaryKeySelective(ActvcodeInfo record);

    int updateByPrimaryKey(ActvcodeInfo record);

    @Select("select * from actvcode_info o where o.active_code=#{activeCode}")
    @ResultMap(value={"BaseResultMap"})
    ActvcodeInfo selectByActiveCode(@Param("activeCode") String activeCode);
}