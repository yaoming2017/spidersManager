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
    public Long eventArticleNum(String eventID) {
        String hql = "SELECT SUM(articleNum.num) FROM TbSourceArticleNumEntity articleNum WHERE articleNum.event.id = '"
                                + eventID + "'";
        Long result = (Long) baseDAO.get(hql);
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
        String hql = "FROM TbEventArticleEntity eventArticle WHERE eventArticle.event.id = '"
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
                "(select MIN(article1.time) from TbEventArticleEntity article1 WHERE article1.event.id = '" + eventID + "' )";

        return ((TbEventArticleEntity) baseDAO.get(hql));
    }

    @Override
    public String getEventEndTime(String eventID) {
        String hql = "FROM TbEventArticleEntity article WHERE article.time = " +
                "(select MAX(article1.time) from TbEventArticleEntity article1 WHERE article1.event.id = '" + eventID + "' )";

        return ((TbEventArticleEntity) baseDAO.get(hql)).getTime();
    }

    @Override
    public Object[] getRushTimeAndNum(String eventID) {
        String sql = "SELECT " +
                " sm1.s, " +
                "max(sm1.sum) " +
                "FROM " +
                "(" +
                "SELECT " +
                "substring(articleNum.start_time, 1, 10) s, " +
                "SUM(articleNum.num) sum " +
                "FROM " +
                "tb_source_article_num articleNum " +
                "WHERE " +
                "articleNum.event_id = '" + eventID + "' " +
                "GROUP BY " +
                "substring(articleNum.start_time, 1, 10) " +
                ") sm1 " +
                "WHERE " +
                "sm1.sum = ( " +
                "SELECT " +
                "MAX(sm2.sum) " +
                "FROM " +
                "( " +
                "SELECT " +
                "substring(articleNum.start_time, 1, 10) s, " +
                "SUM(articleNum.num) sum " +
                "FROM " +
                "tb_source_article_num articleNum " +
                "WHERE " +
                "articleNum.event_id = '" + eventID + "' " +
                "GROUP BY " +
                "substring(articleNum.start_time, 1, 10) " +
                ") sm2 " +
                ")";

        return (String[]) baseDAO.getSqlList(sql).get(0);
    }

    @Override
    public void updateEvent(TbEventEntity eventEntity) {
        baseDAO.update(eventEntity);
    }

    @Override
    public TbEventEntity getEventByName(String eventName) {
        String hql = "from TbEventEntity e where e.eventName = '"+eventName+"'";
        return (TbEventEntity) baseDAO.get(hql);
    }

    @Override
    public List<WebsiteEntity> getEventWebsite(String eventID) {
        String hql = "FROM WebsiteEntity website " +
                "WHERE website.id in " +
                "(" +
                "SELECT table.websiteId " +
                "FROM TbTableEntity table, TbSourceArticleNumEntity articleNum " +
                "WHERE table.id = articleNum.table.id AND articleNum.event.id = '" + eventID + "'" +
                ")";

        return baseDAO.find(hql);
    }

    @Override
    public List<Object[]> getEventArticleNumByWebsite(String eventID, String websiteName) {
        String hql = "SELECT articleNum.startTime, SUM(articleNum.num) " +
                "FROM TbSourceArticleNumEntity articleNum " +
                "WHERE articleNum.event.id = '" + eventID + "' AND articleNum.table.id IN (" +
                "SELECT table.id " +
                "FROM TbTableEntity table, WebsiteEntity website " +
                "WHERE website.websiteName = '" + websiteName + "' AND website.id = table.websiteId" +
                ")" +
                "GROUP BY articleNum.startTime";
        return baseDAO.find(hql);
    }

    @Override
    public List<TbEventEntity> getAllEvent() {
        String hql = "from TbEventEntity e";
        return baseDAO.find(hql);
    }
}

