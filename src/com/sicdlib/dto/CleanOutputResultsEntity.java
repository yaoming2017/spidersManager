package com.sicdlib.dto;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

/**
 * Created by DeMH on 2017/5/16.
 */
@Entity
@Table(name = "clean_output_results", schema = "socialmind", catalog = "")
public class CleanOutputResultsEntity {
    private String id;
    private String outName;
    private String outUrl;
    private String outTime;
    //多对一：多个process_user对应一个output_result
    private CleanDataProcessUserEntity cleanDataProcessUser;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "clndt_procs_user_id", referencedColumnName = "id")
    public CleanDataProcessUserEntity getCleanDataProcessUser() {
        return cleanDataProcessUser;
    }

    public void setCleanDataProcessUser(CleanDataProcessUserEntity cleanDataProcessUser) {
        this.cleanDataProcessUser = cleanDataProcessUser;
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
    @Column(name = "out_name")
    public String getOutName() {
        return outName;
    }

    public void setOutName(String outName) {
        this.outName = outName;
    }

    @Basic
    @Column(name = "out_url")
    public String getOutUrl() {
        return outUrl;
    }

    public void setOutUrl(String outUrl) {
        this.outUrl = outUrl;
    }

    @Basic
    @Column(name = "out_time")
    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CleanOutputResultsEntity that = (CleanOutputResultsEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (outName != null ? !outName.equals(that.outName) : that.outName != null) return false;
        if (outUrl != null ? !outUrl.equals(that.outUrl) : that.outUrl != null) return false;
        if (outTime != null ? !outTime.equals(that.outTime) : that.outTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (outName != null ? outName.hashCode() : 0);
        result = 31 * result + (outUrl != null ? outUrl.hashCode() : 0);
        result = 31 * result + (outTime != null ? outTime.hashCode() : 0);
        return result;
    }
}
