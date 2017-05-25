package com.sicdlib.dto.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by DeMH on 2017/5/11.
 */
@Entity
@Table(name = "clean_data_process", schema = "socialmind", catalog = "")
public class CleanDataProcessEntity {
    private String id;
    private String name;
    private String value;
    //多对一：多个cleanDataProcess属于一个cleanDataEntity
    private CleanDataEntity cleanDataEntity;
    //一对多
    private Set<CleanDataProcessUserEntity> cleanDataProcessUserEntitySet = new HashSet<CleanDataProcessUserEntity>();

    @OneToMany(mappedBy = "cleanDataProcess", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<CleanDataProcessUserEntity> getCleanDataProcessUserEntitySet() {
        return cleanDataProcessUserEntitySet;
    }

    public void setCleanDataProcessUserEntitySet(Set<CleanDataProcessUserEntity> cleanDataProcessUserEntitySet) {
        this.cleanDataProcessUserEntitySet = cleanDataProcessUserEntitySet;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "cln_data_id", referencedColumnName = "id")
    public CleanDataEntity getCleanDataEntity() {
        return cleanDataEntity;
    }

    public void setCleanDataEntity(CleanDataEntity cleanDataEntity) {
        this.cleanDataEntity = cleanDataEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CleanDataProcessEntity that = (CleanDataProcessEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
