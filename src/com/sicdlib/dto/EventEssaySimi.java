package com.sicdlib.dto;

import com.sicdlib.dto.entity.BbsPeoplePostEntity;
import com.sicdlib.dto.entity.DoubanGroupPostEntity;
import com.sicdlib.dto.entity.XinhuaNewsEntity;

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
    //示例：豆瓣小组的发布
    private DoubanGroupPostEntity doubanGroupPostEntity;
    //示例：人民网BBS的发布
    private BbsPeoplePostEntity bbsPeoplePostEntity;
    //示例：新华网的发布
    private XinhuaNewsEntity xinhuaNewsEntity;

    public XinhuaNewsEntity getXinhuaNewsEntity() {
        return xinhuaNewsEntity;
    }

    public void setXinhuaNewsEntity(XinhuaNewsEntity xinhuaNewsEntity) {
        this.xinhuaNewsEntity = xinhuaNewsEntity;
    }

    public BbsPeoplePostEntity getBbsPeoplePostEntity() {
        return bbsPeoplePostEntity;
    }

    public void setBbsPeoplePostEntity(BbsPeoplePostEntity bbsPeoplePostEntity) {
        this.bbsPeoplePostEntity = bbsPeoplePostEntity;
    }

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
