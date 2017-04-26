package com.sicdlib.dto;

import javax.persistence.*;

/**
 * Created by haoyang on 2017/4/24.
 */
@Entity
@Table(name = "process", schema = "socialMind", catalog = "")
public class ProcessEntity {
    private String id;
    private String processName;
    private String outputTableName;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "process_name")
    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    @Basic
    @Column(name = "output_table_name")
    public String getOutputTableName() {
        return outputTableName;
    }

    public void setOutputTableName(String outputTableName) {
        this.outputTableName = outputTableName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProcessEntity that = (ProcessEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (processName != null ? !processName.equals(that.processName) : that.processName != null) return false;
        if (outputTableName != null ? !outputTableName.equals(that.outputTableName) : that.outputTableName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (processName != null ? processName.hashCode() : 0);
        result = 31 * result + (outputTableName != null ? outputTableName.hashCode() : 0);
        return result;
    }
}
