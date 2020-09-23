package com.governer.mapper;

import com.governer.domain.po.BatchJobTemplatePO;
import com.governer.domain.po.BatchJobTemplatePOExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BatchJobTemplatePOMapper {
    long countByExample(BatchJobTemplatePOExample example);

    int deleteByExample(BatchJobTemplatePOExample example);

    @Delete({
        "delete from ds_batch_job_template",
        "where job_name = #{jobName,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String jobName);

    @Insert({
        "insert into ds_batch_job_template (job_name, job_application_name, ",
        "source_type, remote_job_name, ",
        "file_template_name, sharding_rule, ",
        "transactios_submit_num, max_parall_num, ",
        "is_skip, is_repeat, ",
        "is_result, retry_times, ",
        "job_param, create_stamp, ",
        "last_mod_stamp)",
        "values (#{jobName,jdbcType=VARCHAR}, #{jobApplicationName,jdbcType=VARCHAR}, ",
        "#{sourceType,jdbcType=VARCHAR}, #{remoteJobName,jdbcType=VARCHAR}, ",
        "#{fileTemplateName,jdbcType=VARCHAR}, #{shardingRule,jdbcType=VARCHAR}, ",
        "#{transactiosSubmitNum,jdbcType=BIGINT}, #{maxParallNum,jdbcType=SMALLINT}, ",
        "#{isSkip,jdbcType=SMALLINT}, #{isRepeat,jdbcType=SMALLINT}, ",
        "#{isResult,jdbcType=SMALLINT}, #{retryTimes,jdbcType=BIGINT}, ",
        "#{jobParam,jdbcType=VARCHAR}, #{createStamp,jdbcType=OTHER,typeHandler=org.apache.ibatis.type.LocalDateTimeTypeHandler}, ",
        "#{lastModStamp,jdbcType=OTHER,typeHandler=org.apache.ibatis.type.LocalDateTimeTypeHandler})"
    })
    int insert(BatchJobTemplatePO record);

    int insertSelective(BatchJobTemplatePO record);

    List<BatchJobTemplatePO> selectByExampleWithRowbounds(BatchJobTemplatePOExample example, RowBounds rowBounds);

    List<BatchJobTemplatePO> selectByExample(BatchJobTemplatePOExample example);

    @Select({
        "select",
        "job_name, job_application_name, source_type, remote_job_name, file_template_name, ",
        "sharding_rule, transactios_submit_num, max_parall_num, is_skip, is_repeat, is_result, ",
        "retry_times, job_param, create_stamp, last_mod_stamp",
        "from ds_batch_job_template",
        "where job_name = #{jobName,jdbcType=VARCHAR}"
    })
    @ResultMap("com.governer.mapper.BatchJobTemplatePOMapper.BaseResultMap")
    BatchJobTemplatePO selectByPrimaryKey(String jobName);

    int updateByExampleSelective(@Param("record") BatchJobTemplatePO record, @Param("example") BatchJobTemplatePOExample example);

    int updateByExample(@Param("record") BatchJobTemplatePO record, @Param("example") BatchJobTemplatePOExample example);

    int updateByPrimaryKeySelective(BatchJobTemplatePO record);

    @Update({
        "update ds_batch_job_template",
        "set job_application_name = #{jobApplicationName,jdbcType=VARCHAR},",
          "source_type = #{sourceType,jdbcType=VARCHAR},",
          "remote_job_name = #{remoteJobName,jdbcType=VARCHAR},",
          "file_template_name = #{fileTemplateName,jdbcType=VARCHAR},",
          "sharding_rule = #{shardingRule,jdbcType=VARCHAR},",
          "transactios_submit_num = #{transactiosSubmitNum,jdbcType=BIGINT},",
          "max_parall_num = #{maxParallNum,jdbcType=SMALLINT},",
          "is_skip = #{isSkip,jdbcType=SMALLINT},",
          "is_repeat = #{isRepeat,jdbcType=SMALLINT},",
          "is_result = #{isResult,jdbcType=SMALLINT},",
          "retry_times = #{retryTimes,jdbcType=BIGINT},",
          "job_param = #{jobParam,jdbcType=VARCHAR},",
          "create_stamp = #{createStamp,jdbcType=OTHER,typeHandler=org.apache.ibatis.type.LocalDateTimeTypeHandler},",
          "last_mod_stamp = #{lastModStamp,jdbcType=OTHER,typeHandler=org.apache.ibatis.type.LocalDateTimeTypeHandler}",
        "where job_name = #{jobName,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(BatchJobTemplatePO record);
}