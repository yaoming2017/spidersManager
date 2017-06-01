package com.sicdlib.dto.entity;

import javax.persistence.*;

/**
 * Created by init on 2017/5/31.
 */
@Entity
@Table(name = "bbs_people_comment_post_id", schema = "socialmind", catalog = "")
public class BbsPeopleCommentPostIdEntity {
    private String id;
    private String commentId;
    private String postId;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "comment_id")
    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    @Basic
    @Column(name = "post_id")
    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BbsPeopleCommentPostIdEntity that = (BbsPeopleCommentPostIdEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (commentId != null ? !commentId.equals(that.commentId) : that.commentId != null) return false;
        if (postId != null ? !postId.equals(that.postId) : that.postId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (commentId != null ? commentId.hashCode() : 0);
        result = 31 * result + (postId != null ? postId.hashCode() : 0);
        return result;
    }
}
