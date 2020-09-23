package com.governer.mapper;

import com.governer.domain.po.TaskTemplatePO;
import com.governer.domain.po.TaskTemplatePOExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TaskTemplatePOMapper {
    long countByExample(TaskTemplatePOExample example);

    int deleteByExample(TaskTemplatePOExample example);

    @Delete({
        "delete from ds_task_template",
        "where task_name = #{taskName,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String taskName);

    @Insert({
        "insert into ds_task_template (task_name, task_type_name, ",
        "task_type, task_param, ",
        "description, max_parall_num, ",
        "dus_list, service_list, ",
        "is_run, is_repeat, ",
        "create_stamp, ",
        "last_mod_stamp, ",
        "timeout, app_name, ",
        "task_priority)",
        "values (#{taskName,jdbcType=VARCHAR}, #{taskTypeName,jdbcType=VARCHAR}, ",
        "#{taskType,jdbcType=VARCHAR}, #{taskParam,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{maxParallNum,jdbcType=INTEGER}, ",
        "#{dusList,jdbcType=VARCHAR}, #{serviceList,jdbcType=VARCHAR}, ",
        "#{isRun,jdbcType=INTEGER}, #{isRepeat,jdbcType=INTEGER}, ",
        "#{createStamp,jdbcType=OTHER,typeHandler=org.apache.ibatis.type.LocalDateTimeTypeHandler}, ",
        "#{lastModStamp,jdbcType=OTHER,typeHandler=org.apache.ibatis.type.LocalDateTimeTypeHandler}, ",
        "#{timeout,jdbcType=BIGINT}, #{appName,jdbcType=VARCHAR}, ",
        "#{taskPriority,jdbcType=VARCHAR})"
    })
    int insert(TaskTemplatePO record);

    int insertSelective(TaskTemplatePO record);

    List<TaskTemplatePO> selectByExampleWithRowbounds(TaskTemplatePOExample example, RowBounds rowBounds);

    List<TaskTemplatePO> selectByExample(TaskTemplatePOExample example);

    @Select({
        "select",
        "task_name, task_type_name, task_type, task_param, description, max_parall_num, ",
        "dus_list, service_list, is_run, is_repeat, create_stamp, last_mod_stamp, timeout, ",
        "app_name, task_priority",
        "from ds_task_template",
        "where task_name = #{taskName,jdbcType=VARCHAR}"
    })
    @ResultMap("com.governer.mapper.TaskTemplatePOMapper.BaseResultMap")
    TaskTemplatePO selectByPrimaryKey(String taskName);

    int updateByExampleSelective(@Param("record") TaskTemplatePO record, @Param("example") TaskTemplatePOExample example);

    int updateByExample(@Param("record") TaskTemplatePO record, @Param("example") TaskTemplatePOExample example);

    int updateByPrimaryKeySelective(TaskTemplatePO record);

    @Update({
        "update ds_task_template",
        "set task_type_name = #{taskTypeName,jdbcType=VARCHAR},",
          "task_type = #{taskType,jdbcType=VARCHAR},",
          "task_param = #{taskParam,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "max_parall_num = #{maxParallNum,jdbcType=INTEGER},",
          "dus_list = #{dusList,jdbcType=VARCHAR},",
          "service_list = #{serviceList,jdbcType=VARCHAR},",
          "is_run = #{isRun,jdbcType=INTEGER},",
          "is_repeat = #{isRepeat,jdbcType=INTEGER},",
          "create_stamp = #{createStamp,jdbcType=OTHER,typeHandler=org.apache.ibatis.type.LocalDateTimeTypeHandler},",
          "last_mod_stamp = #{lastModStamp,jdbcType=OTHER,typeHandler=org.apache.ibatis.type.LocalDateTimeTypeHandler},",
          "timeout = #{timeout,jdbcType=BIGINT},",
          "app_name = #{appName,jdbcType=VARCHAR},",
          "task_priority = #{taskPriority,jdbcType=VARCHAR}",
        "where task_name = #{taskName,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TaskTemplatePO record);
}