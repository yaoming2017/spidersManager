package com.sicdlib.dao;

import com.sicdlib.dto.TbTableEntity;

import java.util.List;

public interface ITableDAO {
    Boolean saveOrUpdateTable(TbTableEntity table);
    TbTableEntity getTable(String name);
    List<TbTableEntity> getTableByEventID(String eventID);
    List<String> getArticleContent(String eventID, String tableID, String tableName);
    List<String[]> getArticleIdAndContent(String eventID, String tableID, String tableName);
    String getArticleContent(String articleID, String tableName);
    //得到每个网站文章的评论量
    List<String> getArticleCommentNumByEventID(String eventID,String tableID, String tableName);
}
