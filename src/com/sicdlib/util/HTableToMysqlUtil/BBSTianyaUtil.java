package com.sicdlib.util.HTableToMysqlUtil;

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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by init on 2017/6/2.
 */
public class BBSTianyaUtil {
    static ApplicationContext apx = new ClassPathXmlApplicationContext("beans.xml");

    /**
     * 天涯htable_作者转换到Mysql中
     */
    @Test
    public void test_bbsTianyaAuthor_HTableToMysql() throws Exception{
        IBBSTianyaAuthorService bbsTianyaAuthorService = (IBBSTianyaAuthorService) apx.getBean("bbsTianyaAuthorService");
        Long beginTime = new Date().getTime();
        /**
         * 天涯
         */
        //天涯 - 作者
        String htable_name = "bbs_tianya_author";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            BbsTianyaAuthorEntity bbsTianyaAuthor = new BbsTianyaAuthorEntity();
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
                        bbsTianyaAuthor.setAuthorId(value);
                        break;
                    case "author_name":
                        bbsTianyaAuthor.setAuthorName(value);
                        break;
                    case "level":
                        bbsTianyaAuthor.setLevel(value);
                        break;
                    case "friends_num":
                        bbsTianyaAuthor.setFriendsNum(Integer.parseInt(value));
                        break;
                    case "fans_num":
                        bbsTianyaAuthor.setFansNum(Integer.parseInt(value));
                        break;
                    case "point":
                        bbsTianyaAuthor.setPoint(value);
                        break;
                    case "login_num":
                        bbsTianyaAuthor.setLoginNum(Integer.parseInt(value));
                        break;
                    case "register_date":
                        bbsTianyaAuthor.setRegisterDate(value);
                        break;
                    case "location":
                        bbsTianyaAuthor.setLocation(value);
                        break;
                    case "url":
                        bbsTianyaAuthor.setUrl(value);
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                bbsTianyaAuthor.setTimeStamp(new Timestamp(time));
            }
            bbsTianyaAuthorService.saveBBSTianyaAuthor(bbsTianyaAuthor);
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
     * 天涯htable_评论转换到Mysql中
     */
    @Test
    public void test_bbsTianyaComment_HTableToMysql() throws Exception{
        IBBSTianyaCommentService bbsTianyaCommentService = (IBBSTianyaCommentService) apx.getBean("bbsTianyaCommentService");
        Long beginTime = new Date().getTime();
        /**
         * 天涯
         */
        //天涯 - 评论
        String htable_name = "bbs_tianya_comment";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            BbsTianyaCommentEntity bbsTianyaComment = new BbsTianyaCommentEntity();
            i++;
            for (KeyValue rowKV : result.raw()) {
                //字段名
                String qualifer = new String(rowKV.getQualifier());
                //值：字段对应的值
                String value = new String(rowKV.getValue());
                //将4字节表情或特殊字符去掉
                value = value.replaceAll("[\\x{10000}-\\x{10FFFF}]", "");
                switch (qualifer){
                    case "comment_id":
                        bbsTianyaComment.setCommentId(value);
                        break;
                    case "author_id":
                        bbsTianyaComment.setAuthorId(value);
                        break;
                    case "post_id":
                        bbsTianyaComment.setPostId(value);
                        break;
                    case "author_name":
                        bbsTianyaComment.setAuthorName(value);
                        break;
                    case "author_href":
                        bbsTianyaComment.setAuthorHref(value);
                        break;
                    case "content":
                        bbsTianyaComment.setContent(value);
                        break;
                    case "date_time":
                        String dateTime = "";
                        DateFormat sourceFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
                        DateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        dateTime = destFormat.format(sourceFormat.parse(value));
                        bbsTianyaComment.setDateTime(dateTime);
                        break;
                }
                // 获取爬取数据时间戳
                Long time = new Long(rowKV.getTimestamp());
                bbsTianyaComment.setTimeStamp(new Timestamp(time));
            }
            bbsTianyaCommentService.saveBBSTianyaComment(bbsTianyaComment);
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
     * 天涯htable_发布信息转换到Mysql中
     */
    @Test
    public void test_bbsTianyaPost_HTableToMysql() throws Exception{
       IBBSTianyaPostService bbsTianyaPostService = (IBBSTianyaPostService) apx.getBean("bbsTianyaPostService ");
        Long beginTime = new Date().getTime();
        /**
         * 天涯
         */
        //天涯 -文章
        String htable_name = "bbs_tianya_post";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            BbsTianyaPostEntity bbsTianyaPost =new BbsTianyaPostEntity();
            i++;
            for (KeyValue rowKV : result.raw()) {
                //字段名
                String qualifer = new String(rowKV.getQualifier());
                //值：字段对应的值
                String value = new String(rowKV.getValue());
                //将4字节表情或特殊字符去掉
                value = value.replaceAll("[\\x{10000}-\\x{10FFFF}]", "");
                switch (qualifer){
                    case "post_id":
                        bbsTianyaPost.setPostId(value);
                        break;
                    case "author_id":
                        bbsTianyaPost.setAuthorId(value);
                        break;
                    case "url":
                        bbsTianyaPost.setUrl(value);
                        break;
                    case "author_name":
                        bbsTianyaPost.setAuthorName(value);
                        break;
                    case "author_url":
                        bbsTianyaPost.setAuthorUrl(value);
                        break;
                    case "title":
                        bbsTianyaPost.setTitle(value);
                        break;
                    case "key_words":
                        bbsTianyaPost.setKeyWords(value);
                        break;
                    case "tags":
                        bbsTianyaPost.setTags(value);
                        break;
                    case "date_time":
                        String dateTime = "";
                        DateFormat sourceFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
                        DateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        dateTime = destFormat.format(sourceFormat.parse(value));
                        bbsTianyaPost.setDateTime(dateTime);
                        break;
                    case "create_time":
                        bbsTianyaPost.setCreateTime(value);
                        break;
                    case "content":
                        bbsTianyaPost.setContent(value);
                        break;
                    case "picture_hrefs":
                        bbsTianyaPost.setPictureHrefsNum(Integer.parseInt(value));
                        break;
                    case "category":
                        bbsTianyaPost.setCategory(value);
                        break;
                    case "comment_num":
                        bbsTianyaPost.setCommentNum(Integer.parseInt(value));
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                bbsTianyaPost.setTimeStamp(new Timestamp(time));
            }
            bbsTianyaPostService.saveBBSTianyaPost(bbsTianyaPost);
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
}
