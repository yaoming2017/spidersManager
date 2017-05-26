package com.sicdlib.dao;

import com.sicdlib.dto.TbEventArticleEntity;
import com.sicdlib.dto.TbEventEntity;
import com.sicdlib.dto.WebsiteEntity;

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
    List getKeyWords(String eventID, int limit);

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
    int eventArticleNum(String eventID);

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
}
