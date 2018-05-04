package com.rw.finance.client.dao;

import com.rw.finance.common.entity.MemberAccount;
import com.rw.finance.common.entity.MemberAccountExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MemberAccountMapper {
    long countByExample(MemberAccountExample example);

    int deleteByExample(MemberAccountExample example);

    int deleteByPrimaryKey(Long accountId);

    int insert(MemberAccount record);

    int insertSelective(MemberAccount record);

    List<MemberAccount> selectByExample(MemberAccountExample example);

    MemberAccount selectByPrimaryKey(Long accountId);

    int updateByExampleSelective(@Param("record") MemberAccount record, @Param("example") MemberAccountExample example);

    int updateByExample(@Param("record") MemberAccount record, @Param("example") MemberAccountExample example);

    int updateByPrimaryKeySelective(MemberAccount record);

    int updateByPrimaryKey(MemberAccount record);

    @Select("select * from member_account o where o.member_id=#{memberId}")
    @ResultMap(value={"BaseResultMap"})
    MemberAccount selectByMemberId(@Param("memberId") long memberId);
    /**
     * 增加代还总额
     * @param memberId
     * @param amount
     */
    @Select("update member_account set repay_total=repay_total+#{amount} where member_id=#{memberId}")
    void addRepayTotal(@Param("memberId") long memberId, @Param("amount") double amount);

    /**
     * 增加提现总额
     * @param memberId
     * @param amount
     */
    @Select("update member_account set cash_total=cash_total+#{amount} where member_id=#{memberId}")
    void addCashTotal(@Param("memberId") long memberId, @Param("amount") double amount);

    /**
     * 增加套现总额
     * @param memberId
     * @param amount
     */
    @Select("update member_account set borrow_total=borrow_total+#{amount} where member_id=#{memberId}")
    void addBorrowTotal(@Param("memberId") long memberId, @Param("amount") double amount);
}