package com.sicdlib.controller;

import com.sicdlib.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by YH on 2017/5/24.
 */
@Controller
public class EventController {
    @Autowired
    @Qualifier("eventService")
    private IEventService eventService;

    @RequestMapping("event")
    public String event(HttpServletRequest req, Model model) {
//        String eventId = req.getParameter("eventID");
//        String introduction = eventService.eventIntroduction(eventId);
        String introduction = "本报告围绕关键词“#赵雅淇道歉#”，对2016/11/22 00:00~2016/11/23日 17:01期间，从微博上采集到的4919条信息进行了深入地分析。微博声量最高峰出现在2016/11/22 18，共有1230篇相关微博言论；疑似源头的微博讯息于2016/11/22 17:27发布在新浪微博标题为： 『【林丹“小三”#赵雅淇道歉#！】继#林丹...』。总体来说，整个微博事件的发展趋势较为突出，详细报告如下。";

        model.addAttribute("introduction", introduction);
        return "event";
    }
}
