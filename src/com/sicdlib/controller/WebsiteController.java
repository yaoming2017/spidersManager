package com.sicdlib.controller;

import com.sicdlib.dto.WebsiteEntity;
import com.sicdlib.service.IDataDictService;
import com.sicdlib.service.IWebsiteService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by haoyang on 2017/4/20.
 */
@Controller
public class WebsiteController {
    @Autowired
    @Qualifier("dataDictService")
    private IDataDictService dataDictService;

    @Autowired
    @Qualifier("websiteService")
    private IWebsiteService websiteService;

    @RequestMapping("addNewSite")
    public String addNewSite(HttpServletRequest req, HttpServletResponse resp, Model model) {
        String SITE_TYPE = "SITE_TYPE";
        List<String> siteValue = dataDictService.getDataDictValue(SITE_TYPE);
        model.addAttribute("siteVlaue", siteValue);

        return "addNewWebsite";
    }

    @RequestMapping("saveWebsite")
//    public String saveWebsite(@RequestParam("siteName") String siteName,
//                              @RequestParam("url") String url,
//                              @RequestParam("siteType") String siteType,
//                              Model model) {
    public String saveWebsite(WebsiteEntity website, HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();

        boolean result = websiteService.saveNoIDWebsite(website);

        if(result) {
            out.print("success");
        } else {
            out.print("failure");
        }
        out.print("success");


        return null;
    }

}
