package com.sicdlib.controller;

import com.alibaba.fastjson.JSON;
import com.sicdlib.service.IHotWordsService;
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
public class HotWordsController {
    @Autowired
    @Qualifier("hotWordsService")
    private IHotWordsService hotWordsService;

    @RequestMapping("hotWords")
    public String hotWords(HttpServletRequest req, Model model) {
        String eventID = req.getParameter("eventID");
        List<Map> hotWords = hotWordsService.getHotWordsMap(eventID);

        model.addAttribute("keyWords", JSON.toJSON(hotWords));
        model.addAttribute("eventID", eventID);

        return "hot_words";
    }

    @RequestMapping("setHotWords")
    public void setHotWords(HttpServletRequest req) {
        String eventID = req.getParameter("eventID");
        hotWordsService.setHotWords(eventID);
    }
}
