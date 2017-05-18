package com.sicdlib.dto;

import javax.persistence.*;

/**
 * Created by haoyang on 2017/4/24.
 */
@Entity
@Table(name = "spider_config_item", schema = "socialMind", catalog = "")
public class SpiderConfigItemEntity {
    private String id;
    private String configId;
    private String configItemName;
    private String configItemValue;
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
    @Column(name = "config_id")
    public String getConfigId() {
        return configId;
    }

    public void setConfigId(String configId) {
        this.configId = configId;
    }

    @Basic
    @Column(name = "config_item_name")
    public String getConfigItemName() {
        return configItemName;
    }

    public void setConfigItemName(String configItemName) {
        this.configItemName = configItemName;
    }

    @Basic
    @Column(name = "config_item_value")
    public String getConfigItemValue() {
        return configItemValue;
    }

    public void setConfigItemValue(String configItemValue) {
        this.configItemValue = configItemValue;
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

        SpiderConfigItemEntity that = (SpiderConfigItemEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (configId != null ? !configId.equals(that.configId) : that.configId != null) return false;
        if (configItemName != null ? !configItemName.equals(that.configItemName) : that.configItemName != null)
            return false;
        if (configItemValue != null ? !configItemValue.equals(that.configItemValue) : that.configItemValue != null)
            return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (configId != null ? configId.hashCode() : 0);
        result = 31 * result + (configItemName != null ? configItemName.hashCode() : 0);
        result = 31 * result + (configItemValue != null ? configItemValue.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
