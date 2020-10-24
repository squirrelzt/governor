package com.governer.domain.vo.request;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("资源请求类")
public class RoleRequestVO {

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("角色编码")
    private String roleCode;

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("法人编码")
    private String corpCode;

    @ApiModelProperty("所属应用")
    private String application;

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
