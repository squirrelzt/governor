package com.governer.mapper;

import com.governer.domain.po.TaskTemplatePO;
import com.governer.domain.po.TaskTemplatePOExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TaskTemplatePOMapper {
    long countByExample(TaskTemplatePOExample example);

    int deleteByExample(TaskTemplatePOExample example);

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
        "#{taskPriority,jdbcType=INTEGER})"
    })
    int insert(TaskTemplatePO record);

    int insertSelective(TaskTemplatePO record);

    List<TaskTemplatePO> selectByExampleWithRowbounds(TaskTemplatePOExample example, RowBounds rowBounds);

    List<TaskTemplatePO> selectByExample(TaskTemplatePOExample example);

    int updateByExampleSelective(@Param("record") TaskTemplatePO record, @Param("example") TaskTemplatePOExample example);

    int updateByExample(@Param("record") TaskTemplatePO record, @Param("example") TaskTemplatePOExample example);
}