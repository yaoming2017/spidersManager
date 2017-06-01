package com.sicdlib.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YH on 2017/6/1.
 */
@Controller
public class HotWordsController {

    @RequestMapping("hotWords")
    public String hotWords(HttpServletRequest req, Model model) {
//        String eventID = req.getParameter("eventID");
//        List<Map> hotWords =
        List<Map> list = new ArrayList<>();
        Map<String, String> map1 = new HashMap<>();
        map1.put("name", "毫无关系");
        map1.put("value", "366.44");
        list.add(map1);

        Map<String, String> map2 = new HashMap<>();
        map2.put("name", "草率");
        map2.put("value", "220.21");
        list.add(map2);

        Map<String, String> map3 = new HashMap<>();
        map3.put("name", "抹泪");
        map3.put("value", "399.00001");
        list.add(map3);

        model.addAttribute("keyWords", JSON.toJSON(list));

        return "hot_words";
    }
}
