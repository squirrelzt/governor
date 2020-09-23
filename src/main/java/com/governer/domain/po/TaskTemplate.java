package com.governer.domain.po;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TaskTemplate implements Serializable {
    private String taskName;

    private String taskTypeName;

    private String taskType;

    private String taskParam;

    private String description;

    private Integer maxParallNum;

    private String dusList;

    private String serviceList;

    private Integer isRun;

    private Integer isRepeat;

    private LocalDateTime createStamp;

    private LocalDateTime lastModStamp;

    private Long timeout;

    private String appName;

    private String taskPriority;

    private static final long serialVersionUID = 1L;

    public String getTaskName() {
        return taskName;
    }

    public TaskTemplate withTaskName(String taskName) {
        this.setTaskName(taskName);
        return this;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public String getTaskTypeName() {
        return taskTypeName;
    }

    public TaskTemplate withTaskTypeName(String taskTypeName) {
        this.setTaskTypeName(taskTypeName);
        return this;
    }

    public void setTaskTypeName(String taskTypeName) {
        this.taskTypeName = taskTypeName == null ? null : taskTypeName.trim();
    }

    public String getTaskType() {
        return taskType;
    }

    public TaskTemplate withTaskType(String taskType) {
        this.setTaskType(taskType);
        return this;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType == null ? null : taskType.trim();
    }

    public String getTaskParam() {
        return taskParam;
    }

    public TaskTemplate withTaskParam(String taskParam) {
        this.setTaskParam(taskParam);
        return this;
    }

    public void setTaskParam(String taskParam) {
        this.taskParam = taskParam == null ? null : taskParam.trim();
    }

    public String getDescription() {
        return description;
    }

    public TaskTemplate withDescription(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getMaxParallNum() {
        return maxParallNum;
    }

    public TaskTemplate withMaxParallNum(Integer maxParallNum) {
        this.setMaxParallNum(maxParallNum);
        return this;
    }

    public void setMaxParallNum(Integer maxParallNum) {
        this.maxParallNum = maxParallNum;
    }

    public String getDusList() {
        return dusList;
    }

    public TaskTemplate withDusList(String dusList) {
        this.setDusList(dusList);
        return this;
    }

    public void setDusList(String dusList) {
        this.dusList = dusList == null ? null : dusList.trim();
    }

    public String getServiceList() {
        return serviceList;
    }

    public TaskTemplate withServiceList(String serviceList) {
        this.setServiceList(serviceList);
        return this;
    }

    public void setServiceList(String serviceList) {
        this.serviceList = serviceList == null ? null : serviceList.trim();
    }

    public Integer getIsRun() {
        return isRun;
    }

    public TaskTemplate withIsRun(Integer isRun) {
        this.setIsRun(isRun);
        return this;
    }

    public void setIsRun(Integer isRun) {
        this.isRun = isRun;
    }

    public Integer getIsRepeat() {
        return isRepeat;
    }

    public TaskTemplate withIsRepeat(Integer isRepeat) {
        this.setIsRepeat(isRepeat);
        return this;
    }

    public void setIsRepeat(Integer isRepeat) {
        this.isRepeat = isRepeat;
    }

    public LocalDateTime getCreateStamp() {
        return createStamp;
    }

    public TaskTemplate withCreateStamp(LocalDateTime createStamp) {
        this.setCreateStamp(createStamp);
        return this;
    }

    public void setCreateStamp(LocalDateTime createStamp) {
        this.createStamp = createStamp;
    }

    public LocalDateTime getLastModStamp() {
        return lastModStamp;
    }

    public TaskTemplate withLastModStamp(LocalDateTime lastModStamp) {
        this.setLastModStamp(lastModStamp);
        return this;
    }

    public void setLastModStamp(LocalDateTime lastModStamp) {
        this.lastModStamp = lastModStamp;
    }

    public Long getTimeout() {
        return timeout;
    }

    public TaskTemplate withTimeout(Long timeout) {
        this.setTimeout(timeout);
        return this;
    }

    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }

    public String getAppName() {
        return appName;
    }

    public TaskTemplate withAppName(String appName) {
        this.setAppName(appName);
        return this;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public String getTaskPriority() {
        return taskPriority;
    }

    public TaskTemplate withTaskPriority(String taskPriority) {
        this.setTaskPriority(taskPriority);
        return this;
    }

    public void setTaskPriority(String taskPriority) {
        this.taskPriority = taskPriority == null ? null : taskPriority.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", taskName=").append(taskName);
        sb.append(", taskTypeName=").append(taskTypeName);
        sb.append(", taskType=").append(taskType);
        sb.append(", taskParam=").append(taskParam);
        sb.append(", description=").append(description);
        sb.append(", maxParallNum=").append(maxParallNum);
        sb.append(", dusList=").append(dusList);
        sb.append(", serviceList=").append(serviceList);
        sb.append(", isRun=").append(isRun);
        sb.append(", isRepeat=").append(isRepeat);
        sb.append(", createStamp=").append(createStamp);
        sb.append(", lastModStamp=").append(lastModStamp);
        sb.append(", timeout=").append(timeout);
        sb.append(", appName=").append(appName);
        sb.append(", taskPriority=").append(taskPriority);
        sb.append("]");
        return sb.toString();
    }
}