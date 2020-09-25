package com.governer.mapper;

import com.governer.domain.po.FlowTypeTemplatePO;
import com.governer.domain.po.FlowTypeTemplatePOExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FlowTypeTemplatePOMapper {
    long countByExample(FlowTypeTemplatePOExample example);

    int deleteByExample(FlowTypeTemplatePOExample example);

    @Insert({
        "insert into ds_flow_type_template (flow_name, task_type_name, ",
        "max_parall_num, service_list, ",
        "dus_list, description, ",
        "create_stamp, ",
        "last_mod_stamp)",
        "values (#{flowName,jdbcType=VARCHAR}, #{taskTypeName,jdbcType=VARCHAR}, ",
        "#{maxParallNum,jdbcType=SMALLINT}, #{serviceList,jdbcType=VARCHAR}, ",
        "#{dusList,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{createStamp,jdbcType=OTHER,typeHandler=org.apache.ibatis.type.LocalDateTimeTypeHandler}, ",
        "#{lastModStamp,jdbcType=OTHER,typeHandler=org.apache.ibatis.type.LocalDateTimeTypeHandler})"
    })
    int insert(FlowTypeTemplatePO record);

    int insertSelective(FlowTypeTemplatePO record);

    List<FlowTypeTemplatePO> selectByExampleWithRowbounds(FlowTypeTemplatePOExample example, RowBounds rowBounds);

    List<FlowTypeTemplatePO> selectByExample(FlowTypeTemplatePOExample example);

    int updateByExampleSelective(@Param("record") FlowTypeTemplatePO record, @Param("example") FlowTypeTemplatePOExample example);

    int updateByExample(@Param("record") FlowTypeTemplatePO record, @Param("example") FlowTypeTemplatePOExample example);
}