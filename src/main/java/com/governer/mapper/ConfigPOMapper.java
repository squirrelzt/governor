package com.governer.mapper;

import com.governer.domain.po.ConfigPO;
import com.governer.domain.po.ConfigPOExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ConfigPOMapper {
    long countByExample(ConfigPOExample example);

    int deleteByExample(ConfigPOExample example);

    @Delete({
        "delete from config",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into config (id, app_name, ",
        "name, type, json, ",
        "cron, enabled, ",
        "description, last_mod_stamp)",
        "values (#{id,jdbcType=BIGINT}, #{appName,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{type,jdbcType=VARCHAR}, #{json,jdbcType=VARCHAR}, ",
        "#{cron,jdbcType=VARCHAR}, #{enabled,jdbcType=SMALLINT}, ",
        "#{description,jdbcType=VARCHAR}, #{lastModStamp,jdbcType=TIMESTAMP})"
    })
    int insert(ConfigPO record);

    int insertSelective(ConfigPO record);

    List<ConfigPO> selectByExampleWithRowbounds(ConfigPOExample example, RowBounds rowBounds);

    List<ConfigPO> selectByExample(ConfigPOExample example);

    @Select({
        "select",
        "id, app_name, name, type, json, cron, enabled, description, last_mod_stamp",
        "from config",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.governer.mapper.ConfigPOMapper.BaseResultMap")
    ConfigPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ConfigPO record, @Param("example") ConfigPOExample example);

    int updateByExample(@Param("record") ConfigPO record, @Param("example") ConfigPOExample example);

    int updateByPrimaryKeySelective(ConfigPO record);

    @Update({
        "update config",
        "set app_name = #{appName,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "json = #{json,jdbcType=VARCHAR},",
          "cron = #{cron,jdbcType=VARCHAR},",
          "enabled = #{enabled,jdbcType=SMALLINT},",
          "description = #{description,jdbcType=VARCHAR},",
          "last_mod_stamp = #{lastModStamp,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ConfigPO record);
}