package com.sicdlib.dto;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by init on 2017/5/24.
 */
@Entity
@Table(name = "kdnet_author", schema = "socialmind", catalog = "")
public class KdnetAuthorEntity {
    private String authorId;
    private String url;
    private String nick;
    private String level;
    private Double influence;
    private Integer hits;
    private Integer postNum;
    private Integer fansNum;
    private Integer friendsNum;
    private String registerTime;
    private Integer loginNum;
    private Timestamp parseTime;
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
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "nick")
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
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
    @Column(name = "influence")
    public Double getInfluence() {
        return influence;
    }

    public void setInfluence(Double influence) {
        this.influence = influence;
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
    @Column(name = "post_num")
    public Integer getPostNum() {
        return postNum;
    }

    public void setPostNum(Integer postNum) {
        this.postNum = postNum;
    }

    @Basic
    @Column(name = "fans_num")
    public Integer getFansNum() {
        return fansNum;
    }

    public void setFansNum(Integer fansNum) {
        this.fansNum = fansNum;
    }

    @Basic
    @Column(name = "friends_num")
    public Integer getFriendsNum() {
        return friendsNum;
    }

    public void setFriendsNum(Integer friendsNum) {
        this.friendsNum = friendsNum;
    }

    @Basic
    @Column(name = "register_time")
    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    @Basic
    @Column(name = "login_num")
    public Integer getLoginNum() {
        return loginNum;
    }

    public void setLoginNum(Integer loginNum) {
        this.loginNum = loginNum;
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

        KdnetAuthorEntity that = (KdnetAuthorEntity) o;

        if (authorId != null ? !authorId.equals(that.authorId) : that.authorId != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (nick != null ? !nick.equals(that.nick) : that.nick != null) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;
        if (influence != null ? !influence.equals(that.influence) : that.influence != null) return false;
        if (hits != null ? !hits.equals(that.hits) : that.hits != null) return false;
        if (postNum != null ? !postNum.equals(that.postNum) : that.postNum != null) return false;
        if (fansNum != null ? !fansNum.equals(that.fansNum) : that.fansNum != null) return false;
        if (friendsNum != null ? !friendsNum.equals(that.friendsNum) : that.friendsNum != null) return false;
        if (registerTime != null ? !registerTime.equals(that.registerTime) : that.registerTime != null) return false;
        if (loginNum != null ? !loginNum.equals(that.loginNum) : that.loginNum != null) return false;
        if (parseTime != null ? !parseTime.equals(that.parseTime) : that.parseTime != null) return false;
        if (timeStamp != null ? !timeStamp.equals(that.timeStamp) : that.timeStamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = authorId != null ? authorId.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (nick != null ? nick.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (influence != null ? influence.hashCode() : 0);
        result = 31 * result + (hits != null ? hits.hashCode() : 0);
        result = 31 * result + (postNum != null ? postNum.hashCode() : 0);
        result = 31 * result + (fansNum != null ? fansNum.hashCode() : 0);
        result = 31 * result + (friendsNum != null ? friendsNum.hashCode() : 0);
        result = 31 * result + (registerTime != null ? registerTime.hashCode() : 0);
        result = 31 * result + (loginNum != null ? loginNum.hashCode() : 0);
        result = 31 * result + (parseTime != null ? parseTime.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        return result;
    }
}
