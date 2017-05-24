package com.sicdlib.dto;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by init on 2017/5/24.
 */
@Entity
@Table(name = "blogchina_comment", schema = "socialmind", catalog = "")
public class BlogchinaCommentEntity {
    private String commentId;
    private String commentUserId;
    private String commentBlogId;
    private String commentTime;
    private String commentContent;
    private Integer praiseNum;
    private String praiseIds;
    private String replayId;
    private String ip;
    private String lastIp;
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
    @Column(name = "comment_user_id")
    public String getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(String commentUserId) {
        this.commentUserId = commentUserId;
    }

    @Basic
    @Column(name = "comment_blog_id")
    public String getCommentBlogId() {
        return commentBlogId;
    }

    public void setCommentBlogId(String commentBlogId) {
        this.commentBlogId = commentBlogId;
    }

    @Basic
    @Column(name = "comment_time")
    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    @Basic
    @Column(name = "comment_content")
    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    @Basic
    @Column(name = "praise_num")
    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    @Basic
    @Column(name = "praise_ids")
    public String getPraiseIds() {
        return praiseIds;
    }

    public void setPraiseIds(String praiseIds) {
        this.praiseIds = praiseIds;
    }

    @Basic
    @Column(name = "replay_id")
    public String getReplayId() {
        return replayId;
    }

    public void setReplayId(String replayId) {
        this.replayId = replayId;
    }

    @Basic
    @Column(name = "ip")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Basic
    @Column(name = "last_ip")
    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
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

        BlogchinaCommentEntity that = (BlogchinaCommentEntity) o;

        if (commentId != null ? !commentId.equals(that.commentId) : that.commentId != null) return false;
        if (commentUserId != null ? !commentUserId.equals(that.commentUserId) : that.commentUserId != null)
            return false;
        if (commentBlogId != null ? !commentBlogId.equals(that.commentBlogId) : that.commentBlogId != null)
            return false;
        if (commentTime != null ? !commentTime.equals(that.commentTime) : that.commentTime != null) return false;
        if (commentContent != null ? !commentContent.equals(that.commentContent) : that.commentContent != null)
            return false;
        if (praiseNum != null ? !praiseNum.equals(that.praiseNum) : that.praiseNum != null) return false;
        if (praiseIds != null ? !praiseIds.equals(that.praiseIds) : that.praiseIds != null) return false;
        if (replayId != null ? !replayId.equals(that.replayId) : that.replayId != null) return false;
        if (ip != null ? !ip.equals(that.ip) : that.ip != null) return false;
        if (lastIp != null ? !lastIp.equals(that.lastIp) : that.lastIp != null) return false;
        if (timeStamp != null ? !timeStamp.equals(that.timeStamp) : that.timeStamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commentId != null ? commentId.hashCode() : 0;
        result = 31 * result + (commentUserId != null ? commentUserId.hashCode() : 0);
        result = 31 * result + (commentBlogId != null ? commentBlogId.hashCode() : 0);
        result = 31 * result + (commentTime != null ? commentTime.hashCode() : 0);
        result = 31 * result + (commentContent != null ? commentContent.hashCode() : 0);
        result = 31 * result + (praiseNum != null ? praiseNum.hashCode() : 0);
        result = 31 * result + (praiseIds != null ? praiseIds.hashCode() : 0);
        result = 31 * result + (replayId != null ? replayId.hashCode() : 0);
        result = 31 * result + (ip != null ? ip.hashCode() : 0);
        result = 31 * result + (lastIp != null ? lastIp.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        return result;
    }
}
