package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.IEventDAO;
import com.sicdlib.dao.ITableDAO;
import com.sicdlib.dto.TbEventEntity;
import com.sicdlib.dto.TbTableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}