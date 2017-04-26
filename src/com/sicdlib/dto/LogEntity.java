package com.sicdlib.dto;

import javax.persistence.*;

/**
 * Created by haoyang on 2017/4/24.
 */
@Entity
@Table(name = "log", schema = "socialMind", catalog = "")
public class LogEntity {
    private String id;
    private String userId;
    private String loginIp;
    private String operateType;
    private String operateObject;
    private String operateTime;
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
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "login_ip")
    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    @Basic
    @Column(name = "operate_type")
    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    @Basic
    @Column(name = "operate_object")
    public String getOperateObject() {
        return operateObject;
    }

    public void setOperateObject(String operateObject) {
        this.operateObject = operateObject;
    }

    @Basic
    @Column(name = "operate_time")
    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
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

        LogEntity logEntity = (LogEntity) o;

        if (id != null ? !id.equals(logEntity.id) : logEntity.id != null) return false;
        if (userId != null ? !userId.equals(logEntity.userId) : logEntity.userId != null) return false;
        if (loginIp != null ? !loginIp.equals(logEntity.loginIp) : logEntity.loginIp != null) return false;
        if (operateType != null ? !operateType.equals(logEntity.operateType) : logEntity.operateType != null)
            return false;
        if (operateObject != null ? !operateObject.equals(logEntity.operateObject) : logEntity.operateObject != null)
            return false;
        if (operateTime != null ? !operateTime.equals(logEntity.operateTime) : logEntity.operateTime != null)
            return false;
        if (remark != null ? !remark.equals(logEntity.remark) : logEntity.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (loginIp != null ? loginIp.hashCode() : 0);
        result = 31 * result + (operateType != null ? operateType.hashCode() : 0);
        result = 31 * result + (operateObject != null ? operateObject.hashCode() : 0);
        result = 31 * result + (operateTime != null ? operateTime.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
