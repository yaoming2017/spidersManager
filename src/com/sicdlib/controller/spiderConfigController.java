package com.sicdlib.controller;

import com.sicdlib.dto.SpiderConfigItemEntity;
import com.sicdlib.dto.SpiderConfigItemTypeEntity;
import com.sicdlib.service.imple.ISpiderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by YH on 2017/4/28.
 */
@Controller
public class spiderConfigController {
    @Autowired
    @Qualifier("spiderInfoService")
    private ISpiderInfoService spiderInfoService;

    @RequestMapping("spiderConfig")
    public String spiderConfig(HttpServletRequest req, Model model) {
        String spiderID = req.getParameter("spiderID");
        List<SpiderConfigItemTypeEntity> configItemList = spiderInfoService.getAllSpiderConfItemType();

        spiderID = "928";
        model.addAttribute("spiderID", spiderID);
        model.addAttribute("configItemList", configItemList);

        return "spiderConfig";
    }

    @RequestMapping("saveSpiderConfig")
    public void saveSpiderConfig(HttpServletRequest req, Model model) {
        String spider_id = req.getParameter("spider_id");
        String config = req.getParameter("config");

    }
}
