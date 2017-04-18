package com.sicdlib.dto;

import javax.persistence.*;

/**
 * Created by haoyang on 2017/4/18.
 */
@Entity
@Table(name = "spider_info", schema = "socialMind")
public class SpiderInfoEntity {
    private String id;
    private String spiderAction;
    private String spiderActionTime;
    private String spiderSourcePath;
    private String spiderLogPath;
    private String spiderFilePath;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "spider_action")
    public String getSpiderAction() {
        return spiderAction;
    }

    public void setSpiderAction(String spiderAction) {
        this.spiderAction = spiderAction;
    }

    @Basic
    @Column(name = "spider_action_time")
    public String getSpiderActionTime() {
        return spiderActionTime;
    }

    public void setSpiderActionTime(String spiderActionTime) {
        this.spiderActionTime = spiderActionTime;
    }

    @Basic
    @Column(name = "spider_source_path")
    public String getSpiderSourcePath() {
        return spiderSourcePath;
    }

    public void setSpiderSourcePath(String spiderSourcePath) {
        this.spiderSourcePath = spiderSourcePath;
    }

    @Basic
    @Column(name = "spider_log_path")
    public String getSpiderLogPath() {
        return spiderLogPath;
    }

    public void setSpiderLogPath(String spiderLogPath) {
        this.spiderLogPath = spiderLogPath;
    }

    @Basic
    @Column(name = "spider_file_path")
    public String getSpiderFilePath() {
        return spiderFilePath;
    }

    public void setSpiderFilePath(String spiderFilePath) {
        this.spiderFilePath = spiderFilePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpiderInfoEntity that = (SpiderInfoEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (spiderAction != null ? !spiderAction.equals(that.spiderAction) : that.spiderAction != null) return false;
        if (spiderActionTime != null ? !spiderActionTime.equals(that.spiderActionTime) : that.spiderActionTime != null)
            return false;
        if (spiderSourcePath != null ? !spiderSourcePath.equals(that.spiderSourcePath) : that.spiderSourcePath != null)
            return false;
        if (spiderLogPath != null ? !spiderLogPath.equals(that.spiderLogPath) : that.spiderLogPath != null)
            return false;
        if (spiderFilePath != null ? !spiderFilePath.equals(that.spiderFilePath) : that.spiderFilePath != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (spiderAction != null ? spiderAction.hashCode() : 0);
        result = 31 * result + (spiderActionTime != null ? spiderActionTime.hashCode() : 0);
        result = 31 * result + (spiderSourcePath != null ? spiderSourcePath.hashCode() : 0);
        result = 31 * result + (spiderLogPath != null ? spiderLogPath.hashCode() : 0);
        result = 31 * result + (spiderFilePath != null ? spiderFilePath.hashCode() : 0);
        return result;
    }
}
