package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.IEventDAO;
import com.sicdlib.dto.TbEventArticleEntity;
import com.sicdlib.dto.TbEventEntity;
import com.sicdlib.dto.TbHotWordEntity;
import com.sicdlib.dto.WebsiteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.sicdlib.dao.IStopWordsDAO;
import com.sicdlib.dto.TbEventEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by YH on 2017/5/25.
 */
@Repository("eventDAO")
public class EventDAO implements IEventDAO {
    @Autowired
    @Qualifier("baseDAO")
    private IBaseDAO baseDAO;

    @Override
    public List<TbHotWordEntity> getKeyWords(String eventID, int limit) {
        String hql = "FROM TbHotWordEntity hotWords WHERE hotWords.eventId = '"
                + eventID + "' order by hotWords.heat desc";

        return baseDAO.find(hql, 0, limit);
    }

    @Override
    public String startDatetime(String eventID) {
        return this.getEvent(eventID).getEventStartTime();
    }

    @Override
    public String endDatetime(String eventID) {
        return this.getEvent(eventID).getEventEndTime();
    }

    @Override
    public int eventArticleNum(String eventID) {
        String hql = "SELECT SUM(articleNum.num) FROM TbSourceArticleNumEntity articleNum WHERE articleNum.eventId = '"
                                + eventID + "'";
        int result = (int) baseDAO.get(hql);
        return result;
    }

    @Override
    public String rushDate(String eventID) {
        return this.getEvent(eventID).getEventRushTime();
    }

    @Override
    public int rushNum(String eventID) {
        return this.getEvent(eventID).getEventRushNum();
    }

    @Override
    public String sourceDateTime(String eventID) {
        return this.getSourceEventArticle(eventID).getTime();
    }

    @Override
    public String sourceArticleTitle(String eventID) {
        TbEventArticleEntity eventArticle = this.getSourceEventArticle(eventID);
        String tableID = eventArticle.getTableId();
//        String articleID = eventArticle
        return null;
    }

    @Override
    public WebsiteEntity sourceWebsite(String eventID) {
        String tableID = this.getSourceEventArticle(eventID).getTableId();
        String hql = "FROM WebsiteEntity w and TbTableEntity t WHERE w.id = t.websiteId AND t.id = '" + tableID + "'";

        return (WebsiteEntity) baseDAO.get(hql);
    }

    @Override
    public String eventTrend(String eventID) {
        return "突出";
    }

    @Override
    public TbEventEntity getEvent(String eventID) {
        return (TbEventEntity) baseDAO.get(TbEventEntity.class, eventID);
    }

    @Override
    public TbEventArticleEntity getSourceEventArticle(String eventID) {
        String hql = "FROM TbEventArticleEntity eventArticle WHERE eventArticle.eventId = '"
                + eventID + "' ORDER BY eventArticle.time asc";

        return (TbEventArticleEntity) baseDAO.find(hql, 0, 1).get(0);
    }

    @Override
    public Boolean saveOrUpdateEvent(TbEventEntity event) {
        try {
            baseDAO.saveOrUpdate(event);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}

