package com.governer.domain.dto.design;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BatchDesignTaskInsertRequestDTO {
    private String appName;

    private LocalDateTime createStamp;

    private String description;

    private String dusList;

    private String fileTemplateName;

    private String flowName;

    private String isResult;

    private String isRun;

    private String isSkip;

    private String jobApplicationName;

    private String jobParam;

    private LocalDateTime lastModStamp;

    private String maxParallNum;

    private String remoteJobName;

    private String retryTime;

    private String serviceList;

    private String sortNo;

    private String sourceType;

    private String taskParam;

    private String taskType;

    private String timeout;

    private String transactionsSubmitNum;
}
