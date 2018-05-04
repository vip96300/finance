package com.rw.finance.client.controller;

import java.util.Date;

import com.rw.finance.client.annotation.Member;
import com.rw.finance.common.entity.MemberAccount;
import com.rw.finance.common.entity.MemberCard;
import com.rw.finance.common.entity.MemberInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rw.finance.client.vo.MemberAccountVo;
import com.rw.finance.common.constants.MemberCardConstatns;
import com.rw.finance.common.constants.MemberInfoConstants;
import com.rw.finance.common.pay.PayResult;
import com.rw.finance.client.service.MemberAccountService;
import com.rw.finance.client.service.MemberCardService;
import com.rw.finance.client.service.MemberInfoService;
import com.rw.finance.client.service.MemberProfitService;
import com.rw.finance.common.utils.DateUtils;
import com.rw.finance.common.utils.Result;
/**
 * 
 * @file MemberAccountController.java	
 * @author huanghongfei
 * @date 2017年12月23日 下午4:09:26
 * @declaration
 */
@RestController
@RequestMapping(value="/member/account")
public class MemberAccountController {
	
	@Autowired
	private MemberInfoService memberInfoService;
	@Autowired
	private MemberAccountService memberAccountService;
	@Autowired
	private MemberCardService memberCardService;
	@Autowired
	private MemberProfitService memberProfitService;
	/**
	 * 
	 * @param memberid
	 * @param amount
	 * @param cardid
	 * @param paypwd
	 * @param channelid 渠道编号
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/outcash")
	public Result<Object> outcash(@RequestAttribute(value="memberid"  )long memberid,
			@RequestParam(value="amount"  )Double amount,
			@RequestParam(value="cardid"  )long cardid,
			@RequestParam(value="paypwd"  )String paypwd){
		MemberInfo memberInfo=memberInfoService.getByMemberid(memberid);
		if(!memberInfo.getPayPwd().equals(paypwd)){
			return new Result<Object>(500,"支付密码错误",null);
		}
		PayResult payResult=memberAccountService.outcash(memberid, amount,cardid);
		if(!payResult.getSuccess()){
			return new Result<Object>(505,payResult.getDetails(),null);
		}
		return new Result<Object>(200,null,null);
	}
	
	/**
	 * 套现=收款
	 * @param memberid
	 * @param amount 金额
	 * @param fromcardid 支出信用卡编号
	 * @param tocardid 收入储蓄卡编号
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/borrowcash")
	public Result<Object> borrowcash(@RequestAttribute(value="memberid"  )long memberid,
			@RequestParam(value="amount"  )Double amount,
			@RequestParam(value="fromcardid"  )long fromcardid,
			@RequestParam(value="tocardid"  )long tocardid,
			@RequestParam(value="paypwd"  )String paypwd,
			@RequestParam(value="channelid"  )long channelid){
		MemberInfo memberInfo=memberInfoService.getByMemberid(memberid);
		if(!memberInfo.getPayPwd().equals(paypwd)){
			return new Result<Object>(500,"支付密码错误",null);
		}
		MemberCard fromCard=memberCardService.getByMemberidAndCardidAndType(memberid, fromcardid, MemberCardConstatns.Type.TYPE2.getType());
		if(StringUtils.isEmpty(fromCard)){
			return new Result<Object>(501,"信用卡不存在",null);
		}
		if(fromCard.getStatus()!=MemberCardConstatns.Status.STATUS1.getStatus()){//未鉴权
			return new Result<Object>(502,"信用卡无效",null);
		}
		MemberCard toCard=memberCardService.getByMemberidAndCardidAndType(memberid, tocardid, MemberCardConstatns.Type.TYPE1.getType());
		if(StringUtils.isEmpty(toCard)){
			return new Result<Object>(503,"储蓄卡不存在",null);
		}
		PayResult payResult=memberAccountService.borrowcash(memberid, amount, fromcardid, tocardid,channelid);
		return new Result<Object>(200,payResult.getDetails(),payResult.getIsNeedSms());
	}
	/**
	 * 根据会员编号获取账户信息
	 * @param memberid
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/getByMemberid")
	public Result<Object> getByMemberid(@RequestAttribute(value="memberid"  )long memberid){
		MemberAccount memberAccount=memberAccountService.getByMemberid(memberid);
		MemberAccountVo.DetailVo detailVo=new MemberAccountVo().new DetailVo();
		detailVo.setTotalProfit(memberProfitService.sumProfitByMemberid(memberid));
		detailVo.setCurMonthProfit(memberProfitService.sumProfitByMemberidAndMonth(memberid,DateUtils.getMonthStr(new Date())));
		detailVo.setCurDayProfit(memberProfitService.sumProfitByMemberidAndDate(memberid,DateUtils.getDateStr(new Date())));
		detailVo.setUsableBalance(memberAccount.getUsableBalance());
		detailVo.setLockBalance(memberAccount.getLockBalance());
		return new Result<Object>(200,null,detailVo);
	}
}
