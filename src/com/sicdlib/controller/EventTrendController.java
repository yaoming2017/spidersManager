package com.sicdlib.controller;


import com.sicdlib.dto.TableHotValue;
import com.sicdlib.dto.TbEventArticleEntity;
import com.sicdlib.service.IEventArticleService;
import com.sicdlib.service.IEventService;
import com.sicdlib.util.ForeUtil.HotValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by YH on 2017/5/24.
 */
@Controller
public class EventTrendController {
    @Autowired
    @Qualifier("eventService")
    private IEventService eventService;

    @Autowired
    @Qualifier("eventArticleService")
    private IEventArticleService eventArticleService;

    @RequestMapping("eventTrend")
    public String event(HttpServletRequest req, Model model) {
        String eventID = req.getParameter("eventID");
        List<TableHotValue> tableHotValues = new ArrayList<TableHotValue>();
        //1. 获得事件的开始文章
        TbEventArticleEntity starttimeEventArticle = eventService.getSourceEventArticle(eventID);
        //2. 获得事件的结束文章
        TbEventArticleEntity EndtimeEventArticle = eventService.getEndtimeSourceEventArticle(eventID);
        //3. 时间平均划分10份，求每份中的热度
        String startTimeStr = starttimeEventArticle.getTime();
        String endTimeStr = EndtimeEventArticle.getTime();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = sf.parse(startTimeStr);
            endDate = sf.parse(endTimeStr);
        }catch (Exception e){
            e.printStackTrace();
        }
        int days = (int) ((endDate.getTime() - startDate.getTime()) / (1000*3600*24));
        /**
         * 策略：时间T
         * 1) T>10天,     按天计算，选取10个时间节点
         * 2) 10天>T>1天, 按每天计算
         * 3) T<1天,      按每2小时计算
         *
         */
        //1) T>10天
        if (days > 10){
            int internalDay = days / 10;
            //获得不同时间点的热度
            for (int i = 1 ; i < 11 ; i++){
                Calendar ca = Calendar.getInstance();
                ca.setTime(startDate);
                ca.add(Calendar.DATE, internalDay*(i-1));
                String starttime = sf.format(ca.getTime());
                ca.setTime(startDate);
                ca.add(Calendar.DATE, internalDay*i);
                String endtime = sf.format(ca.getTime());
                //通过不同事件ID，开始时间，结束时间获得事件文章列表
                List<TbEventArticleEntity> eventArticles = eventArticleService.getEventArticlesByStartEndTime(eventID, starttime, endtime);
//                //获得热度值：
//                List<String> sourceArticles = new ArrayList<>();
//                for (TbEventArticleEntity ea : eventArticles){
//                    sourceArticles.add(ea.getSourceArticleId());
//                }
                //获得热度值
                TableHotValue tableHotValue = null;
                List<TableHotValue> tableHotValues_temp = HotValueUtil.getTableHotValueByArticles(eventArticles);
                System.out.println(tableHotValues_temp);
                if (tableHotValues_temp != null && tableHotValues_temp.size() > 0){
                    tableHotValue = HotValueUtil.getTableHotValueByArticles(eventArticles).get(0);
                }
                if (tableHotValue != null){
                    tableHotValues.add(tableHotValue);
                }
            }
        }
        //2) 10天>T>1天
        else if(days<10 && days > 1){
            for (int i = 1; i < days+1; i++){
                Calendar ca = Calendar.getInstance();
                ca.setTime(startDate);
                ca.add(Calendar.DATE, (i-1));
                String starttime = sf.format(ca.getTime());
                ca.setTime(startDate);
                ca.add(Calendar.DATE, i);
                String endtime = sf.format(ca.getTime());
                //通过不同事件ID，开始时间，结束时间获得事件文章列表
                List<TbEventArticleEntity> eventArticles = eventArticleService.getEventArticlesByStartEndTime(eventID, starttime, endtime);
                //获得热度值
                TableHotValue tableHotValue = null;
                if (HotValueUtil.getTableHotValueByArticles(eventArticles) != null){
                    tableHotValue = HotValueUtil.getTableHotValueByArticles(eventArticles).get(0);
                }
                if (tableHotValue != null){
                    tableHotValues.add(tableHotValue);
                }
            }
        }
        //3) T<1天
        else{
            int hours = (int) ((endDate.getTime() - startDate.getTime()) / (1000*3600));
            for (int i = 1; i < hours/2; i++){
                GregorianCalendar cal = new GregorianCalendar();
                cal.setTime(startDate);
                //按小时（10）相加减
                cal.add(10, i-1);
                String starttime = sf.format(cal.getTime());
                cal.setTime(startDate);
                cal.add(10, i);
                String endtime = sf.format(cal.getTime());
                //通过不同事件ID，开始时间，结束时间获得事件文章列表
                List<TbEventArticleEntity> eventArticles = eventArticleService.getEventArticlesByStartEndTime(eventID, starttime, endtime);
                //获得热度值
                TableHotValue tableHotValue = null;
                if (HotValueUtil.getTableHotValueByArticles(eventArticles) != null){
                    tableHotValue = HotValueUtil.getTableHotValueByArticles(eventArticles).get(0);
                }
                if (tableHotValue != null){
                    tableHotValues.add(tableHotValue);
                }
            }
        }
        model.addAttribute("tableHotValues", tableHotValues);
        model.addAttribute("eventID", eventID);
        return "eventTrend";
    }
}
