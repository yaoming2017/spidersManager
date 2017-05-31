package com.sicdlib.service;

import com.sicdlib.dto.TbEventEntity;

/**
 * Created by YH on 2017/5/25.
 */
public interface IEventService {
    String eventIntroduction(String eventID);
    String eventTrendJson();
    Boolean saveOrUpdateEvent(TbEventEntity event);
    String setEventAttributes(String eventID);
    TbEventEntity getEventByName(String eventName);
}
