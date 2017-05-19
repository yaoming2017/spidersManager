package com.sicdlib.dto;

import javax.persistence.*;

/**
 * Created by YH on 2017/5/19.
 */
@Entity
@Table(name = "tb_table", schema = "socialMind")
public class TbTableEntity {
    private String id;
    private String tableName;
    private String websiteId;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    @Column(name = "website_id")
    public String getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(String websiteId) {
        this.websiteId = websiteId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbTableEntity that = (TbTableEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (tableName != null ? !tableName.equals(that.tableName) : that.tableName != null) return false;
        if (websiteId != null ? !websiteId.equals(that.websiteId) : that.websiteId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tableName != null ? tableName.hashCode() : 0);
        result = 31 * result + (websiteId != null ? websiteId.hashCode() : 0);
        return result;
    }
}
