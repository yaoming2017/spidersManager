package com.sicdlib.dto.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by init on 2017/5/24.
 */
@Entity
@Table(name = "moe_conference", schema = "socialmind", catalog = "")
public class MoeConferenceEntity {
    private String id;
    private String url;
    private String spiderPath;
    private String position;
    private String title;
    private String date;
    private String author;
    private String source;
    private String time;
    private String site;
    private String compere;
    private String member;
    private String content;
    private Integer pictureHrefsNum;
    private String agendaUrl;
    private String materialUrls;
    private String pictureNewsUrl;
    private String filesUrl;
    private String newsUrls;
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
    @Column(name = "spider_path")
    public String getSpiderPath() {
        return spiderPath;
    }

    public void setSpiderPath(String spiderPath) {
        this.spiderPath = spiderPath;
    }

    @Basic
    @Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "source")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Basic
    @Column(name = "time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "site")
    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @Basic
    @Column(name = "compere")
    public String getCompere() {
        return compere;
    }

    public void setCompere(String compere) {
        this.compere = compere;
    }

    @Basic
    @Column(name = "member")
    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
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
    @Column(name = "picture_hrefs_num")
    public Integer getPictureHrefsNum() {
        return pictureHrefsNum;
    }

    public void setPictureHrefsNum(Integer pictureHrefsNum) {
        this.pictureHrefsNum = pictureHrefsNum;
    }

    @Basic
    @Column(name = " agenda_url")
    public String getAgendaUrl() {
        return agendaUrl;
    }

    public void setAgendaUrl(String agendaUrl) {
        this.agendaUrl = agendaUrl;
    }

    @Basic
    @Column(name = "material_urls")
    public String getMaterialUrls() {
        return materialUrls;
    }

    public void setMaterialUrls(String materialUrls) {
        this.materialUrls = materialUrls;
    }

    @Basic
    @Column(name = "picture_news_url")
    public String getPictureNewsUrl() {
        return pictureNewsUrl;
    }

    public void setPictureNewsUrl(String pictureNewsUrl) {
        this.pictureNewsUrl = pictureNewsUrl;
    }

    @Basic
    @Column(name = "files_url")
    public String getFilesUrl() {
        return filesUrl;
    }

    public void setFilesUrl(String filesUrl) {
        this.filesUrl = filesUrl;
    }

    @Basic
    @Column(name = "news_urls")
    public String getNewsUrls() {
        return newsUrls;
    }

    public void setNewsUrls(String newsUrls) {
        this.newsUrls = newsUrls;
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

        MoeConferenceEntity that = (MoeConferenceEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (spiderPath != null ? !spiderPath.equals(that.spiderPath) : that.spiderPath != null) return false;
        if (position != null ? !position.equals(that.position) : that.position != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (source != null ? !source.equals(that.source) : that.source != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (site != null ? !site.equals(that.site) : that.site != null) return false;
        if (compere != null ? !compere.equals(that.compere) : that.compere != null) return false;
        if (member != null ? !member.equals(that.member) : that.member != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (pictureHrefsNum != null ? !pictureHrefsNum.equals(that.pictureHrefsNum) : that.pictureHrefsNum != null)
            return false;
        if (agendaUrl != null ? !agendaUrl.equals(that.agendaUrl) : that.agendaUrl != null) return false;
        if (materialUrls != null ? !materialUrls.equals(that.materialUrls) : that.materialUrls != null) return false;
        if (pictureNewsUrl != null ? !pictureNewsUrl.equals(that.pictureNewsUrl) : that.pictureNewsUrl != null)
            return false;
        if (filesUrl != null ? !filesUrl.equals(that.filesUrl) : that.filesUrl != null) return false;
        if (newsUrls != null ? !newsUrls.equals(that.newsUrls) : that.newsUrls != null) return false;
        if (timeStamp != null ? !timeStamp.equals(that.timeStamp) : that.timeStamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (spiderPath != null ? spiderPath.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (site != null ? site.hashCode() : 0);
        result = 31 * result + (compere != null ? compere.hashCode() : 0);
        result = 31 * result + (member != null ? member.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (pictureHrefsNum != null ? pictureHrefsNum.hashCode() : 0);
        result = 31 * result + (agendaUrl != null ? agendaUrl.hashCode() : 0);
        result = 31 * result + (materialUrls != null ? materialUrls.hashCode() : 0);
        result = 31 * result + (pictureNewsUrl != null ? pictureNewsUrl.hashCode() : 0);
        result = 31 * result + (filesUrl != null ? filesUrl.hashCode() : 0);
        result = 31 * result + (newsUrls != null ? newsUrls.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        return result;
    }
}
