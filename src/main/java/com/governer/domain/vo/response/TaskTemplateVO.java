package com.governer.domain.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel("设计-查询返回值类")
public class TaskTemplateVO {
    @ApiModelProperty("任务名称")
    private String task_name;

    @ApiModelProperty("任务类型名称")
    private String task_type_name;

    @ApiModelProperty("任务类型")
    private String task_type;

    @ApiModelProperty("任务参数")
    private String task_param;

    @ApiModelProperty("描述信息")
    private String description;

    @ApiModelProperty("最大并发任务数")
    private Integer max_parall_num;

    @ApiModelProperty("单元编号列表")
    private String dus_list;

    @ApiModelProperty("应用名列表")
    private String service_list;

    @ApiModelProperty("是否允许执行")
    private Integer is_run;

    @ApiModelProperty("是否允许重复执行")
    private Integer is_repeat;

    @ApiModelProperty("创建时间")
    private LocalDateTime create_stamp;

    @ApiModelProperty("修改时间")
    private LocalDateTime last_mod_stamp;

    @ApiModelProperty("应用名称")
    private Long timeout;

    @ApiModelProperty("应用名称")
    private String app_name;

    @ApiModelProperty("应用名称")
    private String task_priority;
}
