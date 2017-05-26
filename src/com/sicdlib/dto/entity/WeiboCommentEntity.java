package com.sicdlib.dto.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by init on 2017/5/24.
 */
@Entity
@Table(name = "weibo_comment", schema = "socialmind", catalog = "")
public class WeiboCommentEntity {
    private String commentId;
    private String blogId;
    private Timestamp parseTime;
    private String commentUserNick;
    private String commentUserId;
    private String commentUserPage;
    private String commentDateTime;
    private Integer praiseNum;
    private String atNameList;
    private String atUrlList;
    private String content;
    private String childCommentIds;
    private String parentCommentId;
    private String topicUrlList;
    private String topicTextList;
    private String imgUrlList;
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
    @Column(name = "blog_id")
    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
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
    @Column(name = " comment_user_nick")
    public String getCommentUserNick() {
        return commentUserNick;
    }

    public void setCommentUserNick(String commentUserNick) {
        this.commentUserNick = commentUserNick;
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
    @Column(name = "  comment_user_page")
    public String getCommentUserPage() {
        return commentUserPage;
    }

    public void setCommentUserPage(String commentUserPage) {
        this.commentUserPage = commentUserPage;
    }

    @Basic
    @Column(name = "comment_date_time")
    public String getCommentDateTime() {
        return commentDateTime;
    }

    public void setCommentDateTime(String commentDateTime) {
        this.commentDateTime = commentDateTime;
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
    @Column(name = "    at_name_list")
    public String getAtNameList() {
        return atNameList;
    }

    public void setAtNameList(String atNameList) {
        this.atNameList = atNameList;
    }

    @Basic
    @Column(name = "at_url_list")
    public String getAtUrlList() {
        return atUrlList;
    }

    public void setAtUrlList(String atUrlList) {
        this.atUrlList = atUrlList;
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
    @Column(name = "child_comment_ids")
    public String getChildCommentIds() {
        return childCommentIds;
    }

    public void setChildCommentIds(String childCommentIds) {
        this.childCommentIds = childCommentIds;
    }

    @Basic
    @Column(name = "parent_comment_id")
    public String getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(String parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    @Basic
    @Column(name = " topic_url_list")
    public String getTopicUrlList() {
        return topicUrlList;
    }

    public void setTopicUrlList(String topicUrlList) {
        this.topicUrlList = topicUrlList;
    }

    @Basic
    @Column(name = "topic_text_list")
    public String getTopicTextList() {
        return topicTextList;
    }

    public void setTopicTextList(String topicTextList) {
        this.topicTextList = topicTextList;
    }

    @Basic
    @Column(name = " img_url_list")
    public String getImgUrlList() {
        return imgUrlList;
    }

    public void setImgUrlList(String imgUrlList) {
        this.imgUrlList = imgUrlList;
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

        WeiboCommentEntity that = (WeiboCommentEntity) o;

        if (commentId != null ? !commentId.equals(that.commentId) : that.commentId != null) return false;
        if (blogId != null ? !blogId.equals(that.blogId) : that.blogId != null) return false;
        if (parseTime != null ? !parseTime.equals(that.parseTime) : that.parseTime != null) return false;
        if (commentUserNick != null ? !commentUserNick.equals(that.commentUserNick) : that.commentUserNick != null)
            return false;
        if (commentUserId != null ? !commentUserId.equals(that.commentUserId) : that.commentUserId != null)
            return false;
        if (commentUserPage != null ? !commentUserPage.equals(that.commentUserPage) : that.commentUserPage != null)
            return false;
        if (commentDateTime != null ? !commentDateTime.equals(that.commentDateTime) : that.commentDateTime != null)
            return false;
        if (praiseNum != null ? !praiseNum.equals(that.praiseNum) : that.praiseNum != null) return false;
        if (atNameList != null ? !atNameList.equals(that.atNameList) : that.atNameList != null) return false;
        if (atUrlList != null ? !atUrlList.equals(that.atUrlList) : that.atUrlList != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (childCommentIds != null ? !childCommentIds.equals(that.childCommentIds) : that.childCommentIds != null)
            return false;
        if (parentCommentId != null ? !parentCommentId.equals(that.parentCommentId) : that.parentCommentId != null)
            return false;
        if (topicUrlList != null ? !topicUrlList.equals(that.topicUrlList) : that.topicUrlList != null) return false;
        if (topicTextList != null ? !topicTextList.equals(that.topicTextList) : that.topicTextList != null)
            return false;
        if (imgUrlList != null ? !imgUrlList.equals(that.imgUrlList) : that.imgUrlList != null) return false;
        if (timeStamp != null ? !timeStamp.equals(that.timeStamp) : that.timeStamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commentId != null ? commentId.hashCode() : 0;
        result = 31 * result + (blogId != null ? blogId.hashCode() : 0);
        result = 31 * result + (parseTime != null ? parseTime.hashCode() : 0);
        result = 31 * result + (commentUserNick != null ? commentUserNick.hashCode() : 0);
        result = 31 * result + (commentUserId != null ? commentUserId.hashCode() : 0);
        result = 31 * result + (commentUserPage != null ? commentUserPage.hashCode() : 0);
        result = 31 * result + (commentDateTime != null ? commentDateTime.hashCode() : 0);
        result = 31 * result + (praiseNum != null ? praiseNum.hashCode() : 0);
        result = 31 * result + (atNameList != null ? atNameList.hashCode() : 0);
        result = 31 * result + (atUrlList != null ? atUrlList.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (childCommentIds != null ? childCommentIds.hashCode() : 0);
        result = 31 * result + (parentCommentId != null ? parentCommentId.hashCode() : 0);
        result = 31 * result + (topicUrlList != null ? topicUrlList.hashCode() : 0);
        result = 31 * result + (topicTextList != null ? topicTextList.hashCode() : 0);
        result = 31 * result + (imgUrlList != null ? imgUrlList.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        return result;
    }
}
