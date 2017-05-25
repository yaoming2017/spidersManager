package com.sicdlib.dto;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by init on 2017/5/24.
 */
@Entity
@Table(name = "bbs_people_author", schema = "socialmind", catalog = "")
public class BbsPeopleAuthorEntity {
    private String authorId;
    private String authorName;
    private String url;
    private Integer postNum;
    private Integer replyNum;
    private Integer eliteNum;
    private String level;
    private Timestamp timeStamp;

    @Id
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
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "post_num")
    public Integer getPostNum() {
        return postNum;
    }

    public void setPostNum(Integer postNum) {
        this.postNum = postNum;
    }

    @Basic
    @Column(name = "reply_num")
    public Integer getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(Integer replyNum) {
        this.replyNum = replyNum;
    }

    @Basic
    @Column(name = "elite_num")
    public Integer getEliteNum() {
        return eliteNum;
    }

    public void setEliteNum(Integer eliteNum) {
        this.eliteNum = eliteNum;
    }

    @Basic
    @Column(name = "level")
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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

        BbsPeopleAuthorEntity that = (BbsPeopleAuthorEntity) o;

        if (authorId != null ? !authorId.equals(that.authorId) : that.authorId != null) return false;
        if (authorName != null ? !authorName.equals(that.authorName) : that.authorName != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (postNum != null ? !postNum.equals(that.postNum) : that.postNum != null) return false;
        if (replyNum != null ? !replyNum.equals(that.replyNum) : that.replyNum != null) return false;
        if (eliteNum != null ? !eliteNum.equals(that.eliteNum) : that.eliteNum != null) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;
        if (timeStamp != null ? !timeStamp.equals(that.timeStamp) : that.timeStamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = authorId != null ? authorId.hashCode() : 0;
        result = 31 * result + (authorName != null ? authorName.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (postNum != null ? postNum.hashCode() : 0);
        result = 31 * result + (replyNum != null ? replyNum.hashCode() : 0);
        result = 31 * result + (eliteNum != null ? eliteNum.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        return result;
    }
}
