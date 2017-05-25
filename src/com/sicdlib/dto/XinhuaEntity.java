package com.sicdlib.dto;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by init on 2017/5/24.
 */
@Entity
@Table(name = "xinhua", schema = "socialmind", catalog = "")
public class XinhuaEntity {
    private String articleId;
    private String url;
    private String category;
    private String subCategory;
    private String title;
    private String summary;
    private String publishTime;
    private String origin;
    private String content;
    private Timestamp timeStamp;

    @Id
    @Column(name = "article_id")
    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Column(name = "sub_category")
    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "summary")
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Basic
    @Column(name = "publish_time")
    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    @Basic
    @Column(name = "origin")
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "time_stamp")
    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        XinhuaEntity that = (XinhuaEntity) o;

        if (articleId != null ? !articleId.equals(that.articleId) : that.articleId != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (subCategory != null ? !subCategory.equals(that.subCategory) : that.subCategory != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (summary != null ? !summary.equals(that.summary) : that.summary != null) return false;
        if (publishTime != null ? !publishTime.equals(that.publishTime) : that.publishTime != null) return false;
        if (origin != null ? !origin.equals(that.origin) : that.origin != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (timeStamp != null ? !timeStamp.equals(that.timeStamp) : that.timeStamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = articleId != null ? articleId.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (subCategory != null ? subCategory.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        result = 31 * result + (publishTime != null ? publishTime.hashCode() : 0);
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        return result;
    }
}
