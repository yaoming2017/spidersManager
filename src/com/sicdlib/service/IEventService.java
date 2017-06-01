package com.sicdlib.service;

import com.sicdlib.dto.TbEventEntity;

import java.util.List;

/**
 * Created by YH on 2017/5/25.
 */
public interface IEventService {
    String eventIntroduction(String eventID);

    /**
     * 显示事件趋势的时间
     * @return
     */
    List<String> eventTrendDate(String eventID);

    /**
     * 显示事件的来源类型
     * @return
     */
    List<String> eventTrendDataType(String eventID);

    /**
     * 事件的趋势数据
     * @param dateList
     * @param dataTypeList
     * @return
     */
    int[][] eventTrendData(String eventID, List<String> dateList, List<String> dataTypeList);
    int[][] eventTrendData(String eventID);

    Boolean saveOrUpdateEvent(TbEventEntity event);
    String setEventAttributes(String eventID);
    TbEventEntity getEventByName(String eventName);
}
