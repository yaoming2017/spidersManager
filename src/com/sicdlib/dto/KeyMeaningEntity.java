package com.sicdlib.dto;

import javax.persistence.*;

/**
 * Created by DeMH on 2017/4/28.
 */
@Entity
@Table(name = "key_meaning", schema = "socialMind", catalog = "")
public class KeyMeaningEntity {
    private String id;
    private String keyName;
    private String meaning;
    private String fid;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "key_name")
    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    @Basic
    @Column(name = "meaning")
    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KeyMeaningEntity that = (KeyMeaningEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (keyName != null ? !keyName.equals(that.keyName) : that.keyName != null) return false;
        if (meaning != null ? !meaning.equals(that.meaning) : that.meaning != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (keyName != null ? keyName.hashCode() : 0);
        result = 31 * result + (meaning != null ? meaning.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "fid")
    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }
}
