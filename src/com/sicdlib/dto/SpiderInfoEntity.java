package com.sicdlib.dto;

import javax.persistence.*;

/**
 * Created by YH on 2017/5/4.
 */
@Entity
@Table(name = "spider_info", schema = "socialMind", catalog = "")
public class SpiderInfoEntity {
    private String id;
    private String spiderSourcePath;
    private String websiteId;
    private String spiderName;
    private String fileName;
    private String fileId;
    private String addTime;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    @Column(name = "website_id")
    public String getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(String websiteId) {
        this.websiteId = websiteId;
    }

    @Basic
    @Column(name = "spider_name")
    public String getSpiderName() {
        return spiderName;
    }

    public void setSpiderName(String spiderName) {
        this.spiderName = spiderName;
    }

    @Basic
    @Column(name = "file_name")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Basic
    @Column(name = "file_id")
    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    @Basic
    @Column(name = "add_time")
    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpiderInfoEntity that = (SpiderInfoEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (spiderSourcePath != null ? !spiderSourcePath.equals(that.spiderSourcePath) : that.spiderSourcePath != null)
            return false;
        if (websiteId != null ? !websiteId.equals(that.websiteId) : that.websiteId != null) return false;
        if (spiderName != null ? !spiderName.equals(that.spiderName) : that.spiderName != null) return false;
        if (fileName != null ? !fileName.equals(that.fileName) : that.fileName != null) return false;
        if (fileId != null ? !fileId.equals(that.fileId) : that.fileId != null) return false;
        if (addTime != null ? !addTime.equals(that.addTime) : that.addTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (spiderSourcePath != null ? spiderSourcePath.hashCode() : 0);
        result = 31 * result + (websiteId != null ? websiteId.hashCode() : 0);
        result = 31 * result + (spiderName != null ? spiderName.hashCode() : 0);
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (fileId != null ? fileId.hashCode() : 0);
        result = 31 * result + (addTime != null ? addTime.hashCode() : 0);
        return result;
    }
}
