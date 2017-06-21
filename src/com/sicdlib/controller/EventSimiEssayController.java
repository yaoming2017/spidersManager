package com.sicdlib.controller;

import com.sicdlib.dto.*;
import com.sicdlib.dto.entity.BbsPeoplePostEntity;
import com.sicdlib.dto.entity.DoubanGroupPostEntity;
import com.sicdlib.dto.entity.XinhuaNewsEntity;
import com.sicdlib.service.*;
import com.sicdlib.service.pythonService.IBBSPeoplePostService;
import com.sicdlib.service.pythonService.IDoubanGroupPostService;
import com.sicdlib.service.pythonService.IXINHUANewsService;
import com.sicdlib.util.ForeUtil.HotValueUtil;
import com.sicdlib.util.NLPUtil.Word2VecUtil.OtherUtil.Segment;
import com.sicdlib.util.NLPUtil.Word2VecUtil.Test.Word2Vec;
import com.sicdlib.util.NLPUtil.Word2VecUtil.Vec.Learn;
import com.sicdlib.util.NLPUtil.Word2VecUtil.Vec.domain.WordEntry;
import org.ansj.library.UserDefineLibrary;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class EventSimiEssayController {
    @Autowired
    @Qualifier("doubanGroupPostService")
    private IDoubanGroupPostService doubanGroupPostService;

    @Autowired
    @Qualifier("stopWordsService")
    private IStopWordsService stopWordsService;

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
    @Qualifier("bbsPeoplePostService")
    private IBBSPeoplePostService bbsPeoplePostService;

    @Autowired
    @Qualifier("preCalService")
    private IPreCalService preCalService;

    /**
     * 初始化word2vec模型：将数据库中词映射到向量空间
     * @param req
     * @param model
     * @return
     */
    @RequestMapping("initWord2VecModel")
    public String initWord2VecModel(HttpServletRequest req, Model model) {
        String tableName = "douban_group_post";
        tableName = req.getParameter("tableName");
        if (tableName.equals("douban_group_post")){
            //1.获得豆瓣小组发布的所有信息
            List<DoubanGroupPostEntity> doubanGroupPostList = doubanGroupPostService.getAllDoubanGroupPost();
            //2.将所有信息分词并写入doubanpostNoPOS.txt文件中
            try {
                FileWriter writer = new FileWriter("D:\\project\\spidersManager\\data\\doubanpostNoPOS.txt", true);
                //2.1 获得停用词信息
                List<String> stopWords = stopWordsService.getAllStopWords();
                for (DoubanGroupPostEntity db : doubanGroupPostList){
                    //2.2 添加用户自定义词库
                    UserDefineLibrary.insertWord("一带一路", "n", 1000);
                    String wordsStr = "";
                    List<String> words = Segment.getWords(db.getContent());
                    for (String word : words){
                        //去除停用词
                        if(!stopWords.contains(word)){
                            wordsStr = wordsStr + word + " ";
                        }
                    }
                    writer.write(wordsStr + "\n");
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //3.训练word2vec模型，形成model
            Learn learn = new Learn();
            try {
                learn.learnFile(new File("D:\\project\\spidersManager\\data\\doubanpostNoPOS.txt"));
                learn.saveModel(new File("D:\\project\\spidersManager\\data\\wikichinese.model"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //人民网BBS：强国社区
        if (tableName.equals("bbs_people_post")){
            //1.获得强国社区发布的所有信息
            List<BbsPeoplePostEntity> bbsPeoplePostList = bbsPeoplePostService.getAllBbsPeoplePosts();
            //2.将所有信息分词并写入bbs_people_postNoPOS.txt文件中
            try {
                FileWriter writer = new FileWriter("D:\\project\\spidersManager\\data\\bbs_people_postNoPOS.txt", true);
                //2.1 获得停用词信息
                List<String> stopWords = stopWordsService.getAllStopWords();
                for (BbsPeoplePostEntity db : bbsPeoplePostList){
                    //2.2 添加用户自定义词库
                    UserDefineLibrary.insertWord("一带一路", "n", 1000);
                    String wordsStr = "";
                    List<String> words = Segment.getWords(db.getContent());
                    for (String word : words){
                        //去除停用词
                        if(!stopWords.contains(word)){
                            wordsStr = wordsStr + word + " ";
                        }
                    }
                    writer.write(wordsStr + "\n");
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //3.训练word2vec模型，形成model
            Learn learn = new Learn();
            try {
                learn.learnFile(new File("D:\\project\\spidersManager\\data\\bbs_people_postNoPOS.txt"));
                learn.saveModel(new File("D:\\project\\spidersManager\\data\\bbs_people_post.model"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "success";
    }

    /**
     * 找与事件相似性文章，存到event_article数据库中
     * 输入：事件名eventName
     * @param req  : eventName, tableName,
     * @param model
     * @return
     */
    @RequestMapping("eventSimiEssayList")
    public String eventSimiEssayList(HttpServletRequest req, Model model) {
        String eventName ="旅行游玩";
        Float userSetupSimiDegree = 0.4f;
        String tableName1 = "douban_group_post";
        String tableName2 = "bbs_people_post";
//        String tableName3 = "xinhua_news";
        //用来存放数据库文章相似度,大于0.25的文章
//        userSetupSimiDegree = Float.valueOf(req.getParameter("userSetupSimiDegree"));
        eventName = req.getParameter("eventName");

//        tableName = req.getParameter("tableName");
        Long beginTime = new Date().getTime();
        List<DoubanGroupPostEntity> doubanGroupPostList = null;
        List<BbsPeoplePostEntity> bbsPeoplePostList = null;
//        List<XinhuaNewsEntity> xinhuaNewsList = null;
        if (tableName1.equals("douban_group_post")){
            //1.获得豆瓣小组发布的所有信息
            doubanGroupPostList = doubanGroupPostService.getAllDoubanGroupPost();
        }
        if (tableName2.equals("bbs_people_post")){
            //1.获得人民网BBS发布的所有信息
            bbsPeoplePostList = bbsPeoplePostService.getAllBbsPeoplePosts();
        }
//        if (tableName3.equals("xinhua_news")){
//            //1.获得新华网发布的所有信息
//            xinhuaNewsList = xinhuaNewsService.getAllXinHuaNews();
//        }

        List<String> eventWords = Segment.getWords(eventName);
        System.out.println("事件分词大小：" + eventWords.size());
        //4.输入关键词，得到该词的向量表示
        Word2Vec vec = new Word2Vec();
        //4.1 用来存放 所有关键词 取得的前10位相似性词的数组
        Set<WordEntry> eventWord_similarWords = new HashSet<WordEntry>();
        for (String eword : eventWords) {
            Set<WordEntry> similarWords = new HashSet<WordEntry>();
            try {
                vec.loadJavaModel("D:\\project\\spidersManager\\data\\wikichinese.model");
                //获取相似的词语
                similarWords = vec.getSimilarWords(eword, 10);
                System.out.println("与 "+eword+" 语义相似的词语:");
                for (WordEntry word : similarWords) {
                    System.out.println(word.name + " : " + word.score);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            eventWord_similarWords.addAll(similarWords);
        }
        //4.2利用前10位相似关键词与数据库中每条内容进行对比，构建相似度，并将结果 "相似度,文章" 存放到List<EventEssaySimi>中
        List<WordEntry> wordEntryList = new ArrayList<WordEntry>(eventWord_similarWords);
        //将HashSet转换为List, 获得wordEntry中的word.
        List<String> keyWords = new ArrayList<String>();
        for (WordEntry wordEntry : wordEntryList){
            keyWords.add(wordEntry.name);
        }
        int num = 0;
        //用来存放数据库文章相似度,大于0.4的文章
        List<EventEssaySimi> eventEssaySimis = new ArrayList<EventEssaySimi>();
        if (tableName1.equals("douban_group_post")){
            for (DoubanGroupPostEntity db : doubanGroupPostList){
                //获得数据库中每条豆瓣发布的内容信息的分词
                List<String> words = Segment.getWords(db.getContent());
                Float simiDegree = vec.sentenceSimilarity(keyWords, words);
                //如果相似度>设定值，将添加到eventEssaySimis中
                if(simiDegree > userSetupSimiDegree){
                    EventEssaySimi essaySimi = new EventEssaySimi();
                    essaySimi.setDoubanGroupPostEntity(db);
                    essaySimi.setTablename("douban_group_post");
                    essaySimi.setSimi(simiDegree);
                    eventEssaySimis.add(essaySimi);
                }
                num ++;
            }
        }

        if (tableName2.equals("bbs_people_post")){
            for (BbsPeoplePostEntity db : bbsPeoplePostList){
                //获得数据库中每条人民网BBS发布的内容信息的分词
                List<String> words = Segment.getWords(db.getContent());
                Float simiDegree = vec.sentenceSimilarity(keyWords, words);
                //如果相似度>设定值，将添加到eventEssaySimis中
                if(simiDegree > userSetupSimiDegree){
                    EventEssaySimi essaySimi = new EventEssaySimi();
                    essaySimi.setBbsPeoplePostEntity(db);
                    essaySimi.setTablename("bbs_people_post");
                    essaySimi.setSimi(simiDegree);
                    eventEssaySimis.add(essaySimi);
                }
                num ++;
            }
        }
//        if (tableName3.equals("xinhua_news")){
//            for (XinhuaNewsEntity db : xinhuaNewsList){
//                //获得数据库中每条新华网发布的内容信息的分词
//                List<String> words = Segment.getWords(db.getContent());
//                Float simiDegree = vec.sentenceSimilarity(keyWords, words);
//                //如果相似度>设定值，将添加到eventEssaySimis中
//                if(simiDegree > userSetupSimiDegree){
//                    EventEssaySimi essaySimi = new EventEssaySimi();
//                    essaySimi.setXinhuaNewsEntity(db);
//                    essaySimi.setTablename("xinhua_news");
//                    essaySimi.setSimi(simiDegree);
//                    eventEssaySimis.add(essaySimi);
//                }
//                num ++;
//            }
//        }
        Long endTime = new Date().getTime();
        Long internalTime = (endTime - beginTime) / 1000;
        //5 对eventEssaySimis排序
        Collections.sort(eventEssaySimis, new Comparator<EventEssaySimi>() {
            @Override
            public int compare(EventEssaySimi o1, EventEssaySimi o2) {
                //降序排序
                if (o1.getSimi() > o2.getSimi()){
                    return -1;
                }else if(o1.getSimi() < o2.getSimi()){
                    return 1;
                }else{
                    return 0;
                }
            }
        });
        //6 建立数据库关联
        //6.1 插入事件表event中事件信息
        TbEventEntity eve = eventService.getEventByName(eventName);
        if (eve == null){
            TbEventEntity eventEntity = new TbEventEntity();
            eventEntity.setEventName(eventName);
            eventService.saveOrUpdateEvent(eventEntity);
        }
        //重新查询一次事件
        eve = eventService.getEventByName(eventName);
        TbTableEntity tbTable1 = null;
        TbTableEntity tbTable2 = null;
        TbTableEntity tbTable3 = null;
        if (tableName1.equals("douban_group_post")){
            //6.2 设置事件文章event_article中的source_table_id
            tbTable1 = tableService.getTable("douban_group_post");
            String tbid = "";
            if (tbTable1 != null){
                tbid = tbTable1.getId();
            }
        }
        if (tableName2.equals("bbs_people_post")){
            //6.2 设置事件文章event_article中的source_table_id
            tbTable2 = tableService.getTable("bbs_people_post");
            String tbid = "";
            if (tbTable2 != null){
                tbid = tbTable2.getId();
            }
        }
//        if (tableName3.equals("xinhua_news")){
//            //6.2 设置事件文章event_article中的source_table_id
//            tbTable3 = tableService.getTable("xinhua_news");
//            String tbid = "";
//            if (tbTable3 != null){
//                tbid = tbTable2.getId();
//            }
//        }

        int i = 0;
        for (EventEssaySimi essaySimi : eventEssaySimis){
//            System.out.println(i + ":" + essaySimi.getSimi() + ":" + essaySimi.getDoubanGroupPostEntity().getContent());
            //6.2 设置事件event与事件文章event_article之间的关系
            TbEventArticleEntity eventArticle = new TbEventArticleEntity();
            if (essaySimi.getTablename().equals("douban_group_post")) {
                String sourceArticleId = essaySimi.getDoubanGroupPostEntity().getId();
                //设置来源文章ID
                eventArticle.setSourceArticleId(sourceArticleId);
                //设置事件与文章的相似度
                eventArticle.setSimiDegree(essaySimi.getSimi());
                //设置事件event
                eventArticle.setEvent(eve);
                //设置表ID
                eventArticle.setTable(tbTable1);
                //设置事件文章的时间
                String time = essaySimi.getDoubanGroupPostEntity().getDateTime();
                System.out.println(time);
                eventArticle.setTime(time);
                eventArticleService.saveOrUpdateEventArticle(eventArticle);
                i++;
                if (i > 200) {
                    break;
                }
            }
            if (essaySimi.getTablename().equals("bbs_people_post")) {
                String sourceArticleId = essaySimi.getBbsPeoplePostEntity().getId();
                //设置来源文章ID
                eventArticle.setSourceArticleId(sourceArticleId);
                //设置事件与文章的相似度
                eventArticle.setSimiDegree(essaySimi.getSimi());
                //设置事件event
                eventArticle.setEvent(eve);
                //设置表ID
                eventArticle.setTable(tbTable2);
                //设置事件文章的时间
                String time = essaySimi.getBbsPeoplePostEntity().getDateTime();
                if (time != null && !time.equals("")){
                    SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
                    Date d = null;
                    try {
                        d = sdf.parse(time);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    String formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);
                    System.out.println(formatDate);
                    eventArticle.setTime(formatDate);
                }
                eventArticleService.saveOrUpdateEventArticle(eventArticle);
                i++;
                if (i > 200) {
                    break;
                }
            }
//            if (essaySimi.getTablename().equals("xinhua_news")) {
//                String sourceArticleId = essaySimi.getXinhuaNewsEntity().getId();
//                //设置来源文章ID
//                eventArticle.setSourceArticleId(sourceArticleId);
//                //设置事件与文章的相似度
//                eventArticle.setSimiDegree(essaySimi.getSimi());
//                //设置事件event
//                eventArticle.setEvent(eve);
//                //设置新华网的表ID
//                eventArticle.setTable(tbTable3);
//                //设置事件文章的时间
//                String time = essaySimi.getXinhuaNewsEntity().getDateTime();
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
//                Date date = new Date();
//                try {
//                    date = sdf.parse(time);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                time = sf.format(date);
//                System.out.println(time);
//                eventArticle.setTime(time);
//                eventArticleService.saveOrUpdateEventArticle(eventArticle);
//                i++;
//                if (i > 200) {
//                    break;
//                }
//            }
        }
        System.out.println("耗时：\t" + internalTime + "秒");
        System.out.println("事件ID：" + eve.getId());
        //添加事件摘要、趋势类型、开始时间、结束时间等属性

        preCalService.cal(eve.getId());

        List<TbEventEntity> events = eventService.getAllEvent();
        model.addAttribute("events", events);
        return "/WEB-INF/addEvent";
    }


    /**
     * 前台事件相似文章展示
     * 输入：事件名称
     * 输出：event_article
     * @param req
     * @param model
     * @return
     */
    @RequestMapping("getEventSimiEssayList")
    public String getEventSimiEssayList(HttpServletRequest req, Model model) {
        String eventName = "学生兼职";
        eventName = req.getParameter("eventName");
        System.out.println(eventName);
        TbEventEntity event = eventService.getEventByName(eventName);
        //与事件相关的文章
        Set<TbEventArticleEntity> eventArticles = event.getEventArticleSet();
        System.out.println("与事件相关的文章数量为：" + event.getEventArticleSet().size());
        //新建所有“网站表”的列表
        List<DoubanGroupPostEntity> doubanGroupPosts = new ArrayList<DoubanGroupPostEntity>();
        for (TbEventArticleEntity eventArticle : event.getEventArticleSet()){
            TbTableEntity table = eventArticle.getTable();
            String tableName = "douban_group_post";
            if (table != null){
                tableName = table.getTableName();
            }
            //搜索不同表中的源数据
            switch (tableName){
                case "douban_group_post":
                    //通过表名 和 源文章ID 找到各个网站的文章
                    if (doubanGroupPosts.size() < 20) {
                        DoubanGroupPostEntity doubanGroupPost = doubanGroupPostService.getDoubanGroupPost(eventArticle.getSourceArticleId());
                        doubanGroupPosts.add(doubanGroupPost);
                    }
                    break;
                case "bbs_sohu_post":
                    break;
            }
        }
        //获得所有事件信息
        List<TbEventEntity> events = eventService.getAllEvent();
        model.addAttribute("events", events);
        model.addAttribute("doubanGroupPosts", doubanGroupPosts);
        model.addAttribute("eventArticles", eventArticles);
        return "eventsList";
    }

    //列出所有的事件信息
    @RequestMapping("eventsList")
    public String eventsList(HttpServletRequest req, Model model) {
        //获得所有事件信息
        List<TbEventEntity> events = eventService.getAllEvent();
        //添加事件中文章的热度
        for (int i = 0; i < events.size(); i ++){
            String eventID = events.get(i).getId();
            List<TbEventArticleEntity> eventArticles = eventArticleService.getEventArticleByEventID(eventID);
        }

        model.addAttribute("events", events);
        return "eventsList";
    }

    //新增事件
    @RequestMapping("addEvent")
    public String addEvent(HttpServletRequest req, Model model) {
        //获得所有事件信息
        List<TbEventEntity> events = eventService.getAllEvent();
        model.addAttribute("events", events);
        return "addEvent";
    }

    //计算文章热度
    @RequestMapping("addHotValues")
    public String addHotValues(HttpServletRequest req, Model model){
        String tableName = "douban_group_post";
        tableName = req.getParameter("tableName");
        if (tableName.equals("douban_group_post")) {
            List<DoubanGroupPostEntity> doubanGroupPosts = doubanGroupPostService.getAllDoubanGroupPost();
            //添加热度值
            HotValueUtil.insertHotValueBySourceArticles_doubanPosts(doubanGroupPosts);
        }

        if (tableName.equals("bbs_people_post")) {
            List<BbsPeoplePostEntity> bbsPeoplePosts = bbsPeoplePostService.getAllBbsPeoplePosts();
            //添加热度值
            HotValueUtil.insertHotValueBySourceArticles_bbsPeoplePosts(bbsPeoplePosts);
        }

//        if (tableName.equals("xinhua_news")) {
//            List<XinhuaNewsEntity> xinhuaNewsList = xinhuaNewsService.getAllXinHuaNews();
//            //添加热度值
//            HotValueUtil.insertHotValueBySourceArticles_xinhuanews(xinhuaNewsList);
//        }
        return "success";
    }

    /****************************************************************************************************/
    /**
     * 命名实体识别NER
     */

}
