package com.sicdlib.dto.entity;

import javax.persistence.*;

/**
 * Created by DeMH on 2017/5/16.
 */
@Entity
@Table(name = "clean_input", schema = "socialmind", catalog = "")
public class CleanInputEntity {
    private String id;
    private String tableName;
    private String fieldName;
    //多对一：多个输入clean_input对应一个clean_data_process_user
    private CleanDataProcessUserEntity cleanDataProcessUser;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "cln_dt_pro_user_id", referencedColumnName = "id")
    public CleanDataProcessUserEntity getCleanDataProcessUser() {
        return cleanDataProcessUser;
    }

    public void setCleanDataProcessUser(CleanDataProcessUserEntity cleanDataProcessUser) {
        this.cleanDataProcessUser = cleanDataProcessUser;
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
    @Column(name = "table_name")
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Basic
    @Column(name = "field_name")
    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CleanInputEntity that = (CleanInputEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (tableName != null ? !tableName.equals(that.tableName) : that.tableName != null) return false;
        if (fieldName != null ? !fieldName.equals(that.fieldName) : that.fieldName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tableName != null ? tableName.hashCode() : 0);
        result = 31 * result + (fieldName != null ? fieldName.hashCode() : 0);
        return result;
    }
}
