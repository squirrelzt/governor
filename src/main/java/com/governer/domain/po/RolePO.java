package com.governer.domain.po;

import java.util.Date;

import lombok.Data;

@Data
public class RolePO {

    private Integer id;

    private String roleCode;

    private String roleName;

    private String corpCode;

    private String application;

    private String enable;

    private String description;

    private String createBy;

    private Date createDate;

    private String lastUpdateBy;

    private Date lastUpdateDate;

}
