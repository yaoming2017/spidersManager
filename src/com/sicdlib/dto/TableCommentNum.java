package com.sicdlib.dto;

import com.sicdlib.dto.entity.DoubanGroupPostEntity;
import com.sicdlib.dto.entity.KdnetPostEntity;

/**
 * Created by init on 2017/6/16.
 */
public class TableCommentNum {
    //评论量
    private int commentNum;
    //网站名称
    private String websiteName;
    //表名
    private String tableName;
    //例如：豆瓣
    private DoubanGroupPostEntity doubanGroupPostEntity;
    //例如：凯迪社区
    private KdnetPostEntity kdnetPostEntity;

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
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

    public DoubanGroupPostEntity getDoubanGroupPostEntity() {
        return doubanGroupPostEntity;
    }

    public void setDoubanGroupPostEntity(DoubanGroupPostEntity doubanGroupPostEntity) {
        this.doubanGroupPostEntity = doubanGroupPostEntity;
    }

    public KdnetPostEntity getKdnetPostEntity() {
        return kdnetPostEntity;
    }

    public void setKdnetPostEntity(KdnetPostEntity kdnetPostEntity) {
        this.kdnetPostEntity = kdnetPostEntity;
    }
}
