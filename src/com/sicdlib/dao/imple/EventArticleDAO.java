package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.IEventArticleDAO;
import com.sicdlib.dao.IEventDAO;
import com.sicdlib.dto.TbEventArticleEntity;
import com.sicdlib.dto.TbEventEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("eventArticleDAO")
public class EventArticleDAO implements IEventArticleDAO {
    @Autowired
    private IBaseDAO baseDAO;

    @Override
    public Boolean saveOrUpdateEventArticle(TbEventArticleEntity eventArticle) {
        try {
            baseDAO.saveOrUpdate(eventArticle);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}