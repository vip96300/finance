package com.rw.finance.client.service.impl;

import com.rw.finance.common.constants.MemberCardConstatns;
import com.rw.finance.client.service.MemberCardService;
import com.rw.finance.client.dao.MemberCardMapper;
import com.rw.finance.common.entity.MemberCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Calendar;
import java.util.List;

@Service
public class MemberCardServiceImpl implements MemberCardService{

	@Autowired
	private MemberCardMapper memberCardMapper;

	@Transactional(rollbackFor=Exception.class)
	@Override
	public boolean add(MemberCard memberCard) {
		List<MemberCard> memberCards =memberCardMapper.selectByMemberIdAndTypeAndIsDefAndIsDel(memberCard.getMemberId(),MemberCardConstatns.Type.TYPE1.getType(), 1,0);
		memberCard.setIsDef(memberCards.isEmpty()?1:0);
		memberCard.setStatus(MemberCardConstatns.Status.STATUS1.getStatus());
		memberCardMapper.insert(memberCard);
		return true;
	}

	@Override
	public MemberCard add1(MemberCard memberCard) {
		memberCardMapper.insert(memberCard);
		return memberCard;
	}

	@Async
	@Override
	public void isdef(long memberid, long cardid) {
		List<MemberCard> memberCards=memberCardMapper.selectByMemberIdAndTypeAndStatusAndIsDel(memberid, MemberCardConstatns.Type.TYPE1.getType(),MemberCardConstatns.Status.STATUS1.getStatus(), 0);
		memberCards.forEach(memberCard->{
			memberCard.setIsDef(0);
			if(memberCard.getCardId().longValue()==cardid){
				memberCard.setIsDef(1);
			}
		});
		memberCards.forEach(memberCard -> {
			memberCardMapper.updateByPrimaryKey(memberCard);
		});

	}

	/**
	 * 此处判断存在加入状态的原因是因为显示时过滤掉了没有鉴权的卡片，如果会员添加信用卡不鉴权，再次添加时会报出卡片已存在的问题
	 * 且如果添加后不鉴权再次添加也不会再鉴权到上次添加的卡，此处无问题，如果修改了将未鉴权的卡显示给会员，此处也应相应调整，
	 * 判断卡片是否存在的标准需要去除status字段
	 * 过滤未鉴权卡片代码坐标在client中 @See MemberCardController.listByMemberidAndType0和@See MemberCardController.listByMemberidAndType1
	 * @param cardno
	 * @return
	 */
	@Override
	public boolean isExsit(String cardno) {
		List<MemberCard> memberCardList=memberCardMapper.selectByCardNoAndStatusAndIsDel(cardno, MemberCardConstatns.Status.STATUS1.getStatus(),0);
		if(!memberCardList.isEmpty()){
			return true;//卡片已存在
		}
		return false;
	}

	@Override
	public List<MemberCard> listByMemberidAndType(long memberid, int type) {
		List<MemberCard> memberCards =memberCardMapper.selectByMemberIdAndTypeAndStatusAndIsDel(memberid,type,MemberCardConstatns.Status.STATUS1.getStatus(),0);
		if(type==MemberCardConstatns.Type.TYPE2.getType()){//如果是贷记卡，计算今日到账单日和今日到还款日的天数
			Calendar today=Calendar.getInstance();
			memberCards.forEach(memberCard->{
				Calendar toDate=Calendar.getInstance();
				toDate.set(Calendar.DATE,Integer.valueOf(memberCard.getBillDate()));
				memberCard.setToBillDate(toDate.get(Calendar.DAY_OF_YEAR)-today.get(Calendar.DAY_OF_YEAR));//今天至账单日天数
				toDate.set(Calendar.DATE,Integer.valueOf(memberCard.getRepayDate()));
				memberCard.setToRepayDate(toDate.get(Calendar.DAY_OF_YEAR)-today.get(Calendar.DAY_OF_YEAR));//今天至还款日天数
			});
		}
		return memberCards;
	}

	@Override
	public MemberCard getByMemberidAndCardid(long memberid, long cardid) {
		return memberCardMapper.selectByMemberIdAndCardId(memberid, cardid);
	}

	@Override
	public void update(MemberCard memberCard) {
		memberCardMapper.updateByPrimaryKey(memberCard);
	}

	@Override
	public MemberCard getByMemberidAndCardidAndType(long memberid, long cardid,int type) {
		return memberCardMapper.selectByMemberIdAndCardIdAndType(memberid, cardid, type);
	}
	@Override
	public void delByMemberidAndCardid(long memberid, long cardid) {
		MemberCard memberCard=memberCardMapper.selectByMemberIdAndCardId(memberid, cardid);
		if(StringUtils.isEmpty(memberCard)){
			return;
		}
		memberCard.setIsDel(1);
		memberCardMapper.updateByPrimaryKey(memberCard);
	}
	

	
}
