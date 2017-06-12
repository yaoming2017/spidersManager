package com.sicdlib.dto;

import javax.persistence.*;

/**
 * Created by YH on 2017/5/19.
 */
@Entity
@Table(name = "tb_article_similarity", schema = "socialMind")
public class TbArticleSimilarityEntity {
    private String id;
    private Double similarity;

    //多对一映射
    private TbEventArticleEntity articleA;
    private TbEventArticleEntity articleB;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "article_a_id", referencedColumnName = "id")
    public TbEventArticleEntity getArticleA() {
        return articleA;
    }

    public void setArticleA(TbEventArticleEntity articleA) {
        this.articleA = articleA;
    }

    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "article_b_id", referencedColumnName = "id")
    public TbEventArticleEntity getArticleB() {
        return articleB;
    }

    public void setArticleB(TbEventArticleEntity articleB) {
        this.articleB = articleB;
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
        if (similarity != null ? !similarity.equals(that.similarity) : that.similarity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (similarity != null ? similarity.hashCode() : 0);
        return result;
    }
}
