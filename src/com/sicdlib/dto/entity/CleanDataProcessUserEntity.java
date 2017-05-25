package com.sicdlib.dto.entity;

import com.sicdlib.dto.UserEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by DeMH on 2017/5/16.
 */
@Entity
@Table(name = "clean_data_process_user", schema = "socialmind", catalog = "")
public class CleanDataProcessUserEntity {
    private String id;
    private String customValue;
    private String customTime;
    private String userProcessLogUrl;
    //多对一：多个process_user对应一个process
    private CleanDataProcessEntity cleanDataProcess;
    //多对一：多个process_user对应一个user
    private UserEntity user;
    //一对多：一个process_user对应多个输出结果output_result
    private Set<CleanOutputResultsEntity> cleanOutputResultsEntitySet = new HashSet<CleanOutputResultsEntity>();
    //一对多：一个process_user对应多个输入clean_input
    private Set<CleanInputEntity> cleanInputEntitySet = new HashSet<CleanInputEntity>();

    @OneToMany(mappedBy = "cleanDataProcessUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<CleanInputEntity> getCleanInputEntitySet() {
        return cleanInputEntitySet;
    }

    public void setCleanInputEntitySet(Set<CleanInputEntity> cleanInputEntitySet) {
        this.cleanInputEntitySet = cleanInputEntitySet;
    }

    @OneToMany(mappedBy = "cleanDataProcessUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<CleanOutputResultsEntity> getCleanOutputResultsEntitySet() {
        return cleanOutputResultsEntitySet;
    }

    public void setCleanOutputResultsEntitySet(Set<CleanOutputResultsEntity> cleanOutputResultsEntitySet) {
        this.cleanOutputResultsEntitySet = cleanOutputResultsEntitySet;
    }

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "cln_td_prcss_id", referencedColumnName = "id")
    public CleanDataProcessEntity getCleanDataProcess() {
        return cleanDataProcess;
    }

    public void setCleanDataProcess(CleanDataProcessEntity cleanDataProcess) {
        this.cleanDataProcess = cleanDataProcess;
    }

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "custom_value")
    public String getCustomValue() {
        return customValue;
    }

    public void setCustomValue(String customValue) {
        this.customValue = customValue;
    }

    @Basic
    @Column(name = "custom_time")
    public String getCustomTime() {
        return customTime;
    }

    public void setCustomTime(String customTime) {
        this.customTime = customTime;
    }

    @Basic
    @Column(name = "user_process_log_url")
    public String getUserProcessLogUrl() {
        return userProcessLogUrl;
    }

    public void setUserProcessLogUrl(String userProcessLogUrl) {
        this.userProcessLogUrl = userProcessLogUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CleanDataProcessUserEntity that = (CleanDataProcessUserEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (customValue != null ? !customValue.equals(that.customValue) : that.customValue != null) return false;
        if (customTime != null ? !customTime.equals(that.customTime) : that.customTime != null) return false;
        if (userProcessLogUrl != null ? !userProcessLogUrl.equals(that.userProcessLogUrl) : that.userProcessLogUrl != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (customValue != null ? customValue.hashCode() : 0);
        result = 31 * result + (customTime != null ? customTime.hashCode() : 0);
        result = 31 * result + (userProcessLogUrl != null ? userProcessLogUrl.hashCode() : 0);
        return result;
    }
}
