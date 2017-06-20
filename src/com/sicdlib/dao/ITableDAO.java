package com.sicdlib.dao;

import com.google.protobuf.Internal;
import com.sicdlib.dto.TbTableEntity;

import java.util.List;
import java.util.Map;

public interface ITableDAO {
    Boolean saveOrUpdateTable(TbTableEntity table);
    TbTableEntity getTable(String name);

    List<String> getArticleContent(String eventID, String tableID, String tableName);
    List<String[]> getArticleIdAndContent(String eventID, String tableID, String tableName);
    String getArticleContent(String articleID, String tableName);
    //得到每个网站文章的评论量
    //List<String> getArticleCommentNumByEventID(String eventID);
    List<TbTableEntity> getTableByEventID(String eventID);
    Map<String,Integer> getCommentNumByTableName(String eventname);

}

