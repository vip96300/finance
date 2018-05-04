package com.rw.finance.client.controller;

import com.rw.finance.client.annotation.Member;
import com.rw.finance.common.entity.MemberInfo;
import com.rw.finance.common.entity.MemberLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rw.finance.common.constants.MemberInfoConstants;
import com.rw.finance.client.service.MemberInfoService;
import com.rw.finance.client.service.MemberLevelService;
import com.rw.finance.client.service.PayChannelService;
import com.rw.finance.common.utils.Result;

/**
 * 
 * @file MemberLevelController.java	
 * @author huanghongfei
 * @date 2018年2月6日 下午2:01:38
 * @declaration
 */
@RequestMapping(value="/member/level")
@RestController
public class MemberLevelController {

	@Autowired
	private MemberLevelService memberLevelService;
	@Autowired
	private MemberInfoService memberInfoService;
	@Autowired
	private PayChannelService payChannelService;
	/**
	 * 根据会员等级和默认渠道编号获取会员级别信息
	 * @param memberid
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/getByLevelAndChannelId")
	public Result<Object> getByLevelAndChannelId(@RequestAttribute(value="memberid")long memberid){
		MemberInfo memberInfo=memberInfoService.getByMemberid(memberid);
		MemberLevel memberLevel=memberLevelService.getByLevelAndChannelid(memberInfo.getLevel().intValue(),payChannelService.getByIsdef().getChannelId());
		return new Result<Object>(200,null,memberLevel);
	}
	
}
