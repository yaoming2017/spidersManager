package com.sicdlib.dto;

import java.util.List;

/**
 * Created by DeMH on 2017/5/9.
 */
public class TableFields {
    //父ID
    private String fid;
    //父表
    private KeyMeaningEntity htable;
    //字段
    private List<KeyMeaningEntity> fields;
    //字段对应的值
    private List<List<String>> values;

    public String getFid() {
        return fid;
    }
    public void setFid(String fid) {
        this.fid = fid;
    }
    public List<KeyMeaningEntity> getFields() {
        return fields;
    }
    public void setFields(List<KeyMeaningEntity> fields) {
        this.fields = fields;
    }
    public KeyMeaningEntity getHtable() {
        return htable;
    }
    public void setHtable(KeyMeaningEntity htable) {
        this.htable = htable;
    }
    public List<List<String>> getValues() {
        return values;
    }
    public void setValues(List<List<String>> values) {
        this.values = values;
    }
}
