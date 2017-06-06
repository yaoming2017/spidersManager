package com.sicdlib.dto.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by init on 2017/6/3.
 */
@Entity
@Table(name = "bbs_xici_post", schema = "socialmind", catalog = "")
public class BbsXiciPostEntity {
    private String postId;
    private String authorId;
    private String authorName;
    private String authorHref;
    private Timestamp parseTime;
    private String keyWords;
    private String title;
    private String dateTime;
    private String content;
    private Integer pictureHrefsNum;
    private String url;
    private Timestamp timeStamp;
    private String id;
    private Integer commentNum;

    @Basic
    @Column(name = "post_id")
    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    @Basic
    @Column(name = "author_id")
    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    @Basic
    @Column(name = "author_name")
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Basic
    @Column(name = "author_href")
    public String getAuthorHref() {
        return authorHref;
    }

    public void setAuthorHref(String authorHref) {
        this.authorHref = authorHref;
    }

    @Basic
    @Column(name = "parse_time")
    public Timestamp getParseTime() {
        return parseTime;
    }

    public void setParseTime(Timestamp parseTime) {
        this.parseTime = parseTime;
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
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "time_stamp")
    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
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
    @Column(name = "comment_num")
    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BbsXiciPostEntity that = (BbsXiciPostEntity) o;

        if (postId != null ? !postId.equals(that.postId) : that.postId != null) return false;
        if (authorId != null ? !authorId.equals(that.authorId) : that.authorId != null) return false;
        if (authorName != null ? !authorName.equals(that.authorName) : that.authorName != null) return false;
        if (authorHref != null ? !authorHref.equals(that.authorHref) : that.authorHref != null) return false;
        if (parseTime != null ? !parseTime.equals(that.parseTime) : that.parseTime != null) return false;
        if (keyWords != null ? !keyWords.equals(that.keyWords) : that.keyWords != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (dateTime != null ? !dateTime.equals(that.dateTime) : that.dateTime != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (pictureHrefsNum != null ? !pictureHrefsNum.equals(that.pictureHrefsNum) : that.pictureHrefsNum != null)
            return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (timeStamp != null ? !timeStamp.equals(that.timeStamp) : that.timeStamp != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (commentNum != null ? !commentNum.equals(that.commentNum) : that.commentNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = postId != null ? postId.hashCode() : 0;
        result = 31 * result + (authorId != null ? authorId.hashCode() : 0);
        result = 31 * result + (authorName != null ? authorName.hashCode() : 0);
        result = 31 * result + (authorHref != null ? authorHref.hashCode() : 0);
        result = 31 * result + (parseTime != null ? parseTime.hashCode() : 0);
        result = 31 * result + (keyWords != null ? keyWords.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (pictureHrefsNum != null ? pictureHrefsNum.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (commentNum != null ? commentNum.hashCode() : 0);
        return result;
    }
}
