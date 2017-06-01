package com.sicdlib.dto.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by init on 2017/5/25.
 */
@Entity
@Table(name = "douban_group_comment", schema = "socialmind", catalog = "")
public class DoubanGroupCommentEntity {
    private String commentId;
    private String postId;
    private String authorId;
    private String authorName;
    private String authorHref;
    private String content;
    private String pubTime;
    private Integer priseNum;
    private String quoteContent;
    private String quoteAuthorName;
    private String quoteAuthorHref;
    private String url;
    private Timestamp timeStamp;
    private String id;

    @Basic
    @Column(name = "comment_id")
    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

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
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "pub_time")
    public String getPubTime() {
        return pubTime;
    }

    public void setPubTime(String pubTime) {
        this.pubTime = pubTime;
    }

    @Basic
    @Column(name = "prise_num")
    public Integer getPriseNum() {
        return priseNum;
    }

    public void setPriseNum(Integer priseNum) {
        this.priseNum = priseNum;
    }

    @Basic
    @Column(name = "quote_content")
    public String getQuoteContent() {
        return quoteContent;
    }

    public void setQuoteContent(String quoteContent) {
        this.quoteContent = quoteContent;
    }

    @Basic
    @Column(name = "quote_author_name")
    public String getQuoteAuthorName() {
        return quoteAuthorName;
    }

    public void setQuoteAuthorName(String quoteAuthorName) {
        this.quoteAuthorName = quoteAuthorName;
    }

    @Basic
    @Column(name = "quote_author_href")
    public String getQuoteAuthorHref() {
        return quoteAuthorHref;
    }

    public void setQuoteAuthorHref(String quoteAuthorHref) {
        this.quoteAuthorHref = quoteAuthorHref;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DoubanGroupCommentEntity that = (DoubanGroupCommentEntity) o;

        if (commentId != null ? !commentId.equals(that.commentId) : that.commentId != null) return false;
        if (postId != null ? !postId.equals(that.postId) : that.postId != null) return false;
        if (authorId != null ? !authorId.equals(that.authorId) : that.authorId != null) return false;
        if (authorName != null ? !authorName.equals(that.authorName) : that.authorName != null) return false;
        if (authorHref != null ? !authorHref.equals(that.authorHref) : that.authorHref != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (pubTime != null ? !pubTime.equals(that.pubTime) : that.pubTime != null) return false;
        if (priseNum != null ? !priseNum.equals(that.priseNum) : that.priseNum != null) return false;
        if (quoteContent != null ? !quoteContent.equals(that.quoteContent) : that.quoteContent != null) return false;
        if (quoteAuthorName != null ? !quoteAuthorName.equals(that.quoteAuthorName) : that.quoteAuthorName != null)
            return false;
        if (quoteAuthorHref != null ? !quoteAuthorHref.equals(that.quoteAuthorHref) : that.quoteAuthorHref != null)
            return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (timeStamp != null ? !timeStamp.equals(that.timeStamp) : that.timeStamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commentId != null ? commentId.hashCode() : 0;
        result = 31 * result + (postId != null ? postId.hashCode() : 0);
        result = 31 * result + (authorId != null ? authorId.hashCode() : 0);
        result = 31 * result + (authorName != null ? authorName.hashCode() : 0);
        result = 31 * result + (authorHref != null ? authorHref.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (pubTime != null ? pubTime.hashCode() : 0);
        result = 31 * result + (priseNum != null ? priseNum.hashCode() : 0);
        result = 31 * result + (quoteContent != null ? quoteContent.hashCode() : 0);
        result = 31 * result + (quoteAuthorName != null ? quoteAuthorName.hashCode() : 0);
        result = 31 * result + (quoteAuthorHref != null ? quoteAuthorHref.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        return result;
    }

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
