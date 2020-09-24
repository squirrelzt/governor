package com.governer.domain.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel("设计-主页面新增")
public class BatchDesignTaskInsertRequestVO {
    @ApiModelProperty("应用名称")
    private String app_name;

    @ApiModelProperty("创建时间")
    private LocalDateTime create_stamp;

    @ApiModelProperty("描述信息")
    private String description;

    @ApiModelProperty("单元列表")
    private String dus_list;

    @ApiModelProperty("文件模板名称")
    private String file_template_name;

    @ApiModelProperty("任务名称")
    private String flow_name;

    @ApiModelProperty("是否产生结果文件")
    private String is_result;

    @ApiModelProperty("是否允许运行")
    private String is_run;

    @ApiModelProperty("是否跳过")
    private String is_skip;

    @ApiModelProperty("作业应用名称")
    private String job_application_name;

    @ApiModelProperty("任务参数")
    private String job_param;

    @ApiModelProperty("最近修改时间")
    private LocalDateTime last_mod_stamp;

    @ApiModelProperty("最大并发任务数")
    private String max_parall_num;

    @ApiModelProperty("远程作业名称")
    private String remote_job_name;

    @ApiModelProperty("重试次数")
    private String retry_time;

    @ApiModelProperty("服务列表")
    private String service_list;

    @ApiModelProperty("顺序号")
    private String sort_no;

    @ApiModelProperty("数据源类型")
    private String source_type;

    @ApiModelProperty("任务参数")
    private String task_parm;

    @ApiModelProperty("任务类型")
    private String task_type;

    @ApiModelProperty("超时时长")
    private String timeout;

    @ApiModelProperty("事务提交间隔")
    private String transactions_submit_num;
}
