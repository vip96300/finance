package com.rw.finance.client.dao;

import com.rw.finance.common.entity.LoginInfo;
import com.rw.finance.common.entity.LoginInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoginInfoMapper {
    long countByExample(LoginInfoExample example);

    int deleteByExample(LoginInfoExample example);

    int deleteByPrimaryKey(Long loginId);

    int insert(LoginInfo record);

    int insertSelective(LoginInfo record);

    List<LoginInfo> selectByExample(LoginInfoExample example);

    LoginInfo selectByPrimaryKey(Long loginId);

    int updateByExampleSelective(@Param("record") LoginInfo record, @Param("example") LoginInfoExample example);

    int updateByExample(@Param("record") LoginInfo record, @Param("example") LoginInfoExample example);

    int updateByPrimaryKeySelective(LoginInfo record);

    int updateByPrimaryKey(LoginInfo record);
}