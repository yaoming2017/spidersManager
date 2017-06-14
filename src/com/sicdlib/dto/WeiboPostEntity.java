package com.sicdlib.dto;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by init on 2017/5/24.
 */
@Entity
@Table(name = "weibo_post", schema = "socialmind", catalog = "")
public class WeiboPostEntity {
    private String id;
    private String articleUrl;
    private String articleDateTime;
    private String articleTitle;
    private String articlePreface;
    private String articleContent;
    private String articlePicUrlDesc;
    private String articleMediaUrl;
    private Integer articleReadNum;
    private Integer priseNum;
    private Integer commentNum;
    private Integer forwardNum;
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
    @Column(name = "article_url")
    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    @Basic
    @Column(name = "article_date_time")
    public String getArticleDateTime() {
        return articleDateTime;
    }

    public void setArticleDateTime(String articleDateTime) {
        this.articleDateTime = articleDateTime;
    }

    @Basic
    @Column(name = "article_title")
    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    @Basic
    @Column(name = "article_preface")
    public String getArticlePreface() {
        return articlePreface;
    }

    public void setArticlePreface(String articlePreface) {
        this.articlePreface = articlePreface;
    }

    @Basic
    @Column(name = "article_content")
    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    @Basic
    @Column(name = "article_pic_url_desc")
    public String getArticlePicUrlDesc() {
        return articlePicUrlDesc;
    }

    public void setArticlePicUrlDesc(String articlePicUrlDesc) {
        this.articlePicUrlDesc = articlePicUrlDesc;
    }

    @Basic
    @Column(name = "article_media_url")
    public String getArticleMediaUrl() {
        return articleMediaUrl;
    }

    public void setArticleMediaUrl(String articleMediaUrl) {
        this.articleMediaUrl = articleMediaUrl;
    }

    @Basic
    @Column(name = " article_read_num")
    public Integer getArticleReadNum() {
        return articleReadNum;
    }

    public void setArticleReadNum(Integer articleReadNum) {
        this.articleReadNum = articleReadNum;
    }

    @Basic
    @Column(name = "  prise_num")
    public Integer getPriseNum() {
        return priseNum;
    }

    public void setPriseNum(Integer priseNum) {
        this.priseNum = priseNum;
    }

    @Basic
    @Column(name = "comment_num")
    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    @Basic
    @Column(name = "forward_num")
    public Integer getForwardNum() {
        return forwardNum;
    }

    public void setForwardNum(Integer forwardNum) {
        this.forwardNum = forwardNum;
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

        WeiboPostEntity that = (WeiboPostEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (articleUrl != null ? !articleUrl.equals(that.articleUrl) : that.articleUrl != null) return false;
        if (articleDateTime != null ? !articleDateTime.equals(that.articleDateTime) : that.articleDateTime != null)
            return false;
        if (articleTitle != null ? !articleTitle.equals(that.articleTitle) : that.articleTitle != null) return false;
        if (articlePreface != null ? !articlePreface.equals(that.articlePreface) : that.articlePreface != null)
            return false;
        if (articleContent != null ? !articleContent.equals(that.articleContent) : that.articleContent != null)
            return false;
        if (articlePicUrlDesc != null ? !articlePicUrlDesc.equals(that.articlePicUrlDesc) : that.articlePicUrlDesc != null)
            return false;
        if (articleMediaUrl != null ? !articleMediaUrl.equals(that.articleMediaUrl) : that.articleMediaUrl != null)
            return false;
        if (articleReadNum != null ? !articleReadNum.equals(that.articleReadNum) : that.articleReadNum != null)
            return false;
        if (priseNum != null ? !priseNum.equals(that.priseNum) : that.priseNum != null) return false;
        if (commentNum != null ? !commentNum.equals(that.commentNum) : that.commentNum != null) return false;
        if (forwardNum != null ? !forwardNum.equals(that.forwardNum) : that.forwardNum != null) return false;
        if (timeStamp != null ? !timeStamp.equals(that.timeStamp) : that.timeStamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (articleUrl != null ? articleUrl.hashCode() : 0);
        result = 31 * result + (articleDateTime != null ? articleDateTime.hashCode() : 0);
        result = 31 * result + (articleTitle != null ? articleTitle.hashCode() : 0);
        result = 31 * result + (articlePreface != null ? articlePreface.hashCode() : 0);
        result = 31 * result + (articleContent != null ? articleContent.hashCode() : 0);
        result = 31 * result + (articlePicUrlDesc != null ? articlePicUrlDesc.hashCode() : 0);
        result = 31 * result + (articleMediaUrl != null ? articleMediaUrl.hashCode() : 0);
        result = 31 * result + (articleReadNum != null ? articleReadNum.hashCode() : 0);
        result = 31 * result + (priseNum != null ? priseNum.hashCode() : 0);
        result = 31 * result + (commentNum != null ? commentNum.hashCode() : 0);
        result = 31 * result + (forwardNum != null ? forwardNum.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        return result;
    }
}
