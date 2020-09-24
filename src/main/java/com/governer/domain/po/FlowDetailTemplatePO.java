package com.governer.domain.po;

import java.io.Serializable;
import java.time.LocalDateTime;

public class FlowDetailTemplatePO implements Serializable {
    private String flowName;

    private Short sortNo;

    private String dependTask;

    private String taskName;

    private String taskTypeName;

    private Short isRun;

    private Short isSkip;

    private String dusList;

    private String serviceList;

    private String taskType;

    private Short retryTime;

    private String description;

    private LocalDateTime lastModStamp;

    private LocalDateTime createStamp;

    private static final long serialVersionUID = 1L;

    public String getFlowName() {
        return flowName;
    }

    public FlowDetailTemplatePO withFlowName(String flowName) {
        this.setFlowName(flowName);
        return this;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName == null ? null : flowName.trim();
    }

    public Short getSortNo() {
        return sortNo;
    }

    public FlowDetailTemplatePO withSortNo(Short sortNo) {
        this.setSortNo(sortNo);
        return this;
    }

    public void setSortNo(Short sortNo) {
        this.sortNo = sortNo;
    }

    public String getDependTask() {
        return dependTask;
    }

    public FlowDetailTemplatePO withDependTask(String dependTask) {
        this.setDependTask(dependTask);
        return this;
    }

    public void setDependTask(String dependTask) {
        this.dependTask = dependTask == null ? null : dependTask.trim();
    }

    public String getTaskName() {
        return taskName;
    }

    public FlowDetailTemplatePO withTaskName(String taskName) {
        this.setTaskName(taskName);
        return this;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public String getTaskTypeName() {
        return taskTypeName;
    }

    public FlowDetailTemplatePO withTaskTypeName(String taskTypeName) {
        this.setTaskTypeName(taskTypeName);
        return this;
    }

    public void setTaskTypeName(String taskTypeName) {
        this.taskTypeName = taskTypeName == null ? null : taskTypeName.trim();
    }

    public Short getIsRun() {
        return isRun;
    }

    public FlowDetailTemplatePO withIsRun(Short isRun) {
        this.setIsRun(isRun);
        return this;
    }

    public void setIsRun(Short isRun) {
        this.isRun = isRun;
    }

    public Short getIsSkip() {
        return isSkip;
    }

    public FlowDetailTemplatePO withIsSkip(Short isSkip) {
        this.setIsSkip(isSkip);
        return this;
    }

    public void setIsSkip(Short isSkip) {
        this.isSkip = isSkip;
    }

    public String getDusList() {
        return dusList;
    }

    public FlowDetailTemplatePO withDusList(String dusList) {
        this.setDusList(dusList);
        return this;
    }

    public void setDusList(String dusList) {
        this.dusList = dusList == null ? null : dusList.trim();
    }

    public String getServiceList() {
        return serviceList;
    }

    public FlowDetailTemplatePO withServiceList(String serviceList) {
        this.setServiceList(serviceList);
        return this;
    }

    public void setServiceList(String serviceList) {
        this.serviceList = serviceList == null ? null : serviceList.trim();
    }

    public String getTaskType() {
        return taskType;
    }

    public FlowDetailTemplatePO withTaskType(String taskType) {
        this.setTaskType(taskType);
        return this;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType == null ? null : taskType.trim();
    }

    public Short getRetryTime() {
        return retryTime;
    }

    public FlowDetailTemplatePO withRetryTime(Short retryTime) {
        this.setRetryTime(retryTime);
        return this;
    }

    public void setRetryTime(Short retryTime) {
        this.retryTime = retryTime;
    }

    public String getDescription() {
        return description;
    }

    public FlowDetailTemplatePO withDescription(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public LocalDateTime getLastModStamp() {
        return lastModStamp;
    }

    public FlowDetailTemplatePO withLastModStamp(LocalDateTime lastModStamp) {
        this.setLastModStamp(lastModStamp);
        return this;
    }

    public void setLastModStamp(LocalDateTime lastModStamp) {
        this.lastModStamp = lastModStamp;
    }

    public LocalDateTime getCreateStamp() {
        return createStamp;
    }

    public FlowDetailTemplatePO withCreateStamp(LocalDateTime createStamp) {
        this.setCreateStamp(createStamp);
        return this;
    }

    public void setCreateStamp(LocalDateTime createStamp) {
        this.createStamp = createStamp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", flowName=").append(flowName);
        sb.append(", sortNo=").append(sortNo);
        sb.append(", dependTask=").append(dependTask);
        sb.append(", taskName=").append(taskName);
        sb.append(", taskTypeName=").append(taskTypeName);
        sb.append(", isRun=").append(isRun);
        sb.append(", isSkip=").append(isSkip);
        sb.append(", dusList=").append(dusList);
        sb.append(", serviceList=").append(serviceList);
        sb.append(", taskType=").append(taskType);
        sb.append(", retryTime=").append(retryTime);
        sb.append(", description=").append(description);
        sb.append(", lastModStamp=").append(lastModStamp);
        sb.append(", createStamp=").append(createStamp);
        sb.append("]");
        return sb.toString();
    }
}