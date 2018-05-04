package com.rw.finance.client.dao;

import com.rw.finance.common.entity.RepayTask;
import com.rw.finance.common.entity.RepayTaskExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RepayTaskMapper {
    long countByExample(RepayTaskExample example);

    int deleteByExample(RepayTaskExample example);

    int deleteByPrimaryKey(Long taskId);

    int insert(RepayTask record);

    int insertSelective(RepayTask record);

    List<RepayTask> selectByExample(RepayTaskExample example);

    RepayTask selectByPrimaryKey(Long taskId);

    int updateByExampleSelective(@Param("record") RepayTask record, @Param("example") RepayTaskExample example);

    int updateByExample(@Param("record") RepayTask record, @Param("example") RepayTaskExample example);

    int updateByPrimaryKeySelective(RepayTask record);

    int updateByPrimaryKey(RepayTask record);

    @Select("select * from repay_task o where o.member_id=#{memberId} and o.plan_id=#{planId} and o.execute_time=(select min(execute_time) from repay_task where status=#{status} )")
    @ResultMap(value={"BaseResultMap"})
    RepayTask selectByMemberIdAndPlanIdAndStatusAndExecuteTimeMinOrderByExecuteTime(@Param("memberId") long memberId, @Param("planId") long planId, @Param("status") int status);
}