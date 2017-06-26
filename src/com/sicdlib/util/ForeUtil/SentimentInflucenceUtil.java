package com.sicdlib.util.ForeUtil;

import com.sicdlib.dto.*;
import com.sicdlib.dto.entity.BbsPeoplePostEntity;
import com.sicdlib.dto.entity.BbsSohuPostEntity;
import com.sicdlib.dto.entity.DoubanGroupPostEntity;

import com.sicdlib.service.pythonService.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by init on 2017/6/16.
 */
public class SentimentInflucenceUtil {
    static ApplicationContext apx = new ClassPathXmlApplicationContext("beans.xml");
    static IDoubanGroupPostService  doubanGroupPostService = (IDoubanGroupPostService) apx.getBean("doubanGroupPostService");
    static IBBSPeoplePostService  bbsPeoplePostService = (IBBSPeoplePostService) apx.getBean("bbsPeoplePostService");
    static IBBSSohuPostService bbsSohuPostService = (IBBSSohuPostService) apx.getBean("bbsSohuPostService");
    /**
     * 获取某个网民在某个网站的评论量和点击量
     *
     */

    /**
     * 获取某个网民在某个网站的评论量和点击量
     *  计算公式：
     *  评论量C，点击量H=h+1,
     *  E=C/H
     */
    public static List<TbNetizenParticiEntity> getNetizenParticiByArticles(List<TbEventArticleEntity> eventArticles){
        List<TbNetizenParticiEntity> TbNetizenParticis = new ArrayList<>();
        for (int i = 0;i < eventArticles.size(); i++){
            TbNetizenParticiEntity tbNetizenPartici = new TbNetizenParticiEntity();
            TbEventArticleEntity eventArticle = eventArticles.get(i);
            //获得单个文章的参与度值
            tbNetizenPartici = engagementByArticle(eventArticle);
            if ( tbNetizenPartici != null){
                TbNetizenParticis.add( tbNetizenPartici);
            }
        }

        //对表(网站文章)的参与度值进行排序
       /* Collections.sort(TbNetizenParticis, new Comparator<TbNetizenParticiEntity>(){
            @Override
            public int compare(TbNetizenParticiEntity o1, TbNetizenParticiEntity o2) {
                return  o2.getEngagement().compareTo(o1.getEngagement());
            }
        });*/
        return TbNetizenParticis;
    }

    /**
     * 给定事件文章，获得单个文章的参与度值
     * @param eventArticle
     * @return
     */
    public static TbNetizenParticiEntity engagementByArticle(TbEventArticleEntity eventArticle){
        TbNetizenParticiEntity tbNetizenPartici = new TbNetizenParticiEntity();
        if (eventArticle != null){
            String tableName = eventArticle.getTable().getTableName();
           /**得到属于哪张表
            * 如果是豆瓣发布表
            */
            if (tableName.equals("douban_group_post")){
                DoubanGroupPostEntity doubanGroupPost = doubanGroupPostService.getDoubanGroupPost(eventArticle.getSourceArticleId());
                System.out.println(doubanGroupPost);
                if (doubanGroupPost != null){
                    //计算参与度: E = C/H
                    double engagement = doubanGroupPost.getCommentNum() / (doubanGroupPost.getRecommendNum()+1);
                    /*DecimalFormat df = new DecimalFormat("#.00");
                    engagement = Double.parseDouble(df.format(engagement));*/
                    tbNetizenPartici.setEngagement(engagement);
                    tbNetizenPartici.setDoubanGroupPost(doubanGroupPost);
                    tbNetizenPartici.setTableName("douban_group_post");
                    tbNetizenPartici.setWebsiteName("豆瓣社区");
                }
            }
            if(tableName.equals("bbs_people_post")){
                BbsPeoplePostEntity bbsPeoplePost = bbsPeoplePostService.getBbsPeoplePost(eventArticle.getSourceArticleId());
                if(bbsPeoplePost !=null){
                    //计算参与度：E = C/H
                    double engagement = bbsPeoplePost.getCommentNum() / (bbsPeoplePost.getReadNum()+1);
                    /*DecimalFormat df = new DecimalFormat("#.00");
                    engagement = Double.parseDouble(df.format(engagement));*/
                    tbNetizenPartici.setEngagement(engagement);
                    tbNetizenPartici.setBbsPeoplePost(bbsPeoplePost);
                    tbNetizenPartici.setTableName("bbs_people_post");
                    tbNetizenPartici.setWebsiteName("人民网社区");
                }

            }

            if(tableName.equals("bbs_sohu_post")){
                BbsSohuPostEntity bbsSohuPost = bbsSohuPostService.getBbsSohuPost(eventArticle.getSourceArticleId());
                if(bbsSohuPost != null){
                //计算参与度: E = C/ H
                    double engagement = bbsSohuPost.getCommentNum() / (bbsSohuPost.getReadNum() + 1);
                    /*DecimalFormat df = new DecimalFormat("#.00");
                    engagement = Double.parseDouble(df.format(engagement));*/
                    tbNetizenPartici.setEngagement(engagement);
                    tbNetizenPartici.setBbsSohuPost(bbsSohuPost);
                    tbNetizenPartici.setTableName("bbs_sohu_post");
                    tbNetizenPartici.setWebsiteName("搜狐社区");
                }

            }
        }
        return tbNetizenPartici;
    }

}
