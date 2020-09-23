package com.governer.domain.po;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TimerM implements Serializable {
    private String appName;

    private String name;

    private String type;

    private String cron;

    private String json;

    private Integer enabled;

    private String description;

    private LocalDateTime lastModStamp;

    private LocalDateTime createStamp;

    private static final long serialVersionUID = 1L;

    public String getAppName() {
        return appName;
    }

    public TimerM withAppName(String appName) {
        this.setAppName(appName);
        return this;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public String getName() {
        return name;
    }

    public TimerM withName(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public TimerM withType(String type) {
        this.setType(type);
        return this;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getCron() {
        return cron;
    }

    public TimerM withCron(String cron) {
        this.setCron(cron);
        return this;
    }

    public void setCron(String cron) {
        this.cron = cron == null ? null : cron.trim();
    }

    public String getJson() {
        return json;
    }

    public TimerM withJson(String json) {
        this.setJson(json);
        return this;
    }

    public void setJson(String json) {
        this.json = json == null ? null : json.trim();
    }

    public Integer getEnabled() {
        return enabled;
    }

    public TimerM withEnabled(Integer enabled) {
        this.setEnabled(enabled);
        return this;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getDescription() {
        return description;
    }

    public TimerM withDescription(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public LocalDateTime getLastModStamp() {
        return lastModStamp;
    }

    public TimerM withLastModStamp(LocalDateTime lastModStamp) {
        this.setLastModStamp(lastModStamp);
        return this;
    }

    public void setLastModStamp(LocalDateTime lastModStamp) {
        this.lastModStamp = lastModStamp;
    }

    public LocalDateTime getCreateStamp() {
        return createStamp;
    }

    public TimerM withCreateStamp(LocalDateTime createStamp) {
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
        sb.append(", appName=").append(appName);
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", cron=").append(cron);
        sb.append(", json=").append(json);
        sb.append(", enabled=").append(enabled);
        sb.append(", description=").append(description);
        sb.append(", lastModStamp=").append(lastModStamp);
        sb.append(", createStamp=").append(createStamp);
        sb.append("]");
        return sb.toString();
    }
}