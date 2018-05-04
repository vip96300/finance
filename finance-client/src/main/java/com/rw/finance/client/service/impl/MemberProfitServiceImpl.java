package com.rw.finance.client.service.impl;

import com.rw.finance.client.service.MemberProfitService;
import com.rw.finance.client.dao.MemberAccountMapper;
import com.rw.finance.client.dao.MemberInfoMapper;
import com.rw.finance.client.dao.MemberProfitMapper;
import com.rw.finance.common.entity.MemberAccount;
import com.rw.finance.common.entity.MemberProfit;
import com.rw.finance.common.entity.MemberProfitExample;
import com.rw.finance.common.utils.MathUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 
 * @file MemberProfitServiceImpl.java	
 * @author huanghongfei
 * @date 2017年12月22日 下午4:47:19
 * @declaration
 */
@Service
public class MemberProfitServiceImpl implements MemberProfitService{

	@Autowired
	private MemberProfitMapper memberProfitMapper;
	@Autowired
	private MemberAccountMapper memberAccountMapper;
	@Autowired
	private MemberInfoMapper memberInfoMapper;
	
	@Async
	@Transactional(rollbackFor=Exception.class)
	@Override
	public void add(MemberProfit memberProfit) {
		memberProfitMapper.insert(memberProfit);
		MemberAccount memberAccount=memberAccountMapper.selectByMemberId(memberProfit.getMemberId());
		memberAccount.setCashTotal(MathUtils.add(memberAccount.getCashTotal(), memberProfit.getAmount()));//收款总额
		memberAccount.setUsableBalance(MathUtils.add(memberAccount.getUsableBalance(), memberProfit.getAmount()));//可用余额
		memberAccountMapper.updateByPrimaryKey(memberAccount);
	}

	@Override
	public List<MemberProfit> listByMemberidAndLevel(long memberid, int level,int page,int size) {
		MemberProfitExample example = new MemberProfitExample();
		example.setOrderByClause("create_time desc");
		example.setOffset((page - 1) * size);
		example.setLimit(size);
		MemberProfitExample.Criteria criteria=example.createCriteria();
		criteria.andMemberIdEqualTo(memberid);
		criteria.andLevelEqualTo(level);
		return memberProfitMapper.selectByExample(example);
	}


	@Override
	public List<MemberProfit> listByMemberid(long memberid,int page,int size) {
		MemberProfitExample example = new MemberProfitExample();
		example.setOrderByClause("create_time desc");
		example.setOffset((page - 1) * size);
		example.setLimit(size);
		MemberProfitExample.Criteria criteria=example.createCriteria();
		criteria.andMemberIdEqualTo(memberid);
		return memberProfitMapper.selectByExample(example);
	}

	
	@Override
	public List<Object[]> countByMemberidGroupLevel(long memberid) {
		return memberProfitMapper.sumAmountAndBizamountCountPromemberIdByMemberIdGroupByLevel(memberid);
	}

	@Override
	public double sumProfitByMemberidAndDate(long memberid, String date) {
		return memberProfitMapper.sumAmountByMemberIdAndCreateTimeLikeDate(memberid, date);
	}

	@Override
	public double sumProfitByMemberidAndMonth(long memberid, String month) {
		return memberProfitMapper.sumAmountByMemberIdAndCreateTimeLikeMonth(memberid, month);
	}

	@Override
	public double sumProfitByMemberid(long memberid) {
		return memberProfitMapper.sumAmountByMemberId(memberid);
	}

}
