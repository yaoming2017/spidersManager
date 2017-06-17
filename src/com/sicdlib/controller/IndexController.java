package com.sicdlib.controller;

import com.sicdlib.service.IIndexService;
import com.sicdlib.service.IWebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @Autowired
    @Qualifier("indexService")
    private IIndexService indexService;

    @RequestMapping("iindex")
    public void index(Model model) {
        indexService.test();
    }

}
