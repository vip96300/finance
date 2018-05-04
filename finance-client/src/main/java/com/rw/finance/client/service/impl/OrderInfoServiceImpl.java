package com.rw.finance.client.service.impl;

import com.rw.finance.client.service.OrderInfoService;
import com.rw.finance.client.dao.OrderInfoMapper;
import com.rw.finance.common.entity.OrderInfo;
import com.rw.finance.common.entity.OrderInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * @file OrderInfoServiceImpl.java	
 * @author huanghongfei
 * @date 2017年12月15日 上午9:52:21
 * @declaration
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService{

	@Autowired
	private OrderInfoMapper orderInfoMapper;
	
	@Override
	public void add(OrderInfo orderInfo) {
		orderInfoMapper.insert(orderInfo);
	}

	@Override
	public List<OrderInfo> listByMemberidAndType(long memberid,int type,int page,int size) {
		OrderInfoExample example = new OrderInfoExample();
		example.setOrderByClause("create_time desc");
		example.setOffset((page - 1) * size);
		example.setLimit(size);
		OrderInfoExample.Criteria criteria=example.createCriteria();
		criteria.andUserIdEqualTo(memberid);
		criteria.andTypeEqualTo(type);
		return orderInfoMapper.selectByExample(example);
	}

	@Override
	public OrderInfo getByDetailsLike(String details) {
		return orderInfoMapper.selectByDetailsLike(details);
	}

}
