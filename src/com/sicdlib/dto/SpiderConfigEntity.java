package com.sicdlib.dto;

import javax.persistence.*;

/**
 * Created by haoyang on 2017/4/18.
 */
@Entity
@Table(name = "spider_config", schema = "socialMind")
public class SpiderConfigEntity {
    private String id;
    private Integer isDefault;
    private String configTime;
    private Integer spiderFrequency;
    private Long spiderRunTime;
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
    @Column(name = "is_default")
    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
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
        if (isDefault != null ? !isDefault.equals(that.isDefault) : that.isDefault != null) return false;
        if (configTime != null ? !configTime.equals(that.configTime) : that.configTime != null) return false;
        if (spiderFrequency != null ? !spiderFrequency.equals(that.spiderFrequency) : that.spiderFrequency != null)
            return false;
        if (spiderRunTime != null ? !spiderRunTime.equals(that.spiderRunTime) : that.spiderRunTime != null)
            return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (isDefault != null ? isDefault.hashCode() : 0);
        result = 31 * result + (configTime != null ? configTime.hashCode() : 0);
        result = 31 * result + (spiderFrequency != null ? spiderFrequency.hashCode() : 0);
        result = 31 * result + (spiderRunTime != null ? spiderRunTime.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
