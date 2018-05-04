package com.rw.finance.client.dao;

import com.rw.finance.common.entity.MemberInfo;
import com.rw.finance.common.entity.MemberInfoExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MemberInfoMapper {
    long countByExample(MemberInfoExample example);

    int deleteByExample(MemberInfoExample example);

    int deleteByPrimaryKey(Long memberId);

    int insert(MemberInfo record);

    int insertSelective(MemberInfo record);

    List<MemberInfo> selectByExample(MemberInfoExample example);

    MemberInfo selectByPrimaryKey(Long memberId);

    int updateByExampleSelective(@Param("record") MemberInfo record, @Param("example") MemberInfoExample example);

    int updateByExample(@Param("record") MemberInfo record, @Param("example") MemberInfoExample example);

    int updateByPrimaryKeySelective(MemberInfo record);

    int updateByPrimaryKey(MemberInfo record);

    @Select("select * from member_info o where o.telephone=#{telephone}")
    @ResultMap(value={"BaseResultMap"})
    MemberInfo selectByTelephone(@Param("telephone") String telephone);

    @Select("select * from member_info o where o.telephone=#{telephone} and o.password=#{password}")
    @ResultMap(value={"BaseResultMap"})
    MemberInfo selectByTelephoneAndPassword(@Param("telephone") String telephone, @Param("password") String password);

    @Select("select * from member_info o where o.member_id=#{memberId} and o.password=#{password}")
    @ResultMap(value={"BaseResultMap"})
    MemberInfo selectByMemberIdAndPassword(@Param("memberId") long memberId, @Param("password") String password);

    @Select("select * from member_info o where o.member_id=#{memberId} and o.pay_pwd=#{payPwd}")
    @ResultMap(value={"BaseResultMap"})
    MemberInfo selectByMemberIdAndPayPwd(@Param("memberId") long memberId, @Param("payPwd") String payPwd);

    @Select("select * from member_info o where o.member_id=#{memberId} and o.telephone=#{telephone}")
    @ResultMap(value={"BaseResultMap"})
    MemberInfo selectByMemberIdAndTelephone(@Param("memberId") long memberId, @Param("telephone") String telephone);

    @Select("select * from member_info o where o.parent_id=#{ParentId} order by o.register_time desc")
    @ResultMap(value={"BaseResultMap"})
    List<MemberInfo> selectByParentIdOrderByRegisterTimeDesc(@Param("ParentId") long ParentId);

    @Select("select * from member_info o where o.level>#{level} and o.level_time<#{levelTime}")
    @ResultMap(value={"BaseResultMap"})
    List<MemberInfo> selectByLevelGreaterThanAndLeveltimeLessThan(@Param("level") int level, @Param("levelTime") String levelTime);

    @Select("select count(*) from member_info o where o.parent_id=#{parentId} and o.is_real=#{isReal}")
    long countByParentIdAndIsReal(@Param("parentId")long parentId,@Param("isReal")int isReal);
}