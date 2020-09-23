package com.governer.mapper;

import com.governer.domain.po.FlowTemplateDetailPO;
import com.governer.domain.po.FlowTemplateDetailPOExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FlowTemplateDetailPOMapper {
    long countByExample(FlowTemplateDetailPOExample example);

    int deleteByExample(FlowTemplateDetailPOExample example);

    @Delete({
        "delete from ds_flow_template_detail",
        "where flow_name = #{flowName,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String flowName);

    @Insert({
        "insert into ds_flow_template_detail (flow_name, sort_no, ",
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
    int insert(FlowTemplateDetailPO record);

    int insertSelective(FlowTemplateDetailPO record);

    List<FlowTemplateDetailPO> selectByExampleWithRowbounds(FlowTemplateDetailPOExample example, RowBounds rowBounds);

    List<FlowTemplateDetailPO> selectByExample(FlowTemplateDetailPOExample example);

    @Select({
        "select",
        "flow_name, sort_no, depend_task, task_name, task_type_name, is_run, is_skip, ",
        "dus_list, service_list, task_type, retry_time, description, last_mod_stamp, ",
        "create_stamp",
        "from ds_flow_template_detail",
        "where flow_name = #{flowName,jdbcType=VARCHAR}"
    })
    @ResultMap("com.governer.mapper.FlowTemplateDetailPOMapper.BaseResultMap")
    FlowTemplateDetailPO selectByPrimaryKey(String flowName);

    int updateByExampleSelective(@Param("record") FlowTemplateDetailPO record, @Param("example") FlowTemplateDetailPOExample example);

    int updateByExample(@Param("record") FlowTemplateDetailPO record, @Param("example") FlowTemplateDetailPOExample example);

    int updateByPrimaryKeySelective(FlowTemplateDetailPO record);

    @Update({
        "update ds_flow_template_detail",
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
    int updateByPrimaryKey(FlowTemplateDetailPO record);
}