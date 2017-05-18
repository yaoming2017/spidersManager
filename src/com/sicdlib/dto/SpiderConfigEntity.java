package com.sicdlib.dto;

import javax.persistence.*;

/**
 * Created by YH on 2017/5/14.
 */
@Entity
@Table(name = "spider_config", schema = "socialmind")
public class SpiderConfigEntity {
    private String id;
    private String spiderId;
    private String configTime;
    private Integer spiderFrequency;
    private Long spiderRunTime;
    private String logPath;
    private String filePath;
    private String status;
    private String remark;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "spider_id")
    public String getSpiderId() {
        return spiderId;
    }

    public void setSpiderId(String spiderId) {
        this.spiderId = spiderId;
    }

    @Basic
    @Column(name = "config_time")
    public String getConfigTime() {
        return configTime;
    }

    public void setConfigTime(String configTime) {
        this.configTime = configTime;
    }

    @Basic
    @Column(name = "spider_frequency")
    public Integer getSpiderFrequency() {
        return spiderFrequency;
    }

    public void setSpiderFrequency(Integer spiderFrequency) {
        this.spiderFrequency = spiderFrequency;
    }

    @Basic
    @Column(name = "spider_run_time")
    public Long getSpiderRunTime() {
        return spiderRunTime;
    }

    public void setSpiderRunTime(Long spiderRunTime) {
        this.spiderRunTime = spiderRunTime;
    }

    @Basic
    @Column(name = "log_path")
    public String getLogPath() {
        return logPath;
    }

    public void setLogPath(String logPath) {
        this.logPath = logPath;
    }

    @Basic
    @Column(name = "file_path")
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpiderConfigEntity that = (SpiderConfigEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (spiderId != null ? !spiderId.equals(that.spiderId) : that.spiderId != null) return false;
        if (configTime != null ? !configTime.equals(that.configTime) : that.configTime != null) return false;
        if (spiderFrequency != null ? !spiderFrequency.equals(that.spiderFrequency) : that.spiderFrequency != null)
            return false;
        if (spiderRunTime != null ? !spiderRunTime.equals(that.spiderRunTime) : that.spiderRunTime != null)
            return false;
        if (logPath != null ? !logPath.equals(that.logPath) : that.logPath != null) return false;
        if (filePath != null ? !filePath.equals(that.filePath) : that.filePath != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (spiderId != null ? spiderId.hashCode() : 0);
        result = 31 * result + (configTime != null ? configTime.hashCode() : 0);
        result = 31 * result + (spiderFrequency != null ? spiderFrequency.hashCode() : 0);
        result = 31 * result + (spiderRunTime != null ? spiderRunTime.hashCode() : 0);
        result = 31 * result + (logPath != null ? logPath.hashCode() : 0);
        result = 31 * result + (filePath != null ? filePath.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
