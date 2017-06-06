package com.sicdlib.dto.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by init on 2017/6/2.
 */
@Entity
@Table(name = "bbs_sohu_author", schema = "socialmind", catalog = "")
public class BbsSohuAuthorEntity {
    private String authorId;
    private String nickName;
    private String sex;
    private String level;
    private String title;
    private String duty;
    private Integer postNum;
    private Integer eliteNum;
    private String point;
    private String birthday;
    private String onlineTime;
    private String reputation;
    private String lastLogin;
    private Integer loginNum;
    private String sport;
    private String movie;
    private String music;
    private String food;
    private String book;
    private String person;
    private String education;
    private String profession;
    private Integer friendsNum;
    private Integer fansNum;
    private Timestamp parseTime;
    private Timestamp timeStamp;
    private String id;
    private String introduction;

    @Basic
    @Column(name = "author_id")
    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
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
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "duty")
    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
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
    @Column(name = "elite_num")
    public Integer getEliteNum() {
        return eliteNum;
    }

    public void setEliteNum(Integer eliteNum) {
        this.eliteNum = eliteNum;
    }

    @Basic
    @Column(name = "point")
    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
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
    @Column(name = "online_time")
    public String getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(String onlineTime) {
        this.onlineTime = onlineTime;
    }

    @Basic
    @Column(name = "reputation")
    public String getReputation() {
        return reputation;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }

    @Basic
    @Column(name = "last_login")
    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
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
    @Column(name = "sport")
    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    @Basic
    @Column(name = "movie")
    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    @Basic
    @Column(name = "music")
    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    @Basic
    @Column(name = "food")
    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    @Basic
    @Column(name = "book")
    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    @Basic
    @Column(name = "person")
    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
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
    @Column(name = "profession")
    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
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

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "introduction")
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BbsSohuAuthorEntity that = (BbsSohuAuthorEntity) o;

        if (authorId != null ? !authorId.equals(that.authorId) : that.authorId != null) return false;
        if (nickName != null ? !nickName.equals(that.nickName) : that.nickName != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (duty != null ? !duty.equals(that.duty) : that.duty != null) return false;
        if (postNum != null ? !postNum.equals(that.postNum) : that.postNum != null) return false;
        if (eliteNum != null ? !eliteNum.equals(that.eliteNum) : that.eliteNum != null) return false;
        if (point != null ? !point.equals(that.point) : that.point != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (onlineTime != null ? !onlineTime.equals(that.onlineTime) : that.onlineTime != null) return false;
        if (reputation != null ? !reputation.equals(that.reputation) : that.reputation != null) return false;
        if (lastLogin != null ? !lastLogin.equals(that.lastLogin) : that.lastLogin != null) return false;
        if (loginNum != null ? !loginNum.equals(that.loginNum) : that.loginNum != null) return false;
        if (sport != null ? !sport.equals(that.sport) : that.sport != null) return false;
        if (movie != null ? !movie.equals(that.movie) : that.movie != null) return false;
        if (music != null ? !music.equals(that.music) : that.music != null) return false;
        if (food != null ? !food.equals(that.food) : that.food != null) return false;
        if (book != null ? !book.equals(that.book) : that.book != null) return false;
        if (person != null ? !person.equals(that.person) : that.person != null) return false;
        if (education != null ? !education.equals(that.education) : that.education != null) return false;
        if (profession != null ? !profession.equals(that.profession) : that.profession != null) return false;
        if (friendsNum != null ? !friendsNum.equals(that.friendsNum) : that.friendsNum != null) return false;
        if (fansNum != null ? !fansNum.equals(that.fansNum) : that.fansNum != null) return false;
        if (parseTime != null ? !parseTime.equals(that.parseTime) : that.parseTime != null) return false;
        if (timeStamp != null ? !timeStamp.equals(that.timeStamp) : that.timeStamp != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (introduction != null ? !introduction.equals(that.introduction) : that.introduction != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = authorId != null ? authorId.hashCode() : 0;
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (duty != null ? duty.hashCode() : 0);
        result = 31 * result + (postNum != null ? postNum.hashCode() : 0);
        result = 31 * result + (eliteNum != null ? eliteNum.hashCode() : 0);
        result = 31 * result + (point != null ? point.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (onlineTime != null ? onlineTime.hashCode() : 0);
        result = 31 * result + (reputation != null ? reputation.hashCode() : 0);
        result = 31 * result + (lastLogin != null ? lastLogin.hashCode() : 0);
        result = 31 * result + (loginNum != null ? loginNum.hashCode() : 0);
        result = 31 * result + (sport != null ? sport.hashCode() : 0);
        result = 31 * result + (movie != null ? movie.hashCode() : 0);
        result = 31 * result + (music != null ? music.hashCode() : 0);
        result = 31 * result + (food != null ? food.hashCode() : 0);
        result = 31 * result + (book != null ? book.hashCode() : 0);
        result = 31 * result + (person != null ? person.hashCode() : 0);
        result = 31 * result + (education != null ? education.hashCode() : 0);
        result = 31 * result + (profession != null ? profession.hashCode() : 0);
        result = 31 * result + (friendsNum != null ? friendsNum.hashCode() : 0);
        result = 31 * result + (fansNum != null ? fansNum.hashCode() : 0);
        result = 31 * result + (parseTime != null ? parseTime.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (introduction != null ? introduction.hashCode() : 0);
        return result;
    }
}
