package com.sicdlib.dto.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by init on 2017/5/24.
 */
@Entity
@Table(name = "blog_sina_author", schema = "socialmind", catalog = "")
public class BlogSinaAuthorEntity {
    private String authorId;
    private String authorName;
    private String pictureHeadUrl;
    private String url;
    private String level;
    private String point;
    private Integer visitNum;
    private String popularity;
    private String getGolden;
    private String giveGolden;
    private String info;
    private String experience;
    private String introduction;
    private String certification;
    private Timestamp timeStamp;
    private String id;

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
    @Column(name = "picture_head_url")
    public String getPictureHeadUrl() {
        return pictureHeadUrl;
    }

    public void setPictureHeadUrl(String pictureHeadUrl) {
        this.pictureHeadUrl = pictureHeadUrl;
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
    @Column(name = "level")
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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
    @Column(name = "visit_num")
    public Integer getVisitNum() {
        return visitNum;
    }

    public void setVisitNum(Integer visitNum) {
        this.visitNum = visitNum;
    }

    @Basic
    @Column(name = "popularity")
    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    @Basic
    @Column(name = "get_golden")
    public String getGetGolden() {
        return getGolden;
    }

    public void setGetGolden(String getGolden) {
        this.getGolden = getGolden;
    }

    @Basic
    @Column(name = "give_golden")
    public String getGiveGolden() {
        return giveGolden;
    }

    public void setGiveGolden(String giveGolden) {
        this.giveGolden = giveGolden;
    }

    @Basic
    @Column(name = "info")
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Basic
    @Column(name = "experience")
    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    @Basic
    @Column(name = "introduction")
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Basic
    @Column(name = "certification")
    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
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

        BlogSinaAuthorEntity that = (BlogSinaAuthorEntity) o;

        if (authorId != null ? !authorId.equals(that.authorId) : that.authorId != null) return false;
        if (authorName != null ? !authorName.equals(that.authorName) : that.authorName != null) return false;
        if (pictureHeadUrl != null ? !pictureHeadUrl.equals(that.pictureHeadUrl) : that.pictureHeadUrl != null)
            return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;
        if (point != null ? !point.equals(that.point) : that.point != null) return false;
        if (visitNum != null ? !visitNum.equals(that.visitNum) : that.visitNum != null) return false;
        if (popularity != null ? !popularity.equals(that.popularity) : that.popularity != null) return false;
        if (getGolden != null ? !getGolden.equals(that.getGolden) : that.getGolden != null) return false;
        if (giveGolden != null ? !giveGolden.equals(that.giveGolden) : that.giveGolden != null) return false;
        if (info != null ? !info.equals(that.info) : that.info != null) return false;
        if (experience != null ? !experience.equals(that.experience) : that.experience != null) return false;
        if (introduction != null ? !introduction.equals(that.introduction) : that.introduction != null) return false;
        if (certification != null ? !certification.equals(that.certification) : that.certification != null)
            return false;
        if (timeStamp != null ? !timeStamp.equals(that.timeStamp) : that.timeStamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = authorId != null ? authorId.hashCode() : 0;
        result = 31 * result + (authorName != null ? authorName.hashCode() : 0);
        result = 31 * result + (pictureHeadUrl != null ? pictureHeadUrl.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (point != null ? point.hashCode() : 0);
        result = 31 * result + (visitNum != null ? visitNum.hashCode() : 0);
        result = 31 * result + (popularity != null ? popularity.hashCode() : 0);
        result = 31 * result + (getGolden != null ? getGolden.hashCode() : 0);
        result = 31 * result + (giveGolden != null ? giveGolden.hashCode() : 0);
        result = 31 * result + (info != null ? info.hashCode() : 0);
        result = 31 * result + (experience != null ? experience.hashCode() : 0);
        result = 31 * result + (introduction != null ? introduction.hashCode() : 0);
        result = 31 * result + (certification != null ? certification.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        return result;
    }

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
