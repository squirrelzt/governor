package com.governer.domain.po;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class RoleResourceRelationPO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

    private String roleCode;

    private String resourceCode;

    private String createBy;

    private Date createDate;

    private String lastUpdateBy;

    private Date lastUpdateDate;
}
