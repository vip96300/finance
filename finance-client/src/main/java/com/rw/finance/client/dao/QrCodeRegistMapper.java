package com.rw.finance.client.dao;

import com.rw.finance.common.entity.QrCodeRegist;
import com.rw.finance.common.entity.QrCodeRegistExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface QrCodeRegistMapper {
    long countByExample(QrCodeRegistExample example);

    int deleteByExample(QrCodeRegistExample example);

    int deleteByPrimaryKey(Long registId);

    int insert(QrCodeRegist record);

    int insertSelective(QrCodeRegist record);

    List<QrCodeRegist> selectByExample(QrCodeRegistExample example);

    QrCodeRegist selectByPrimaryKey(Long registId);

    int updateByExampleSelective(@Param("record") QrCodeRegist record, @Param("example") QrCodeRegistExample example);

    int updateByExample(@Param("record") QrCodeRegist record, @Param("example") QrCodeRegistExample example);

    int updateByPrimaryKeySelective(QrCodeRegist record);

    int updateByPrimaryKey(QrCodeRegist record);

    @Select("select * from qrcode_regist o where o.ip_addr=#{ipAddr} and o.user_agent=#{userAgent} and o.create_time> #{createTime}")
    @ResultMap(value={"BaseResultMap"})
    QrCodeRegist selectByIpAddrAndUserAgentAndCreateTimeGreaterThan(@Param("ipAddr") String ipAddr, @Param("userAgent") String userAgent, @Param("createTime") String createTime);
}