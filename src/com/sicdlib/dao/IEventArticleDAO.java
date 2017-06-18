package com.sicdlib.dao;

import com.sicdlib.dto.TbEventArticleEntity;
import com.sicdlib.dto.TbEventEntity;

import java.util.List;

/**
 * Created by YH on 2017/5/26.
 */
public interface IEventArticleDAO {
    String getArticleTitle(String tableID, String articleID);
    String getArticleDateTime(String tableID, String articleID);
    Boolean saveOrUpdateEventArticle(TbEventArticleEntity eventArticle);
    TbEventArticleEntity getEventArticleEntity(String id);
    //通过事件ID，开始时间，结束时间获得事件文章列表
    List<TbEventArticleEntity> getEventArticlesByStartEndTime(String eventId, String startTimeStr, String endTimeStr);
    //通过事件ID获得事件文章列表
    List<TbEventArticleEntity> getEventArticleByEventID(String eventID);
}
