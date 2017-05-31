package com.sicdlib.service.imple;

import com.sicdlib.dao.IEventDAO;
import com.sicdlib.dao.IStopWordsDAO;
import com.sicdlib.dto.TbEventEntity;
import com.sicdlib.service.IEventService;
import com.sicdlib.service.IStopWordsService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yh on 2016/9/8.
 */
@Service("eventService")
public class EventService implements IEventService{
    @Autowired
    @Qualifier("eventDAO")
    private IEventDAO eventDAO;

    @Override
    public Boolean saveOrUpdateEvent(TbEventEntity event) {
        if (event.getId() == null){
            String uuid = UUIDUtil.getUUID();
            event.setId(uuid);
        }
        return eventDAO.saveOrUpdateEvent(event);
    }

    @Override
    public TbEventEntity getEventByName(String eventName) {
        return eventDAO.getEventByName(eventName);
    }

}
