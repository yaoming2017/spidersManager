package com.sicdlib.dto;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by init on 2017/5/24.
 */
@Entity
@Table(name = "sanqin_news", schema = "socialmind", catalog = "")
public class SanqinNewsEntity {
    private String id;
    private String url;
    private String pathUrl;
    private String pathText;
    private String title;
    private String publishTime;
    private String editor;
    private String sourceText;
    private String sourceHref;
    private Integer pictureHrefsNum;
    private String keyWords;
    private Timestamp timeStamp;
    private String content;

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
    @Column(name = "path_url")
    public String getPathUrl() {
        return pathUrl;
    }

    public void setPathUrl(String pathUrl) {
        this.pathUrl = pathUrl;
    }

    @Basic
    @Column(name = "path_text")
    public String getPathText() {
        return pathText;
    }

    public void setPathText(String pathText) {
        this.pathText = pathText;
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
    @Column(name = "publish_time")
    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    @Basic
    @Column(name = "editor")
    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    @Basic
    @Column(name = "source_text")
    public String getSourceText() {
        return sourceText;
    }

    public void setSourceText(String sourceText) {
        this.sourceText = sourceText;
    }

    @Basic
    @Column(name = "source_href")
    public String getSourceHref() {
        return sourceHref;
    }

    public void setSourceHref(String sourceHref) {
        this.sourceHref = sourceHref;
    }

    @Basic
    @Column(name = " picture_hrefs_num")
    public Integer getPictureHrefsNum() {
        return pictureHrefsNum;
    }

    public void setPictureHrefsNum(Integer pictureHrefsNum) {
        this.pictureHrefsNum = pictureHrefsNum;
    }

    @Basic
    @Column(name = "key_words")
    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
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
    @Column(name = " content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SanqinNewsEntity that = (SanqinNewsEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (pathUrl != null ? !pathUrl.equals(that.pathUrl) : that.pathUrl != null) return false;
        if (pathText != null ? !pathText.equals(that.pathText) : that.pathText != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (publishTime != null ? !publishTime.equals(that.publishTime) : that.publishTime != null) return false;
        if (editor != null ? !editor.equals(that.editor) : that.editor != null) return false;
        if (sourceText != null ? !sourceText.equals(that.sourceText) : that.sourceText != null) return false;
        if (sourceHref != null ? !sourceHref.equals(that.sourceHref) : that.sourceHref != null) return false;
        if (pictureHrefsNum != null ? !pictureHrefsNum.equals(that.pictureHrefsNum) : that.pictureHrefsNum != null)
            return false;
        if (keyWords != null ? !keyWords.equals(that.keyWords) : that.keyWords != null) return false;
        if (timeStamp != null ? !timeStamp.equals(that.timeStamp) : that.timeStamp != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (pathUrl != null ? pathUrl.hashCode() : 0);
        result = 31 * result + (pathText != null ? pathText.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (publishTime != null ? publishTime.hashCode() : 0);
        result = 31 * result + (editor != null ? editor.hashCode() : 0);
        result = 31 * result + (sourceText != null ? sourceText.hashCode() : 0);
        result = 31 * result + (sourceHref != null ? sourceHref.hashCode() : 0);
        result = 31 * result + (pictureHrefsNum != null ? pictureHrefsNum.hashCode() : 0);
        result = 31 * result + (keyWords != null ? keyWords.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
