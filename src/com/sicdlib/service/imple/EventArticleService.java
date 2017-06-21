package com.sicdlib.service.imple;

import com.sicdlib.dao.IEventArticleDAO;
import com.sicdlib.dao.IEventDAO;
import com.sicdlib.dto.TbEventArticleEntity;
import com.sicdlib.dto.TbEventEntity;
import com.sicdlib.dto.TbSentimentInflucenceEntity;
import com.sicdlib.dto.entity.DoubanGroupPostEntity;
import com.sicdlib.service.IEventArticleService;
import com.sicdlib.service.IEventService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yh on 2016/9/8.
 */
@Service("eventArticleService")
public class EventArticleService implements IEventArticleService {
    @Autowired
    @Qualifier("eventArticleDAO")
    private IEventArticleDAO eventArticleDAO;

    @Override
    public Boolean saveOrUpdateEventArticle(TbEventArticleEntity eventArticle) {
        if (eventArticle.getId() == null){
            String uuid = UUIDUtil.getUUID();
            eventArticle.setId(uuid);
        }
        return eventArticleDAO.saveOrUpdateEventArticle(eventArticle);
    }

    @Override
    public List<TbEventArticleEntity> getEventArticlesByStartEndTime(String eventId, String startTimeStr, String endTimeStr) {
        return eventArticleDAO.getEventArticlesByStartEndTime(eventId, startTimeStr, endTimeStr);
    }

    @Override
    public List<TbEventArticleEntity> getEventArticleByEventID(String eventID) {
        return eventArticleDAO.getEventArticleByEventID(eventID);
    }

    @Override
    public List<TbSentimentInflucenceEntity> getInflucenceByStartEndTime(String eventId, String startTimeStr, String endTimeStr) {
        return eventArticleDAO.getInflucenceByStartEndTime(eventId, startTimeStr, endTimeStr);
    }

}
