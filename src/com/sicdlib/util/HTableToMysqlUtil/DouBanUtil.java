package com.sicdlib.util.HTableToMysqlUtil;

import com.kenai.jffi.Array;
import com.sicdlib.dto.entity.*;
import com.sicdlib.service.*;
import com.sicdlib.util.HBaseUtil.HBaseData;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by init on 2017/5/24.
 */
public class DouBanUtil {
    static ApplicationContext apx = new ClassPathXmlApplicationContext("beans.xml");

    /**
     * 豆瓣htable_作者转换到Mysql中
     */
    @Test
    public void test_doubanGroupAuthor_HTableToMysql() throws Exception{
        IDoubanGroupAuthorService doubanGroupAuthorService = (IDoubanGroupAuthorService) apx.getBean("doubanGroupAuthorService");
        Long beginTime = new Date().getTime();
        /**
         * 豆瓣小组
         */
        //豆瓣小组 - 作者
        String htable_name = "douban_group_author";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            DoubanGroupAuthorEntity doubanGroupAuthor = new DoubanGroupAuthorEntity();
            i++;
            for (KeyValue rowKV : result.raw()) {
                //字段名
                String qualifer = new String(rowKV.getQualifier());
                //值：字段对应的值
                String value = new String(rowKV.getValue());
                    //将4字节表情或特殊字符去掉
                    value = value.replaceAll("[\\x{10000}-\\x{10FFFF}]", "");
                    switch (qualifer) {
                        case "author_id":
                            doubanGroupAuthor.setAuthorId(value);
                            break;
                        case "author_name":
                            doubanGroupAuthor.setAuthorName(value);
                            break;
                        case "introduction":
                            doubanGroupAuthor.setIntroduction(value);
                            break;
                        case "join_time":
                            doubanGroupAuthor.setJoinTime(value);
                            break;
                        case "location":
                            doubanGroupAuthor.setLocation(value);
                            break;
                        case "logoff_time":
                            doubanGroupAuthor.setLogoffTime(value);
                            break;
                        case "signature":
                            doubanGroupAuthor.setSignature(value);
                            break;
                        case "url":
                            doubanGroupAuthor.setUrl(value);
                            break;
                        /*case "time_stamp":
                            DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                            doubanGroupAuthor.setTimeStamp(Timestamp.valueOf(df.format(value)));
                            break;*/
                    }
                Long time = new Long(rowKV.getTimestamp());
                doubanGroupAuthor.setTimeStamp(new Timestamp(time));
                }
                doubanGroupAuthorService.saveDoubanGroupAuthor(doubanGroupAuthor);
                //每隔100条打印一下时间
                if (i % 100 == 0) {
                    int k = i / 100;
                    Long end100Time = new Date().getTime();
                    Long end100toBeginTime = (end100Time - beginTime) / 1000;
                    System.out.println("运行到第" + k + "百条所需：\t" + end100toBeginTime + "秒");
                }
            }
        Long endTime = new Date().getTime();
        Long EndtoBeginTime = (endTime - beginTime) % 1000;
        System.out.println("运行到结束所需：\t" + EndtoBeginTime + "秒");
    }

    /**
     * 豆瓣htable_评论转换到Mysql中
     */
    @Test
    public void test_doubanGroupComment_HTableToMysql() throws Exception{
        IDoubanGroupCommentService doubanGroupCommentService = (IDoubanGroupCommentService) apx.getBean("doubanGroupCommentService");
        Long beginTime = new Date().getTime();
        /**
         * 豆瓣小组
         */
        //豆瓣小组 - 评论
        String htable_name = "douban_group_comment";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            DoubanGroupCommentEntity doubanGroupComment = new DoubanGroupCommentEntity();
            i++;
            for (KeyValue rowKV : result.raw()) {
                //字段名
                String qualifer = new String(rowKV.getQualifier());
                //值：字段对应的值
                String value = new String(rowKV.getValue());
                //将4字节表情或特殊字符去掉
                value = value.replaceAll("[\\x{10000}-\\x{10FFFF}]", "");
                switch (qualifer){
                    case "author_href":
                        doubanGroupComment.setAuthorHref(value);
                        break;
                    case "author_name":
                        doubanGroupComment.setAuthorName(value);
                        break;
                    case "comment_ids":
                        doubanGroupComment.setCommentId(value);
                        break;
                    case "content":
                        doubanGroupComment.setContent(value);
                        break;
                    case "post_id":
                        doubanGroupComment.setPostId(value);
                        break;
                    case "prise_num":
                        doubanGroupComment.setPriseNum(Integer.parseInt(value));
                        break;
                    case "pub_time":
                        doubanGroupComment.setPubTime(value);
                        break;
                    case "quote_author_href":
                        doubanGroupComment.setQuoteAuthorHref(value);
                        break;
                    case "quote_content":
                        doubanGroupComment.setQuoteContent(value);
                        break;
                    case "url":
                        doubanGroupComment.setUrl(value);
                        break;
                    /*case  "time_stamp":
                        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        doubanGroupComment.setTimeStamp(Timestamp.valueOf(df.format(value)));
                        break;*/
                }
                Long time = new Long(rowKV.getTimestamp());
                doubanGroupComment.setTimeStamp(new Timestamp(time));
            }
            doubanGroupCommentService.saveDoubanGroupComment(doubanGroupComment);
            //每隔100条打印一下时间
            if (i % 100 == 0){
                int k = i/100;
                Long end100Time = new Date().getTime();
                Long end100toBeginTime = (end100Time - beginTime) / 1000;
                System.out.println("运行到第" + k + "百条所需：\t" + end100toBeginTime+"秒");
            }
        }
        Long endTime = new Date().getTime();
        Long EndtoBeginTime = (endTime - beginTime) % 1000;
        System.out.println("运行到结束所需：\t" + EndtoBeginTime + "秒");
    }


    /**
     * 豆瓣htable_发布信息转换到Mysql中
     */
    @Test
    public void test_doubanGroupPost_HTableToMysql() throws Exception{
        IDoubanGroupPostService doubanGroupPostService = (IDoubanGroupPostService) apx.getBean("doubanGroupPostService");
        IDoubanGroupCommentPostIdService doubanGroupCommentPostIdService = (IDoubanGroupCommentPostIdService) apx.getBean("doubanGroupCommentPostIdService");
        Long beginTime = new Date().getTime();
        /**
         * 豆瓣小组
         */
        //豆瓣小组 -文章
        String htable_name = "douban_group_post";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            DoubanGroupPostEntity doubanGrouppost = new DoubanGroupPostEntity();
            i++;
            for (KeyValue rowKV : result.raw()) {
                //字段名
                String qualifer = new String(rowKV.getQualifier());
                //值：字段对应的值
                String value = new String(rowKV.getValue());
                //将4字节表情或特殊字符去掉
                value = value.replaceAll("[\\x{10000}-\\x{10FFFF}]", "");
                String postID = null;
                List<String> commentIds = new ArrayList<>();
                switch (qualifer){
                    case "author_href":
                        doubanGrouppost.setAuthorHref(value);
                        break;
                    case "author_name":
                        doubanGrouppost.setAuthorName(value);
                        break;
                    case "author_id":
                        doubanGrouppost.setAuthorId(value);
                        break;
                    case "content":
                        doubanGrouppost.setContent(value);
                        break;
                    case "post_id":
                        postID = value;
                        doubanGrouppost.setPostId(value);
                        break;
                    case "comment_ids":
                        List<String> listString = this.getCommentId(value);
                        commentIds = listString;
                        doubanGrouppost.setCommentNum(listString.size());
                        break;
                    case "date_time":
                        doubanGrouppost.setDateTime(value);
                        break;
                    case "group_href":
                        doubanGrouppost.setGroupHref(value);
                        break;
                    case "group_id":
                        doubanGrouppost.setGroupId(value);
                        break;
                    case "group_name":
                        doubanGrouppost.setGroupName(value);
                        break;
                    case "like_num":
                        doubanGrouppost.setLikeNum(Integer.parseInt(value));
                        break;
                    case "recommend_num":
                        doubanGrouppost.setRecommendNum(Integer.parseInt(value));
                        break;
                    case "title":
                        doubanGrouppost.setTitle(value);
                        break;
                    case "picture_hrefs_num":
                        doubanGrouppost.setPictureHrefsNum(Integer.parseInt(value));
                        break;
                    case "url":
                        doubanGrouppost.setUrl(value);
                        break;
                    /*case  "time_stamp":
                        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        doubanGrouppost.setTimeStamp(Timestamp.valueOf(df.format(value)));
                        break;*/
                }
                Long time = new Long(rowKV.getTimestamp());
                doubanGrouppost.setTimeStamp(new Timestamp(time));
                if(postID != null && commentIds != null && commentIds.size() > 0) {
                    for(String commentId: commentIds){
                        DoubanGroupComentPostIdEntity commentPostId = new DoubanGroupComentPostIdEntity();
                        commentPostId.setPostId(postID);
                        commentPostId.setCommentId(commentId);
                        doubanGroupCommentPostIdService.saveDoubanGroupCommentPostId(commentPostId);
                    }
                }

            }
            doubanGroupPostService.saveDoubanGroupPost(doubanGrouppost);
            //每隔100条打印一下时间
            if (i % 100 == 0){
                int k = i/100;
                Long end100Time = new Date().getTime();
                Long end100toBeginTime = (end100Time - beginTime) / 1000;
                System.out.println("运行到第" + k + "百条所需：\t" + end100toBeginTime+"秒");
            }
        }
        Long endTime = new Date().getTime();
        Long EndtoBeginTime = (endTime - beginTime) % 1000;
        System.out.println("test_doubanGroupPost_HTableToMysql运行到结束所需：\t" + EndtoBeginTime + "秒");
    }
    private List<String> getCommentId(String comment_ids){
        String[] commentIdsSplit = comment_ids.split("'");
        List<String> arrayList = new ArrayList<>();
        for(int i=1;i<commentIdsSplit.length;i=i+2){
            arrayList.add(commentIdsSplit[i]);
        }
        return  arrayList;

    }
            /**
             * 豆瓣组的组信息转换到Mysql中
             */
             @Test
             public void test_doubanGroupGroup_HTableToMysql() throws Exception {
                 IDoubanGroupGroupService doubanGroupGroupService = (IDoubanGroupGroupService) apx.getBean("doubanGroupGroupService");
                 Long beginTime = new Date().getTime();
                 /**
                  * 豆瓣小组
                  */
                 //群组
                 String htable_name ="douban_group_group";
                 HBaseData hBaseData = new HBaseData(htable_name);
                 ResultScanner results = hBaseData.getAllData();
                 int i = 0;
                 //输出结果
               for(Result result : results){
                    DoubanGroupGroupEntity doubanGroupGroup = new DoubanGroupGroupEntity();
                    i++;
                    for(KeyValue rowKV : result.raw()){
                        //字段名
                        String qualifer = new String(rowKV.getQualifier());
                        //值,字段对应的值
                        String value = new String(rowKV.getValue());
                        //数据公共清理
                        value = CleanPublicUtil.publicCleanMethods(value);
                        switch(qualifer){
                            case "group_id":
                                   doubanGroupGroup.setGroupId(value);
                                   break;
                            case "group_name":
                                   doubanGroupGroup.setGroupName(value);
                                   break;
                            case  "group_tags":
                                   doubanGroupGroup.setGroupTags(value);
                                   break;
                            case  "url":
                                   doubanGroupGroup.setUrl(value);
                                   break;
                            case   "content":
                                   doubanGroupGroup.setContent(value);
                                   break;
                            case  "create_time":
                                   doubanGroupGroup.setCreateTime(value);
                                   break;
                            case   "leader_name":
                                    doubanGroupGroup.setLeaderName(value);
                                    break;
                            case    "leader_href":
                                    doubanGroupGroup.setLeaderHref(value);
                                    break;
                            /*case    "time_stamp":
                                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                                    doubanGroupGroup.setTimeStamp(Timestamp.valueOf(df.format(value)));
                                    break;*/
                        }
                        Long time = new Long(rowKV.getTimestamp());
                       doubanGroupGroup.setTimeStamp(new Timestamp(time));

                    }
                    doubanGroupGroupService.saveDoubanGroupGroup(doubanGroupGroup);
                    //每隔100条打印一下时间
                   if (i % 100 == 0){
                       int k = i/100;
                       Long end100Time = new Date().getTime();
                       Long end100toBeginTime = (end100Time - beginTime) / 1000;
                       System.out.println("运行到第" + k + "百条所需：\t" + end100toBeginTime+"秒");
                   }
               }
                 Long endTime = new Date().getTime();
                 Long EndtoBeginTime = (endTime - beginTime) % 1000;
                 System.out.println("test_doubanGroupGroup_HTableToMysql运行到结束所需：\t" + EndtoBeginTime + "秒");
             }

}
