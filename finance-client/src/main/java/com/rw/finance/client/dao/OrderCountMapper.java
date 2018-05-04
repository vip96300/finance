package com.rw.finance.client.dao;

import com.rw.finance.common.entity.OrderCount;
import com.rw.finance.common.entity.OrderCountExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderCountMapper {
    long countByExample(OrderCountExample example);

    int deleteByExample(OrderCountExample example);

    int deleteByPrimaryKey(Long countId);

    int insert(OrderCount record);

    int insertSelective(OrderCount record);

    List<OrderCount> selectByExample(OrderCountExample example);

    OrderCount selectByPrimaryKey(Long countId);

    int updateByExampleSelective(@Param("record") OrderCount record, @Param("example") OrderCountExample example);

    int updateByExample(@Param("record") OrderCount record, @Param("example") OrderCountExample example);

    int updateByPrimaryKeySelective(OrderCount record);

    int updateByPrimaryKey(OrderCount record);
}