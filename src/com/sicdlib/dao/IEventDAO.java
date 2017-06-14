package com.sicdlib.dao;

import com.sicdlib.dto.*;

import java.util.List;

/**
 * Created by YH on 2017/5/25.
 */
public interface IEventDAO {
    /**
     * 获取事件的关键词
     * @param eventID
     * @param limit
     * @return
     */
    List<TbHotWordEntity> getKeyWords(String eventID, int limit);

    /**
     * 事件的开始时间
     * @param eventID
     * @return
     */
    String startDatetime(String eventID);

    /**
     * 事件的结束时间
     * @param eventID
     * @return
     */
    String endDatetime(String eventID);

    /**
     * 事件相关的文章总条数
     * @param eventID
     * @return
     */
    Long eventArticleNum(String eventID);

    /**
     * 事件的高峰时间
     * @param eventID
     * @return
     */
    String rushDate(String eventID);

    /**
     * 高峰时间事件的数量
     * @param eventID
     * @return
     */
    int rushNum(String eventID);

    /**
     * 事件源头的发布时间
     * @param eventID
     * @return
     */
    String sourceDateTime(String eventID);

    /**
     * 源头文章的标题
     * @param eventID
     * @return
     */
    String sourceArticleTitle(String eventID);

    /**
     * 来源网站
     * @param eventID
     * @return
     */
    WebsiteEntity sourceWebsite(String eventID);

    /**
     * 整个事件来源网站
     * @param eventID
     * @return
     */
    List<WebsiteEntity> sourceWebsiteList(String eventID);


    /**
     * 整个事件的发展趋势
     * @param eventID
     * @return
     */
    String eventTrend(String eventID);

    /**
     * 获取事件实体
     * @param eventID
     * @return
     */
    TbEventEntity getEvent(String eventID);

    /**
     * 根据时间获取源头时间文章
     * @param eventID
     * @return
     */
    TbEventArticleEntity getSourceEventArticle(String eventID);

    Boolean saveOrUpdateEvent(TbEventEntity event);

    /**
     * 计算事件开始时间
     * @param eventID
     * @return
     */
    TbEventArticleEntity getSourceEventEntity(String eventID);

    /**
     * 计算事件结束时间
     * @param eventID
     * @return
     */
    String getEventEndTime(String eventID);

    /**
     * 从sourceArticleNum表中获取事件的高峰时间
     * @param eventID
     * @return
     */
    Object[] getRushTimeAndNum(String eventID);

    /**
     * 保存事件
     * @param eventEntity
     */
    void updateEvent(TbEventEntity eventEntity);

    TbEventEntity getEventByName(String eventName);

    /**
     * 获取事件来源的网站
     * @param eventID
     * @return
     */
    List<WebsiteEntity> getEventWebsite(String eventID);

    /**
     * 获取事件下某一网站的文章数量
     * @param eventID
     * @param websiteName
     * @return
     */
    List<Object[]> getEventArticleNumByWebsite(String eventID, String websiteName);

    /**
     * 获取所有的事件
     * @return eventList
     */
    List<TbEventEntity> getAllEvent();

    /**
     * 获取事件中文章的时间以及热度，并按时间升序排列
     * @param eventID 事件ID
     * @return 时间和热度的二元组
     */
    List<Object[]> getEventArticleDateAndHotValue(String eventID);
}
