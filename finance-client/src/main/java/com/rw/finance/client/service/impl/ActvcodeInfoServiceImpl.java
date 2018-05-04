package com.rw.finance.client.service.impl;

import com.google.gson.Gson;
import com.rw.finance.common.constants.ActvcodeInfoConstants;
import com.rw.finance.common.constants.MemberInfoConstants;
import com.rw.finance.common.constants.OrderInfoConstants;
import com.rw.finance.client.dao.ActvcodeInfoMapper;
import com.rw.finance.client.dao.MemberInfoMapper;
import com.rw.finance.client.dao.OrderInfoMapper;
import com.rw.finance.client.dao.PayChannelMapper;
import com.rw.finance.common.entity.ActvcodeInfo;
import com.rw.finance.common.entity.MemberCard;
import com.rw.finance.common.entity.MemberInfo;
import com.rw.finance.common.entity.OrderInfo;
import com.rw.finance.common.entity.order.MemberActiveOrder;
import com.rw.finance.common.pay.PayResult;
import com.rw.finance.common.pay.PayerBo;
import com.rw.finance.common.pay.PayerFactory;
import com.rw.finance.common.pay.YeeBao2Payer;
import com.rw.finance.client.service.ActvcodeInfoService;
import com.rw.finance.common.utils.DateUtils;
import com.rw.finance.common.utils.UuidUtil;
import com.rw.finance.client.config.SystemSetting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @file ActvcodeInfoServiceImpl.java	
 * @author huanghongfei
 * @date 2017年12月15日 下午2:28:39
 * @declaration
 */
@Service
public class ActvcodeInfoServiceImpl implements ActvcodeInfoService{

	private static final Logger log=LoggerFactory.getLogger(ActvcodeInfoServiceImpl.class);
	
	@Autowired
	private ActvcodeInfoMapper actvcodeInfoMapper;
	@Autowired
	private MemberInfoMapper memberInfoMapper;
	@Autowired
	private OrderInfoMapper orderInfoMapper;
	@Autowired
	private SystemSetting systemSetting;
	@Autowired
	private PayChannelMapper payChannelMapper;

	@Override
	public ActvcodeInfo getByActivecode(String activecode) {
		return actvcodeInfoMapper.selectByActiveCode(activecode);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void testActive(long memberid) {
		MemberInfo memberInfo=memberInfoMapper.selectByPrimaryKey(memberid);
		if(!StringUtils.isEmpty(memberInfo.getLevelTime())||memberInfo.getIsReal().intValue()!=1){
			return;//已经试用过或已激活或未实名
		}
		memberInfo.setLevel(MemberInfoConstants.Level.LEVEL_0);
		Calendar calendar= Calendar.getInstance();
		calendar.set(Calendar.DATE,calendar.get(Calendar.DATE)+MemberInfoConstants.TEST_ACTIVE_DATE);
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.SECOND,0);
		calendar.set(Calendar.MINUTE,0);
		memberInfo.setLevelTime(DateUtils.getTimeStr(calendar.getTime()));
		memberInfo.setActiveTime(DateUtils.getTimeStr(new Date()));
		memberInfoMapper.updateByPrimaryKey(memberInfo);
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public void codeActive(long memberid, String activecode) {
		ActvcodeInfo actvcodeInfo=actvcodeInfoMapper.selectByActiveCode(activecode);
		if(StringUtils.isEmpty(actvcodeInfo)){
			log.error("actvcode info is null,activecode:{}",activecode);
			return;
		}
		MemberInfo memberInfo=memberInfoMapper.selectByPrimaryKey(memberid);
		if(StringUtils.isEmpty(memberInfo)){
			log.error("member info is null,memberid :{}",memberid);
			return;
		}
		actvcodeInfo.setUseStatus(ActvcodeInfoConstants.UseStatus.STATUS2.getStatus());
		actvcodeInfo.setUseTime(DateUtils.getTimeStr(new Date()));
		actvcodeInfo.setMemberId(memberid);
		actvcodeInfoMapper.updateByPrimaryKey(actvcodeInfo);
		memberInfo.setLevel(actvcodeInfo.getLevel());
		memberInfo.setLevelTime(MemberInfoConstants.LEVEL_TIME_DEFAULT);
		memberInfo.setActiveTime(DateUtils.getTimeStr(new Date()));
		memberInfoMapper.updateByPrimaryKey(memberInfo);
	}
	
	@Transactional(rollbackFor=Exception.class)
	@Override
	public PayResult payActive(MemberInfo memberInfo, MemberCard memberCard, int level, String method, String beforeCallbackUrl) {
		double payAmount=systemSetting.getLevelPrice(level);
		String TradeNo=UuidUtil.TradeNoBuilder(OrderInfoConstants.Prefix.MemberActiveOrder.getPrefix());
		PayerBo.OrderInfo oi=new PayerBo().new OrderInfo(TradeNo,"", payAmount,0,new YeeBao2Payer().getBackUrl(),"");
		oi.setBeforeBackUrl(beforeCallbackUrl);
		oi.getProductInfo().setName("会员激活");
		oi.getProductInfo().setDetails("58还款-会员激活");
		PayResult payResult=new YeeBao2Payer().pay(new PayerBo().new UserInfo(memberCard.getIdNumber(),memberCard.getRealName()),
				new PayerBo().new CardInfo(memberCard.getBankName(),memberCard.getProvince(),memberCard.getCity(),memberCard.getAbbreviation(),memberCard.getCardNo(), memberCard.getMobile(), memberCard.getAuthCode(), memberCard.getExpiryDate()),
				oi,
				new PayerBo().new PayInfo(method, "", ""));
		orderInfoMapper.insert(new OrderInfo(memberInfo.getMemberId(),memberInfo.getRealName(),TradeNo, payAmount, payAmount,payChannelMapper.selectByIsDef(1).getChannelId(),payResult.getPayTradeNo(), OrderInfoConstants.Type.MemberActiveOrder.getType(), "",
			new Gson().toJson(new MemberActiveOrder(level))));
		return payResult;
	}
	
	@Override
	public PayResult confirmPayActive(String TradeNo, String code) {
		OrderInfo orderInfo=orderInfoMapper.selectByTradeNo(TradeNo);
		if(StringUtils.isEmpty(orderInfo)){
			log.error("order info is null");
			return null;
		}
		PayResult payResult=new PayerFactory().DefaultPayer().confirm(new PayerBo().new OrderInfo(TradeNo, null, 0,0,new PayerFactory().DefaultPayer().getBackUrl(), code));
		return payResult;
	}

	@Override
	public PayResult upgrade() {
		//TODO
		return null;
	}
}
