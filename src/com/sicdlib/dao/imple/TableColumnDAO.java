package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.ITableColumnDAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by YH on 2017/6/15.
 */
@Repository("tableColumnDAO")
public class TableColumnDAO implements ITableColumnDAO {
    @Autowired
    @Qualifier("baseDAO")
    private IBaseDAO baseDAO;

    @Override
    @Test
    public boolean isExistColumn(String tableName, String columnName) {
        String sql = "SELECT\n" +
                "\t*\n" +
                "FROM\n" +
                "\tinformation_schema.COLUMNS\n" +
                "WHERE\n" +
                "\tTABLE_NAME = '" + tableName + "'\n" +
                "AND COLUMN_NAME = '" + columnName + "'";

        List result = baseDAO.getSqlList(sql);

        return result != null && result.size() > 0;
    }
}
