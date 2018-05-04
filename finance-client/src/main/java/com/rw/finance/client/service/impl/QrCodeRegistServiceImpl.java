package com.rw.finance.client.service.impl;

import com.rw.finance.client.service.QrCodeRegistService;
import com.rw.finance.client.dao.QrCodeRegistMapper;
import com.rw.finance.common.entity.QrCodeRegist;
import com.rw.finance.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

/**
 * 
 * @file QrCodeRegistServiceImpl.java	
 * @author huanghongfei
 * @date 2017年12月28日 下午7:45:51
 * @declaration
 */
@Service
public class QrCodeRegistServiceImpl implements QrCodeRegistService{

	@Autowired
	private QrCodeRegistMapper qrCodeRegistMapper;
	
	@Override
	public void add(QrCodeRegist qrCodeRegist) {
		qrCodeRegistMapper.insert(qrCodeRegist);
	}
	
	@Override
	public QrCodeRegist getByIpaddrAndUseragent(String ipaddr,String useragent) {
		Calendar before=Calendar.getInstance();
		before.set(Calendar.MINUTE,before.get(Calendar.MINUTE)-5);
		QrCodeRegist qrCodeRegist=qrCodeRegistMapper.selectByIpAddrAndUserAgentAndCreateTimeGreaterThan(ipaddr, useragent, DateUtils.getTimeStr(before.getTime()));
		return qrCodeRegist;
	}
	
}
