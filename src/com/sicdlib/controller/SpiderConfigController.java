package com.sicdlib.controller;

import com.google.gson.Gson;
import com.sicdlib.dto.SpiderConfigItemTypeEntity;
import com.sicdlib.service.ISpiderConfigService;
import com.sicdlib.service.ISpiderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YH on 2017/4/28.
 */
@Controller
public class SpiderConfigController {
    @Autowired
    @Qualifier("spiderInfoService")
    private ISpiderInfoService spiderInfoService;

    @Autowired
    @Qualifier("spiderConfigService")
    private ISpiderConfigService spiderConfigService;

    @RequestMapping("spiderConfig")
    public String spiderConfig(HttpServletRequest req, Model model) {
        String spiderID = req.getParameter("spiderID");
        List<SpiderConfigItemTypeEntity> configItemList = spiderInfoService.getAllSpiderConfItemType();

        model.addAttribute("spiderID", spiderID);
        model.addAttribute("configItemList", configItemList);

        return "spiderConfig";
    }

    @RequestMapping("saveSpiderConfig")
    public void saveSpiderConfig(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String spider_id = req.getParameter("spider_id");
        String config = req.getParameter("config");

        Gson gson = new Gson();
        Map map = gson.fromJson(config, Map.class);

        boolean result = spiderConfigService.addConfig(spider_id, map);

        PrintWriter out = res.getWriter();

        if(result) {
            out.print("success");
        } else {
            out.print("failure");
        }

        out.flush();
        out.close();
    }

    @RequestMapping("getConfigItem")
    public void getConfigItem(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String spiderID = req.getParameter("spider_id");
        Map<String, List<Object[]>> configMap = spiderConfigService.getSpiderConfigItem(spiderID);

        Map result = new HashMap();
        if(configMap!=null) {
            result.put("result", "success");
            result.put("data", configMap);
        } else {
            result.put("result", "failure");
            result.put("data", "");
        }
        Gson gson = new Gson();
        String resultGson = gson.toJson(result);

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        out.print(resultGson);

        out.flush();
        out.close();
    }
}
