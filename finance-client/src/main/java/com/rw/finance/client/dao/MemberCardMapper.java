package com.rw.finance.client.dao;

import com.rw.finance.common.entity.MemberCard;
import com.rw.finance.common.entity.MemberCardExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MemberCardMapper {
    long countByExample(MemberCardExample example);

    int deleteByExample(MemberCardExample example);

    int deleteByPrimaryKey(Long cardId);

    int insert(MemberCard record);

    int insertSelective(MemberCard record);

    List<MemberCard> selectByExample(MemberCardExample example);

    MemberCard selectByPrimaryKey(Long cardId);

    int updateByExampleSelective(@Param("record") MemberCard record, @Param("example") MemberCardExample example);

    int updateByExample(@Param("record") MemberCard record, @Param("example") MemberCardExample example);

    int updateByPrimaryKeySelective(MemberCard record);

    int updateByPrimaryKey(MemberCard record);

    @Select("select * from member_card o where o.member_id=#{memberId} and o.card_id=#{cardId} and o.type=#{type}")
    @ResultMap(value={"BaseResultMap"})
    MemberCard selectByMemberIdAndCardIdAndType(@Param("memberId") long memberId, @Param("cardId") long cardId, @Param("type") int type);

    @Select("select * from member_card o where o.member_id=#{memberId} and o.type=#{type} and o.is_def=#{isDef} and o.is_del=#{isDel}")
    @ResultMap(value={"BaseResultMap"})
    List<MemberCard> selectByMemberIdAndTypeAndIsDefAndIsDel(@Param("memberId") long memberId, @Param("type") int type, @Param("isDef") int isDef, @Param("isDel") int isDel);

    @Select("select * from member_card o where o.member_id=#{memberId} and o.type=#{type} and o.status=#{status} and o.is_del=#{isDel}")
    @ResultMap(value={"BaseResultMap"})
    List<MemberCard> selectByMemberIdAndTypeAndStatusAndIsDel(@Param("memberId") long memberId, @Param("type") int type, @Param("status") int status, @Param("isDel") int isDel);

    @Select("select * from member_card o where o.card_no=#{cardNo} and o.status=#{status} and o.is_del=#{isDel}")
    @ResultMap(value={"BaseResultMap"})
    List<MemberCard> selectByCardNoAndStatusAndIsDel(@Param("cardNo") String cardNo, @Param("status") int status, @Param("isDel") int isDel);

    @Select("select * from member_card o where o.member_id=#{memberId} and o.card_id=#{cardId}")
    @ResultMap(value={"BaseResultMap"})
    MemberCard selectByMemberIdAndCardId(@Param("memberId") long memberId, @Param("cardId") long cardId);
}