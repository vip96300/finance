package com.rw.finance.client.dao;

import com.rw.finance.common.entity.MemberLevel;
import com.rw.finance.common.entity.MemberLevelExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MemberLevelMapper {
    long countByExample(MemberLevelExample example);

    int deleteByExample(MemberLevelExample example);

    int deleteByPrimaryKey(Long levelId);

    int insert(MemberLevel record);

    int insertSelective(MemberLevel record);

    List<MemberLevel> selectByExample(MemberLevelExample example);

    MemberLevel selectByPrimaryKey(Long levelId);

    int updateByExampleSelective(@Param("record") MemberLevel record, @Param("example") MemberLevelExample example);

    int updateByExample(@Param("record") MemberLevel record, @Param("example") MemberLevelExample example);

    int updateByPrimaryKeySelective(MemberLevel record);

    int updateByPrimaryKey(MemberLevel record);

    @Select("select * from member_level o where o.level=#{level} and o.channel_id=#{channelId}")
    @ResultMap(value={"BaseResultMap"})
    MemberLevel selectByLevelAndChannelId(@Param("level") int level, @Param("channelId") long channelId);

    @Select("select * from member_level o where o.channel_id=#{channelId}")
    @ResultMap(value={"BaseResultMap"})
    List<MemberLevel> selectByChannelId(@Param("channelId") long channelId);

    @Select("select * from member_level o where o.level=#{level}")
    @ResultMap(value={"BaseResultMap"})
    MemberLevel selectByLevel(@Param("level")int level);
}