package com.sicdlib.service.imple;

import com.sicdlib.dao.IDataDictDAO;
import com.sicdlib.dto.Constant;
import com.sicdlib.service.IEventService;
import com.sicdlib.dao.IEventDAO;
import com.sicdlib.dao.IStopWordsDAO;
import com.sicdlib.dto.TbEventEntity;
import com.sicdlib.service.IEventService;
import com.sicdlib.service.IStopWordsService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by YH on 2017/5/25.
 */
@Service("eventService")
public class EventService implements IEventService {
    @Autowired
    @Qualifier("dataDictDAO")
    private IDataDictDAO dataDictDAO;

    @Autowired
    @Qualifier("eventDAO")
    private IEventDAO eventDAO;

    @Override
    public String eventIntroduction() {
        String eventIntroTemplate = dataDictDAO.getDictValue(Constant.EVENT_INTRODUCTION).get(0);
        return null;
    }

    @Override
    public String eventTrendJson() {
        return null;
    }

    @Override
    public Boolean saveOrUpdateEvent(TbEventEntity event) {
        if (event.getId() == null){
            String uuid = UUIDUtil.getUUID();
            event.setId(uuid);
        }

        return eventDAO.saveOrUpdateEvent(event);
    }

}
