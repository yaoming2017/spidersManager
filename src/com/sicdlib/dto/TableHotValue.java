package com.sicdlib.dto;

import com.sicdlib.dto.entity.BbsPeoplePostEntity;
import com.sicdlib.dto.entity.DoubanGroupPostEntity;

import java.util.List;

/**
 * Created by DeMH on 2017/5/9.
 */
public class TableHotValue {
    //热度值
    private Double hotValue;
    //网站名称
    private String websiteName;
    //表名（对应tb_table的网站名称）
    private String tableName;
    //例：豆瓣
    private DoubanGroupPostEntity doubanGroupPost;
    //例：人民网：强国社区
    private BbsPeoplePostEntity bbsPeoplePost;

    public BbsPeoplePostEntity getBbsPeoplePost() {
        return bbsPeoplePost;
    }

    public void setBbsPeoplePost(BbsPeoplePostEntity bbsPeoplePost) {
        this.bbsPeoplePost = bbsPeoplePost;
    }

    public Double getHotValue() {
        return hotValue;
    }

    public void setHotValue(Double hotValue) {
        this.hotValue = hotValue;
    }

    public DoubanGroupPostEntity getDoubanGroupPost() {
        return doubanGroupPost;
    }

    public void setDoubanGroupPost(DoubanGroupPostEntity doubanGroupPost) {
        this.doubanGroupPost = doubanGroupPost;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
