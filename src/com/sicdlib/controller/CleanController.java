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
public class CleanController {
    @Autowired
    @Qualifier("websiteService")
    private IWebsiteService websiteService;

    @RequestMapping("source_datas_display")
    public String source_datas_display(Model model) {

        return "source_datas_display";
    }

    @RequestMapping("cleaned_datas")
    public String cleaned_datas(Model model) {

        return "cleaned_datas";
    }

}
