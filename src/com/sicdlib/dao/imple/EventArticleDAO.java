package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.IEventArticleDAO;
import com.sicdlib.dto.TbTableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Created by YH on 2017/5/26.
 */
@Repository
public class EventArticleDAO implements IEventArticleDAO {
    @Autowired
    @Qualifier("baseDAO")
    private IBaseDAO baseDAO;

    @Override
    public String getSourceArticleTitle(String tableID, String articleID) {
        String tableName = ((TbTableEntity) baseDAO.get(TbTableEntity.class, tableID)).getTableName();

        String sql = "SELECT title FROM " + tableName + " WHERE id = '" + articleID + "'";
        return (String) baseDAO.getSqlList(sql).get(0);
    }
}
