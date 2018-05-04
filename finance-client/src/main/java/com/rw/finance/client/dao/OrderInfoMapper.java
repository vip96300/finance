package com.rw.finance.client.dao;

import com.rw.finance.common.entity.OrderInfo;
import com.rw.finance.common.entity.OrderInfoExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderInfoMapper {
    long countByExample(OrderInfoExample example);

    int deleteByExample(OrderInfoExample example);

    int deleteByPrimaryKey(Long OrderId);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    List<OrderInfo> selectByExample(OrderInfoExample example);

    OrderInfo selectByPrimaryKey(Long OrderId);

    int updateByExampleSelective(@Param("record") OrderInfo record, @Param("example") OrderInfoExample example);

    int updateByExample(@Param("record") OrderInfo record, @Param("example") OrderInfoExample example);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

    @Select("select * from order_info o where o.trade_no=#{TradeNo}")
    @ResultMap(value={"BaseResultMap"})
    OrderInfo selectByTradeNo(@Param("TradeNo") String TradeNo);

    @Select("select * from order_info o where o.details like concat('%',#{details},'%')")
    @ResultMap(value={"BaseResultMap"})
    OrderInfo selectByDetailsLike(@Param("details") String details);
}