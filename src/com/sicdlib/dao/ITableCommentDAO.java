package com.sicdlib.dao;

/**
 * Created by YH on 2017/6/18.
 */
public interface ITableCommentDAO {
    int participantCommentNumByName(String tableName, String userName);
    int participantCommentNumById(String tableName, String authorId);
}
