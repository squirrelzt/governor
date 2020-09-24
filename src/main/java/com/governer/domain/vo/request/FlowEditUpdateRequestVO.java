package com.governer.domain.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("设计-主页面-流程任务修改请求类")
public class FlowEditUpdateRequestVO {
    @ApiModelProperty("任务名称")
    private String task_name;

    @ApiModelProperty("任务类型")
    private String task_type;

    @ApiModelProperty("任务参数")
    private String task_param;

    @ApiModelProperty("描述信息")
    private String description;

    @ApiModelProperty("最大并发任务数")
    private Integer max_parall_num;

    @ApiModelProperty("是否允许执行")
    private Integer is_run;

    @ApiModelProperty("应用名称")
    private Long timeout;
}
