package com.sicdlib.dto;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by init on 2017/6/5.
 */
@Entity
@Table(name = "weibo_author", schema = "socialmind", catalog = "")
public class WeiboAuthorEntity {
    private String id;
    private String url;
    private Timestamp parseTime;
    private String userId;
    private String pageId;
    private String headImgUrl;
    private String nickName;
    private String realName;
    private String location;
    private String sex;
    private String sexualOrientation;
    private String relationshipStatus;
    private String birthday;
    private String blogAddress;
    private String personalUrl;
    private String description;
    private String registerDate;
    private String mail;
    private String qq;
    private String bloodType;
    private String company;
    private String education;
    private String tag;
    private Integer friendsNum;
    private Integer fansNum;
    private Integer blogNum;
    private String rank;
    private String isV;
    private String bHeadImgUrl;
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
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "page_id")
    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    @Basic
    @Column(name = " head_img_url")
    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    @Basic
    @Column(name = "nick_name")
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Basic
    @Column(name = " real_name")
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Basic
    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
    @Column(name = " sexual_orientation")
    public String getSexualOrientation() {
        return sexualOrientation;
    }

    public void setSexualOrientation(String sexualOrientation) {
        this.sexualOrientation = sexualOrientation;
    }

    @Basic
    @Column(name = "relationship_status")
    public String getRelationshipStatus() {
        return relationshipStatus;
    }

    public void setRelationshipStatus(String relationshipStatus) {
        this.relationshipStatus = relationshipStatus;
    }

    @Basic
    @Column(name = " birthday")
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "blog_address")
    public String getBlogAddress() {
        return blogAddress;
    }

    public void setBlogAddress(String blogAddress) {
        this.blogAddress = blogAddress;
    }

    @Basic
    @Column(name = "personal_url")
    public String getPersonalUrl() {
        return personalUrl;
    }

    public void setPersonalUrl(String personalUrl) {
        this.personalUrl = personalUrl;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "  register_date")
    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    @Basic
    @Column(name = "mail")
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "qq")
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Basic
    @Column(name = "blood_type")
    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    @Basic
    @Column(name = "company")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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
    @Column(name = "tag")
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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
    @Column(name = "blog_num")
    public Integer getBlogNum() {
        return blogNum;
    }

    public void setBlogNum(Integer blogNum) {
        this.blogNum = blogNum;
    }

    @Basic
    @Column(name = "rank")
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Basic
    @Column(name = "is_v")
    public String getIsV() {
        return isV;
    }

    public void setIsV(String isV) {
        this.isV = isV;
    }

    @Basic
    @Column(name = "b_head_img_url")
    public String getbHeadImgUrl() {
        return bHeadImgUrl;
    }

    public void setbHeadImgUrl(String bHeadImgUrl) {
        this.bHeadImgUrl = bHeadImgUrl;
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

        WeiboAuthorEntity that = (WeiboAuthorEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (parseTime != null ? !parseTime.equals(that.parseTime) : that.parseTime != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (pageId != null ? !pageId.equals(that.pageId) : that.pageId != null) return false;
        if (headImgUrl != null ? !headImgUrl.equals(that.headImgUrl) : that.headImgUrl != null) return false;
        if (nickName != null ? !nickName.equals(that.nickName) : that.nickName != null) return false;
        if (realName != null ? !realName.equals(that.realName) : that.realName != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (sexualOrientation != null ? !sexualOrientation.equals(that.sexualOrientation) : that.sexualOrientation != null)
            return false;
        if (relationshipStatus != null ? !relationshipStatus.equals(that.relationshipStatus) : that.relationshipStatus != null)
            return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (blogAddress != null ? !blogAddress.equals(that.blogAddress) : that.blogAddress != null) return false;
        if (personalUrl != null ? !personalUrl.equals(that.personalUrl) : that.personalUrl != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (registerDate != null ? !registerDate.equals(that.registerDate) : that.registerDate != null) return false;
        if (mail != null ? !mail.equals(that.mail) : that.mail != null) return false;
        if (qq != null ? !qq.equals(that.qq) : that.qq != null) return false;
        if (bloodType != null ? !bloodType.equals(that.bloodType) : that.bloodType != null) return false;
        if (company != null ? !company.equals(that.company) : that.company != null) return false;
        if (education != null ? !education.equals(that.education) : that.education != null) return false;
        if (tag != null ? !tag.equals(that.tag) : that.tag != null) return false;
        if (friendsNum != null ? !friendsNum.equals(that.friendsNum) : that.friendsNum != null) return false;
        if (fansNum != null ? !fansNum.equals(that.fansNum) : that.fansNum != null) return false;
        if (blogNum != null ? !blogNum.equals(that.blogNum) : that.blogNum != null) return false;
        if (rank != null ? !rank.equals(that.rank) : that.rank != null) return false;
        if (isV != null ? !isV.equals(that.isV) : that.isV != null) return false;
        if (bHeadImgUrl != null ? !bHeadImgUrl.equals(that.bHeadImgUrl) : that.bHeadImgUrl != null) return false;
        if (timeStamp != null ? !timeStamp.equals(that.timeStamp) : that.timeStamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (parseTime != null ? parseTime.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (pageId != null ? pageId.hashCode() : 0);
        result = 31 * result + (headImgUrl != null ? headImgUrl.hashCode() : 0);
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        result = 31 * result + (realName != null ? realName.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (sexualOrientation != null ? sexualOrientation.hashCode() : 0);
        result = 31 * result + (relationshipStatus != null ? relationshipStatus.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (blogAddress != null ? blogAddress.hashCode() : 0);
        result = 31 * result + (personalUrl != null ? personalUrl.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (registerDate != null ? registerDate.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (qq != null ? qq.hashCode() : 0);
        result = 31 * result + (bloodType != null ? bloodType.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (education != null ? education.hashCode() : 0);
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        result = 31 * result + (friendsNum != null ? friendsNum.hashCode() : 0);
        result = 31 * result + (fansNum != null ? fansNum.hashCode() : 0);
        result = 31 * result + (blogNum != null ? blogNum.hashCode() : 0);
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        result = 31 * result + (isV != null ? isV.hashCode() : 0);
        result = 31 * result + (bHeadImgUrl != null ? bHeadImgUrl.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        return result;
    }
}
