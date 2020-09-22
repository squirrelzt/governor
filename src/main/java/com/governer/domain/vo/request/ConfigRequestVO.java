package com.governer.domain.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("定时请求类")
public class ConfigRequestVO {
    @ApiModelProperty("应用名称")
    private String app_name;

    @ApiModelProperty("作业名称")
    private String name;

    @ApiModelProperty("作业类型:本地-LOCAL(默认),流程-FLOW")
    private String type;

    @ApiModelProperty("JSON")
    private String json;

    @ApiModelProperty("Cron表达式")
    private String cron;

    @ApiModelProperty("是否启用: 启用-1;禁用-0")
    private Integer enabled;

    @ApiModelProperty("描述")
    private String description;
}
