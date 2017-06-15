package com.sicdlib.dto.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by init on 2017/6/11.
 */
@Entity
@Table(name = "moe_news", schema = "socialmind", catalog = "")
public class MoeNewsEntity {
    private String id;
    private String url;
    private String spiderPath;
    private String position;
    private String newsYt;
    private String newsTitle;
    private String newsSubTitle;
    private String newsFwzh;
    private String newsTime;
    private String newsSource;
    private String newsEditor;
    private String newsContent;
    private String qrCodeUrl;
    private Timestamp timeStamp;
    private Integer fileNum;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    @Column(name = "spider_path")
    public String getSpiderPath() {
        return spiderPath;
    }

    public void setSpiderPath(String spiderPath) {
        this.spiderPath = spiderPath;
    }

    @Basic
    @Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Basic
    @Column(name = "news_yt")
    public String getNewsYt() {
        return newsYt;
    }

    public void setNewsYt(String newsYt) {
        this.newsYt = newsYt;
    }

    @Basic
    @Column(name = "news_title")
    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    @Basic
    @Column(name = "news_sub_title")
    public String getNewsSubTitle() {
        return newsSubTitle;
    }

    public void setNewsSubTitle(String newsSubTitle) {
        this.newsSubTitle = newsSubTitle;
    }

    @Basic
    @Column(name = "news_fwzh")
    public String getNewsFwzh() {
        return newsFwzh;
    }

    public void setNewsFwzh(String newsFwzh) {
        this.newsFwzh = newsFwzh;
    }

    @Basic
    @Column(name = "news_time")
    public String getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(String newsTime) {
        this.newsTime = newsTime;
    }

    @Basic
    @Column(name = "news_source")
    public String getNewsSource() {
        return newsSource;
    }

    public void setNewsSource(String newsSource) {
        this.newsSource = newsSource;
    }

    @Basic
    @Column(name = "news_editor")
    public String getNewsEditor() {
        return newsEditor;
    }

    public void setNewsEditor(String newsEditor) {
        this.newsEditor = newsEditor;
    }

    @Basic
    @Column(name = "news_content")
    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    @Basic
    @Column(name = "QRCode_url")
    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }

    @Basic
    @Column(name = "time_stamp")
    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Basic
    @Column(name = "file_num")
    public Integer getFileNum() {
        return fileNum;
    }

    public void setFileNum(Integer fileNum) {
        this.fileNum = fileNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MoeNewsEntity that = (MoeNewsEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (spiderPath != null ? !spiderPath.equals(that.spiderPath) : that.spiderPath != null) return false;
        if (position != null ? !position.equals(that.position) : that.position != null) return false;
        if (newsYt != null ? !newsYt.equals(that.newsYt) : that.newsYt != null) return false;
        if (newsTitle != null ? !newsTitle.equals(that.newsTitle) : that.newsTitle != null) return false;
        if (newsSubTitle != null ? !newsSubTitle.equals(that.newsSubTitle) : that.newsSubTitle != null) return false;
        if (newsFwzh != null ? !newsFwzh.equals(that.newsFwzh) : that.newsFwzh != null) return false;
        if (newsTime != null ? !newsTime.equals(that.newsTime) : that.newsTime != null) return false;
        if (newsSource != null ? !newsSource.equals(that.newsSource) : that.newsSource != null) return false;
        if (newsEditor != null ? !newsEditor.equals(that.newsEditor) : that.newsEditor != null) return false;
        if (newsContent != null ? !newsContent.equals(that.newsContent) : that.newsContent != null) return false;
        if (qrCodeUrl != null ? !qrCodeUrl.equals(that.qrCodeUrl) : that.qrCodeUrl != null) return false;
        if (timeStamp != null ? !timeStamp.equals(that.timeStamp) : that.timeStamp != null) return false;
        if (fileNum != null ? !fileNum.equals(that.fileNum) : that.fileNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (spiderPath != null ? spiderPath.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (newsYt != null ? newsYt.hashCode() : 0);
        result = 31 * result + (newsTitle != null ? newsTitle.hashCode() : 0);
        result = 31 * result + (newsSubTitle != null ? newsSubTitle.hashCode() : 0);
        result = 31 * result + (newsFwzh != null ? newsFwzh.hashCode() : 0);
        result = 31 * result + (newsTime != null ? newsTime.hashCode() : 0);
        result = 31 * result + (newsSource != null ? newsSource.hashCode() : 0);
        result = 31 * result + (newsEditor != null ? newsEditor.hashCode() : 0);
        result = 31 * result + (newsContent != null ? newsContent.hashCode() : 0);
        result = 31 * result + (qrCodeUrl != null ? qrCodeUrl.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        result = 31 * result + (fileNum != null ? fileNum.hashCode() : 0);
        return result;
    }
}
