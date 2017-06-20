package com.sicdlib.dao;

/**
 * Created by YH on 2017/6/15.
 */
public interface ITableColumnDAO {
    boolean isExistColumn(String tableName, String columnName);
    boolean isExistTable(String schemaName, String tableName);
}
