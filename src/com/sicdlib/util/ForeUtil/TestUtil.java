package com.sicdlib.util.ForeUtil;

import com.sicdlib.dto.ArticleHotValueEntity;
import com.sicdlib.dto.TableHotValue;
import com.sicdlib.dto.TbEventArticleEntity;
import com.sicdlib.dto.entity.BbsPeoplePostEntity;
import com.sicdlib.dto.entity.DoubanGroupPostEntity;
import com.sicdlib.dto.entity.XinhuaNewsEntity;
import com.sicdlib.service.IArticleHotValueService;
import com.sicdlib.service.IEventArticleService;
import com.sicdlib.service.IEventService;
import com.sicdlib.service.pythonService.IBBSPeoplePostService;
import com.sicdlib.service.pythonService.IDoubanGroupPostService;
import com.sicdlib.service.pythonService.IXINHUANewsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by DeMH on 2017/5/17.
 */
public class TestUtil {

    static ApplicationContext apx = new ClassPathXmlApplicationContext("beans.xml");
    static IDoubanGroupPostService doubanGroupPostService = (IDoubanGroupPostService)apx.getBean("doubanGroupPostService");
    static IArticleHotValueService articleHotValueService = (IArticleHotValueService)apx.getBean("articleHotValueService");
    static IBBSPeoplePostService bbsPeoplePostService = (IBBSPeoplePostService) apx.getBean("bbsPeoplePostService");
    static IXINHUANewsService xinhuaNewsService = (IXINHUANewsService) apx.getBean("xinhuaNewsService");
    static IEventArticleService eventArticleService = (IEventArticleService) apx.getBean("eventArticleService");
    static IEventService eventService = (IEventService)apx.getBean("eventService");

    @Test
    public void test01(){
        eventService.getSourceEventArticle("5524a6e0-58cb-4e64-baab-b14ffb622b2e");
    }

    public static TableHotValue hotValueByArticle(TbEventArticleEntity eventArticle){
        TableHotValue tableHotValue = new TableHotValue();
        if (eventArticle != null){
            String tableName = eventArticle.getTable().getTableName();
            //得到属于哪张表，如果属于豆瓣发布表
            if (tableName.equals("douban_group_post")){
                ArticleHotValueEntity articleHotValue = new ArticleHotValueEntity();
                DoubanGroupPostEntity doubanGroupPost = doubanGroupPostService.getDoubanGroupPost(eventArticle.getSourceArticleId());
                System.out.println(doubanGroupPost);
                if (doubanGroupPost != null){
                    //计算热度:H = 0.1*L + 0.3*C + 0.2*R
                    double hotValue = doubanGroupPost.getLikeNum() * 0.1 + doubanGroupPost.getCommentNum() * 0.3 + doubanGroupPost.getRecommendNum() * 0.2;
                    DecimalFormat df = new DecimalFormat("#.00");
                    hotValue = Double.parseDouble(df.format(hotValue));
                    tableHotValue.setHotValue(hotValue);
                    tableHotValue.setDoubanGroupPost(doubanGroupPost);
                    tableHotValue.setTableName("douban_group_post");
                    tableHotValue.setWebsiteName("豆瓣小组");
                }
            }


        }
        return tableHotValue;
    }


}
