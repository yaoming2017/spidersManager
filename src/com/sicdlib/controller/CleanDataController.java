package com.sicdlib.controller;

import com.sicdlib.dto.WebsiteEntity;
import com.sicdlib.service.IWebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Controller
public class CleanDataController {
    @Autowired
    @Qualifier("websiteService")
    private IWebsiteService websiteService;

    @RequestMapping("clean_data")
    public String clean_data(HttpServletRequest req, Model model) {

        return "clean_data";
    }

    @RequestMapping("clean_data_display")
    public String clean_data_display(Model model) {

        return "clean_data_display";
    }

}
