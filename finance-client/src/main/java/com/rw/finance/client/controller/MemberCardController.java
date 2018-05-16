package com.rw.finance.client.controller;

import java.util.List;

import com.rw.finance.client.annotation.Member;
import com.rw.finance.common.entity.BankInfo;
import com.rw.finance.common.entity.MemberCard;
import com.rw.finance.common.entity.MemberInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.rw.finance.client.vo.MemberCardVo;
import com.rw.finance.common.constants.MemberCardConstatns;
import com.rw.finance.common.constants.MemberInfoConstants;
import com.rw.finance.common.constants.OrderInfoConstants;
import com.rw.finance.common.entity.order.MemberCardOrder;
import com.rw.finance.common.pay.PayResult;
import com.rw.finance.common.pay.PayerBo;
import com.rw.finance.common.pay.PayerFactory;
import com.rw.finance.client.service.BaseCacheService;
import com.rw.finance.client.service.MemberCardService;
import com.rw.finance.client.service.BankInfoService;
import com.rw.finance.client.service.MemberInfoService;
import com.rw.finance.client.service.OrderInfoService;
import com.rw.finance.client.service.PayChannelService;
import com.rw.finance.common.utils.Result;
import com.rw.finance.common.utils.UuidUtil;

/**
 * 
 * @file MemberCardController.java	
 * @author huanghongfei
 * @date 2017年12月14日 上午11:18:31
 * @declaration
 */
@RestController
@RequestMapping(value="/member/card")
public class MemberCardController {

	@Autowired
	private MemberCardService memberCardService;
	@Autowired
	private BankInfoService bankInfoService;
	@Autowired
	private MemberInfoService memberInfoService;
	@Autowired
	private BaseCacheService baseCacheService;
	@Autowired
	private OrderInfoService orderInfoService;
	@Autowired
	private PayChannelService payChannelService;
	/**
	 * 添加银行卡
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/add")
	public Result<Object> add(@RequestAttribute(value="memberid")long memberid,
			@RequestParam(value="bankid")long bankid,
			@RequestParam(value="cardno")String cardno,
			@RequestParam(value="mobile")String mobile){
		MemberInfo memberInfo=memberInfoService.getByMemberid(memberid);
		if(memberInfo.getIsReal().intValue()==0){
			return new Result<>(500,"请先实名认证",null);
		}
		BankInfo bankInfo=bankInfoService.getByBankid(bankid);
		if(StringUtils.isEmpty(bankInfo)){
			return new Result<>(501,"银行信息未找到或暂不支持",null);
		}
		if(memberCardService.isExsit(cardno)){
			return new Result<>(502,"银行卡片已存在",null);
		}
		MemberCard memberCard =new MemberCard(memberid,memberInfo.getIdNumber(),bankInfo.getBankId(),memberInfo.getRealName(),cardno,mobile,bankInfo.getBankCode(),
				bankInfo.getBankName(),bankInfo.getAbbreviation(),bankInfo.getBankLogo(),bankInfo.getCardColor(),bankInfo.getBankExtra());
		String TradeNo=UuidUtil.TradeNoBuilder(OrderInfoConstants.Prefix.MemberCardOrder.getPrefix());
		PayResult payResult=new PayerFactory().DefaultPayer().auth(new PayerBo().new UserInfo(memberInfo.getIdNumber(),memberInfo.getRealName()),
				new PayerBo().new CardInfo(bankInfo.getBankName(),memberCard.getProvince(),memberCard.getCity(),memberCard.getAbbreviation(),cardno,mobile,"", ""),
				new PayerBo().new OrderInfo(TradeNo, "", 1,0,new PayerFactory().DefaultPayer().getBackUrl(),""));
		if(!payResult.getSuccess()){
			return new Result<>(505,"储蓄卡认证失败",null);
		}
		memberCardService.add(memberCard);
		return new Result<>(200, null, null);
	}

	/**
	 * 鉴权
	 * @param memberid
	 * @param supid 银行编号
	 * @param number 卡号
	 * @param expirydate 有效期
	 * @param authcode 安全码
	 * @param billdate 账单日
	 * @param repaydate 还款日
	 * @param mobile 预留手机号
	 * @param code 短信验证码
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/auth")
	public Result<Object> auth(@RequestAttribute(value="memberid")long memberid,
			@RequestParam(value="bankid")long bankid,
			@RequestParam(value="cardno")String cardno,
			@RequestParam(value="expirydate")String expirydate,
			@RequestParam(value="authcode")String authcode,
			@RequestParam(value="billdate")String billdate,
			@RequestParam(value="repaydate")String repaydate,
			@RequestParam(value="mobile")String mobile){
		MemberInfo memberInfo=memberInfoService.getByMemberid(memberid);
		if(memberInfo.getIsReal().intValue()==0){
			return new Result<>(500,"请先实名认证",null);
		}
		if(memberCardService.isExsit(cardno)){
			return new Result<>(501,"银行卡片已存在",null);
		}
		BankInfo bankInfo=bankInfoService.getByBankid(bankid);
		if(StringUtils.isEmpty(bankInfo)){
			return new Result<>(502,"银行信息未找到",null);
		}
		//支付鉴权
		MemberCard memberCard =new MemberCard(memberid,memberInfo.getIdNumber(),bankInfo.getBankId(),
				cardno,memberInfo.getRealName(),expirydate,authcode,billdate,
				repaydate,mobile,bankInfo.getBankCode(),bankInfo.getBankName(),bankInfo.getAbbreviation(),
				bankInfo.getBankLogo(),bankInfo.getCardColor(),bankInfo.getBankExtra());
		String TradeNo=UuidUtil.TradeNoBuilder(OrderInfoConstants.Prefix.MemberCardOrder.getPrefix());
		PayResult payResult=this.pay(TradeNo,memberInfo, memberCard,MemberCardConstatns.AUTH_PAY_AMOUNT);
		if(payResult.getSuccess()){
			memberCard=memberCardService.add1(memberCard);
		}else {
			return new Result<>(505, payResult.getDetails(), null);
		}
		orderInfoService.add(new com.rw.finance.common.entity.OrderInfo(memberInfo.getMemberId(),memberInfo.getRealName(), TradeNo,
				MemberCardConstatns.AUTH_PAY_AMOUNT, MemberCardConstatns.AUTH_PAY_AMOUNT,payChannelService.getByIsdef().getChannelId(),payResult.getPayTradeNo(),
				OrderInfoConstants.Type.MemberCardOrder.getType(), payResult.getDetails(),new Gson().toJson(new MemberCardOrder(memberCard.getCardId()))));
		MemberCardVo.AuthVo vo=new MemberCardVo().new AuthVo(payResult.getTradeNo(),memberCard.getCardId(),payResult.getIsNeedSms());
		return new Result<>(200,null,vo);
	}
	/**
	 * 将储蓄卡设为默认，只能是储蓄卡
	 * @param memberid
	 * @param cardid
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/isdef")
	public Result<Object> isdef(@RequestAttribute(value="memberid")long memberid,
								@RequestParam(value="cardid")long cardid){
		memberCardService.isdef(memberid, cardid);
		return new Result<>(200,null,null);
	}
	/**
	 * 支付重发验证码
	 * @return
	 */
	@RequestMapping(value="/reSendSms")
	public Result<Object> reSendSms(@RequestParam(value="TradeNo")String TradeNo){
		PayResult payResult=new PayerFactory().DefaultPayer().reSendSms(new PayerBo().new OrderInfo(TradeNo,"", 0,0,new PayerFactory().DefaultPayer().getBackUrl(),""));
		if(!payResult.getSuccess()){
			return new Result<>(501,payResult.getDetails(),null);
		}
		return new Result<>(200,null,null);
	}
	
