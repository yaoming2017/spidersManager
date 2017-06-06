package com.sicdlib.service.imple;

import com.sicdlib.dao.IDataDictDAO;
import com.sicdlib.dto.*;
import com.sicdlib.service.IEventService;
import com.sicdlib.dao.IEventDAO;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public String eventIntroduction(String eventID) {
//        //事件简介的模板
//        String eventIntroTemplate = dataDictDAO.getDictValue(Constant.EVENT_INTRODUCTION).get(0);
//
//        //关键词，取前三个，并用加号拼接
//        List<TbHotWordEntity> keyWordsEntity = eventDAO.getKeyWords(eventID, 3);
//        List<String> keyWords = new ArrayList<>();
//
//        for (TbHotWordEntity hotWords: keyWordsEntity) {
//            keyWords.add(hotWords.getName());
//        }
//
//        String keyWordsStr = StringUtils.join(keyWords.toArray(),"+");
//
//        TbEventEntity event = eventDAO.getEvent(eventID);
//
//        //事件的开始时间
//        String eventStartDate = event.getEventStartTime();
//
//        //事件的结束时间
//        String eventEndDate = event.getEventEndTime();
//
//        //整个事件的文章数量
//        int articleNum = eventDAO.eventArticleNum(eventID);
//
//        //源文章的标题
//        String sourceTitle = eventDAO.sourceArticleTitle(eventID);
//
//        //事件发生的高峰日期
//        String rushDate = eventDAO.rushDate(eventID);
//
//        //高峰时间的文章数量
//        int rushNum = eventDAO.rushNum(eventID);
//
//        //文章出现的网站名，并用顿号拼接
//        List<WebsiteEntity> websiteList = eventDAO.sourceWebsiteList(eventID);
//        String websiteStr = "";
//        for (WebsiteEntity website: websiteList) {
//            websiteStr = websiteStr + website.getWebsiteName() + "、";
//        }
//        websiteStr = websiteStr.substring(0, websiteStr.length() - 1);
//
//        //事件的来源网站
//        String sourceWebsite = eventDAO.sourceWebsite(eventID).getWebsiteName();
//
//        //事件的趋势
//        String trend = eventDAO.eventTrend(eventID);
//
//        //格式化事件简介模板
//        String introduction = String.format(eventIntroTemplate, keyWordsStr, eventStartDate,
//                eventEndDate, articleNum, rushDate, rushNum, eventStartDate, sourceWebsite,
//                sourceTitle, websiteStr, trend);
        String introduction = eventDAO.getEvent(eventID).getEventIntroduction();

        return introduction;
    }

    @Override
    public List<String> eventTrendDate(String eventID) {
        TbEventEntity event = eventDAO.getEvent(eventID);
        String startTime = event.getEventStartTime();
        String endTime = event.getEventEndTime();

        SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = sdf.parse(startTime);
            endDate = sdf.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long hourSecond = 60 * 60 * 1000;
        assert endDate != null;
        assert startDate != null;
        List<String> dateList = new ArrayList<>();
        for(long i = startDate.getTime(); i < endDate.getTime(); i += hourSecond) {
            String dateTime = (new SimpleDateFormat("yyyy-MM-dd HH")).format(new Date(i));
            dateList.add(dateTime);
        }

        return dateList;
    }

    @Override
    public List<String> eventTrendDataType(String eventID) {
        List<WebsiteEntity> websiteList = eventDAO.getEventWebsite(eventID);

        List<String> dataTypeList = new ArrayList<>();

        for(WebsiteEntity website: websiteList) {
            dataTypeList.add(website.getWebsiteName());
        }

        return dataTypeList;
    }

    @Override
    public int[][] eventTrendData(String eventID, List<String> dateList, List<String> dataTypeList) {
        int data[][] = new int[dataTypeList.size()][dateList.size()];
        for (int i = 0; i < dataTypeList.size(); i++) {
            for (int j = 0; j < dateList.size(); j++) {
                data[i][j] = 0;
            }
        }

        for(int i = 0; i < dataTypeList.size(); i++) {
            String websiteName = dataTypeList.get(i);

            List<Object[]> typeDataList = eventDAO.getEventArticleNumByWebsite(eventID, websiteName);
            for(Object[] typeData: typeDataList) {
                String dateStr = ((String) typeData[0]).substring(0, 13);

                int j = dateList.indexOf(dateStr);
                if(j != -1) {
                    data[i][j] = ((Long) typeData[1]).intValue();
                }
            }
        }

        return data;
    }

    @Override
    public int[][] eventTrendData(String eventID) {
        List<String> dateList = this.eventTrendDate(eventID);
        List<String> dataTypeList = this.eventTrendDataType(eventID);

        return this.eventTrendData(eventID, dateList, dataTypeList);
    }

    @Override
    public Boolean saveOrUpdateEvent(TbEventEntity event) {
        if (event.getId() == null){
            String uuid = UUIDUtil.getUUID();
            event.setId(uuid);
        }

        return eventDAO.saveOrUpdateEvent(event);
    }

    @Override
    public String setEventAttributes(String eventID) {
        //从事件文章中获取事件的开始时间
        TbEventArticleEntity sourceArticle = eventDAO.getSourceEventArticle(eventID);
        String startTime = sourceArticle.getTime();

        //从事件文章中获取事件的结束时间
        String endTime = eventDAO.getEventEndTime(eventID);

        //从事件文章中获取事件的高峰时间
        //从事件文章中获取事件的高峰时间当天的文章量
        Object[] rushTimeAndNum = eventDAO.getRushTimeAndNum(eventID);

        String rushTime = "";
        int rushNum = 0;
        if(rushTimeAndNum != null && rushTimeAndNum.length == 2) {
            rushTime = (String) rushTimeAndNum[0];
            BigDecimal bigTime = (BigDecimal) rushTimeAndNum[1];
            rushNum = bigTime.intValue();
        }

        //获取源头文章的ID
        String sourceArticleID = sourceArticle.getSourceArticleId();

        //计算事件的趋势
        String trend = eventDAO.eventTrend(eventID);

        //事件的简介
        String eventIntroTemplate = dataDictDAO.getDictValue(Constant.EVENT_INTRODUCTION).get(0);

        List<TbHotWordEntity> keyWordsEntity = eventDAO.getKeyWords(eventID, 3);
        List<String> keyWords = new ArrayList<>();

        for (TbHotWordEntity hotWords: keyWordsEntity) {
            keyWords.add(hotWords.getName());
        }

        String keyWordsStr = StringUtils.join(keyWords.toArray(),"+");

        long articleNum = eventDAO.eventArticleNum(eventID);

        String sourceWebsite = eventDAO.sourceWebsite(eventID).getWebsiteName();

        //源文章的标题
        String sourceTitle = eventDAO.sourceArticleTitle(eventID);

        //文章出现的网站名，并用顿号拼接
        List<WebsiteEntity> websiteList = eventDAO.sourceWebsiteList(eventID);
        String websiteStr = "";
        for (WebsiteEntity website: websiteList) {
            websiteStr = websiteStr + website.getWebsiteName() + "、";
        }
        websiteStr = websiteStr.substring(0, websiteStr.length() - 1);

        String introduction = String.format(eventIntroTemplate, keyWordsStr, startTime,
                endTime, articleNum, rushTime, rushNum, startTime, sourceWebsite,
                sourceTitle, websiteStr, trend);

        TbEventEntity event = eventDAO.getEvent(eventID);
        event.setEventStartTime(startTime);
        event.setEventEndTime(endTime);
        event.setEventRushTime(rushTime);
        event.setEventRushNum(rushNum);
        event.setEventTrend(trend);
        event.setEventSourceArticleId(sourceArticleID);
        event.setEventIntroduction(introduction);

        eventDAO.updateEvent(event);

        return "";
    }

    @Override
    public TbEventEntity getEventByName(String eventName) {
        return eventDAO.getEventByName(eventName);
    }

    @Override
    public List<TbEventEntity> getAllEvent() {
        return eventDAO.getAllEvent();
    }
}
