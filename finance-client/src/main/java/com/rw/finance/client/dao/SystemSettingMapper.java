package com.rw.finance.client.dao;

import com.rw.finance.common.entity.SystemSetting;
import com.rw.finance.common.entity.SystemSettingExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SystemSettingMapper {

    long countByExample(SystemSettingExample example);

    int deleteByExample(SystemSettingExample example);

    int deleteByPrimaryKey(Long dictId);

    int insert(SystemSetting record);

    int insertSelective(SystemSetting record);

    List<SystemSetting> selectByExample(SystemSettingExample example);

    SystemSetting selectByPrimaryKey(Long dictId);

    int updateByExampleSelective(@Param("record") SystemSetting record, @Param("example") SystemSettingExample example);

    int updateByExample(@Param("record") SystemSetting record, @Param("example") SystemSettingExample example);

    int updateByPrimaryKeySelective(SystemSetting record);

    int updateByPrimaryKey(SystemSetting record);

    @Select("select * from system_setting o where o.dict_key=#{dictKey}")
    @ResultMap(value={"BaseResultMap"})
    SystemSetting selectByDictKey(@Param("dictKey") String dictKey);

    @Select("select * from system_setting o where o.is_app=#{isApp}")
    @ResultMap(value={"BaseResultMap"})
    List<SystemSetting> selectByIsApp(@Param("isApp") int isApp);
}