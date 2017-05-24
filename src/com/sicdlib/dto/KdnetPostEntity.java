package com.sicdlib.dto;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by init on 2017/5/24.
 */
@Entity
@Table(name = "kdnet_post", schema = "socialmind", catalog = "")
public class KdnetPostEntity {
    private String postId;
    private String authorId;
    private String postStatus;
    private String postUrl;
    private String title;
    private String author;
    private String authorHref;
    private String postTime;
    private String category;
    private Integer hits;
    private Integer commentNum;
    private String atUser;
    private String atHref;
    private Integer pictureHrefsNum;
    private String content;
    private Timestamp parseTime;
    private Timestamp timeStamp;

    @Id
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
    @Column(name = "post_status")
    public String getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(String postStatus) {
        this.postStatus = postStatus;
    }

    @Basic
    @Column(name = "post_url")
    public String getPostUrl() {
        return postUrl;
    }

    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
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
    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
    @Column(name = "post_time")
    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
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
    @Column(name = "hits")
    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
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
    @Column(name = "at_user")
    public String getAtUser() {
        return atUser;
    }

    public void setAtUser(String atUser) {
        this.atUser = atUser;
    }

    @Basic
    @Column(name = "at_href")
    public String getAtHref() {
        return atHref;
    }

    public void setAtHref(String atHref) {
        this.atHref = atHref;
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
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

        KdnetPostEntity that = (KdnetPostEntity) o;

        if (postId != null ? !postId.equals(that.postId) : that.postId != null) return false;
        if (authorId != null ? !authorId.equals(that.authorId) : that.authorId != null) return false;
        if (postStatus != null ? !postStatus.equals(that.postStatus) : that.postStatus != null) return false;
        if (postUrl != null ? !postUrl.equals(that.postUrl) : that.postUrl != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (authorHref != null ? !authorHref.equals(that.authorHref) : that.authorHref != null) return false;
        if (postTime != null ? !postTime.equals(that.postTime) : that.postTime != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (hits != null ? !hits.equals(that.hits) : that.hits != null) return false;
        if (commentNum != null ? !commentNum.equals(that.commentNum) : that.commentNum != null) return false;
        if (atUser != null ? !atUser.equals(that.atUser) : that.atUser != null) return false;
        if (atHref != null ? !atHref.equals(that.atHref) : that.atHref != null) return false;
        if (pictureHrefsNum != null ? !pictureHrefsNum.equals(that.pictureHrefsNum) : that.pictureHrefsNum != null)
            return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (parseTime != null ? !parseTime.equals(that.parseTime) : that.parseTime != null) return false;
        if (timeStamp != null ? !timeStamp.equals(that.timeStamp) : that.timeStamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = postId != null ? postId.hashCode() : 0;
        result = 31 * result + (authorId != null ? authorId.hashCode() : 0);
        result = 31 * result + (postStatus != null ? postStatus.hashCode() : 0);
        result = 31 * result + (postUrl != null ? postUrl.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (authorHref != null ? authorHref.hashCode() : 0);
        result = 31 * result + (postTime != null ? postTime.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (hits != null ? hits.hashCode() : 0);
        result = 31 * result + (commentNum != null ? commentNum.hashCode() : 0);
        result = 31 * result + (atUser != null ? atUser.hashCode() : 0);
        result = 31 * result + (atHref != null ? atHref.hashCode() : 0);
        result = 31 * result + (pictureHrefsNum != null ? pictureHrefsNum.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (parseTime != null ? parseTime.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        return result;
    }
}
