package com.governer.convert;

import com.governer.domain.po.FlowDetailTemplatePO;
import com.governer.domain.po.TaskTemplatePO;
import com.governer.domain.vo.response.FlowEditQueryResponseVO;
import com.governer.domain.vo.response.TaskTemplateVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DesignFlowEditQueryConvert {
    DesignFlowEditQueryConvert INSTANCE = Mappers.getMapper(DesignFlowEditQueryConvert.class);

    @Mappings({
            @Mapping(source = "taskName", target = "task_name"),
            @Mapping(source = "taskTypeName", target = "task_type_name"),
            @Mapping(source = "taskType", target = "task_type"),
            @Mapping(source = "isRun", target = "is_run"),
    })
    FlowEditQueryResponseVO convertFlowDetailTemplatePO(FlowDetailTemplatePO po);
}
