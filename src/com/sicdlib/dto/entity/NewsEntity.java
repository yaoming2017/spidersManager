package com.sicdlib.dto.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by init on 2017/5/24.
 */
@Entity
@Table(name = "news", schema = "socialmind", catalog = "")
public class NewsEntity {
    private String id;
    private String url;
    private String spiderTime;
    private String keywords;
    private String description;
    private String author;
    private String pathText;
    private String pathHref;
    private String title;
    private String dateTime;
    private String sourceText;
    private String sourceHref;
    private String content;
    private Integer pictureHrefsNum;
    private String editor;
    private Integer commentNum;
    private String bPictures;
    private Timestamp timeStamp;

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
    @Column(name = "spider_time")
    public String getSpiderTime() {
        return spiderTime;
    }

    public void setSpiderTime(String spiderTime) {
        this.spiderTime = spiderTime;
    }

    @Basic
    @Column(name = "keywords")
    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
    @Column(name = "path_href")
    public String getPathHref() {
        return pathHref;
    }

    public void setPathHref(String pathHref) {
        this.pathHref = pathHref;
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
    @Column(name = "date_time")
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
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
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "picture_hrefs_num")
    public Integer getPictureHrefsNum() {
        return pictureHrefsNum;
    }

    public void setPictureHrefsNum(Integer pictureHrefsNum) {
        this.pictureHrefsNum = pictureHrefsNum;
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
    @Column(name = "comment_num")
    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    @Basic
    @Column(name = "b_pictures")
    public String getbPictures() {
        return bPictures;
    }

    public void setbPictures(String bPictures) {
        this.bPictures = bPictures;
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

        NewsEntity that = (NewsEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (spiderTime != null ? !spiderTime.equals(that.spiderTime) : that.spiderTime != null) return false;
        if (keywords != null ? !keywords.equals(that.keywords) : that.keywords != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (pathText != null ? !pathText.equals(that.pathText) : that.pathText != null) return false;
        if (pathHref != null ? !pathHref.equals(that.pathHref) : that.pathHref != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (dateTime != null ? !dateTime.equals(that.dateTime) : that.dateTime != null) return false;
        if (sourceText != null ? !sourceText.equals(that.sourceText) : that.sourceText != null) return false;
        if (sourceHref != null ? !sourceHref.equals(that.sourceHref) : that.sourceHref != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (pictureHrefsNum != null ? !pictureHrefsNum.equals(that.pictureHrefsNum) : that.pictureHrefsNum != null)
            return false;
        if (editor != null ? !editor.equals(that.editor) : that.editor != null) return false;
        if (commentNum != null ? !commentNum.equals(that.commentNum) : that.commentNum != null) return false;
        if (bPictures != null ? !bPictures.equals(that.bPictures) : that.bPictures != null) return false;
        if (timeStamp != null ? !timeStamp.equals(that.timeStamp) : that.timeStamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (spiderTime != null ? spiderTime.hashCode() : 0);
        result = 31 * result + (keywords != null ? keywords.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (pathText != null ? pathText.hashCode() : 0);
        result = 31 * result + (pathHref != null ? pathHref.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        result = 31 * result + (sourceText != null ? sourceText.hashCode() : 0);
        result = 31 * result + (sourceHref != null ? sourceHref.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (pictureHrefsNum != null ? pictureHrefsNum.hashCode() : 0);
        result = 31 * result + (editor != null ? editor.hashCode() : 0);
        result = 31 * result + (commentNum != null ? commentNum.hashCode() : 0);
        result = 31 * result + (bPictures != null ? bPictures.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        return result;
    }
}
