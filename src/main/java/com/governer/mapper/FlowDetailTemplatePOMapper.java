package com.governer.mapper;

import com.governer.domain.po.FlowDetailTemplatePO;
import com.governer.domain.po.FlowDetailTemplatePOExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FlowDetailTemplatePOMapper {
    long countByExample(FlowDetailTemplatePOExample example);

    int deleteByExample(FlowDetailTemplatePOExample example);

    @Delete({
        "delete from ds_flow_detail_template",
        "where flow_name = #{flowName,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String flowName);

    @Insert({
        "insert into ds_flow_detail_template (flow_name, sort_no, ",
        "depend_task, task_name, ",
        "task_type_name, is_run, ",
        "is_skip, dus_list, ",
        "service_list, task_type, ",
        "retry_time, description, ",
        "last_mod_stamp, ",
        "create_stamp)",
        "values (#{flowName,jdbcType=VARCHAR}, #{sortNo,jdbcType=SMALLINT}, ",
        "#{dependTask,jdbcType=VARCHAR}, #{taskName,jdbcType=VARCHAR}, ",
        "#{taskTypeName,jdbcType=VARCHAR}, #{isRun,jdbcType=SMALLINT}, ",
        "#{isSkip,jdbcType=SMALLINT}, #{dusList,jdbcType=VARCHAR}, ",
        "#{serviceList,jdbcType=VARCHAR}, #{taskType,jdbcType=VARCHAR}, ",
        "#{retryTime,jdbcType=SMALLINT}, #{description,jdbcType=VARCHAR}, ",
        "#{lastModStamp,jdbcType=OTHER,typeHandler=org.apache.ibatis.type.LocalDateTimeTypeHandler}, ",
        "#{createStamp,jdbcType=OTHER,typeHandler=org.apache.ibatis.type.LocalDateTimeTypeHandler})"
    })
    int insert(FlowDetailTemplatePO record);

    int insertSelective(FlowDetailTemplatePO record);

    List<FlowDetailTemplatePO> selectByExampleWithRowbounds(FlowDetailTemplatePOExample example, RowBounds rowBounds);

    List<FlowDetailTemplatePO> selectByExample(FlowDetailTemplatePOExample example);

    @Select({
        "select",
        "flow_name, sort_no, depend_task, task_name, task_type_name, is_run, is_skip, ",
        "dus_list, service_list, task_type, retry_time, description, last_mod_stamp, ",
        "create_stamp",
        "from ds_flow_detail_template",
        "where flow_name = #{flowName,jdbcType=VARCHAR}"
    })
    @ResultMap("com.governer.mapper.FlowDetailTemplatePOMapper.BaseResultMap")
    FlowDetailTemplatePO selectByPrimaryKey(String flowName);

    int updateByExampleSelective(@Param("record") FlowDetailTemplatePO record, @Param("example") FlowDetailTemplatePOExample example);

    int updateByExample(@Param("record") FlowDetailTemplatePO record, @Param("example") FlowDetailTemplatePOExample example);

    int updateByPrimaryKeySelective(FlowDetailTemplatePO record);

    @Update({
        "update ds_flow_detail_template",
        "set sort_no = #{sortNo,jdbcType=SMALLINT},",
          "depend_task = #{dependTask,jdbcType=VARCHAR},",
          "task_name = #{taskName,jdbcType=VARCHAR},",
          "task_type_name = #{taskTypeName,jdbcType=VARCHAR},",
          "is_run = #{isRun,jdbcType=SMALLINT},",
          "is_skip = #{isSkip,jdbcType=SMALLINT},",
          "dus_list = #{dusList,jdbcType=VARCHAR},",
          "service_list = #{serviceList,jdbcType=VARCHAR},",
          "task_type = #{taskType,jdbcType=VARCHAR},",
          "retry_time = #{retryTime,jdbcType=SMALLINT},",
          "description = #{description,jdbcType=VARCHAR},",
          "last_mod_stamp = #{lastModStamp,jdbcType=OTHER,typeHandler=org.apache.ibatis.type.LocalDateTimeTypeHandler},",
          "create_stamp = #{createStamp,jdbcType=OTHER,typeHandler=org.apache.ibatis.type.LocalDateTimeTypeHandler}",
        "where flow_name = #{flowName,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(FlowDetailTemplatePO record);
}