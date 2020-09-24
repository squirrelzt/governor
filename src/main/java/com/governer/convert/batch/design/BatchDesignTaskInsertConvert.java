package com.governer.convert.batch.design;

import com.governer.domain.po.*;
import com.governer.domain.vo.request.BatchDesignTaskInsertRequestVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BatchDesignTaskInsertConvert {

    BatchDesignTaskInsertConvert INSTANCE = Mappers.getMapper(BatchDesignTaskInsertConvert.class);

    /**
     *
     * @param requestVO
     * @return
     * BatchDesignTaskInsertRequestVO中没有TaskTemplatePO中的isRepeat
     */
    @Mappings({
            @Mapping(source = "flow_name", target = "taskName"),
            @Mapping(source = "flow_name", target = "taskTypeName"),
            @Mapping(source = "task_type", target = "taskType"),
            @Mapping(source = "task_param", target = "taskParam"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "max_parall_num", target = "maxParallNum"),
            @Mapping(source = "dus_list", target = "dusList"),
            @Mapping(source = "service_list", target = "serviceList"),
            @Mapping(source = "is_run", target = "isRun"),
            @Mapping(source = "create_stamp", target = "createStamp"),
            @Mapping(source = "last_mod_stamp", target = "lastModStamp"),
            @Mapping(source = "timeout", target = "timeout"),
            @Mapping(source = "app_name", target = "appName"),
            @Mapping(source = "task_priority", target = "taskPriority"),
    })
    TaskTemplatePO convertInsertRequestVO2TaskTemplatePO(BatchDesignTaskInsertRequestVO requestVO);

    /**
     *
     * @param requestVO
     * @return
     * BatchDesignTaskInsertRequestVO中没有jobProcessor
     */
    @Mappings({
            @Mapping(source = "flow_name", target = "jobName"),
            @Mapping(source = "flow_name", target = "taskTypeName"),
            @Mapping(source = "task_type", target = "jobType"),
            @Mapping(source = "dus_list", target = "dusList"),
            @Mapping(source = "service_list", target = "serviceList"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "create_stamp", target = "createStamp"),
            @Mapping(source = "last_mod_stamp", target = "lastModStamp")
    })
    SimpleTaskTemplatePO convertInsertRequestVO2SimpleTaskTemplatePO(BatchDesignTaskInsertRequestVO requestVO);

    /**
     *
     * @param requestVO
     * @return
     * 没有shardingRule,isRepeat
     */
    @Mappings({
            @Mapping(source = "flow_name", target = "jobName"),
            @Mapping(source = "job_application_name", target = "jobApplicationName"),
            @Mapping(source = "source_type", target = "sourceType"),
            @Mapping(source = "remote_job_name", target = "remoteJobName"),
            @Mapping(source = "file_template_name", target = "fileTemplateName"),
            @Mapping(source = "transactions_submit_num", target = "transactionsSubmitNum"),
            @Mapping(source = "max_parall_num", target = "maxParallNum"),
            @Mapping(source = "is_skip", target = "isSkip"),
            @Mapping(source = "is_result", target = "isResult"),
            @Mapping(source = "retry_time", target = "retryTime"),
            @Mapping(source = "job_param", target = "jobParam"),
            @Mapping(source = "create_stamp", target = "createStamp"),
            @Mapping(source = "last_mod_stamp", target = "lastModStamp")
    })
    BatchJobTemplatePO convertInsertRequestVO2BatchJobTemplatePO(BatchDesignTaskInsertRequestVO requestVO);

    /**
     *
     * @param requestVO
     * @return
     */
    @Mappings({
            @Mapping(source = "flow_name", target = "flowName"),
            @Mapping(source = "sort_no", target = "sortNo"),
            @Mapping(source = "flow_name", target = "taskName"),
            @Mapping(source = "flow_name", target = "taskTypeName"),
            @Mapping(source = "is_run", target = "isRun"),
            @Mapping(source = "is_skip", target = "isSkip"),
            @Mapping(source = "dus_list", target = "dusList"),
            @Mapping(source = "service_list", target = "serviceList"),
            @Mapping(source = "task_type", target = "taskType"),
            @Mapping(source = "retry_time", target = "retryTime"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "create_stamp", target = "createStamp"),
            @Mapping(source = "last_mod_stamp", target = "lastModStamp"),
            @Mapping(source = "depend_task", target = "dependTask")
    })
    FlowDetailTemplatePO convertInsertRequestVO2FlowTemplateDetailPO(BatchDesignTaskInsertRequestVO requestVO);
}
