package com.sicdlib.util.ForeUtil;

import com.sicdlib.dto.TableCommentNum;
import com.sicdlib.dto.TbSentimentInflucenceEntity;
import com.sicdlib.dto.entity.DoubanGroupPostEntity;
import com.sicdlib.service.IArticleCommentNumService;
import com.sicdlib.service.pythonService.IDoubanGroupPostService;
import com.sicdlib.service.pythonService.IKDNETPostService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by init on 2017/6/16.
 */
public class SentimentInflucenceUtil {
    static ApplicationContext apx = new ClassPathXmlApplicationContext("beans.xml");
    static IArticleCommentNumService articleCommentNumService = (IArticleCommentNumService) apx.getBean("articleCommentNumService");
    static IDoubanGroupPostService doubanGroupPostService = (IDoubanGroupPostService)apx.getBean("doubanGroupPostService");
    static IKDNETPostService kdnetPostService = (IKDNETPostService) apx.getBean("kdnetPostService");
    /**
     * 获取某个事件在某个网站的评论量
     *
     */
    public static void insertCommentNumBySourceArticles_doubanPosts(List<DoubanGroupPostEntity> doubanGroupPost){
        for(int i=0;i<doubanGroupPost.size();i++){
            TbSentimentInflucenceEntity tbSentimentInflucenceEntity = new TbSentimentInflucenceEntity();
            DoubanGroupPostEntity doubanGroupPostEntity = doubanGroupPost.get(i);
            //评论量
            int commentNum = doubanGroupPostEntity.getCommentNum();
            //日期
            String time = doubanGroupPostEntity.getDateTime();
            //存入数据库
            tbSentimentInflucenceEntity.setInflucence(Long.valueOf(commentNum));
            tbSentimentInflucenceEntity.setTableName("douban_group_post");
            tbSentimentInflucenceEntity.setWebsiteName("豆瓣小组");
            tbSentimentInflucenceEntity.setDateTime(time);
            articleCommentNumService.getArticleCommentNumByEventID(tbSentimentInflucenceEntity);
        }

    }



}
