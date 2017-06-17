package com.sicdlib.controller;


import com.alibaba.fastjson.JSON;
import com.sicdlib.dto.SourceArticleNum;
import com.sicdlib.dto.TableHotValue;
import com.sicdlib.dto.TbEventArticleEntity;
import com.sicdlib.service.*;
import com.sicdlib.service.pythonService.*;
import com.sicdlib.util.ForeUtil.HotValueUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by init on 2017/6/14.
 */
@Controller
public class InflucenceController {
    @Autowired
    @Qualifier("sentimentInflucenceService")
    ISentimentInflucenceService sentimentInflucenceService;


    @Autowired
    @Qualifier("eventService")
    private IEventService eventService;

    @Autowired
    @Qualifier("eventArticleService")
    private IEventArticleService eventArticleService;

    @Autowired
    @Qualifier("tableService")
    private ITableService tableService;

    @Autowired
    @Qualifier("sourceArticleNumService")
    private ISourceArticleNumService sourceArticleNumService;

    /**
     *各个网站
     */
    @Autowired
    @Qualifier("doubanGroupPostService")
    private IDoubanGroupPostService doubanGroupPostService;

    @Autowired
    @Qualifier("kdnetPostService")
    private IKDNETPostService kdnetPostService;

    @Autowired
    @Qualifier("bbsSohuPostService")
    private IBBSSohuPostService bbsSohuPostService;

    @Autowired
    @Qualifier("bbsTianyaPostService")
    private IBBSTianyaPostService bbsTianyaPostService;


    @Autowired
    @Qualifier("bbsXiciPostService")
    private IBBSXiciPostService bbsXiciPostService;

//    @RequestMapping(value="influcence")
//    public String listDailyCommentNum(HttpServletRequest req, Model model){
//        String postId = req.getParameter("postId");
//        List<Map> commentNum = sentimentInflucenceService.getSentimentInflucenceMap(postId);
//        model.addAttribute("keyWords",JSON.toJSON(commentNum));
//        return null;
//    }

    @RequestMapping(value="influcence")
    public String listDailyCommentNum(HttpServletRequest req, Model model){
        List<SourceArticleNum> sourceArticleNums = new ArrayList<>();
        String eventID = req.getParameter("eventID");
        List<TbEventArticleEntity>  eventArticles = eventArticleService.getEventArticleByEventID(eventID);
        //1. 获得事件的开始文章
        TbEventArticleEntity starttimeEventArticle = eventService.getSourceEventArticle(eventID);
        //2. 获得事件的结束文章
        TbEventArticleEntity EndtimeEventArticle = eventService.getEndtimeSourceEventArticle(eventID);

        //3. 时间平均划分10份，求每份中的热度
        String startTimeStr = starttimeEventArticle.getTime();
        String endTimeStr = EndtimeEventArticle.getTime();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = sf.parse(startTimeStr);
            endDate = sf.parse(endTimeStr);
        }catch (Exception e){
            e.printStackTrace();
        }
        int days = (int) ((endDate.getTime() - startDate.getTime()) / (1000*3600*24));
        /**
         * 策略：时间T
         * 1) T>10天,     按天计算，选取10个时间节点
         * 2) 10天>T>1天, 按每天计算
         * 3) T<1天,      按每2小时计算
         *
         */
        //1) T>10天
        if (days > 10){
            int internalDay = days / 10;
            //获得不同时间点的热度
            for (int i = 1 ; i < 11 ; i++){
                Calendar ca = Calendar.getInstance();
                ca.setTime(startDate);
                ca.add(Calendar.DATE, internalDay*(i-1));
                String starttime = sf.format(ca.getTime());
                ca.setTime(startDate);
                ca.add(Calendar.DATE, internalDay*i);
                String endtime = sf.format(ca.getTime());
                //通过不同事件ID，开始时间，结束时间获得事件文章列表
                List<TbEventArticleEntity> eventArticles_time = eventArticleService.getEventArticlesByStartEndTime(eventID, starttime, endtime);
                int doubanNum = 0;
                int bbs_peopleNum = 0;
                SourceArticleNum sourceArticleNum_douban = new SourceArticleNum();
                SourceArticleNum sourceArticleNum_bbspeople = new SourceArticleNum();
                for (int j = 0;j<eventArticles_time.size();j++){
                    if (eventArticles_time.get(i).getTable().getTableName().equals("douban_group_post")){
                        doubanNum++;
                    }
                    if (eventArticles_time.get(i).getTable().getTableName().equals("bbs_people_post")){
                        bbs_peopleNum ++;
                    }
                }
                //豆瓣
                sourceArticleNum_douban.setNum(doubanNum);
                sourceArticleNum_douban.setStartTime(starttime);
                sourceArticleNum_douban.setEndTime(endtime);
                sourceArticleNum_douban.setTableName("douban_group_post");
                sourceArticleNums.add(sourceArticleNum_douban);
                //人民网bbs
                sourceArticleNum_bbspeople.setNum(bbs_peopleNum);
                sourceArticleNum_bbspeople.setStartTime(starttime);
                sourceArticleNum_bbspeople.setEndTime(endtime);
                sourceArticleNum_bbspeople.setTableName("bbs_people_post");
                sourceArticleNums.add(sourceArticleNum_bbspeople);
                //
            }
        }
        model.addAttribute("sourceArticleNums", sourceArticleNums);
        return null;
    }
}
