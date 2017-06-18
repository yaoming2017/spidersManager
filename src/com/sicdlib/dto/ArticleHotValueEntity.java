package com.sicdlib.dto;

import javax.persistence.*;

/**
 * Created by DeMH on 2017/6/13.
 */
@Entity
@Table(name = "article_hot_value", schema = "socialmind", catalog = "")
public class ArticleHotValueEntity {

    private String id;
    private Double hotValue;
    private String websiteName;
    private String tableName;
    private String sourceArticleId;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "hot_value")
    public Double getHotValue() {
        return hotValue;
    }

    public void setHotValue(Double hotValue) {
        this.hotValue = hotValue;
    }

    @Basic
    @Column(name = "website_name")
    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    @Basic
    @Column(name = "table_name")
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Basic
    @Column(name = "source_article_id")
    public String getSourceArticleId() {
        return sourceArticleId;
    }

    public void setSourceArticleId(String sourceArticleId) {
        this.sourceArticleId = sourceArticleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleHotValueEntity that = (ArticleHotValueEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (hotValue != null ? !hotValue.equals(that.hotValue) : that.hotValue != null) return false;
        if (websiteName != null ? !websiteName.equals(that.websiteName) : that.websiteName != null) return false;
        if (tableName != null ? !tableName.equals(that.tableName) : that.tableName != null) return false;
        if (sourceArticleId != null ? !sourceArticleId.equals(that.sourceArticleId) : that.sourceArticleId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (hotValue != null ? hotValue.hashCode() : 0);
        result = 31 * result + (websiteName != null ? websiteName.hashCode() : 0);
        result = 31 * result + (tableName != null ? tableName.hashCode() : 0);
        result = 31 * result + (sourceArticleId != null ? sourceArticleId.hashCode() : 0);
        return result;
    }
}
