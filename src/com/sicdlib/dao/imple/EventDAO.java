package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.IEventArticleDAO;
import com.sicdlib.dao.IEventDAO;
import com.sicdlib.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

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

    @Autowired
    @Qualifier("eventArticleDAO")
    private IEventArticleDAO eventArticleDAO;

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
        String tableID = eventArticle.getTable().getId();
        String articleID = eventArticle.getSourceArticleId();

        return eventArticleDAO.getArticleTitle(tableID, articleID);
    }

    @Override
    public WebsiteEntity sourceWebsite(String eventID) {
        String tableID = this.getSourceEventArticle(eventID).getTable().getId();
        String hql = "FROM WebsiteEntity w and TbTableEntity t WHERE w.id = t.websiteId AND t.id = '" + tableID + "'";
        return (WebsiteEntity) baseDAO.get(hql);
    }

    @Override
    public List<WebsiteEntity> sourceWebsiteList(String eventID) {
        String hql = "SELECT articleNum FROM TbSourceArticleNumEntity articleNum, TbTableEntity table, WebsiteEntity website " +
                "WHERE articleNum.tableId = table.id AND table.websiteId = website.id AND articleNum.eventId = '" + eventID + "'";

        List<WebsiteEntity> websiteList = baseDAO.find(hql);

        return websiteList;
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

    @Override
    public TbEventArticleEntity getSourceEventEntity(String eventID) {
        String hql = "FROM TbEventArticleEntity article WHERE article.time = " +
                "(select MIN(article1.time) from TbEventArticleEntity article1 WHERE article1.eventId = '" + eventID + "' )";

        return ((TbEventArticleEntity) baseDAO.get(hql));
    }

    @Override
    public String getEventEndTime(String eventID) {
        String hql = "FROM TbEventArticleEntity article WHERE article.time = " +
                "(select MAX(article1.time) from TbEventArticleEntity article1 WHERE article1.eventId = '" + eventID + "' )";

        return ((TbEventArticleEntity) baseDAO.get(hql)).getTime();
    }

    @Override
    public String[] getRushTimeAndNum(String eventID) {
        String sql = "SELECT convert(nvarchar(10),articleNum.start_time, 120), SUM(articleNum.num) " +
                "FROM tb_source_article_num articleNum " +
                "WHERE articleNum.event_id = '" + eventID + "' AND HAVING SUM(articleNum.num) = " +
                "(SELECT SUM(articleNum.num) FROM tb_source_article_num articleNum1 " +
                "WHERE articleNum1.event_id = '" + eventID + "' " +
                "GROUP BY convert(nvarchar(10),articleNum.start_time, 120)" +
                "ORDER BY s desc limit 1)";

        return (String[]) baseDAO.getSqlList(sql).get(0);
    }

    @Override
    public void updateEvent(TbEventEntity eventEntity) {
        baseDAO.update(eventEntity);
    }

    @Override
    public TbEventEntity getEventByName(String eventName) {
        String hql = "from TbEventArticleEntity e where e.eventName = '"+eventName+"'";
        return (TbEventEntity) baseDAO.get(hql);
    }
}

