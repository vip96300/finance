package com.rw.finance.client.dao;

import com.rw.finance.common.entity.RepayPlan;
import com.rw.finance.common.entity.RepayPlanExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RepayPlanMapper {
    long countByExample(RepayPlanExample example);

    int deleteByExample(RepayPlanExample example);

    int deleteByPrimaryKey(Long planId);

    int insert(RepayPlan record);

    int insertSelective(RepayPlan record);

    List<RepayPlan> selectByExample(RepayPlanExample example);

    RepayPlan selectByPrimaryKey(Long planId);

    int updateByExampleSelective(@Param("record") RepayPlan record, @Param("example") RepayPlanExample example);

    int updateByExample(@Param("record") RepayPlan record, @Param("example") RepayPlanExample example);

    int updateByPrimaryKeySelective(RepayPlan record);

    int updateByPrimaryKey(RepayPlan record);

    @Select("select * from repay_plan o where o.status=#{status}")
    @ResultMap(value={"BaseResultMap"})
    List<RepayPlan> selectByStatus(@Param("status") int status);

    @Select("select * from repay_plan o where o.member_id=#{memberId} and o.plan_id=#{planId}")
    @ResultMap(value={"BaseResultMap"})
    RepayPlan selectMemberIdAndPlanId(@Param("memberId") long memberId, @Param("planId") long planId);
}