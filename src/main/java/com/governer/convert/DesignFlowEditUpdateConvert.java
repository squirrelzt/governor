package com.governer.convert;

import com.governer.domain.po.FlowDetailTemplatePO;
import com.governer.domain.vo.request.FlowEditUpdateRequestVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DesignFlowEditUpdateConvert {
    DesignFlowEditUpdateConvert INSTANCE = Mappers.getMapper(DesignFlowEditUpdateConvert.class);

    @Mappings({
            @Mapping(source = "task_name", target = "taskName"),
            @Mapping(source = "task_name", target = "flowName"),
            @Mapping(source = "task_type", target = "taskType"),
            @Mapping(source = "is_run", target = "isRun")
    })
    FlowDetailTemplatePO convertFlowEditUpdateRequestVO(FlowEditUpdateRequestVO po);
}
