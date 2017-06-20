package com.sicdlib.controller;

import com.alibaba.fastjson.JSON;
import com.sicdlib.service.IAuthorService;
import com.sicdlib.service.IIndexService;
import com.sicdlib.service.ITableService;
import com.sicdlib.service.IWebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

@Controller
public class IndexController {
    @Autowired
    @Qualifier("tableService")
    private ITableService tableService;

    @Autowired
    @Qualifier("authorService")
    private IAuthorService authorService;

    @RequestMapping("setAuthor")
    public void setAuthor(HttpServletRequest req) throws Exception {
        String eventID = req.getParameter("eventID");

        tableService.setAuthorAttributes(eventID);
    }

    @RequestMapping("authorIndex")
    public String showAuthorIndex(HttpServletRequest req, Model model) throws UnsupportedEncodingException {
        String eventID = req.getParameter("eventID");

        Map<String, Map> result = new HashMap<>();

        if (eventID != null && !eventID.equals("")) {
            result = authorService.getAuthorInfluenceAndActiveness(eventID);
        }

        model.addAttribute("influenceAndActiveness", JSON.toJSON(result));

        return "author_index";
    }

}
