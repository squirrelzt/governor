package com.governer.convert;

import com.governer.domain.po.TaskTemplatePO;
import com.governer.domain.vo.response.TaskTemplateVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TaskTemplateVOConvert {
    TaskTemplateVOConvert INSTANCE = Mappers.getMapper(TaskTemplateVOConvert.class);

    @Mappings({
            @Mapping(source = "taskName", target = "task_name"),
            @Mapping(source = "taskTypeName", target = "task_type_name"),
            @Mapping(source = "taskType", target = "task_type"),
            @Mapping(source = "taskParam", target = "task_param"),
            @Mapping(source = "maxParallNum", target = "max_parall_num"),
            @Mapping(source = "dusList", target = "dus_list"),
            @Mapping(source = "serviceList", target = "service_list"),
            @Mapping(source = "isRun", target = "is_run"),
            @Mapping(source = "isRepeat", target = "is_repeat"),
            @Mapping(source = "createStamp", target = "create_stamp"),
            @Mapping(source = "lastModStamp", target = "last_mod_stamp"),
            @Mapping(source = "appName", target = "app_name"),
    })
    TaskTemplateVO convertTaskTemplatePO(TaskTemplatePO po);

    List<TaskTemplateVO> convertTaskTemplatePOList(List<TaskTemplatePO> poList);
}
