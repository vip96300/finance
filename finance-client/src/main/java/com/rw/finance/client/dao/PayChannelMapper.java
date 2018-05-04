package com.rw.finance.client.dao;

import com.rw.finance.common.entity.PayChannel;
import com.rw.finance.common.entity.PayChannelExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PayChannelMapper {
    long countByExample(PayChannelExample example);

    int deleteByExample(PayChannelExample example);

    int deleteByPrimaryKey(Long channelId);

    int insert(PayChannel record);

    int insertSelective(PayChannel record);

    List<PayChannel> selectByExample(PayChannelExample example);

    PayChannel selectByPrimaryKey(Long channelId);

    int updateByExampleSelective(@Param("record") PayChannel record, @Param("example") PayChannelExample example);

    int updateByExample(@Param("record") PayChannel record, @Param("example") PayChannelExample example);

    int updateByPrimaryKeySelective(PayChannel record);

    int updateByPrimaryKey(PayChannel record);

    @Select("select * from pay_channel o where o.is_def=#{isDef}")
    @ResultMap(value={"BaseResultMap"})
    PayChannel selectByIsDef(@Param("isDef") int isDef);

    @Select("select * from pay_channel o where o.is_enable=#{isEnable}")
    @ResultMap(value={"BaseResultMap"})
    List<PayChannel> selectByIsEnable(@Param("isEnable") int isEnable);
}