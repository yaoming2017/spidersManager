package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.IEventArticleDAO;
import com.sicdlib.dto.TbEventArticleEntity;
import com.sicdlib.dto.TbSentimentInflucenceEntity;
import com.sicdlib.dto.TbTableEntity;
import com.sicdlib.dto.entity.DoubanGroupPostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by YH on 2017/5/26.
 */
@Repository("eventArticleDAO")
public class EventArticleDAO implements IEventArticleDAO {
    @Autowired
    @Qualifier("baseDAO")
    private IBaseDAO baseDAO;

    @Override
    public String getArticleTitle(String tableID, String articleID) {
        String tableName = ((TbTableEntity) baseDAO.get(TbTableEntity.class, tableID)).getTableName();

        String sql = "SELECT title FROM " + tableName + " WHERE id = '" + articleID + "'";

        return "";
    }

    @Override
    public String getArticleDateTime(String tableID, String articleID) {
        String tableName = ((TbTableEntity) baseDAO.get(TbTableEntity.class, tableID)).getTableName();

        String sql = "SELECT datetime FROM " + tableName + " WHERE id = '" + articleID + "'";
        return (String) baseDAO.getSqlList(sql).get(0);
    }


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

    @Override
    public TbEventArticleEntity getEventArticleEntity(String id) {
        return (TbEventArticleEntity) baseDAO.get(TbEventArticleEntity.class, id);
    }

    @Override
    public List<TbEventArticleEntity> getEventArticlesByStartEndTime(String eventId, String startTimeStr, String endTimeStr) {
        String hql = "from TbEventArticleEntity ea where ea.event.id = '"+eventId+"' and ea.time > '"+ startTimeStr +"' and ea.time < '"+ endTimeStr +"'";
        return baseDAO.find(hql);
    }

    @Override
    public List<TbEventArticleEntity> getEventArticleByEventID(String eventID) {
        String hql = "from TbEventArticleEntity ea where ea.event.id = '"+eventID+"'";
        return baseDAO.find(hql);

    }

    @Override
    public List<TbSentimentInflucenceEntity> getInflucenceByStartEndTime(String eventId, String startTimeStr, String endTimeStr) {
        String hql = "from TbSentimentInflucenceEntity ea where ea.event.id = '"+eventId+"' and ea.time > '"+ startTimeStr +"' and ea.time < '"+ endTimeStr +"'";
        return baseDAO.find(hql);
    }

}

