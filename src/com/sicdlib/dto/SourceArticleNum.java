package com.sicdlib.dto;

import com.sicdlib.dto.entity.BbsPeoplePostEntity;
import com.sicdlib.dto.entity.DoubanGroupPostEntity;

/**
 * 源文章数量
 * Created by init on 2017/6/16.
 */
public class SourceArticleNum {
    private Integer num;
    private String startTime;
    private String endTime;
    private String tableName;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

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

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
