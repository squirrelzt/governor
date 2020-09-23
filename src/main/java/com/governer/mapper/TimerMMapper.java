package com.governer.mapper;

import com.governer.domain.po.TimerM;
import com.governer.domain.po.TimerMExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TimerMMapper {
    long countByExample(TimerMExample example);

    int deleteByExample(TimerMExample example);

    @Delete({
        "delete from ds_timer_m",
        "where app_name = #{appName,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String appName);

    @Insert({
        "insert into ds_timer_m (app_name, name, ",
        "type, cron, json, ",
        "enabled, description, ",
        "last_mod_stamp, ",
        "create_stamp)",
        "values (#{appName,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=VARCHAR}, #{cron,jdbcType=VARCHAR}, #{json,jdbcType=VARCHAR}, ",
        "#{enabled,jdbcType=INTEGER}, #{description,jdbcType=VARCHAR}, ",
        "#{lastModStamp,jdbcType=OTHER,typeHandler=org.apache.ibatis.type.LocalDateTimeTypeHandler}, ",
        "#{createStamp,jdbcType=OTHER,typeHandler=org.apache.ibatis.type.LocalDateTimeTypeHandler})"
    })
    int insert(TimerM record);

    int insertSelective(TimerM record);

    List<TimerM> selectByExampleWithRowbounds(TimerMExample example, RowBounds rowBounds);

    List<TimerM> selectByExample(TimerMExample example);

    @Select({
        "select",
        "app_name, name, type, cron, json, enabled, description, last_mod_stamp, create_stamp",
        "from ds_timer_m",
        "where app_name = #{appName,jdbcType=VARCHAR}"
    })
    @ResultMap("com.governer.mapper.TimerMMapper.BaseResultMap")
    TimerM selectByPrimaryKey(String appName);

    int updateByExampleSelective(@Param("record") TimerM record, @Param("example") TimerMExample example);

    int updateByExample(@Param("record") TimerM record, @Param("example") TimerMExample example);

    int updateByPrimaryKeySelective(TimerM record);

    @Update({
        "update ds_timer_m",
        "set name = #{name,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "cron = #{cron,jdbcType=VARCHAR},",
          "json = #{json,jdbcType=VARCHAR},",
          "enabled = #{enabled,jdbcType=INTEGER},",
          "description = #{description,jdbcType=VARCHAR},",
          "last_mod_stamp = #{lastModStamp,jdbcType=OTHER,typeHandler=org.apache.ibatis.type.LocalDateTimeTypeHandler},",
          "create_stamp = #{createStamp,jdbcType=OTHER,typeHandler=org.apache.ibatis.type.LocalDateTimeTypeHandler}",
        "where app_name = #{appName,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TimerM record);
}