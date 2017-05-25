package com.sicdlib.dto;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by init on 2017/5/24.
 */
@Entity
@Table(name = "weibo_content", schema = "socialmind", catalog = "")
public class WeiboContentEntity {
    private String mid;
    private Timestamp praiseTime;
    private String userId;
    private String isForward;
    private String oMid;
    private String oUserId;
    private String blogInfo;
    private String dateTime;
    private String exactTime;
    private String dataFrom;
    private String atList;
    private String atUrlList;
    private String topicList;
    private String topicUrlList;
    private Integer pictureHrefsNum;
    private Timestamp timeStamp;

    @Id
    @Column(name = "mid")
    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    @Basic
    @Column(name = "praise_time")
    public Timestamp getPraiseTime() {
        return praiseTime;
    }

    public void setPraiseTime(Timestamp praiseTime) {
        this.praiseTime = praiseTime;
    }

    @Basic
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "is_forward")
    public String getIsForward() {
        return isForward;
    }

    public void setIsForward(String isForward) {
        this.isForward = isForward;
    }

    @Basic
    @Column(name = "o_mid")
    public String getoMid() {
        return oMid;
    }

    public void setoMid(String oMid) {
        this.oMid = oMid;
    }

    @Basic
    @Column(name = " o_user_id")
    public String getoUserId() {
        return oUserId;
    }

    public void setoUserId(String oUserId) {
        this.oUserId = oUserId;
    }

    @Basic
    @Column(name = " blog_info")
    public String getBlogInfo() {
        return blogInfo;
    }

    public void setBlogInfo(String blogInfo) {
        this.blogInfo = blogInfo;
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
    @Column(name = "exact_time")
    public String getExactTime() {
        return exactTime;
    }

    public void setExactTime(String exactTime) {
        this.exactTime = exactTime;
    }

    @Basic
    @Column(name = "data_from")
    public String getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(String dataFrom) {
        this.dataFrom = dataFrom;
    }

    @Basic
    @Column(name = "at_list")
    public String getAtList() {
        return atList;
    }

    public void setAtList(String atList) {
        this.atList = atList;
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
    @Column(name = "topic_list")
    public String getTopicList() {
        return topicList;
    }

    public void setTopicList(String topicList) {
        this.topicList = topicList;
    }

    @Basic
    @Column(name = "topic_url_list")
    public String getTopicUrlList() {
        return topicUrlList;
    }

    public void setTopicUrlList(String topicUrlList) {
        this.topicUrlList = topicUrlList;
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

        WeiboContentEntity that = (WeiboContentEntity) o;

        if (mid != null ? !mid.equals(that.mid) : that.mid != null) return false;
        if (praiseTime != null ? !praiseTime.equals(that.praiseTime) : that.praiseTime != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (isForward != null ? !isForward.equals(that.isForward) : that.isForward != null) return false;
        if (oMid != null ? !oMid.equals(that.oMid) : that.oMid != null) return false;
        if (oUserId != null ? !oUserId.equals(that.oUserId) : that.oUserId != null) return false;
        if (blogInfo != null ? !blogInfo.equals(that.blogInfo) : that.blogInfo != null) return false;
        if (dateTime != null ? !dateTime.equals(that.dateTime) : that.dateTime != null) return false;
        if (exactTime != null ? !exactTime.equals(that.exactTime) : that.exactTime != null) return false;
        if (dataFrom != null ? !dataFrom.equals(that.dataFrom) : that.dataFrom != null) return false;
        if (atList != null ? !atList.equals(that.atList) : that.atList != null) return false;
        if (atUrlList != null ? !atUrlList.equals(that.atUrlList) : that.atUrlList != null) return false;
        if (topicList != null ? !topicList.equals(that.topicList) : that.topicList != null) return false;
        if (topicUrlList != null ? !topicUrlList.equals(that.topicUrlList) : that.topicUrlList != null) return false;
        if (pictureHrefsNum != null ? !pictureHrefsNum.equals(that.pictureHrefsNum) : that.pictureHrefsNum != null)
            return false;
        if (timeStamp != null ? !timeStamp.equals(that.timeStamp) : that.timeStamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mid != null ? mid.hashCode() : 0;
        result = 31 * result + (praiseTime != null ? praiseTime.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (isForward != null ? isForward.hashCode() : 0);
        result = 31 * result + (oMid != null ? oMid.hashCode() : 0);
        result = 31 * result + (oUserId != null ? oUserId.hashCode() : 0);
        result = 31 * result + (blogInfo != null ? blogInfo.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        result = 31 * result + (exactTime != null ? exactTime.hashCode() : 0);
        result = 31 * result + (dataFrom != null ? dataFrom.hashCode() : 0);
        result = 31 * result + (atList != null ? atList.hashCode() : 0);
        result = 31 * result + (atUrlList != null ? atUrlList.hashCode() : 0);
        result = 31 * result + (topicList != null ? topicList.hashCode() : 0);
        result = 31 * result + (topicUrlList != null ? topicUrlList.hashCode() : 0);
        result = 31 * result + (pictureHrefsNum != null ? pictureHrefsNum.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        return result;
    }
}
