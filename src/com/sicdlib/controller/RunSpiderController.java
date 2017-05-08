package com.sicdlib.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by YH on 2017/5/8.
 */
public class RunSpiderController {

    @RequestMapping("runSpider")
    public String runSpider(HttpServletRequest req, HttpServletResponse resp) {
        String spiderID = req.getParameter("spiderID");
        String configID = req.getParameter("configID");
        //获取爬虫的路径

        return null;
    }
}
