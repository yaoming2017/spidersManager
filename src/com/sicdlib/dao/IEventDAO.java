package com.sicdlib.dao;

import com.sicdlib.dto.TbEventEntity;

import java.util.List;

public interface IEventDAO {
    Boolean saveOrUpdateEvent(TbEventEntity event);
}
