package com.sicdlib.dto;

import javax.persistence.*;

/**
 * Created by haoyang on 2017/4/24.
 */
@Entity
@Table(name = "process_method", schema = "socialMind", catalog = "")
public class ProcessMethodEntity {
    private String id;
    private String methodName;
    private String methodCodePath;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "method_name")
    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    @Basic
    @Column(name = "method_code_path")
    public String getMethodCodePath() {
        return methodCodePath;
    }

    public void setMethodCodePath(String methodCodePath) {
        this.methodCodePath = methodCodePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProcessMethodEntity that = (ProcessMethodEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (methodName != null ? !methodName.equals(that.methodName) : that.methodName != null) return false;
        if (methodCodePath != null ? !methodCodePath.equals(that.methodCodePath) : that.methodCodePath != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (methodName != null ? methodName.hashCode() : 0);
        result = 31 * result + (methodCodePath != null ? methodCodePath.hashCode() : 0);
        return result;
    }
}
