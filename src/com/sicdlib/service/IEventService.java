package com.sicdlib.service;

import com.sicdlib.dto.TbEventEntity;

import java.util.List;

public interface IEventService {
    Boolean saveOrUpdateEvent(TbEventEntity event);
}
