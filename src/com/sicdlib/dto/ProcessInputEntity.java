package com.sicdlib.dto;

import javax.persistence.*;

/**
 * Created by haoyang on 2017/4/24.
 */
@Entity
@Table(name = "process_input", schema = "socialMind", catalog = "")
public class ProcessInputEntity {
    private String id;
    private String tableName;
    private String fieldName;
    private String processId;
    private Integer isBasic;
    private String fillMethod;

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

    @Basic
    @Column(name = "process_id")
    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    @Basic
    @Column(name = "is_basic")
    public Integer getIsBasic() {
        return isBasic;
    }

    public void setIsBasic(Integer isBasic) {
        this.isBasic = isBasic;
    }

    @Basic
    @Column(name = "fill_method")
    public String getFillMethod() {
        return fillMethod;
    }

    public void setFillMethod(String fillMethod) {
        this.fillMethod = fillMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProcessInputEntity that = (ProcessInputEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (tableName != null ? !tableName.equals(that.tableName) : that.tableName != null) return false;
        if (fieldName != null ? !fieldName.equals(that.fieldName) : that.fieldName != null) return false;
        if (processId != null ? !processId.equals(that.processId) : that.processId != null) return false;
        if (isBasic != null ? !isBasic.equals(that.isBasic) : that.isBasic != null) return false;
        if (fillMethod != null ? !fillMethod.equals(that.fillMethod) : that.fillMethod != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tableName != null ? tableName.hashCode() : 0);
        result = 31 * result + (fieldName != null ? fieldName.hashCode() : 0);
        result = 31 * result + (processId != null ? processId.hashCode() : 0);
        result = 31 * result + (isBasic != null ? isBasic.hashCode() : 0);
        result = 31 * result + (fillMethod != null ? fillMethod.hashCode() : 0);
        return result;
    }
}
