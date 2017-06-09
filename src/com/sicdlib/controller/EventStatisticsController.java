package com.sicdlib.controller;

import com.alibaba.fastjson.JSON;
import com.sicdlib.service.IEventStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by YH on 2017/6/1.
 */
@Controller
public class EventStatisticsController {
    @Autowired
    @Qualifier("eventStatisticsService")
    private IEventStatisticsService eventStatisticsService;

    @RequestMapping("sourceWebsiteStatistics")
    public String sourceWebsiteStatistics(HttpServletRequest req, Model model) {
        String eventID = req.getParameter("eventID");
        List<Map> websiteNumList = eventStatisticsService.getMediaSourceStatistics(eventID);

        model.addAttribute("websiteNum", JSON.toJSON(websiteNumList));
        model.addAttribute("eventID", eventID);

        return "sourceMedia";
    }
}
