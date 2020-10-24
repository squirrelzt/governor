package com.governer.domain.vo.request;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("资源请求类")
public class ResourceRequestVO {

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("资源编码")
    private String resourceCode;

    @ApiModelProperty("资源名称")
    private String resourceName;

    @ApiModelProperty("所属应用")
    private String application;

    @ApiModelProperty("资源父级")
    private String resourceParent;

    @ApiModelProperty("资源全路径")
    private String resourcePath;

    @ApiModelProperty("资源类型")
    private String resourceType;

    @ApiModelProperty("资源方法")
    private String resourceMethod;

    @ApiModelProperty("资源URL")
    private String resourceUrl;

    @ApiModelProperty("资源图标")
    private String resourceIcon;

    @ApiModelProperty("显示状态")
    private String resourceDisplay;

    @ApiModelProperty("序号")
    private Integer sequence;

    @ApiModelProperty("是否有效")
    private String enable;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("创建人")
    private String createBy;

    @ApiModelProperty("创建时间")
    private Date createDate;

    @ApiModelProperty("修改人")
    private String lastUpdateBy;

    @ApiModelProperty("修改时间")
    private Date lastUpdateDate;
}
