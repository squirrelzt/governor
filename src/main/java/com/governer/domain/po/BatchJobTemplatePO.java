package com.governer.domain.po;

import java.io.Serializable;
import java.time.LocalDateTime;

public class BatchJobTemplatePO implements Serializable {
    private String jobName;

    private String jobApplicationName;

    private String sourceType;

    private String remoteJobName;

    private String fileTemplateName;

    private String shardingRule;

    private Long transactionsSubmitNum;

    private Short maxParallNum;

    private Short isSkip;

    private Short isRepeat;

    private Short isResult;

    private Long retryTime;

    private String jobParam;

    private LocalDateTime createStamp;

    private LocalDateTime lastModStamp;

    private static final long serialVersionUID = 1L;

    public String getJobName() {
        return jobName;
    }

    public BatchJobTemplatePO withJobName(String jobName) {
        this.setJobName(jobName);
        return this;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public String getJobApplicationName() {
        return jobApplicationName;
    }

    public BatchJobTemplatePO withJobApplicationName(String jobApplicationName) {
        this.setJobApplicationName(jobApplicationName);
        return this;
    }

    public void setJobApplicationName(String jobApplicationName) {
        this.jobApplicationName = jobApplicationName == null ? null : jobApplicationName.trim();
    }

    public String getSourceType() {
        return sourceType;
    }

    public BatchJobTemplatePO withSourceType(String sourceType) {
        this.setSourceType(sourceType);
        return this;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType == null ? null : sourceType.trim();
    }

    public String getRemoteJobName() {
        return remoteJobName;
    }

    public BatchJobTemplatePO withRemoteJobName(String remoteJobName) {
        this.setRemoteJobName(remoteJobName);
        return this;
    }

    public void setRemoteJobName(String remoteJobName) {
        this.remoteJobName = remoteJobName == null ? null : remoteJobName.trim();
    }

    public String getFileTemplateName() {
        return fileTemplateName;
    }

    public BatchJobTemplatePO withFileTemplateName(String fileTemplateName) {
        this.setFileTemplateName(fileTemplateName);
        return this;
    }

    public void setFileTemplateName(String fileTemplateName) {
        this.fileTemplateName = fileTemplateName == null ? null : fileTemplateName.trim();
    }

    public String getShardingRule() {
        return shardingRule;
    }

    public BatchJobTemplatePO withShardingRule(String shardingRule) {
        this.setShardingRule(shardingRule);
        return this;
    }

    public void setShardingRule(String shardingRule) {
        this.shardingRule = shardingRule == null ? null : shardingRule.trim();
    }

    public Long getTransactionsSubmitNum() {
        return transactionsSubmitNum;
    }

    public BatchJobTemplatePO withTransactionsSubmitNum(Long transactionsSubmitNum) {
        this.setTransactionsSubmitNum(transactionsSubmitNum);
        return this;
    }

    public void setTransactionsSubmitNum(Long transactionsSubmitNum) {
        this.transactionsSubmitNum = transactionsSubmitNum;
    }

    public Short getMaxParallNum() {
        return maxParallNum;
    }

    public BatchJobTemplatePO withMaxParallNum(Short maxParallNum) {
        this.setMaxParallNum(maxParallNum);
        return this;
    }

    public void setMaxParallNum(Short maxParallNum) {
        this.maxParallNum = maxParallNum;
    }

    public Short getIsSkip() {
        return isSkip;
    }

    public BatchJobTemplatePO withIsSkip(Short isSkip) {
        this.setIsSkip(isSkip);
        return this;
    }

    public void setIsSkip(Short isSkip) {
        this.isSkip = isSkip;
    }

    public Short getIsRepeat() {
        return isRepeat;
    }

    public BatchJobTemplatePO withIsRepeat(Short isRepeat) {
        this.setIsRepeat(isRepeat);
        return this;
    }

    public void setIsRepeat(Short isRepeat) {
        this.isRepeat = isRepeat;
    }

    public Short getIsResult() {
        return isResult;
    }

    public BatchJobTemplatePO withIsResult(Short isResult) {
        this.setIsResult(isResult);
        return this;
    }

    public void setIsResult(Short isResult) {
        this.isResult = isResult;
    }

    public Long getRetryTime() {
        return retryTime;
    }

    public BatchJobTemplatePO withRetryTime(Long retryTime) {
        this.setRetryTime(retryTime);
        return this;
    }

    public void setRetryTime(Long retryTime) {
        this.retryTime = retryTime;
    }

    public String getJobParam() {
        return jobParam;
    }

    public BatchJobTemplatePO withJobParam(String jobParam) {
        this.setJobParam(jobParam);
        return this;
    }

    public void setJobParam(String jobParam) {
        this.jobParam = jobParam == null ? null : jobParam.trim();
    }

    public LocalDateTime getCreateStamp() {
        return createStamp;
    }

    public BatchJobTemplatePO withCreateStamp(LocalDateTime createStamp) {
        this.setCreateStamp(createStamp);
        return this;
    }

    public void setCreateStamp(LocalDateTime createStamp) {
        this.createStamp = createStamp;
    }

    public LocalDateTime getLastModStamp() {
        return lastModStamp;
    }

    public BatchJobTemplatePO withLastModStamp(LocalDateTime lastModStamp) {
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
        sb.append(", jobName=").append(jobName);
        sb.append(", jobApplicationName=").append(jobApplicationName);
        sb.append(", sourceType=").append(sourceType);
        sb.append(", remoteJobName=").append(remoteJobName);
        sb.append(", fileTemplateName=").append(fileTemplateName);
        sb.append(", shardingRule=").append(shardingRule);
        sb.append(", transactionsSubmitNum=").append(transactionsSubmitNum);
        sb.append(", maxParallNum=").append(maxParallNum);
        sb.append(", isSkip=").append(isSkip);
        sb.append(", isRepeat=").append(isRepeat);
        sb.append(", isResult=").append(isResult);
        sb.append(", retryTime=").append(retryTime);
        sb.append(", jobParam=").append(jobParam);
        sb.append(", createStamp=").append(createStamp);
        sb.append(", lastModStamp=").append(lastModStamp);
        sb.append("]");
        return sb.toString();
    }
}