package com.sicdlib.controller;

import com.sicdlib.dto.entity.DoubanGroupPostEntity;
import com.sicdlib.service.IDoubanGroupPostService;
import com.sicdlib.util.NLPUtil.Word2VecUtil.OtherUtil.Segment;
import com.sicdlib.dto.*;
import com.sicdlib.service.*;
import com.sicdlib.util.NLPUtil.Word2VecUtil.Test.Word2Vec;
import com.sicdlib.util.NLPUtil.Word2VecUtil.Vec.Learn;
import com.sicdlib.util.NLPUtil.Word2VecUtil.Vec.domain.WordEntry;
import org.ansj.library.UserDefineLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    /**
     * 初始化word2vec模型：将数据库中词映射到向量空间
     * @param req
     * @param model
     * @return
     */
    @RequestMapping("initWord2VecModel")
    public String initWord2VecModel(HttpServletRequest req, Model model) {
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

        return "success";
    }

    /**
     * 找与事件相似性文章
     * @param req
     * @param model
     * @return
     */
    @RequestMapping("eventSimiEssayList")
    public String eventSimiEssayList(HttpServletRequest req, Model model) {
        Long beginTime = new Date().getTime();
        //1.获得豆瓣小组发布的所有信息
        List<DoubanGroupPostEntity> doubanGroupPostList = doubanGroupPostService.getAllDoubanGroupPost();
        String eventName = "";
//        event = req.getParameter("event");
        Float userSetupSimiDegree = 0.0f;
        userSetupSimiDegree = 0.2f;
//        userSetupSimiDegree = Float.valueOf(req.getParameter("userSetupSimiDegree"));
        eventName = "学生兼职";
        List<String> eventWords = Segment.getWords(eventName);
        System.out.println("事件大小：" + eventWords.size());
        System.out.println("事件大小：" + eventWords.toString());
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
        //用来存放数据库文章相似度,大于0.2的文章
        List<EventEssaySimi> eventEssaySimis = new ArrayList<EventEssaySimi>();
        for (DoubanGroupPostEntity db : doubanGroupPostList){
            //获得数据库中每条豆瓣发布的内容信息的分词
            List<String> words = Segment.getWords(db.getContent());
            Float simiDegree = vec.sentenceSimilarity(keyWords, words);
            //如果相似度>设定值，将添加到eventEssaySimis中
            if(simiDegree > userSetupSimiDegree){
                EventEssaySimi essaySimi = new EventEssaySimi();
                essaySimi.setDoubanGroupPostEntity(db);
                essaySimi.setSimi(simiDegree);
                eventEssaySimis.add(essaySimi);
            }
            num ++;
        }
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
        TbEventEntity eventEntity = new TbEventEntity();
        eventEntity.setEventName(eventName);
        eventService.saveOrUpdateEvent(eventEntity);
        //6.2 插入事件文章event_article中的source_table_id
        TbTableEntity table = new TbTableEntity();
        table.setTableName("douban_group_post");
        tableService.saveOrUpdateTable(table);
        TbTableEntity tbTable = tableService.getTable("douban_group_post");
        String tbid = tbTable.getId();

        int i = 0;
        for (EventEssaySimi essaySimi : eventEssaySimis){
//            System.out.println(i + ":" + essaySimi.getSimi() + ":" + essaySimi.getDoubanGroupPostEntity().getContent());
            //6.2 设置事件event与事件文章event_article之间的关系
            TbEventArticleEntity eventArticle = new TbEventArticleEntity();
            String sourceArticleId = essaySimi.getDoubanGroupPostEntity().getId();
            //设置来源文章ID
            eventArticle.setSourceArticleId(sourceArticleId);
            //设置表ID
            eventArticle.setTableId(tbid);
            eventArticleService.saveOrUpdateEventArticle(eventArticle);
            i++;
        }

        System.out.println("耗时：\t" + internalTime + "秒");

        model.addAttribute("eventEssaySimis", eventEssaySimis);
        return "";
    }

}
