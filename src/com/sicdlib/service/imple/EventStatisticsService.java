package com.sicdlib.service.imple;

import com.sicdlib.dao.IEventStatisticsDAO;
import com.sicdlib.service.IEventStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YH on 2017/6/2.
 */
@Service("eventStatisticsService")
public class EventStatisticsService implements IEventStatisticsService {
    @Autowired
    @Qualifier("eventStatisticsDAO")
    private IEventStatisticsDAO eventStatisticsDAO;

    @Override
    public List<Map> getMediaSourceStatistics(String eventID) {
        List<Object[]> websiteArticleNumList = eventStatisticsDAO.getEventWebsiteArticleNum(eventID);

        List<Map> result = new ArrayList<>();
        for(Object[] articleNum: websiteArticleNumList) {
            Map<String, String> numMap = new HashMap<>();

            numMap.put("name", (String) articleNum[0]);
            numMap.put("value", Long.toString((Long) articleNum[1]));

            result.add(numMap);
        }

        return result;
    }
}
