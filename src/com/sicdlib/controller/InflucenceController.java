package com.sicdlib.controller;



import com.alibaba.fastjson.JSON;
import com.sicdlib.dto.SourceArticleCommNum;

import com.sicdlib.dto.TbEventArticleEntity;
import com.sicdlib.dto.TbSentimentInflucenceEntity;
import com.sicdlib.dto.entity.DoubanGroupPostEntity;
import com.sicdlib.service.*;
import com.sicdlib.service.pythonService.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**舆情影响力
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


    @RequestMapping(value="sentiment")
    public String listDailyCommentNum(HttpServletRequest req, Model model) {

        System.out.println("ccccc");
        List<SourceArticleCommNum> sourceArticleCommNums = new ArrayList<>();
        String eventID = req.getParameter("eventID");
        List<TbEventArticleEntity> eventArticles = eventArticleService.getEventArticleByEventID(eventID);
//        List<DoubanGroupPostEntity> doubanGroupPostList = new ArrayList<>();
//        for (int i = 0;i < eventArticles.size(); i++){
//            TbEventArticleEntity eventArticle = eventArticles.get(i);
//            TbTableEntity table = eventArticle.getTable();
//            if (table.getTableName().equals("douban_group_post")){
//                DoubanGroupPostEntity doubanGroupPost = doubanGroupPostService.getDoubanGroupPost(eventArticle.getSourceArticleId());
//                doubanGroupPostList.add(doubanGroupPost);
//            }
//        }
        TbEventArticleEntity starttimeEventArticle = null;
        if (eventService.getSourceEventArticle(eventID) != null){
            //1. 获得事件的开始文章
            starttimeEventArticle = eventService.getSourceEventArticle(eventID);
        }
        //2. 获得事件的结束文章
        TbEventArticleEntity EndtimeEventArticle = eventService.getEndtimeSourceEventArticle(eventID);
        //3. 时间平均划分10份，求每份中的舆情影响力
        String startTimeStr = starttimeEventArticle.getTime();
        String endTimeStr = EndtimeEventArticle.getTime();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = sf.parse(startTimeStr);
            endDate = sf.parse(endTimeStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //得到的时间是毫秒，将毫秒转换成天数
        int days = (int) ((endDate.getTime() - startDate.getTime()) / (1000 * 3600 * 24));
        /**
         * 策略：时间T
         * 1) T>10天,     按天计算，选取10个时间节点
         * 2) 10天>T>1天, 按每天计算
         * 3) T<1天,      按每2小时计算
         *
         */
        List<SourceArticleCommNum> sourceArticleCommNumList = new ArrayList<>();
        //1) T>10天
        if (days > 10) {
            int internalDay = days / 10;
            //获得不同时间点的热度
            for (int i = 1; i < 11; i++) {
                Calendar ca = Calendar.getInstance();
                ca.setTime(startDate);
                ca.add(Calendar.DATE, internalDay * (i - 1));
                String starttime = sf.format(ca.getTime());
                ca.setTime(startDate);
                ca.add(Calendar.DATE, internalDay * i);
                String endtime = sf.format(ca.getTime());
                //通过不同事件ID，开始时间，结束时间获得事件文章列表
                List<TbEventArticleEntity> eventArticle_parttime = eventArticleService.getEventArticlesByStartEndTime(eventID, starttime, endtime);
                int doubanNum = 0;
                int bbs_peopleNum = 0;
                SourceArticleCommNum sourceArticleCommNum_douban = new SourceArticleCommNum();
//                SourceArticleCommNum sourceArticleNum_bbspeople = new SourceArticleCommNum();
                List<DoubanGroupPostEntity> doubanGroupPostList_parttime = new ArrayList<>();
                int commentNum_temp = 0;
                for (int j = 0; j < eventArticle_parttime.size(); j++) {
                    if (eventArticle_parttime.get(j).getTable().getTableName().equals("douban_group_post")) {
                       DoubanGroupPostEntity douban = doubanGroupPostService.getDoubanGroupPost(eventArticle_parttime.get(j).getSourceArticleId());
                       commentNum_temp += douban.getCommentNum();
                    }
//                    if (eventArticle_parttime.get(i).getTable().getTableName().equals("bbs_people_post")) {
//                        bbs_peopleNum++;
//                    }
                }
                sourceArticleCommNum_douban.setNum(commentNum_temp);
                sourceArticleCommNum_douban.setStartTime(starttime);
                sourceArticleCommNum_douban.setEndTime(endtime);
                sourceArticleCommNum_douban.setTableName("douban_group_post");
                sourceArticleCommNumList.add(sourceArticleCommNum_douban);

//                //豆瓣
//                sourceArticleNum_douban.setNum(doubanNum);
//                sourceArticleNum_douban.setStartTime(starttime);
//                sourceArticleNum_douban.setEndTime(endtime);
//                sourceArticleNum_douban.setTableName("douban_group_post");
//                sourceArticleCommNums.add(sourceArticleNum_douban);
//                //人民网bbs
//                sourceArticleNum_bbspeople.setNum(bbs_peopleNum);
//                sourceArticleNum_bbspeople.setStartTime(starttime);
//                sourceArticleNum_bbspeople.setEndTime(endtime);
//                sourceArticleNum_bbspeople.setTableName("bbs_people_post");
//                sourceArticleCommNums.add(sourceArticleNum_bbspeople);
            }
        }


//        //2)10天>T>1天
//        else if (days < 10 && days > 1) {
//            for (int i = 1; i < days + 1; i++) {
//                Calendar ca = Calendar.getInstance();
//                ca.setTime(startDate);
//                ca.add(Calendar.DATE, (i - 1));
//                String starttime = sf.format(ca.getTime());
//                ca.setTime(startDate);
//                ca.add(Calendar.DATE, i);
//                String endtime = sf.format(ca.getTime());
//                //通过不同事件ID，开始时间，结束时间获得事件文章列表
//                List<TbSentimentInflucenceEntity> eventComment_time = eventArticleService.getInflucenceByStartEndTime(eventID, starttime, endtime);
//                int doubanNum = 0;
//                int bbs_peopleNum = 0;
//                SourceArticleCommNum sourceArticleNum_douban = new SourceArticleCommNum();
//                SourceArticleCommNum sourceArticleNum_bbspeople = new SourceArticleCommNum();
//                for (int j = 0; j < eventComment_time.size(); j++) {
//                    if (eventComment_time.get(i).getTable().getTableName().equals("douban_group_post")) {
//                        doubanNum++;
//                    }
//                    if (eventComment_time.get(i).getTable().getTableName().equals("bbs_people_post")) {
//                        bbs_peopleNum++;
//                    }
//                }
//                //豆瓣
//                sourceArticleNum_douban.setNum(doubanNum);
//                sourceArticleNum_douban.setStartTime(starttime);
//                sourceArticleNum_douban.setEndTime(endtime);
//                sourceArticleNum_douban.setTableName("douban_group_post");
//                sourceArticleCommNums.add(sourceArticleNum_douban);
//                //人民网bbs
//                sourceArticleNum_bbspeople.setNum(bbs_peopleNum);
//                sourceArticleNum_bbspeople.setStartTime(starttime);
//                sourceArticleNum_bbspeople.setEndTime(endtime);
//                sourceArticleNum_bbspeople.setTableName("bbs_people_post");
//                sourceArticleCommNums.add(sourceArticleNum_bbspeople);
//            }
//
//        }
//        // 3) T<1 天
//        else {
//            int hours = (int) ((endDate.getTime() - startDate.getTime()) / (1000 * 3600));
//            for (int i = 1; i < hours / 2; i++) {
//                GregorianCalendar cal = new GregorianCalendar();
//                cal.setTime(startDate);
//                //按小时（10）相加减
//                cal.add(10, i - 1);
//                String starttime = sf.format(cal.getTime());
//                cal.setTime(startDate);
//                cal.add(10, i);
//                String endtime = sf.format(cal.getTime());
//                //通过不同事件ID，开始时间，结束时间获得事件文章列表
//                List<TbSentimentInflucenceEntity> eventComment_time = eventArticleService.getInflucenceByStartEndTime(eventID, starttime, endtime);
//                int doubanNum = 0;
//                int bbs_peopleNum = 0;
//                SourceArticleCommNum sourceArticleNum_douban = new SourceArticleCommNum();
//                SourceArticleCommNum sourceArticleNum_bbspeople = new SourceArticleCommNum();
//                for (int j = 0; j < eventComment_time.size(); j++) {
//                    if (eventComment_time.get(i).getTable().getTableName().equals("douban_group_post")) {
//                        doubanNum++;
//                    }
//                    if (eventComment_time.get(i).getTable().getTableName().equals("bbs_people_post")) {
//                        bbs_peopleNum++;
//                    }
//                }
//                //豆瓣
//                sourceArticleNum_douban.setNum(doubanNum);
//                sourceArticleNum_douban.setStartTime(starttime);
//                sourceArticleNum_douban.setEndTime(endtime);
//                sourceArticleNum_douban.setTableName("douban_group_post");
//                sourceArticleCommNums.add(sourceArticleNum_douban);
//                //人民网bbs
//                sourceArticleNum_bbspeople.setNum(bbs_peopleNum);
//                sourceArticleNum_bbspeople.setStartTime(starttime);
//                sourceArticleNum_bbspeople.setEndTime(endtime);
//                sourceArticleNum_bbspeople.setTableName("bbs_people_post");
//                sourceArticleCommNums.add(sourceArticleNum_bbspeople);
//            }
//        }
        model.addAttribute("commlist",JSON.toJSON(sourceArticleCommNumList));
        return "sentiment";
    }


    @RequestMapping("participant")
    public String  listParticipant(HttpServletRequest req,Model model){
        System.out.println("加载网民参与度...............");
        String eventID = req.getParameter("eventID");
        List<String[]>  activeness = tableService.getActivess(eventID);
        model.addAttribute("activeness",activeness);
        return "";
    }
}
