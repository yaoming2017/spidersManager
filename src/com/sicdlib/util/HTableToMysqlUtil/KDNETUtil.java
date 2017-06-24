package com.sicdlib.util.HTableToMysqlUtil;

import com.sicdlib.dto.entity.*;
import com.sicdlib.service.pythonService.IKDNETAuthorService;
import com.sicdlib.service.pythonService.IKDNETCommentService;
import com.sicdlib.service.pythonService.IKDNETPostService;
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

import java.util.Date;


/**
 * Created by init on 2017/6/5.
 */
public class KDNETUtil {
    static ApplicationContext apx = new ClassPathXmlApplicationContext("beans.xml");

    /**
     * 凯迪社区_作者转换到Mysql中
     */
    @Test
    public void test_KDNETAuthor_HTableToMysql() throws Exception{
        IKDNETAuthorService kdnetAuthorService = (IKDNETAuthorService) apx.getBean("kdnetAuthorService");
        Long beginTime = new Date().getTime();
        /**
         * 凯迪社区
         */
        //凯迪社区 - 作者
        String htable_name = "kdnet_author";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            KdnetAuthorEntity kdnetAuthor = new KdnetAuthorEntity();
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
                        kdnetAuthor.setAuthorId(value);
                        break;
                    case "url":
                        kdnetAuthor.setUrl(value);
                        break;
                    case "nick":
                        kdnetAuthor.setNick(value);
                        break;
                    case "level":
                        kdnetAuthor.setLevel(value);
                        break;
                    case "influence":
                        kdnetAuthor.setInfluence(Double.parseDouble(value));
                        break;
                    case "hits":
                        kdnetAuthor.setHits(Integer.parseInt(value));
                        break;
                    case "post_num":
                        kdnetAuthor.setPostNum(Integer.parseInt(value));
                        break;
                    case "fans_num":
                        kdnetAuthor.setFansNum(Integer.parseInt(value));
                        break;
                    case "friends_num":
                        kdnetAuthor.setFriendsNum(Integer.parseInt(value));
                        break;
                    case "register_time":
                        kdnetAuthor.setRegisterTime(value);
                        break;
                    case "login_num":
                        kdnetAuthor.setLoginNum(Integer.parseInt(value));
                        break;
                    case  "parse_time":
                        Double time =Double.parseDouble(value) * 1000;
                        Long longTime = new Long(time.longValue());
                        kdnetAuthor.setParseTime(new Timestamp(longTime));
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                kdnetAuthor.setTimeStamp(new Timestamp(time));
            }
            kdnetAuthorService.saveKDNETAuthor(kdnetAuthor);
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
     * 凯迪社区htable_评论转换到Mysql中
     */
    @Test
    public void test_KDNETComment_HTableToMysql() throws Exception{
        IKDNETCommentService kdnetCommentService = (IKDNETCommentService) apx.getBean("kdnetCommentService");
        Long beginTime = new Date().getTime();
        /**
         * 凯迪社区
         */
        //凯迪社区- 评论
        String htable_name = "kdnet_comment";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            KdnetCommentEntity kdnetComment = new KdnetCommentEntity();
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
                        kdnetComment.setCommentId(value);
                        break;
                    case "author_href":
                        kdnetComment.setAtHref(value);
                        break;
                    case "author_nick":
                        kdnetComment.setAuthorNick(value);
                        break;
                    case "author_id":
                        kdnetComment.setAuthorId(value);
                        break;
                    case "post_id":
                        kdnetComment.setPostId(value);
                        break;
                    case "floor_num":
                        kdnetComment.setFloorNum(Integer.parseInt(value));
                        break;
                    case "date_time":
                        String dateTime = "";
                        if(value.equals("")){
                            kdnetComment.setDateTime("2016-03-12 12:30:21");
                        }else {
                            DateFormat sourceFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
                            DateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                            dateTime = destFormat.format(sourceFormat.parse(value));
                            kdnetComment.setDateTime(dateTime);
                        }
                        break;
                    case "content":
                        kdnetComment.setContent(value);
                        break;
                    case "at_user":
                        kdnetComment.setAtUser(value);
                        break;
                    case "at_href":
                        kdnetComment.setAtHref(value);
                        break;
                    case "quote_comment_id":
                        kdnetComment.setQuoteCommentId(value);
                        break;
                    case "parse_time":
                       Double time = Double.parseDouble(value) * 1000;
                       Long longTime = new Long(time.longValue());
                        kdnetComment.setParseTime(new Timestamp(longTime));
                        break;
                }
                // 获取爬取数据时间戳
                Long time = new Long(rowKV.getTimestamp());
                kdnetComment.setTimeStamp(new Timestamp(time));

            }
            kdnetCommentService.saveKDNETComment(kdnetComment);
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
     * 凯迪社区htable_发布信息转换到Mysql中
     */
    @Test
    public void test_KDNETPost_HTableToMysql() throws Exception{
        IKDNETPostService kdnetPostService = (IKDNETPostService) apx.getBean("kdnetPostService");
        Long beginTime = new Date().getTime();
        /**
         * 凯迪社区
         */
        //凯迪社区 -文章
        String htable_name = "kdnet_post";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            KdnetPostEntity kdnetPost = new KdnetPostEntity();
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
                        kdnetPost.setPostId(value);
                        break;
                    case "author_id":
                        kdnetPost.setAuthorId(value);
                        break;
                    case "post_status":
                        kdnetPost.setPostStatus(value);
                        break;
                    case "post_url":
                        kdnetPost.setPostUrl(value);
                        break;
                    case "title":
                        kdnetPost.setTitle(value);
                        break;
                    case "author":
                        kdnetPost.setAuthor(value);
                        break;
                    case "author_href":
                        kdnetPost.setAtHref(value);
                        break;
                    case "post_time":
                        kdnetPost.setDateTime(value);
                        break;
                    case "category":
                        kdnetPost.setCategory(value);
                        break;
                    case "hits":
                        kdnetPost.setHits(Integer.parseInt(value));
                        break;
                    case "comment_num":
                        kdnetPost.setCommentNum(Integer.parseInt(value));
                        break;
                    case "at_user":
                        kdnetPost.setAtUser(value);
                        break;
                    case "at_href":
                        kdnetPost.setAtHref(value);
                        break;
                    case "content":
                        kdnetPost.setContent(value);
                        break;
                    case  "parse_time":
                        Double time = Double.parseDouble(value) *1000;
                        Long longTime = new Long(time.longValue());
                        kdnetPost.setDateTime(new Timestamp(longTime).toString());
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                kdnetPost.setTimeStamp(new Timestamp(time));
            }
            kdnetPostService.saveKDNETPost(kdnetPost);
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
