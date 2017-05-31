package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.IEventDAO;
import com.sicdlib.dao.ISourceArticleNumDAO;
import com.sicdlib.dto.TbEventEntity;
import com.sicdlib.dto.TbSourceArticleNumEntity;
import com.sicdlib.dto.TbTableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("sourceArticleNumDAO")
public class SourceArticleNumDAO implements ISourceArticleNumDAO {
    @Autowired
    private IBaseDAO baseDAO;

    @Override
    public Boolean saveOrUpdateSourceArticleNum(TbSourceArticleNumEntity sourceArticleNum) {
        try {
            baseDAO.saveOrUpdate(sourceArticleNum);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public TbSourceArticleNumEntity getSourceArticleNum(TbEventEntity event, TbTableEntity table) {
        String hql = "from TbSourceArticleNumEntity n where n.event.id = '"+event.getId()+"' and n.table.id = '"+table.getId()+"'";
        return (TbSourceArticleNumEntity) baseDAO.get(hql);
    }
}