package com.sicdlib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by YH on 2017/6/6.
 */
@Controller
public class ArticleSpreadController {
    @RequestMapping("articleSpread")
    public String articleSpread(HttpServletRequest req) {
        String eventID = req.getParameter("eventID");

        return "article_spread";
    }
}
