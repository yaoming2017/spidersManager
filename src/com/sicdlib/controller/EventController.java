package com.sicdlib.controller;

import com.alibaba.fastjson.JSON;
import com.sicdlib.service.IArticleSimiService;
import com.sicdlib.service.IEventService;
import com.sicdlib.service.IHotWordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by YH on 2017/5/24.
 */
@Controller
public class EventController {
    @Autowired
    @Qualifier("eventService")
    private IEventService eventService;

    @Autowired
    @Qualifier("hotWordsService")
    private IHotWordsService hotWordsService;

    @Autowired
    @Qualifier("articleSimiService")
    private IArticleSimiService articleSimiService;

    @RequestMapping("event")
    public String event(HttpServletRequest req, Model model, HttpServletResponse resp) {
        String eventId = req.getParameter("eventID");
        String introduction = eventService.eventIntroduction(eventId);
        List<String> dataTypeList = eventService.eventTrendDataType(eventId);
        List<String> dateList = eventService.eventTrendDate(eventId);

        int[][] data = eventService.eventTrendData(eventId);

        model.addAttribute("introduction", introduction);
        model.addAttribute("dataType", JSON.toJSON(dataTypeList));
        model.addAttribute("dateList", JSON.toJSON(dateList));
        model.addAttribute("data", JSON.toJSON(data));
        model.addAttribute("eventID", eventId);

        return "event";
    }

    @RequestMapping("setEventAttributes")
    public void setEventAttributes(HttpServletRequest req) {
        String eventID = req.getParameter("eventID");
//        eventID = "ef4edd79-c167-48c9-960e-aadad7eaa327";
//        eventID = "c2c82ae3-a939-4bb3-a31e-ba540920e00f";
        hotWordsService.setHotWords(eventID);
        eventService.setEventAttributes(eventID);
        articleSimiService.setEventArticleSimi(eventID);
    }
}
