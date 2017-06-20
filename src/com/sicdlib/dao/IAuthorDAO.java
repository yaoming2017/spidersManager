package com.sicdlib.dao;

import com.sicdlib.dto.TbAuthorEntity;
import com.sicdlib.dto.TbEventAuthorMappingEntity;

import java.util.List;

/**
 * Created by YH on 2017/6/16.
 */
public interface IAuthorDAO {
    List<Object[]> getAuthorIdAndNameAndFansNumWithPost(String eventID, String tableID, String postTableName, String authorTableName) throws Exception;
    List<Object[]> getAuthorNameWithNonePost(String eventID, String tableID, String articleTableName) throws Exception;

    Object[] getAuthorReadArticleReplyNumInAuthorTable(String authorID, String tableName);
    Object[] getAuthorReadArticleReplyNumInPostTable(String authorName, String tableName);

    void saveAuthorEntity(TbAuthorEntity authorEntity);
    void saveEventAuthorMapping(TbEventAuthorMappingEntity eventAuthor);
    void saveEventAuthorMapping(TbEventAuthorMappingEntity eventAuthor, String eventID);
}
