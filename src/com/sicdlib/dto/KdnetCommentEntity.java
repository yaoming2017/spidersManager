package com.sicdlib.dto;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by init on 2017/5/24.
 */
@Entity
@Table(name = "kdnet_comment", schema = "socialmind", catalog = "")
public class KdnetCommentEntity {
    private String commentId;
    private String authorHref;
    private String authorNick;
    private String authorId;
    private String postId;
    private Integer floorNum;
    private String dateTime;
    private String content;
    private String atUser;
    private String atHref;
    private Integer pictureHrefsNum;
    private String quoteCommentId;
    private Timestamp parseTime;
    private Timestamp timeStamp;

    @Id
    @Column(name = "comment_id")
    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
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
    @Column(name = "author_nick")
    public String getAuthorNick() {
        return authorNick;
    }

    public void setAuthorNick(String authorNick) {
        this.authorNick = authorNick;
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
    @Column(name = "post_id")
    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    @Basic
    @Column(name = "floor_num")
    public Integer getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(Integer floorNum) {
        this.floorNum = floorNum;
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
    @Column(name = "quote_comment_id")
    public String getQuoteCommentId() {
        return quoteCommentId;
    }

    public void setQuoteCommentId(String quoteCommentId) {
        this.quoteCommentId = quoteCommentId;
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

        KdnetCommentEntity that = (KdnetCommentEntity) o;

        if (commentId != null ? !commentId.equals(that.commentId) : that.commentId != null) return false;
        if (authorHref != null ? !authorHref.equals(that.authorHref) : that.authorHref != null) return false;
        if (authorNick != null ? !authorNick.equals(that.authorNick) : that.authorNick != null) return false;
        if (authorId != null ? !authorId.equals(that.authorId) : that.authorId != null) return false;
        if (postId != null ? !postId.equals(that.postId) : that.postId != null) return false;
        if (floorNum != null ? !floorNum.equals(that.floorNum) : that.floorNum != null) return false;
        if (dateTime != null ? !dateTime.equals(that.dateTime) : that.dateTime != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (atUser != null ? !atUser.equals(that.atUser) : that.atUser != null) return false;
        if (atHref != null ? !atHref.equals(that.atHref) : that.atHref != null) return false;
        if (pictureHrefsNum != null ? !pictureHrefsNum.equals(that.pictureHrefsNum) : that.pictureHrefsNum != null)
            return false;
        if (quoteCommentId != null ? !quoteCommentId.equals(that.quoteCommentId) : that.quoteCommentId != null)
            return false;
        if (parseTime != null ? !parseTime.equals(that.parseTime) : that.parseTime != null) return false;
        if (timeStamp != null ? !timeStamp.equals(that.timeStamp) : that.timeStamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commentId != null ? commentId.hashCode() : 0;
        result = 31 * result + (authorHref != null ? authorHref.hashCode() : 0);
        result = 31 * result + (authorNick != null ? authorNick.hashCode() : 0);
        result = 31 * result + (authorId != null ? authorId.hashCode() : 0);
        result = 31 * result + (postId != null ? postId.hashCode() : 0);
        result = 31 * result + (floorNum != null ? floorNum.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (atUser != null ? atUser.hashCode() : 0);
        result = 31 * result + (atHref != null ? atHref.hashCode() : 0);
        result = 31 * result + (pictureHrefsNum != null ? pictureHrefsNum.hashCode() : 0);
        result = 31 * result + (quoteCommentId != null ? quoteCommentId.hashCode() : 0);
        result = 31 * result + (parseTime != null ? parseTime.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        return result;
    }
}
