package com.sicdlib.controller;

import com.sicdlib.dto.KeyMeaningEntity;
import com.sicdlib.service.IKeyMeaningService;
import com.sicdlib.util.HBaseUtil.HBPage;
import com.sicdlib.util.HBaseUtil.HBaseData;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GhostController {

    @Autowired
    @Qualifier("keyMeaningService")
    public IKeyMeaningService keyMeaningService;

    @RequestMapping("ghostDouban")
    public String index() throws Exception{
        String htable_name = "";
        HBaseData hBaseData = null;
        /**
         * 豆瓣小组
         */
        //豆瓣小组 - 作者
        htable_name = "douban_group_author";
        hBaseData = new HBaseData(htable_name);
        hBaseData.getAllData();


//        //豆瓣小组 - 评论
//        htable_name = "douban_group_comment";
//        hBaseData = new HBaseData(htable_name);
//        List<String> douban_group_comment_fields = hBaseData.getKeys(htable_name);
//        model.addAttribute("douban_group_comment_fields", douban_group_comment_fields);
//        List<KeyMeaningEntity> douban_group_comment_keyMeaningEntities = keyMeaningService.getKeyMeanings(htable_name);
//        model.addAttribute("douban_group_comment_keyMeanings", douban_group_comment_keyMeaningEntities);
//
//        //豆瓣小组 - 发布
//        htable_name = "douban_group_post";
//        hBaseData = new HBaseData(htable_name);
//        List<String> douban_group_post_fields = hBaseData.getKeys(htable_name);
//        model.addAttribute("douban_group_post_fields", douban_group_post_fields);
//        List<KeyMeaningEntity> douban_group_post_keyMeaningEntities = keyMeaningService.getKeyMeanings(htable_name);
//        model.addAttribute("douban_group_post_keyMeanings", douban_group_post_keyMeaningEntities);



        return "index";
    }
}
