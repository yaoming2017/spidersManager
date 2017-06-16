package com.sicdlib.controller;

import com.sicdlib.service.IArticleSimiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by YH on 2017/6/5.
 */
@Controller
public class ArticleSimiController {
    @Autowired
    @Qualifier("articleSimiService")
    private IArticleSimiService articleSimiService;

    @RequestMapping("setArticleSimi")
    public void ArticleSimi(HttpServletRequest req) {
        String eventID = req.getParameter("eventID");
        articleSimiService.setEventArticleSimi(eventID);
    }
}
