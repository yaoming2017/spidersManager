package com.sicdlib.service;

import com.sicdlib.dto.TbEventArticleEntity;
import com.sicdlib.dto.TbEventEntity;
import com.sicdlib.dto.TbSentimentInflucenceEntity;

import java.util.List;

public interface IEventArticleService {
    Boolean saveOrUpdateEventArticle(TbEventArticleEntity eventArticle);
    //通过事件ID，开始时间，结束时间获得事件文章列表
    List<TbEventArticleEntity> getEventArticlesByStartEndTime(String eventId, String startTimeStr, String endTimeStr);
    //通过事件ID获得事件文章列表
    List<TbEventArticleEntity> getEventArticleByEventID(String eventID);
    //通过事件ID，开始时间，结束时间获得不同表名的评论数目
    List<TbSentimentInflucenceEntity> getInflucenceByStartEndTime(String eventId, String startTimeStr, String endTimeStr);

}
