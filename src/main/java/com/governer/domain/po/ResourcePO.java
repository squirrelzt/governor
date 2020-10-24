package com.governer.domain.po;

import java.util.Date;

import lombok.Data;

@Data
public class ResourcePO {

    private Integer id;

    private String resourceCode;

    private String resourceName;

    private String application;

    private String resourceParent;

    private String resourcePath;

    private String resourceType;

    private String resourceMethod;

    private String resourceUrl;

    private String resourceIcon;

    private String resourceDisplay;

    private Integer sequence;

    private String enable;

    private String description;

    private String createBy;

    private Date createDate;

    private String lastUpdateBy;

    private Date lastUpdateDate;
}
