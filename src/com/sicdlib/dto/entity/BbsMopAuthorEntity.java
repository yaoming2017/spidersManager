package com.sicdlib.dto.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by YH on 2017/6/22.
 */
@Entity
@Table(name = "bbs_mop_author", schema = "socialmind")
public class BbsMopAuthorEntity {
    private String id;
    private String authorId;
    private String authorName;
    private String sex;
    private String age;
    private String level;
    private String levelNick;
    private Integer friendsNum;
    private Integer fansNum;
    private Integer postNum;
    private Integer replyNum;
    private Integer hits;
    private String birthday;
    private Integer loginNum;
    private String url;
    private String introduce;
    private String registerDate;
    private String league;
    private String contactWay;
    private String education;
    private String career;
    private Timestamp timeStamp;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "age")
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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
    @Column(name = "level_nick")
    public String getLevelNick() {
        return levelNick;
    }

    public void setLevelNick(String levelNick) {
        this.levelNick = levelNick;
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
    @Column(name = "fans_num")
    public Integer getFansNum() {
        return fansNum;
    }

    public void setFansNum(Integer fansNum) {
        this.fansNum = fansNum;
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
    @Column(name = "hits")
    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    @Basic
    @Column(name = "birthday")
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "introduce")
    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Basic
    @Column(name = "register_date")
    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    @Basic
    @Column(name = "league")
    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    @Basic
    @Column(name = "contact_way")
    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    @Basic
    @Column(name = "education")
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Basic
    @Column(name = "career")
    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
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

        BbsMopAuthorEntity that = (BbsMopAuthorEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (authorId != null ? !authorId.equals(that.authorId) : that.authorId != null) return false;
        if (authorName != null ? !authorName.equals(that.authorName) : that.authorName != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;
        if (levelNick != null ? !levelNick.equals(that.levelNick) : that.levelNick != null) return false;
        if (friendsNum != null ? !friendsNum.equals(that.friendsNum) : that.friendsNum != null) return false;
        if (fansNum != null ? !fansNum.equals(that.fansNum) : that.fansNum != null) return false;
        if (postNum != null ? !postNum.equals(that.postNum) : that.postNum != null) return false;
        if (replyNum != null ? !replyNum.equals(that.replyNum) : that.replyNum != null) return false;
        if (hits != null ? !hits.equals(that.hits) : that.hits != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (loginNum != null ? !loginNum.equals(that.loginNum) : that.loginNum != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (introduce != null ? !introduce.equals(that.introduce) : that.introduce != null) return false;
        if (registerDate != null ? !registerDate.equals(that.registerDate) : that.registerDate != null) return false;
        if (league != null ? !league.equals(that.league) : that.league != null) return false;
        if (contactWay != null ? !contactWay.equals(that.contactWay) : that.contactWay != null) return false;
        if (education != null ? !education.equals(that.education) : that.education != null) return false;
        if (career != null ? !career.equals(that.career) : that.career != null) return false;
        if (timeStamp != null ? !timeStamp.equals(that.timeStamp) : that.timeStamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (authorId != null ? authorId.hashCode() : 0);
        result = 31 * result + (authorName != null ? authorName.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (levelNick != null ? levelNick.hashCode() : 0);
        result = 31 * result + (friendsNum != null ? friendsNum.hashCode() : 0);
        result = 31 * result + (fansNum != null ? fansNum.hashCode() : 0);
        result = 31 * result + (postNum != null ? postNum.hashCode() : 0);
        result = 31 * result + (replyNum != null ? replyNum.hashCode() : 0);
        result = 31 * result + (hits != null ? hits.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (loginNum != null ? loginNum.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (introduce != null ? introduce.hashCode() : 0);
        result = 31 * result + (registerDate != null ? registerDate.hashCode() : 0);
        result = 31 * result + (league != null ? league.hashCode() : 0);
        result = 31 * result + (contactWay != null ? contactWay.hashCode() : 0);
        result = 31 * result + (education != null ? education.hashCode() : 0);
        result = 31 * result + (career != null ? career.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        return result;
    }
}
