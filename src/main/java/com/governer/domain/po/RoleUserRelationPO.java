package com.governer.domain.po;

import java.util.Date;

import lombok.Data;

@Data
public class RoleUserRelationPO {

    private Integer id;

    private String roleCode;

    private String userCode;

    private String createBy;

    private Date createDate;

    private String lastUpdateBy;

    private Date lastUpdateDate;
}
