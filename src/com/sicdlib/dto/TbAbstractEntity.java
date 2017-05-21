package com.sicdlib.dto;

import javax.persistence.*;

/**
 * Created by YH on 2017/5/19.
 */
@Entity
@Table(name = "tb_abstract", schema = "socialMind")
public class TbAbstractEntity {
    private String id;
    private String articleAbstract;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "abstract")
    public String getArticleAbstract() {
        return articleAbstract;
    }

    public void setArticleAbstract(String articleAbstract) {
        this.articleAbstract = articleAbstract;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbAbstractEntity that = (TbAbstractEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (articleAbstract != null ? !articleAbstract.equals(that.articleAbstract) : that.articleAbstract != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (articleAbstract != null ? articleAbstract.hashCode() : 0);
        return result;
    }
}
