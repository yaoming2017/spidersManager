package com.sicdlib.dto.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by init on 2017/5/24.
 */
@Entity
@Table(name = "douban_group_group", schema = "socialmind", catalog = "")
public class DoubanGroupGroupEntity {
    private String groupId;
    private String groupName;
    private String groupTags;
    private String url;
    private String content;
    private String createTime;
    private String leaderName;
    private String leaderHref;
    private Timestamp timeStamp;

    @Id
    @Column(name = "group_id")
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "group_name")
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Basic
    @Column(name = "group_tags")
    public String getGroupTags() {
        return groupTags;
    }

    public void setGroupTags(String groupTags) {
        this.groupTags = groupTags;
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
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "create_time")
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "leader_name")
    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    @Basic
    @Column(name = "leader_href")
    public String getLeaderHref() {
        return leaderHref;
    }

    public void setLeaderHref(String leaderHref) {
        this.leaderHref = leaderHref;
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

        DoubanGroupGroupEntity that = (DoubanGroupGroupEntity) o;

        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null) return false;
        if (groupTags != null ? !groupTags.equals(that.groupTags) : that.groupTags != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (leaderName != null ? !leaderName.equals(that.leaderName) : that.leaderName != null) return false;
        if (leaderHref != null ? !leaderHref.equals(that.leaderHref) : that.leaderHref != null) return false;
        if (timeStamp != null ? !timeStamp.equals(that.timeStamp) : that.timeStamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = groupId != null ? groupId.hashCode() : 0;
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (groupTags != null ? groupTags.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (leaderName != null ? leaderName.hashCode() : 0);
        result = 31 * result + (leaderHref != null ? leaderHref.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        return result;
    }
}
