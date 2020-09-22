package com.governer.domain.po;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ConfigPO implements Serializable {
    private Long id;

    private String appName;

    private String name;

    private String type;

    private String json;

    private String cron;

    private Short enabled;

    private String description;

    private LocalDateTime lastModStamp;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public ConfigPO withId(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public ConfigPO withAppName(String appName) {
        this.setAppName(appName);
        return this;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public String getName() {
        return name;
    }

    public ConfigPO withName(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public ConfigPO withType(String type) {
        this.setType(type);
        return this;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getJson() {
        return json;
    }

    public ConfigPO withJson(String json) {
        this.setJson(json);
        return this;
    }

    public void setJson(String json) {
        this.json = json == null ? null : json.trim();
    }

    public String getCron() {
        return cron;
    }

    public ConfigPO withCron(String cron) {
        this.setCron(cron);
        return this;
    }

    public void setCron(String cron) {
        this.cron = cron == null ? null : cron.trim();
    }

    public Short getEnabled() {
        return enabled;
    }

    public ConfigPO withEnabled(Short enabled) {
        this.setEnabled(enabled);
        return this;
    }

    public void setEnabled(Short enabled) {
        this.enabled = enabled;
    }

    public String getDescription() {
        return description;
    }

    public ConfigPO withDescription(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public LocalDateTime getLastModStamp() {
        return lastModStamp;
    }

    public ConfigPO withLastModStamp(LocalDateTime lastModStamp) {
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
        sb.append(", id=").append(id);
        sb.append(", appName=").append(appName);
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", json=").append(json);
        sb.append(", cron=").append(cron);
        sb.append(", enabled=").append(enabled);
        sb.append(", description=").append(description);
        sb.append(", lastModStamp=").append(lastModStamp);
        sb.append("]");
        return sb.toString();
    }
}