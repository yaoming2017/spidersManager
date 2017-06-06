package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.IEventDAO;
import com.sicdlib.dao.ITableDAO;
import com.sicdlib.dto.TbEventEntity;
import com.sicdlib.dto.TbTableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("tableDAO")
public class TableDAO implements ITableDAO {
    @Autowired
    private IBaseDAO baseDAO;

    @Override
    public Boolean saveOrUpdateTable(TbTableEntity table) {
        try{
            baseDAO.saveOrUpdate(table);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public TbTableEntity getTable(String name) {
        String hql = "from TbTableEntity tb where tb.tableName = '"+name+"'";
        return (TbTableEntity) baseDAO.get(hql);
    }

    @Override
    public List<TbTableEntity> getTableByEventID(String eventID) {
        String hql = "FROM TbTableEntity table " +
                "WHERE table.id in " +
                "(" +
                "SELECT distinct articleNum.table.id " +
                "FROM TbSourceArticleNumEntity articleNum " +
                "WHERE articleNum.event.id = '" + eventID + "'" +
                ")";
        return baseDAO.find(hql);
    }

    @Override
    public List<String> getArticleContent(String eventID, String tableID, String tableName) {
        String sql = "select articleTable.content " +
                "FROM " + tableName + " articleTable " +
                "WHERE articleTable.id in " +
                "(" +
                "SELECT ea.source_article_id " +
                "FROM tb_event_article ea " +
                "WHERE ea.event_id = '" + eventID + "' AND ea.table_id = '" + tableID + "' " +
                ")";
        return baseDAO.getSqlList(sql);
    }

    @Override
    public List<String[]> getArticleIdAndContent(String eventID, String tableID, String tableName) {
        String sql = "select s.id, articleTable.content " +
                "FROM " + tableName + " articleTable, " +
                "(" +
                "SELECT ea.ID, ea.source_article_id " +
                "FROM tb_event_article ea " +
                "WHERE ea.event_id = '" + eventID + "' AND ea.table_id = '" + tableID + "' " +
                ") s " +
                "WHERE articleTable.id = s.source_article_id";
        return baseDAO.getSqlList(sql);
    }
}