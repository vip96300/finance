package com.rw.finance.client.service.impl;

import com.google.gson.Gson;
import com.rw.finance.common.constants.MemberCardConstatns;
import com.rw.finance.common.constants.OrderInfoConstants;
import com.rw.finance.client.dao.*;
import com.rw.finance.common.entity.*;
import com.rw.finance.common.entity.bank.BankExtra;
import com.rw.finance.common.entity.order.MemberBorrowOrder;
import com.rw.finance.common.entity.order.MemberCashOrder;
import com.rw.finance.common.pay.PayResult;
import com.rw.finance.common.pay.PayerBo;
import com.rw.finance.common.pay.PayerFactory;
import com.rw.finance.common.pay.YeeBao2Payer;
import com.rw.finance.client.service.MemberAccountService;
import com.rw.finance.common.utils.MathUtils;
import com.rw.finance.common.utils.UuidUtil;
import com.rw.finance.client.config.SystemSetting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * 
 * @file MemberAccountServiceImpl.java	
 * @author huanghongfei
 * @date 2017年12月23日 下午3:55:37
 * @declaration
 */
@Service
public class MemberAccountServiceImpl implements MemberAccountService{

	private static final Logger log=LoggerFactory.getLogger(MemberAccountServiceImpl.class);
	
	@Autowired
	private MemberAccountMapper memberAccountMapper;
	@Autowired
	private MemberCardMapper memberCardMapper;
	@Autowired
	private MemberInfoMapper memberInfoMapper;
	@Autowired
	private MemberLevelMapper memberLevelMapper;
	@Autowired
	private OrderInfoMapper orderInfoMapper;
	@Autowired
	private SystemSetting systemSetting;
	@Autowired
	private PayChannelMapper payChannelMapper;
	
	@Override
	public MemberAccount getByMemberid(long memberid) {
		return memberAccountMapper.selectByMemberId(memberid);
	}

	@Override
	public void update(MemberAccount memberAccount) {
		memberAccountMapper.updateByPrimaryKey(memberAccount);
	}
	
	@Transactional(rollbackFor=Exception.class)
	@Override
	public PayResult outcash(long memberid, double amount,long cardid) {
		MemberInfo memberInfo=memberInfoMapper.selectByPrimaryKey(memberid);
		MemberLevel memberLevel=memberLevelMapper.selectByLevelAndChannelId(memberInfo.getLevel().intValue(), payChannelMapper.selectByIsDef(1).getChannelId());
		MemberAccount memberAccount=memberAccountMapper.selectByMemberId(memberid);
		if(memberAccount.getUsableBalance()<amount||amount<systemSetting.MEMBER_CASH_MIN_AMOUNT()){
			return new PayResult("999", false, "", "", "", 0);
		}
		MemberCard memberCard=memberCardMapper.selectByMemberIdAndCardIdAndType(memberid, cardid,MemberCardConstatns.Type.TYPE1.getType());
		String TradeNo=UuidUtil.TradeNoBuilder(OrderInfoConstants.Prefix.MemberCashOrder.getPrefix());
		double poundage=MathUtils.multiply(amount,memberLevel.getCashRate());//通道费
		poundage=MathUtils.add(poundage, memberLevel.getCashPoundage());//手续费
		double RealAmount=MathUtils.subtract(amount,poundage);
		PayerBo.CardInfo ci=new PayerBo().new CardInfo("","","","","", "", "", "",memberCard.getCardNo());
		ci.setPayeeBankAbbreviation(new Gson().fromJson(memberCard.getBankExtra(), BankExtra.class).getYeepay2BankCode());
		PayResult payResult=new YeeBao2Payer().agentPay(new PayerBo().new UserInfo("","",memberInfo.getIdNumber(), memberInfo.getRealName()),
				ci,
				new PayerBo().new OrderInfo(TradeNo, "", RealAmount,0,new PayerFactory().DefaultPayer().getBackUrl(),""));
		if(payResult.getSuccess()){//接受通知成功，将金额锁定,等待支付成功扣将锁定余额减去
			memberAccount.setUsableBalance(MathUtils.subtract(memberAccount.getUsableBalance(), MathUtils.add(amount,MathUtils.multiply(amount, systemSetting.PAY_SYSTEM_RATE()))));
			memberAccount.setLockBalance(MathUtils.add(memberAccount.getLockBalance(), MathUtils.add(amount,MathUtils.multiply(amount, systemSetting.PAY_SYSTEM_RATE()))));
			memberAccountMapper.updateByPrimaryKey(memberAccount);
			orderInfoMapper.insert(new com.rw.finance.common.entity.OrderInfo(memberid,memberInfo.getRealName(), TradeNo, amount, RealAmount,payChannelMapper.selectByIsDef(1).getChannelId(),payResult.getPayTradeNo(),OrderInfoConstants.Type.MemberCashOrder.getType(),"",new Gson().toJson(new MemberCashOrder(cardid,poundage))));
		}
		return payResult;
	}
	
