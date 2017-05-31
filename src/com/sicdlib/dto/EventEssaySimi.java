package com.sicdlib.dto;

import com.sicdlib.dto.entity.DoubanGroupPostEntity;

import java.util.List;

/**
 * Created by DeMH on 2017/5/9.
 */
public class EventEssaySimi {
    //相似度
    private Float simi;
    //表名称
    private String tablename;
    //每条记录的ID
    private String id;
    //特例：豆瓣小组的发布
    private DoubanGroupPostEntity doubanGroupPostEntity;

    public Float getSimi() {
        return simi;
    }

    public void setSimi(Float simi) {
        this.simi = simi;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DoubanGroupPostEntity getDoubanGroupPostEntity() {
        return doubanGroupPostEntity;
    }

    public void setDoubanGroupPostEntity(DoubanGroupPostEntity doubanGroupPostEntity) {
        this.doubanGroupPostEntity = doubanGroupPostEntity;
    }
}
