package com.sicdlib.dto;

import javax.persistence.*;

/**
 * Created by YH on 2017/5/19.
 */
@Entity
@Table(name = "tb_article_similarity", schema = "socialMind")
public class TbArticleSimilarityEntity {
    private String id;
    private String articleAId;
    private String articleBId;
    private Double similarity;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "article_a_id")
    public String getArticleAId() {
        return articleAId;
    }

    public void setArticleAId(String articleAId) {
        this.articleAId = articleAId;
    }

    @Basic
    @Column(name = "article_b_id")
    public String getArticleBId() {
        return articleBId;
    }

    public void setArticleBId(String articleBId) {
        this.articleBId = articleBId;
    }

    @Basic
    @Column(name = "similarity")
    public Double getSimilarity() {
        return similarity;
    }

    public void setSimilarity(Double similarity) {
        this.similarity = similarity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbArticleSimilarityEntity that = (TbArticleSimilarityEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (articleAId != null ? !articleAId.equals(that.articleAId) : that.articleAId != null) return false;
        if (articleBId != null ? !articleBId.equals(that.articleBId) : that.articleBId != null) return false;
        if (similarity != null ? !similarity.equals(that.similarity) : that.similarity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (articleAId != null ? articleAId.hashCode() : 0);
        result = 31 * result + (articleBId != null ? articleBId.hashCode() : 0);
        result = 31 * result + (similarity != null ? similarity.hashCode() : 0);
        return result;
    }
}
