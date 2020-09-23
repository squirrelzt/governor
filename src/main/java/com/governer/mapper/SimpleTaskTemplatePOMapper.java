package com.governer.mapper;

import com.governer.domain.po.SimpleTaskTemplatePO;
import com.governer.domain.po.SimpleTaskTemplatePOExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SimpleTaskTemplatePOMapper {
    long countByExample(SimpleTaskTemplatePOExample example);

    int deleteByExample(SimpleTaskTemplatePOExample example);

    @Delete({
        "delete from ds_simple_task_template",
        "where job_name = #{jobName,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String jobName);

    @Insert({
        "insert into ds_simple_task_template (job_name, task_type_name, ",
        "job_type, dus_list, ",
        "service_list, description, ",
        "last_mod_stamp, ",
        "create_stamp, ",
        "job_processor)",
        "values (#{jobName,jdbcType=VARCHAR}, #{taskTypeName,jdbcType=VARCHAR}, ",
        "#{jobType,jdbcType=VARCHAR}, #{dusList,jdbcType=VARCHAR}, ",
        "#{serviceList,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{lastModStamp,jdbcType=OTHER,typeHandler=org.apache.ibatis.type.LocalDateTimeTypeHandler}, ",
        "#{createStamp,jdbcType=OTHER,typeHandler=org.apache.ibatis.type.LocalDateTimeTypeHandler}, ",
        "#{jobProcessor,jdbcType=VARCHAR})"
    })
    int insert(SimpleTaskTemplatePO record);

    int insertSelective(SimpleTaskTemplatePO record);

    List<SimpleTaskTemplatePO> selectByExampleWithRowbounds(SimpleTaskTemplatePOExample example, RowBounds rowBounds);

    List<SimpleTaskTemplatePO> selectByExample(SimpleTaskTemplatePOExample example);

    @Select({
        "select",
        "job_name, task_type_name, job_type, dus_list, service_list, description, last_mod_stamp, ",
        "create_stamp, job_processor",
        "from ds_simple_task_template",
        "where job_name = #{jobName,jdbcType=VARCHAR}"
    })
    @ResultMap("com.governer.mapper.SimpleTaskTemplatePOMapper.BaseResultMap")
    SimpleTaskTemplatePO selectByPrimaryKey(String jobName);

    int updateByExampleSelective(@Param("record") SimpleTaskTemplatePO record, @Param("example") SimpleTaskTemplatePOExample example);

    int updateByExample(@Param("record") SimpleTaskTemplatePO record, @Param("example") SimpleTaskTemplatePOExample example);

    int updateByPrimaryKeySelective(SimpleTaskTemplatePO record);

    @Update({
        "update ds_simple_task_template",
        "set task_type_name = #{taskTypeName,jdbcType=VARCHAR},",
          "job_type = #{jobType,jdbcType=VARCHAR},",
          "dus_list = #{dusList,jdbcType=VARCHAR},",
          "service_list = #{serviceList,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "last_mod_stamp = #{lastModStamp,jdbcType=OTHER,typeHandler=org.apache.ibatis.type.LocalDateTimeTypeHandler},",
          "create_stamp = #{createStamp,jdbcType=OTHER,typeHandler=org.apache.ibatis.type.LocalDateTimeTypeHandler},",
          "job_processor = #{jobProcessor,jdbcType=VARCHAR}",
        "where job_name = #{jobName,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SimpleTaskTemplatePO record);
}