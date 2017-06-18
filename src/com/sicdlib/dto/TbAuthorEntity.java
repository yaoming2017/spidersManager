package com.sicdlib.dto;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created by YH on 2017/6/16.
 */
@Entity
@Table(name = "tb_author", schema = "socialmind")
public class TbAuthorEntity {
    private String id;
    private String sourceAuthorName;
    private String sourceAuthorId;
    private Integer authorPostNum;
    private Integer postReplyNum;
    private Long authorPostReadNum;
    private Double authorInfluence;
    private BigInteger authorFansNum;
    private TbTableEntity table;
    private Integer participateCommentNum;
    private Double activeness;

    @ManyToOne
    @JoinColumn(name = "table_id", referencedColumnName = "id")
    public TbTableEntity getTable() {
        return table;
    }

    public void setTable(TbTableEntity table) {
        this.table = table;
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
    @Column(name = "source_author_name")
    public String getSourceAuthorName() {
        return sourceAuthorName;
    }

    public void setSourceAuthorName(String sourceAuthorName) {
        this.sourceAuthorName = sourceAuthorName;
    }

    @Basic
    @Column(name = "source_author_id")
    public String getSourceAuthorId() {
        return sourceAuthorId;
    }

    public void setSourceAuthorId(String sourceAuthorId) {
        this.sourceAuthorId = sourceAuthorId;
    }

    @Basic
    @Column(name = "author_post_num")
    public Integer getAuthorPostNum() {
        return authorPostNum;
    }

    public void setAuthorPostNum(Integer authorPostNum) {
        this.authorPostNum = authorPostNum;
    }

    @Basic
    @Column(name = "post_reply_num")
    public Integer getPostReplyNum() {
        return postReplyNum;
    }

    public void setPostReplyNum(Integer authorReplyNum) {
        this.postReplyNum = authorReplyNum;
    }

    @Basic
    @Column(name = "author_post_read_num")
    public Long getAuthorPostReadNum() {
        return authorPostReadNum;
    }

    public void setAuthorPostReadNum(Long authorPostReadNum) {
        this.authorPostReadNum = authorPostReadNum;
    }

    @Basic
    @Column(name = "author_influence")
    public Double getAuthorInfluence() {
        return authorInfluence;
    }

    public void setAuthorInfluence(Double authorInfluence) {
        this.authorInfluence = authorInfluence;
    }

    @Basic
    @Column(name = "author_fans_num")
    public BigInteger getAuthorFansNum() {
        return authorFansNum;
    }

    public void setAuthorFansNum(BigInteger authorFansNum) {
        this.authorFansNum = authorFansNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbAuthorEntity that = (TbAuthorEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (sourceAuthorName != null ? !sourceAuthorName.equals(that.sourceAuthorName) : that.sourceAuthorName != null)
            return false;
        if (sourceAuthorId != null ? !sourceAuthorId.equals(that.sourceAuthorId) : that.sourceAuthorId != null)
            return false;
        if (authorPostNum != null ? !authorPostNum.equals(that.authorPostNum) : that.authorPostNum != null)
            return false;
        if (postReplyNum != null ? !postReplyNum.equals(that.postReplyNum) : that.postReplyNum != null)
            return false;
        if (authorPostReadNum != null ? !authorPostReadNum.equals(that.authorPostReadNum) : that.authorPostReadNum != null)
            return false;
        if (authorInfluence != null ? !authorInfluence.equals(that.authorInfluence) : that.authorInfluence != null)
            return false;
        if (authorFansNum != null ? !authorFansNum.equals(that.authorFansNum) : that.authorFansNum != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (sourceAuthorName != null ? sourceAuthorName.hashCode() : 0);
        result = 31 * result + (sourceAuthorId != null ? sourceAuthorId.hashCode() : 0);
        result = 31 * result + (authorPostNum != null ? authorPostNum.hashCode() : 0);
        result = 31 * result + (postReplyNum != null ? postReplyNum.hashCode() : 0);
        result = 31 * result + (authorPostReadNum != null ? authorPostReadNum.hashCode() : 0);
        result = 31 * result + (authorInfluence != null ? authorInfluence.hashCode() : 0);
        result = 31 * result + (authorFansNum != null ? authorFansNum.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "participate_comment_num")
    public Integer getParticipateCommentNum() {
        return participateCommentNum;
    }

    public void setParticipateCommentNum(Integer participateCommentNum) {
        this.participateCommentNum = participateCommentNum;
    }

    @Basic
    @Column(name = "activeness")
    public Double getActiveness() {
        return activeness;
    }

    public void setActiveness(Double activeness) {
        this.activeness = activeness;
    }
}
