package com.rw.finance.client.dao;

import com.rw.finance.common.entity.MemberProfit;
import com.rw.finance.common.entity.MemberProfitExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MemberProfitMapper {
    long countByExample(MemberProfitExample example);

    int deleteByExample(MemberProfitExample example);

    int deleteByPrimaryKey(Long pofitId);

    int insert(MemberProfit record);

    int insertSelective(MemberProfit record);

    List<MemberProfit> selectByExample(MemberProfitExample example);

    MemberProfit selectByPrimaryKey(Long pofitId);

    int updateByExampleSelective(@Param("record") MemberProfit record, @Param("example") MemberProfitExample example);

    int updateByExample(@Param("record") MemberProfit record, @Param("example") MemberProfitExample example);

    int updateByPrimaryKeySelective(MemberProfit record);

    int updateByPrimaryKey(MemberProfit record);

    /**
     * 求和利润金额，交易金额，统计会员数，等级分组
     * @param memberId
     * @return
     */
    @Select("select level,ifnull(sum(amount),0) as amount,ifnull(sum(biz_amount),0)as biz_amount,count(distinct pro_member_id) as pro_member_id from member_profit o where member_id=#{memberId} group by o.level;")
    List<Object[]> sumAmountAndBizamountCountPromemberIdByMemberIdGroupByLevel(@Param("memberId") long memberId);
    /**
     * 统计当日收益
     * @param memberId
     * @param date
     * @return
     */
    @Select("select ifnull(sum(amount),0) from member_profit o where o.member_id=#{memberId} and o.create_time like concat(#{date},'%')")
    double sumAmountByMemberIdAndCreateTimeLikeDate(@Param("memberId") long memberId, @Param("date") String date);
    /**
     * 统计当月收益
     * @param memberId
     * @param month
     * @return
     */
    @Select("select ifnull(sum(amount),0) from member_profit o where o.member_id=#{memberId} and o.create_time like concat(#{month},'%')")
    double sumAmountByMemberIdAndCreateTimeLikeMonth(@Param("memberId") long memberId, @Param("month") String month);
    /**
     * 统计所有收益
     * @param memberId
     * @return
     */
    @Select("select ifnull(sum(amount),0) from member_profit o where o.member_id=#{memberId}")
    double sumAmountByMemberId(@Param("memberId") long memberId);
}