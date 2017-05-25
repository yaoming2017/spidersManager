package com.sicdlib.dto;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by init on 2017/5/24.
 */
@Entity
@Table(name = "bbs_xinhua_post", schema = "socialmind", catalog = "")
public class BbsXinhuaPostEntity {
    private String postId;
    private String authorId;
    private String commentIds;
    private String authorName;
    private String authorUrl;
    private String title;
    private String pathHref;
    private String dateTime;
    private String pathText;
    private Integer readNum;
    private Integer commentNum;
    private Integer likeNum;
    private String detailHref;
    private String content;
    private Integer pictureHrefsNum;
    private Timestamp parseTime;
    private String url;
    private Timestamp timeStamp;

    @Id
    @Column(name = "post_id")
    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
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
    @Column(name = "comment_ids")
    public String getCommentIds() {
        return commentIds;
    }

    public void setCommentIds(String commentIds) {
        this.commentIds = commentIds;
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
    @Column(name = "author_url")
    public String getAuthorUrl() {
        return authorUrl;
    }

    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
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
    @Column(name = "path_href")
    public String getPathHref() {
        return pathHref;
    }

    public void setPathHref(String pathHref) {
        this.pathHref = pathHref;
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
    @Column(name = "path_text")
    public String getPathText() {
        return pathText;
    }

    public void setPathText(String pathText) {
        this.pathText = pathText;
    }

    @Basic
    @Column(name = "read_num")
    public Integer getReadNum() {
        return readNum;
    }

    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
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
    @Column(name = "like_num")
    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    @Basic
    @Column(name = "detail_href")
    public String getDetailHref() {
        return detailHref;
    }

    public void setDetailHref(String detailHref) {
        this.detailHref = detailHref;
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
    @Column(name = "parse_time")
    public Timestamp getParseTime() {
        return parseTime;
    }

    public void setParseTime(Timestamp parseTime) {
        this.parseTime = parseTime;
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

        BbsXinhuaPostEntity that = (BbsXinhuaPostEntity) o;

        if (postId != null ? !postId.equals(that.postId) : that.postId != null) return false;
        if (authorId != null ? !authorId.equals(that.authorId) : that.authorId != null) return false;
        if (commentIds != null ? !commentIds.equals(that.commentIds) : that.commentIds != null) return false;
        if (authorName != null ? !authorName.equals(that.authorName) : that.authorName != null) return false;
        if (authorUrl != null ? !authorUrl.equals(that.authorUrl) : that.authorUrl != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (pathHref != null ? !pathHref.equals(that.pathHref) : that.pathHref != null) return false;
        if (dateTime != null ? !dateTime.equals(that.dateTime) : that.dateTime != null) return false;
        if (pathText != null ? !pathText.equals(that.pathText) : that.pathText != null) return false;
        if (readNum != null ? !readNum.equals(that.readNum) : that.readNum != null) return false;
        if (commentNum != null ? !commentNum.equals(that.commentNum) : that.commentNum != null) return false;
        if (likeNum != null ? !likeNum.equals(that.likeNum) : that.likeNum != null) return false;
        if (detailHref != null ? !detailHref.equals(that.detailHref) : that.detailHref != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (pictureHrefsNum != null ? !pictureHrefsNum.equals(that.pictureHrefsNum) : that.pictureHrefsNum != null)
            return false;
        if (parseTime != null ? !parseTime.equals(that.parseTime) : that.parseTime != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (timeStamp != null ? !timeStamp.equals(that.timeStamp) : that.timeStamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = postId != null ? postId.hashCode() : 0;
        result = 31 * result + (authorId != null ? authorId.hashCode() : 0);
        result = 31 * result + (commentIds != null ? commentIds.hashCode() : 0);
        result = 31 * result + (authorName != null ? authorName.hashCode() : 0);
        result = 31 * result + (authorUrl != null ? authorUrl.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (pathHref != null ? pathHref.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        result = 31 * result + (pathText != null ? pathText.hashCode() : 0);
        result = 31 * result + (readNum != null ? readNum.hashCode() : 0);
        result = 31 * result + (commentNum != null ? commentNum.hashCode() : 0);
        result = 31 * result + (likeNum != null ? likeNum.hashCode() : 0);
        result = 31 * result + (detailHref != null ? detailHref.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (pictureHrefsNum != null ? pictureHrefsNum.hashCode() : 0);
        result = 31 * result + (parseTime != null ? parseTime.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        return result;
    }
}
