package com.sicdlib.dto.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by init on 2017/5/24.
 */
@Entity
@Table(name = "news_sina", schema = "socialmind", catalog = "")
public class NewsSinaEntity {
    private String id;
    private String url;
    private String newsType;
    private String pathText;
    private String pathUrl;
    private String keyWords;
    private String tags;
    private String newsId;
    private String title;
    private String description;
    private String dateTime;
    private String commmentId;
    private String author;
    private String editor;
    private String fromMedia;
    private String fromMediaUrl;
    private String content;
    private Integer pictureHrefsNum;
    private Integer participantNum;
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
    @Column(name = "news_type")
    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
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
    @Column(name = "path_url")
    public String getPathUrl() {
        return pathUrl;
    }

    public void setPathUrl(String pathUrl) {
        this.pathUrl = pathUrl;
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
    @Column(name = "tags")
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Basic
    @Column(name = "news_id")
    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    @Column(name = "commment_id")
    public String getCommmentId() {
        return commmentId;
    }

    public void setCommmentId(String commmentId) {
        this.commmentId = commmentId;
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
    @Column(name = "editor")
    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    @Basic
    @Column(name = "from_media")
    public String getFromMedia() {
        return fromMedia;
    }

    public void setFromMedia(String fromMedia) {
        this.fromMedia = fromMedia;
    }

    @Basic
    @Column(name = "from_media_url")
    public String getFromMediaUrl() {
        return fromMediaUrl;
    }

    public void setFromMediaUrl(String fromMediaUrl) {
        this.fromMediaUrl = fromMediaUrl;
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
    @Column(name = "participant_num")
    public Integer getParticipantNum() {
        return participantNum;
    }

    public void setParticipantNum(Integer participantNum) {
        this.participantNum = participantNum;
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

        NewsSinaEntity that = (NewsSinaEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (newsType != null ? !newsType.equals(that.newsType) : that.newsType != null) return false;
        if (pathText != null ? !pathText.equals(that.pathText) : that.pathText != null) return false;
        if (pathUrl != null ? !pathUrl.equals(that.pathUrl) : that.pathUrl != null) return false;
        if (keyWords != null ? !keyWords.equals(that.keyWords) : that.keyWords != null) return false;
        if (tags != null ? !tags.equals(that.tags) : that.tags != null) return false;
        if (newsId != null ? !newsId.equals(that.newsId) : that.newsId != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (dateTime != null ? !dateTime.equals(that.dateTime) : that.dateTime != null) return false;
        if (commmentId != null ? !commmentId.equals(that.commmentId) : that.commmentId != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (editor != null ? !editor.equals(that.editor) : that.editor != null) return false;
        if (fromMedia != null ? !fromMedia.equals(that.fromMedia) : that.fromMedia != null) return false;
        if (fromMediaUrl != null ? !fromMediaUrl.equals(that.fromMediaUrl) : that.fromMediaUrl != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (pictureHrefsNum != null ? !pictureHrefsNum.equals(that.pictureHrefsNum) : that.pictureHrefsNum != null)
            return false;
        if (participantNum != null ? !participantNum.equals(that.participantNum) : that.participantNum != null)
            return false;
        if (timeStamp != null ? !timeStamp.equals(that.timeStamp) : that.timeStamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (newsType != null ? newsType.hashCode() : 0);
        result = 31 * result + (pathText != null ? pathText.hashCode() : 0);
        result = 31 * result + (pathUrl != null ? pathUrl.hashCode() : 0);
        result = 31 * result + (keyWords != null ? keyWords.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (newsId != null ? newsId.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        result = 31 * result + (commmentId != null ? commmentId.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (editor != null ? editor.hashCode() : 0);
        result = 31 * result + (fromMedia != null ? fromMedia.hashCode() : 0);
        result = 31 * result + (fromMediaUrl != null ? fromMediaUrl.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (pictureHrefsNum != null ? pictureHrefsNum.hashCode() : 0);
        result = 31 * result + (participantNum != null ? participantNum.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        return result;
    }
}
