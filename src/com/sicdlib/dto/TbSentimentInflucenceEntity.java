package com.sicdlib.dto;

import javax.persistence.*;

/**
 * Created by init on 2017/6/16.
 */
@Entity
@Table(name = "tb_sentiment_influcence", schema = "socialmind", catalog = "")
public class TbSentimentInflucenceEntity {
    private String id;
    private Long influcence;
    private String websiteName;
    private String tableName;
    private String dateTime;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "influcence")
    public Long getInflucence() {
        return influcence;
    }

    public void setInflucence(Long influcence) {
        this.influcence = influcence;
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
    @Column(name = "date_time")
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbSentimentInflucenceEntity that = (TbSentimentInflucenceEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (influcence != null ? !influcence.equals(that.influcence) : that.influcence != null) return false;
        if (websiteName != null ? !websiteName.equals(that.websiteName) : that.websiteName != null) return false;
        if (tableName != null ? !tableName.equals(that.tableName) : that.tableName != null) return false;
        if (dateTime != null ? !dateTime.equals(that.dateTime) : that.dateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (influcence != null ? influcence.hashCode() : 0);
        result = 31 * result + (websiteName != null ? websiteName.hashCode() : 0);
        result = 31 * result + (tableName != null ? tableName.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        return result;
    }
}
