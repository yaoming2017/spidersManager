package com.sicdlib.dto.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by DeMH on 2017/5/11.
 */
@Entity
@Table(name = "clean_data", schema = "socialmind", catalog = "")
public class CleanDataEntity {
    private String id;
    private String name;
    private String fid;
    //一对多
    private Set<CleanDataProcessEntity> cleanDataProcessEntitySet = new HashSet<CleanDataProcessEntity>();

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
    @Column(name = "fid")
    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    @OneToMany(mappedBy = "cleanDataEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<CleanDataProcessEntity> getCleanDataProcessEntitySet() {
        return cleanDataProcessEntitySet;
    }

    public void setCleanDataProcessEntitySet(Set<CleanDataProcessEntity> cleanDataProcessEntitySet) {
        this.cleanDataProcessEntitySet = cleanDataProcessEntitySet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CleanDataEntity that = (CleanDataEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (fid != null ? !fid.equals(that.fid) : that.fid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (fid != null ? fid.hashCode() : 0);
        return result;
    }
}
