package com.rw.finance.client.service.impl;

import com.rw.finance.client.config.SystemSetting;
import com.rw.finance.common.constants.Constants;
import com.rw.finance.common.constants.MemberCardConstatns;
import com.rw.finance.client.service.MemberInfoService;
import com.rw.finance.client.dao.*;
import com.rw.finance.common.constants.MemberInfoConstants;
import com.rw.finance.common.entity.MemberAccount;
import com.rw.finance.common.entity.MemberCard;
import com.rw.finance.common.entity.MemberInfo;
import com.rw.finance.common.utils.DateUtils;
import com.rw.finance.common.utils.JwtUtil;
import com.rw.finance.common.utils.Md5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @file MemberInfoServiceImpl.java	
 * @author huanghongfei
 * @date 2017年12月9日 下午1:35:06
 * @declaration
 */
@Component
@Service
public class MemberInfoServiceImpl implements MemberInfoService{

	private static final Logger log= LoggerFactory.getLogger(MemberInfoServiceImpl.class);

	@Autowired
	private MemberInfoMapper memberInfoMapper;
	
	@Autowired
	private MemberCardMapper memberCardMapper;
	
	@Autowired
	private MemberAccountMapper memberAccountMapper;
	
	@Autowired
	private MemberLevelMapper memberLevelMapper;
	@Autowired
	private PayChannelMapper payChannelMapper;
	@Autowired
	private SystemSetting systemSetting;
	
	@Override
	public boolean isExistByTelephone(String telephone) {
		MemberInfo memberInfo =memberInfoMapper.selectByTelephone(telephone);
		if(StringUtils.isEmpty(memberInfo)){
			return false;
		}
		return true;
	}
	@Transactional(rollbackFor=Exception.class)
	@Override
	public void register(MemberInfo memberInfo) {
		memberInfoMapper.insert(memberInfo);
		memberAccountMapper.insert(new MemberAccount(memberInfo.getMemberId(), memberLevelMapper.selectByLevelAndChannelId(memberInfo.getLevel(),payChannelMapper.selectByIsDef(1).getChannelId()).getRepayRate(), 0,0, 0, 0, 0));
	}
	@Override
	public MemberInfo getByTelephone(String telephone) {
		MemberInfo memberInfo =memberInfoMapper.selectByTelephone(telephone);
		return memberInfo;
	}

	@Override
	public void update(MemberInfo memberInfo) {
		memberInfoMapper.updateByPrimaryKey(memberInfo);
	}
	
	@Transactional(rollbackFor=Exception.class)
	@Override
	public void isReal(MemberInfo memberInfo, MemberCard memberCard) {
		memberInfoMapper.updateByPrimaryKey(memberInfo);
		//如果该会员的邀请者满足升级条件，升级会员
		MemberInfo parent=memberInfoMapper.selectByPrimaryKey(memberInfo.getParentId());
		if(parent!=null){
			long childCount=memberInfoMapper.countByParentIdAndIsReal(parent.getMemberId(), Constants.YN.Y.getValue());
			log.debug("child count:{}",childCount);
			int nextLevelThreshold=systemSetting.getLevelThreshold(parent.getLevel());
			//满足升级会员的条件了
			if(childCount>=nextLevelThreshold&&parent.getLevel().intValue()<MemberInfoConstants.Level.LEVEL_6){
				parent.setLevel(parent.getLevel().intValue()+1);
				parent.setActiveTime(DateUtils.getTimeStr(new Date()));
				parent.setLevelTime(MemberInfoConstants.LEVEL_TIME_DEFAULT);
				memberInfoMapper.updateByPrimaryKey(parent);
				log.debug("upgrade,memberId:{},leveled:{}",parent.getMemberId(),parent.getLevel());
			}
		}
		List<MemberCard> memberCards =memberCardMapper.selectByMemberIdAndTypeAndIsDefAndIsDel(memberCard.getMemberId(),MemberCardConstatns.Type.TYPE1.getType(), 1,0);
		memberCard.setIsDef(memberCards.isEmpty()?1:0);
		memberCard.setStatus(MemberCardConstatns.Status.STATUS1.getStatus());
		memberCardMapper.updateByPrimaryKey(memberCard);
	}

	
	@Transactional(rollbackFor=Exception.class)
	@Override
	public String login(String telephone, String password) {
		MemberInfo memberInfo =memberInfoMapper.selectByTelephoneAndPassword(telephone,Md5Util.md5(password));
		if(StringUtils.isEmpty(memberInfo)){
			return null;
		}
		//报文头参数列表
		Map<String,Object> headerParams=new HashMap<String,Object>();
		//报文body参数列表
		Map<String,Object> bodyParams=new HashMap<String,Object>();
		bodyParams.put("memberid", memberInfo.getMemberId());
		memberInfo.setLastLoginTime(DateUtils.getTimeStr(new Date()));
		memberInfoMapper.updateByPrimaryKey(memberInfo);
		return JwtUtil.tokenGenerator(headerParams, bodyParams);
	}
	@Override
	public MemberInfo getByMemberid(long memberid) {
		return memberInfoMapper.selectByPrimaryKey(memberid);
	}
	@Override
	public boolean updPasswordByMemberidAndPassword(long memberid, String password,String newPassword) {
		MemberInfo memberInfo =memberInfoMapper.selectByMemberIdAndPassword(memberid, Md5Util.md5(password));
		if(StringUtils.isEmpty(memberInfo)){
			return false;
		}
		memberInfo.setPassword(Md5Util.md5(newPassword));
		memberInfoMapper.updateByPrimaryKey(memberInfo);
		return true;
	}
	@Override
	public boolean updPaypwdByMemberidAndPaypwd(long memberid, String paypwd,String newPaypwd) {
		MemberInfo memberInfo =memberInfoMapper.selectByMemberIdAndPayPwd(memberid, paypwd);
		if(StringUtils.isEmpty(memberInfo)){
			return false;
		}
		memberInfo.setPayPwd(newPaypwd);
		memberInfoMapper.updateByPrimaryKey(memberInfo);
		return true;
	}
	@Override
	public boolean updPaypwdByMemberid(long memberid, String newPaypwd) {
		MemberInfo memberInfo =memberInfoMapper.selectByPrimaryKey(memberid);
		if(StringUtils.isEmpty(memberInfo)){
			return false;
		}
		memberInfo.setPayPwd(newPaypwd);
		memberInfoMapper.updateByPrimaryKey(memberInfo);
		return true;
	}
	@Override
	public boolean updTelephoneByMemberid(long memberid,String newTelephone) {
		MemberInfo memberInfo =memberInfoMapper.selectByPrimaryKey(memberid);
		if(StringUtils.isEmpty(memberInfo)){
			return false;
		}
		memberInfo.setTelephone(newTelephone);
		memberInfoMapper.updateByPrimaryKey(memberInfo);
		return true;
	}
	@Override
	public MemberInfo getByMemberidAndTelephone(long memberid, String telephone) {
		MemberInfo memberInfo =memberInfoMapper.selectByMemberIdAndTelephone(memberid, telephone);
		return memberInfo;
	}

	@Override
	public List<MemberInfo> listByParentId(long parentId) {
		return memberInfoMapper.selectByParentIdOrderByRegisterTimeDesc(parentId);
	}

	@Override
	public List<MemberInfo> listByLevelGreaterThanAndLeveltimeLessThan(int level, String levelTime) {
		List<MemberInfo> memberInfoList=memberInfoMapper.selectByLevelGreaterThanAndLeveltimeLessThan(level,levelTime);
		return memberInfoList;
	}


}
