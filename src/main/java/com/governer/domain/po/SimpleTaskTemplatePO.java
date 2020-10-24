package com.governer.domain.po;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SimpleTaskTemplatePO implements Serializable {
    private String jobName;

    private String taskTypeName;

    private String jobType;

    private String dusList;

    private String serviceList;

    private String description;

    private LocalDateTime lastModStamp;

    private LocalDateTime createStamp;

    private String jobProcessor;

    private static final long serialVersionUID = 1L;

    public String getJobName() {
        return jobName;
    }

    public SimpleTaskTemplatePO withJobName(String jobName) {
        this.setJobName(jobName);
        return this;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public String getTaskTypeName() {
        return taskTypeName;
    }

    public SimpleTaskTemplatePO withTaskTypeName(String taskTypeName) {
        this.setTaskTypeName(taskTypeName);
        return this;
    }

    public void setTaskTypeName(String taskTypeName) {
        this.taskTypeName = taskTypeName == null ? null : taskTypeName.trim();
    }

    public String getJobType() {
        return jobType;
    }

    public SimpleTaskTemplatePO withJobType(String jobType) {
        this.setJobType(jobType);
        return this;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType == null ? null : jobType.trim();
    }

    public String getDusList() {
        return dusList;
    }

    public SimpleTaskTemplatePO withDusList(String dusList) {
        this.setDusList(dusList);
        return this;
    }

    public void setDusList(String dusList) {
        this.dusList = dusList == null ? null : dusList.trim();
    }

    public String getServiceList() {
        return serviceList;
    }

    public SimpleTaskTemplatePO withServiceList(String serviceList) {
        this.setServiceList(serviceList);
        return this;
    }

    public void setServiceList(String serviceList) {
        this.serviceList = serviceList == null ? null : serviceList.trim();
    }

    public String getDescription() {
        return description;
    }

    public SimpleTaskTemplatePO withDescription(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public LocalDateTime getLastModStamp() {
        return lastModStamp;
    }

    public SimpleTaskTemplatePO withLastModStamp(LocalDateTime lastModStamp) {
        this.setLastModStamp(lastModStamp);
        return this;
    }

    public void setLastModStamp(LocalDateTime lastModStamp) {
        this.lastModStamp = lastModStamp;
    }

    public LocalDateTime getCreateStamp() {
        return createStamp;
    }

    public SimpleTaskTemplatePO withCreateStamp(LocalDateTime createStamp) {
        this.setCreateStamp(createStamp);
        return this;
    }

    public void setCreateStamp(LocalDateTime createStamp) {
        this.createStamp = createStamp;
    }

    public String getJobProcessor() {
        return jobProcessor;
    }

    public SimpleTaskTemplatePO withJobProcessor(String jobProcessor) {
        this.setJobProcessor(jobProcessor);
        return this;
    }

    public void setJobProcessor(String jobProcessor) {
        this.jobProcessor = jobProcessor == null ? null : jobProcessor.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", jobName=").append(jobName);
        sb.append(", taskTypeName=").append(taskTypeName);
        sb.append(", jobType=").append(jobType);
        sb.append(", dusList=").append(dusList);
        sb.append(", serviceList=").append(serviceList);
        sb.append(", description=").append(description);
        sb.append(", lastModStamp=").append(lastModStamp);
        sb.append(", createStamp=").append(createStamp);
        sb.append(", jobProcessor=").append(jobProcessor);
        sb.append("]");
        return sb.toString();
    }
}