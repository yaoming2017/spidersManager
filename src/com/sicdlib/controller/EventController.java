package com.sicdlib.controller;

import com.alibaba.fastjson.JSON;
import com.sicdlib.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by YH on 2017/5/24.
 */
@Controller
public class EventController {
    @Autowired
    @Qualifier("eventService")
    private IEventService eventService;

    @RequestMapping("event")
    public String event(HttpServletRequest req, Model model, HttpServletResponse resp) {
//        String eventId = req.getParameter("eventID");
//        String introduction = eventService.eventIntroduction(eventId);
//        List<String> dataTypeList = eventService.eventTrendDataType(eventId);
//        List<String> dateList = eventService.eventTrendDate(eventId);

//        int[][] data = eventService.eventTrendData(eventId);

        String introduction = "本报告围绕关键词“#赵雅淇道歉#”，对2016/11/22 00:00~2016/11/23日 17:01期间，从微博上采集到的4919条信息进行了深入地分析。微博声量最高峰出现在2016/11/22 18，共有1230篇相关微博言论；疑似源头的微博讯息于2016/11/22 17:27发布在新浪微博标题为： 『【林丹“小三”#赵雅淇道歉#！】继#林丹...』。总体来说，整个微博事件的发展趋势较为突出，详细报告如下。";
        List<String> dataTypeList = Arrays.asList("原创", "转发", "媒体");
        List<String> dateList = Arrays.asList("2016-11-22 00", "2016-11-22 01","2016-11-22 02","2016-11-22 03",
                "2016-11-22 04","2016-11-22 05","2016-11-22 06","2016-11-22 07","2016-11-22 08","2016-11-22 09",
                "2016-11-22 10","2016-11-22 11", "2016-11-22 12","2016-11-22 13", "2016-11-22 14","2016-11-22 15",
                "2016-11-22 16","2016-11-22 17","2016-11-22 18","2016-11-22 19","2016-11-23 20", "2016-11-22 21",
                "2016-11-22 22","2016-11-22 23","2016-11-23 00","2016-11-23 01","2016-11-23 02","2016-11-23 03",
                "2016-11-23 04","2016-11-23 05","2016-11-23 06","2016-11-23 07","2016-11-23 08","2016-11-23 09",
                "2016-11-23 10","2016-11-23 11", "2016-11-23 12","2016-11-23 13","2016-11-23 14","2016-11-23 15",
                "2016-11-23 16","2016-11-23 17");
        int [][] data = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 42, 99, 77, 64, 95, 60, 35, 20, 1, 3, 0,
                1, 2, 7, 21, 27, 38, 27, 9, 6, 13, 12, 14, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 23, 1188, 713, 66, 62, 686, 539, 145, 43, 11, 3, 6,
                        7, 14, 27, 20, 112, 122, 143, 137, 77, 24, 27, 18, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 2, 3, 0, 0, 0, 0, 1, 3, 0, 1, 2, 1, 2, 1,
                        0, 0, 0, 0, 0, 1, 2, 0}
        };
        model.addAttribute("introduction", introduction);
        model.addAttribute("dataType", JSON.toJSON(dataTypeList));
        model.addAttribute("dateList", JSON.toJSON(dateList));
        model.addAttribute("data", JSON.toJSON(data));
        return "event";
    }
}
