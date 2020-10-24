package com.governer.domain.po;

import java.util.Date;

import lombok.Data;

@Data
public class UserPO {

    private Integer id;

    private String userCode;

    private String userName;

    private String userPassword;

    private String orgCode;

    private String employeeCode;

    private Integer pageSize;

    private String menuType;

    private String skinCode;

    private String lastRole;

    private String defaultRole;

    private String status;

    private String enable;

    private Date effectiveDateStart;

    private Date effectiveDateEnd;

    private Integer failedCount;
    
    private String defaultDashboard;

    private Date lastUpdatePwdDate;
    
    private String description;

    private String createBy;

    private Date createDate;

    private String lastUpdateBy;

    private Date lastUpdateDate;

}
