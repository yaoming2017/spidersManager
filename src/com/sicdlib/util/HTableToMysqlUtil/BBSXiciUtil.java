package com.sicdlib.util.HTableToMysqlUtil;


import com.sicdlib.dto.entity.*;
import com.sicdlib.service.pythonService.IBBSXiciCommentService;
import com.sicdlib.service.pythonService.IBBSXiciPostService;
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
 * Created by init on 2017/6/2.
 */
public class BBSXiciUtil {
    static ApplicationContext apx = new ClassPathXmlApplicationContext("beans.xml");
/*
    *//**
     * 天涯htable_作者转换到Mysql中
     *//*
    @Test
    public void test_bbsXiciAuthor_HTableToMysql() throws Exception{
        IBBSXiciAuthorService bbsXiciAuthorService = (IBBSXiciAuthorService) apx.getBean("bbsXiciAuthorService");
        Long beginTime = new Date().getTime();
        *//**
         * 西祠
         *//*
        //西祠 - 作者
        String htable_name = "bbs_xici_author";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            BbsXiciAuthorEntity bbsXiciAuthor = new BbsXiciAuthorEntity();
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
                        bbsXiciAuthor.setAuthorId(value);
                        break;
                    case "author_name":
                        bbsXiciAuthor.setAuthorName(value);
                        break;
                    case "author_href":
                        bbsXiciAuthor.setAuthorHref(value);
                        break;
                    case "register_time":
                        bbsXiciAuthor.setRegisterTime(value);
                        break;
                    case "parse_time":
                         Double doubleTime = Double.parseDouble(value) * 1000;
                         Long longTime = new Long(doubleTime.longValue());
                         bbsXiciAuthor.setParseTime(new Timestamp(longTime));
                         break;
                }
                Long time = new Long(rowKV.getTimestamp());
                bbsXiciAuthor.setTimeStamp(new Timestamp(time));
            }
            bbsXiciAuthorService.saveBBSXiciAuthor(bbsXiciAuthor);
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
    }*/

    /**
     * 西祠htable_评论转换到Mysql中
     */
    @Test
    public void test_bbsXiciComment_HTableToMysql() throws Exception{
        IBBSXiciCommentService bbsXiciCommentService = (IBBSXiciCommentService) apx.getBean("bbsXiciCommentService");
        Long beginTime = new Date().getTime();
        /**
         * 西祠
         */
        //西祠 - 评论
        String htable_name = "bbs_xici_comment";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            BbsXiciCommentEntity bbsXiciComment = new BbsXiciCommentEntity();
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
                        bbsXiciComment.setCommentId(value);
                        break;
                    case "post_id":
                        bbsXiciComment.setPostId(value);
                        break;
                    case "author_id":
                        bbsXiciComment.setAuthorId(value);
                        break;
                    case "author_name":
                        bbsXiciComment .setAuthorName(value);
                        break;
                    case "author_href":
                        bbsXiciComment .setAuthorHref(value);
                        break;
                    case "content":
                        bbsXiciComment .setContent(value);
                        break;
                    case "date_time":;
                        bbsXiciComment .setDateTime(value);
                        break;
                    case "floor":
                        bbsXiciComment.setFloor(value);
                        break;
                    case "parse_time":
                        Double doubleTime = Double.parseDouble(value) * 1000;
                        Long longTime = new Long(doubleTime.longValue());
                        bbsXiciComment.setParseTime(new Timestamp(longTime));
                        break;

                }
                // 获取爬取数据时间戳
                Long time = new Long(rowKV.getTimestamp());
                bbsXiciComment.setTimeStamp(new Timestamp(time));
            }
            bbsXiciCommentService.saveBBSXiciComment(bbsXiciComment);
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
     * 西祠htable_发布信息转换到Mysql中
     */
    @Test
    public void test_bbsXiciPost_HTableToMysql() throws Exception{
        IBBSXiciPostService bbsXiciPostService = (IBBSXiciPostService) apx.getBean("bbsXiciPostService");
        Long beginTime = new Date().getTime();
        /**
         * 西祠
         */
        //西祠-文章
        String htable_name = "bbs_xici_post";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            BbsXiciPostEntity bbsXiciPost = new BbsXiciPostEntity();
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
                        bbsXiciPost.setPostId(value);
                        break;
                    case "comment_ids":
                        List<String> listString = this.getCommentId(value);
                        bbsXiciPost.setCommentNum(listString.size());
                        break;
                    case "author_id":
                        bbsXiciPost.setAuthorId(value);
                        break;
                    case "author_name":
                        bbsXiciPost.setAuthorName(value);
                        break;
                    case "author_href":
                        bbsXiciPost.setAuthorHref(value);
                        break;
                    case "key_words":
                        bbsXiciPost.setKeyWords(value);
                        break;
                    case "title":
                        bbsXiciPost.setTitle(value);
                        break;
                    case "content":
                        bbsXiciPost.setContent(value);
                        break;
                    case "date_time":
                        bbsXiciPost.setDateTime(value);
                        break;
                    case "url":
                        bbsXiciPost.setUrl(value);
                        break;
                    case "parse_time":
                        Double doubleTime = Double.parseDouble(value) * 1000;
                        Long longTime = new Long(doubleTime.longValue());
                        bbsXiciPost.setParseTime(new Timestamp(longTime));
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                bbsXiciPost.setTimeStamp(new Timestamp(time));
            }
           bbsXiciPostService.saveBBSXiciPost(bbsXiciPost);
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
    private List<String> getCommentId(String comment_ids){
        String[] commentIdsSplit = comment_ids.split("'");
        List<String> arrayList = new ArrayList<>();
        for(int i=1;i<commentIdsSplit.length;i=i+2){
            arrayList.add(commentIdsSplit[i]);
        }
        return  arrayList;

    }
}
