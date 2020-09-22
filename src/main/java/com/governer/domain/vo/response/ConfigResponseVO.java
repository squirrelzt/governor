package com.governer.domain.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@ApiModel("定时-查询返回值类")
public class ConfigResponseVO {
//    @ApiModelProperty("id")
//    private Long id;

    @ApiModelProperty("应用名称")
    private String app_name;

    @ApiModelProperty("作业名称")
    private String name;

    @ApiModelProperty("作业类型:本地-LOCAL(默认),流程-FLOW")
    private String type;

    @ApiModelProperty("Cron 表达式")
    private String cron;

    @ApiModelProperty("是否启用: 启用-1;禁用-0")
    private Integer enabled;

    @ApiModelProperty("最近修改时间")
    private LocalDateTime last_mod_stamp;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("JSON")
    private String json;
}
