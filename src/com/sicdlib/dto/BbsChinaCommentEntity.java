package com.sicdlib.dto;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by init on 2017/5/24.
 */
@Entity
@Table(name = "bbs_china_comment", schema = "socialmind", catalog = "")
public class BbsChinaCommentEntity {
    private String commentId;
    private String postId;
    private String authorId;
    private String authorName;
    private Integer priseNum;
    private String dateTime;
    private String floor;
    private String content;
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
    @Column(name = "prise_num")
    public Integer getPriseNum() {
        return priseNum;
    }

    public void setPriseNum(Integer priseNum) {
        this.priseNum = priseNum;
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
    @Column(name = "floor")
    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
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

        BbsChinaCommentEntity that = (BbsChinaCommentEntity) o;

        if (commentId != null ? !commentId.equals(that.commentId) : that.commentId != null) return false;
        if (postId != null ? !postId.equals(that.postId) : that.postId != null) return false;
        if (authorId != null ? !authorId.equals(that.authorId) : that.authorId != null) return false;
        if (authorName != null ? !authorName.equals(that.authorName) : that.authorName != null) return false;
        if (priseNum != null ? !priseNum.equals(that.priseNum) : that.priseNum != null) return false;
        if (dateTime != null ? !dateTime.equals(that.dateTime) : that.dateTime != null) return false;
        if (floor != null ? !floor.equals(that.floor) : that.floor != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (timeStamp != null ? !timeStamp.equals(that.timeStamp) : that.timeStamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commentId != null ? commentId.hashCode() : 0;
        result = 31 * result + (postId != null ? postId.hashCode() : 0);
        result = 31 * result + (authorId != null ? authorId.hashCode() : 0);
        result = 31 * result + (authorName != null ? authorName.hashCode() : 0);
        result = 31 * result + (priseNum != null ? priseNum.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        result = 31 * result + (floor != null ? floor.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        return result;
    }
}
