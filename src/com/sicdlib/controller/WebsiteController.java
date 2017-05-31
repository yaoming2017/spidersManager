package com.sicdlib.controller;

import com.sicdlib.dao.IStopWordsDAO;
import com.sicdlib.dto.WebsiteEntity;
import com.sicdlib.service.IDataDictService;
import com.sicdlib.service.IWebsiteService;
import com.sicdlib.util.KeyWordsUtil.KeyWordsExtract;
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
import java.util.ArrayList;
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

    @Autowired
    @Qualifier("stopWordsDAO")
    private IStopWordsDAO stopWordsDAO;

    @RequestMapping("keywords")
    public void test(HttpServletRequest req, HttpServletResponse resp) {
        List<String> stops = stopWordsDAO.getAllStopWords();
        List<String> strList = new ArrayList<>();
        String str = "动力方面：2017款宝马X6 V8的功率和动力特性很大程度上得益于双涡轮增压技术，"
                + "在8缸发动机上首次采用了两个涡轮以最大效率同时提升发动机功率和扭矩。一个涡轮增压器一次为4个气缸供给压缩空气，确保格外流畅的运转与对油门踏板的直接响应。"
                + "与采用双涡轮增压技术的直六发动机一样，传统涡轮增压发动机典型的“涡轮迟滞”，即涡轮增压器形成功率和增压压力所需的时间滞后，通过这一先进技术几乎被完全消除。";
        strList.add(str);
        KeyWordsExtract key =  new KeyWordsExtract();
        System.out.println(key.getKeyword(strList, stops));
    }
}