	/**
	 * 添加贷记卡
	 * @param memberid
	 * @param cardid 卡编号
	 * @param tn 支付平台流水号
	 * @param code 短信验证码
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/confirm")
	public Result<Object> confirm(@RequestAttribute(value="memberid")long memberid,
		@RequestParam(value="tn")String tn,
		@RequestParam(value="code")String code){
		PayResult payResult=this.confirm(tn, code);
		if(!payResult.getSuccess()){
			return new Result<>(505,payResult.getDetails(),null);
		}
		return new Result<>(200,null,null);
	}
	/**
	 * 申请支付
	 * @param memberInfo
	 * @param memberCard
	 */
	private PayResult pay(String TradeNo,MemberInfo memberInfo,MemberCard memberCard,Double amount){
		return new PayerFactory().DefaultPayer().pay(new PayerBo().new UserInfo(memberInfo.getIdNumber(), memberInfo.getRealName()),
				new PayerBo().new CardInfo(memberCard.getBankName(),memberCard.getProvince(),memberCard.getCity(),memberCard.getAbbreviation(),memberCard.getCardNo(), memberCard.getMobile(), memberCard.getAuthCode(),memberCard.getExpiryDate()),
				new PayerBo().new OrderInfo(TradeNo, "", amount,0,new PayerFactory().DefaultPayer().getBackUrl(),""));
	}
	/**
	 * 确认支付
	 * @param tn
	 */
	private PayResult confirm(String tn,String smsCode){
		PayResult payResult=new PayerFactory().DefaultPayer().confirm(new PayerBo().new OrderInfo(tn, "", 0,0,new PayerFactory().DefaultPayer().getBackUrl(),smsCode));
		return payResult;
	}
	
	
	/**
	 * 获取用户借记卡列表
	 * @param memberid
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/listByMemberidAndType")
	public Result<Object> listByMemberidAndType(@RequestAttribute(value="memberid")long memberid){
		List<MemberCard> memberCards =this.memberCardService.listByMemberidAndType(memberid,MemberCardConstatns.Type.TYPE1.getType());
		return new Result<>(200,null, memberCards);
	}
	/**
	 * 获取用户袋记卡列表
	 * @param memberid
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/listByMemberidAndType1")
	public Result<Object> listByMemberidAndType1(@RequestAttribute(value="memberid")long memberid){
		List<MemberCard> memberCards =this.memberCardService.listByMemberidAndType(memberid,MemberCardConstatns.Type.TYPE2.getType());
		return new Result<>(200,null,  memberCards);
	}
	
	/**
	 * 贷记卡编辑
	 * @param memberid
	 * @param cardid
	 * @param billdate
	 * @param repaydate
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/updByMemberidAndCardid")
	public Result<Object> updByMemberidAndCardid(@RequestAttribute(value="memberid")long memberid,
			@RequestParam(value="cardid")long cardid,
			@RequestParam(value="billdate")String billdate,
			@RequestParam(value="repaydate")String repaydate){
			MemberCard memberCard=memberCardService.getByMemberidAndCardid(memberid, cardid);
			if(StringUtils.isEmpty(memberCard)){
				return new Result<>(501,"银行卡片不存在",null);
			}
			memberCard.setBillDate(billdate);
			memberCard.setRepayDate(repaydate);
			memberCardService.update(memberCard);
		return new Result<>(200,null,null);
	}
	/**
	 * 删除卡片
	 * @param memberid
	 * @param cardid
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/delByMemberidAndCardid")
	public Result<Object> delByMemberidAndCardid(@RequestAttribute(value="memberid")long memberid,
			@RequestParam(value="cardid")long cardid){
		memberCardService.delByMemberidAndCardid(memberid, cardid);
		return new Result<>(200,null,null);
	}
}
