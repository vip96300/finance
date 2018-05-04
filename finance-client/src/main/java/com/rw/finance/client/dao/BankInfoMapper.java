package com.rw.finance.client.dao;

import com.rw.finance.common.entity.BankInfo;
import com.rw.finance.common.entity.BankInfoExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BankInfoMapper {
    long countByExample(BankInfoExample example);

    int deleteByExample(BankInfoExample example);

    int deleteByPrimaryKey(Long bankId);

    int insert(BankInfo record);

    int insertSelective(BankInfo record);

    List<BankInfo> selectByExample(BankInfoExample example);

    BankInfo selectByPrimaryKey(Long bankId);

    int updateByExampleSelective(@Param("record") BankInfo record, @Param("example") BankInfoExample example);

    int updateByExample(@Param("record") BankInfo record, @Param("example") BankInfoExample example);

    int updateByPrimaryKeySelective(BankInfo record);

    int updateByPrimaryKey(BankInfo record);

    @Select("select * from order_info o where o.details like concat('%',#{bankCode},'%')")
    @ResultMap(value={"BaseResultMap"})
    BankInfo selectByBankCodeLike(@Param("bankCode") String bankCode);
}