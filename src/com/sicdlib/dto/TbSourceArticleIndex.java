package com.sicdlib.dto;

import com.sicdlib.dto.entity.BbsPeoplePostEntity;
import com.sicdlib.dto.entity.BbsSohuPostEntity;
import com.sicdlib.dto.entity.DoubanGroupPostEntity;

/**
 * 源文章的舆情负面指数指标
 * Created by init on 2017/6/24.
 */
public class TbSourceArticleIndex {

    private String startTime;
    private String endTime;
    private Double index;
    //表名（对应tb_table的网站名称）
    private String tableName;
    //例如：豆瓣
    private DoubanGroupPostEntity doubanGroupPost ;
    //例如：人民网
    private BbsPeoplePostEntity bbsPeoplePost;
    //例如：搜狐社区
    private BbsSohuPostEntity bbsSohuPost;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Double getIndex() {
        return index;
    }

    public void setIndex(Double index) {
        this.index = index;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public DoubanGroupPostEntity getDoubanGroupPost() {
        return doubanGroupPost;
    }

    public void setDoubanGroupPost(DoubanGroupPostEntity doubanGroupPost) {
        this.doubanGroupPost = doubanGroupPost;
    }

    public BbsPeoplePostEntity getBbsPeoplePost() {
        return bbsPeoplePost;
    }

    public void setBbsPeoplePost(BbsPeoplePostEntity bbsPeoplePost) {
        this.bbsPeoplePost = bbsPeoplePost;
    }

    public BbsSohuPostEntity getBbsSohuPost() {
        return bbsSohuPost;
    }

    public void setBbsSohuPost(BbsSohuPostEntity bbsSohuPost) {
        this.bbsSohuPost = bbsSohuPost;
    }
}
