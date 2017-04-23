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
    public void saveWebsite(WebsiteEntity website, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();

        boolean result = websiteService.saveNoIDWebsite(website);

        if(result) {
            out.print("success");
        } else {
            out.print("failure");
        }
    }

    @RequestMapping("checkSiteUrl")
    public void isExistUrl(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String url = req.getParameter("siteUrl");

        PrintWriter out = res.getWriter();

        if(url == null || url.equals("")) {
            out.print("null");
        } else {
            boolean result = websiteService.isExistUrl(url);

            if(result) {
                out.print("exist");
            } else {
                out.print("notExist");
            }
        }
    }

    @RequestMapping("checkSiteName")
    public void isExistName(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String name = req.getParameter("siteName");

        PrintWriter out = res.getWriter();

        if (name == null || name.equals("")) {
            out.print("null");
        } else {
            boolean result = websiteService.isExistName(name);

            if (result) {
                out.print("exist");
            } else {
                out.print("notExist");
            }
        }
    }

}
