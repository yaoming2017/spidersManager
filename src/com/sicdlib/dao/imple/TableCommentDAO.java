package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.ITableCommentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by YH on 2017/6/18.
 */
@Repository("tableCommentDAO")
public class TableCommentDAO implements ITableCommentDAO {
    @Autowired
    @Qualifier("baseDAO")
    private IBaseDAO baseDAO;

    @Override
    public int participantCommentNumByName(String tableName, String userName) {
        String sql = "SELECT COUNT(1) " +
                "FROM " + tableName + " tb " +
                "WHERE tb.author_name = '" + userName + "'";

        List list = baseDAO.getSqlList(sql);
        if(list != null && list.size() > 0) {
            BigInteger result = (BigInteger)list.get(0);

            return result.intValue();
        }

        return 0;
    }

    @Override
    public int participantCommentNumById(String tableName, String authorId) {
        String sql = "SELECT COUNT(1) " +
                "FROM " + tableName + " tb " +
                "WHERE tb.author_id = '" + authorId + "'";

        List list = baseDAO.getSqlList(sql);
        if(list != null && list.size() > 0) {
            BigInteger result = (BigInteger) ((Object[])list.get(0))[0];

            return result.intValue();
        }

        return 0;
    }
}