	@Transactional(rollbackFor=Exception.class)
	@Override
	public PayResult borrowcash(long memberid, double amount, long fromcardid,long tocardid,long channelid) {
		MemberInfo memberInfo=memberInfoMapper.selectByPrimaryKey(memberid);
		Assert.notNull(memberInfo,"memberInfo can't be null!");
		PayChannel payChannel=payChannelMapper.selectByPrimaryKey(channelid);
		Assert.notNull(payChannel,"payChannel can't be null!");
		if(amount<payChannel.getMinAmount()||amount>payChannel.getMaxAmount()){//通道限额
			return new PayResult("999", false, "", "", "", 0);
		}
		MemberCard fromCard=memberCardMapper.selectByMemberIdAndCardIdAndType(memberid, fromcardid, MemberCardConstatns.Type.TYPE2.getType());
		Assert.notNull(fromCard,"fromCard can't be null!");
		MemberCard toCard=memberCardMapper.selectByMemberIdAndCardIdAndType(memberid, tocardid, MemberCardConstatns.Type.TYPE1.getType());
		Assert.notNull(toCard,"toCard can't be null!");
		MemberLevel memberLevel=memberLevelMapper.selectByLevelAndChannelId(memberInfo.getLevel(),payChannel.getChannelId());
		double poundage=MathUtils.multiply(amount, memberLevel.getBorrowRate());//通道费
		poundage=MathUtils.add(poundage,memberLevel.getBorrowPoundage());//手续费
		double RealAmount=MathUtils.subtract(amount,poundage);//实际金额
		String TradeNo=UuidUtil.TradeNoBuilder(OrderInfoConstants.Prefix.MemberBorrowOrder.getPrefix());
		PayResult payResult=null;
		if(channelid==1){//创新支付,分扣款和还款
			payResult=new PayerFactory().ChuangXinPayer().pay(new PayerBo().new UserInfo(memberInfo.getIdNumber(), memberInfo.getRealName()),
					new PayerBo().new CardInfo(fromCard.getBankName(),fromCard.getProvince(),fromCard.getCity(),fromCard.getAbbreviation(),fromCard.getCardNo(), fromCard.getMobile(),fromCard.getAuthCode(),fromCard.getExpiryDate()),
					new PayerBo().new OrderInfo(TradeNo,"", amount,0,new PayerFactory().DefaultPayer().getBackUrl(),""));
		}else if(channelid==2){//绝顶支付，一步完成，已传入收款人卡号
			payResult=new PayerFactory().JdsoftPayer().pay(new PayerBo().new UserInfo(memberInfo.getIdNumber(), memberInfo.getRealName()),
					new PayerBo().new CardInfo(fromCard.getBankName(),fromCard.getProvince(),fromCard.getCity(),fromCard.getAbbreviation(),fromCard.getCardNo(), fromCard.getMobile(),fromCard.getAuthCode(),fromCard.getExpiryDate(),toCard.getCardNo()),
					new PayerBo().new OrderInfo(TradeNo,"", amount,poundage,new PayerFactory().DefaultPayer().getBackUrl(),""));
		}else{
			throw new IllegalStateException("not have channel");
		}
		orderInfoMapper.insert(new com.rw.finance.common.entity.OrderInfo(memberid,memberInfo.getRealName(),TradeNo, amount, RealAmount,payChannel.getChannelId(),payResult.getPayTradeNo(),
				OrderInfoConstants.Type.MemberBorrowOrder.getType(), "", 
				new Gson().toJson(new MemberBorrowOrder(channelid,fromcardid,tocardid,poundage))));
		return payResult;
	}

}
