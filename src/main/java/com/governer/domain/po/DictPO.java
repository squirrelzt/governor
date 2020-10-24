package com.governer.domain.po;

import java.util.Date;

import lombok.Data;

@Data
public class DictPO {

	private Integer id;

	private String application;

    private String dictType;

    private String dictCode;

	private String dictName;

    private Integer sequence;

    private String i18nCode;

    private String corpCode;

    private String enable;

    private String description;
    
    private String createBy;

    private Date createDate;

    private String lastUpdateBy;

    private Date lastUpdateDate;
}
