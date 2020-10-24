package com.governer.domain.po;

import java.io.Serializable;
import java.time.LocalDateTime;

public class FlowTypeTemplatePO implements Serializable {
    private String flowName;

    private String taskTypeName;

    private Short maxParallNum;

    private String serviceList;

    private String dusList;

    private String description;

    private LocalDateTime createStamp;

    private LocalDateTime lastModStamp;

    private static final long serialVersionUID = 1L;

    public String getFlowName() {
        return flowName;
    }

    public FlowTypeTemplatePO withFlowName(String flowName) {
        this.setFlowName(flowName);
        return this;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName == null ? null : flowName.trim();
    }

    public String getTaskTypeName() {
        return taskTypeName;
    }

    public FlowTypeTemplatePO withTaskTypeName(String taskTypeName) {
        this.setTaskTypeName(taskTypeName);
        return this;
    }

    public void setTaskTypeName(String taskTypeName) {
        this.taskTypeName = taskTypeName == null ? null : taskTypeName.trim();
    }

    public Short getMaxParallNum() {
        return maxParallNum;
    }

    public FlowTypeTemplatePO withMaxParallNum(Short maxParallNum) {
        this.setMaxParallNum(maxParallNum);
        return this;
    }

    public void setMaxParallNum(Short maxParallNum) {
        this.maxParallNum = maxParallNum;
    }

    public String getServiceList() {
        return serviceList;
    }

    public FlowTypeTemplatePO withServiceList(String serviceList) {
        this.setServiceList(serviceList);
        return this;
    }

    public void setServiceList(String serviceList) {
        this.serviceList = serviceList == null ? null : serviceList.trim();
    }

    public String getDusList() {
        return dusList;
    }

    public FlowTypeTemplatePO withDusList(String dusList) {
        this.setDusList(dusList);
        return this;
    }

    public void setDusList(String dusList) {
        this.dusList = dusList == null ? null : dusList.trim();
    }

    public String getDescription() {
        return description;
    }

    public FlowTypeTemplatePO withDescription(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public LocalDateTime getCreateStamp() {
        return createStamp;
    }

    public FlowTypeTemplatePO withCreateStamp(LocalDateTime createStamp) {
        this.setCreateStamp(createStamp);
        return this;
    }

    public void setCreateStamp(LocalDateTime createStamp) {
        this.createStamp = createStamp;
    }

    public LocalDateTime getLastModStamp() {
        return lastModStamp;
    }

    public FlowTypeTemplatePO withLastModStamp(LocalDateTime lastModStamp) {
        this.setLastModStamp(lastModStamp);
        return this;
    }

    public void setLastModStamp(LocalDateTime lastModStamp) {
        this.lastModStamp = lastModStamp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", flowName=").append(flowName);
        sb.append(", taskTypeName=").append(taskTypeName);
        sb.append(", maxParallNum=").append(maxParallNum);
        sb.append(", serviceList=").append(serviceList);
        sb.append(", dusList=").append(dusList);
        sb.append(", description=").append(description);
        sb.append(", createStamp=").append(createStamp);
        sb.append(", lastModStamp=").append(lastModStamp);
        sb.append("]");
        return sb.toString();
    }
}