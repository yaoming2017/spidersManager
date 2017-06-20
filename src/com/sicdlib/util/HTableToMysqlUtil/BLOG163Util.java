package com.sicdlib.util.HTableToMysqlUtil;

import com.sicdlib.dto.entity.*;
import com.sicdlib.service.pythonService.IBLOG163AuthorService;
import com.sicdlib.service.pythonService.IBLOG163CommentService;
import com.sicdlib.service.pythonService.IBLOG163PostService;
import com.sicdlib.util.HBaseUtil.HBaseData;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.misc.BASE64Decoder;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by init on 2017/6/3.
 */
public class BLOG163Util {
    static ApplicationContext apx = new ClassPathXmlApplicationContext("beans.xml");

    /**
     * 网易博客htable_作者转换到Mysql中
     */
    @Test
    public void test_BLOG163Author_HTableToMysql() throws Exception{
        IBLOG163AuthorService blog163AuthorService = (IBLOG163AuthorService) apx.getBean("blog163AuthorService");
        Long beginTime = new Date().getTime();
        /**
         * 网易博客
         */
        //网易博客- 作者
        String htable_name = "blog_163_author";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            Blog163AuthorEntity blog163Author = new Blog163AuthorEntity();
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
                        blog163Author.setAuthorId(value);
                        break;
                    case "url":
                        blog163Author.setUrl(value);
                        break;
                    case "nick":
                        blog163Author.setNick(value);
                        break;
                    case "sex":
                        blog163Author.setSex(value);
                        break;
                    case "birthday":
                        blog163Author.setBirthday(value);
                        break;
                    case "hometown":
                        blog163Author.setHometown(value);
                        break;
                    case "apartment":
                        blog163Author.setApartment(value);
                        break;
                    case "introduce":
                        blog163Author.setIntroduce(value);
                        break;
                    case "wish":
                        blog163Author.setWish(value);
                        break;
                    case "circle":
                        blog163Author.setCircle(value);
                        break;
                    case "level":
                        blog163Author.setLevel(value);
                        break;
                    case "point":
                        blog163Author.setPoint(value);
                        break;
                    case "register_time":
                        blog163Author.setRegisterTime(value);
                        break;
                    case "update_time":
                        blog163Author.setUpdateTime(value);
                        break;
                    case "last_login":
                        blog163Author.setLastLogin(value);
                        break;
                    case "information":
                        blog163Author.setInformation(value);
                        break;
                    case "experience":
                        blog163Author.setExperience(value);
                        break;
                    case "contact":
                        blog163Author.setContact(value);
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                blog163Author.setTimeStamp(new Timestamp(time));
            }
            blog163AuthorService.saveBLOG163Author(blog163Author);
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
     * 网易博客htable_评论转换到Mysql中
     */
    @Test
    public void test_BLOG163Comment_HTableToMysql() throws Exception{
        IBLOG163CommentService blog163CommentService = (IBLOG163CommentService) apx.getBean("blog163CommentService");
        Long beginTime = new Date().getTime();
        /**
         * 网易博客
         */
        //网易博客 - 评论
        String htable_name = "blog_163_comment";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            Blog163CommentEntity blog163Comment = new Blog163CommentEntity();
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
                        blog163Comment.setCommentId(value);
                        break;
                    case "post_id":
                        blog163Comment.setPostId(value);
                        break;
                    case "author_id":
                        blog163Comment.setAuthorId(value);
                        break;
                    case "author_name":
                        blog163Comment.setAuthorName(value);
                        break;
                    case "author_href":
                        blog163Comment.setAuthorHref(value);
                        break;
                    case "content":
                        blog163Comment.setContent(value);
                        break;
                    case "date_time":
                        String dateTime = "";
                        DateFormat sourceFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
                        DateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        dateTime = destFormat.format(sourceFormat.parse(value));
                        blog163Comment.setDateTime(dateTime);
                        break;
                    case "replay_comment_id":
                        blog163Comment.setReplayCommentId(value);
                        break;
                    case "child_comment_ids":
                        blog163Comment.setChildCommentIds(value);
                        break;
                    case "parse_time":
                        Double time = Double.parseDouble(value) * 1000;
                        Long longTime = new Long(time.longValue());
                        blog163Comment.setParseTime(new Timestamp(longTime));
                        break;
                }
                // 获取爬取数据时间戳
                Long time = new Long(rowKV.getTimestamp());
                blog163Comment.setTimeStamp(new Timestamp(time));
            }
            blog163CommentService.saveBLOG163Comment(blog163Comment);
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
     * 网易博客htable_发布信息转换到Mysql中
     */
    @Test
    public void test_BLOG163Post_HTableToMysql() throws Exception{
        IBLOG163PostService blog163PostService = (IBLOG163PostService) apx.getBean("blog163PostService ");
        Long beginTime = new Date().getTime();
        /**
         * 网易博客
         */
        //网易博客 -文章
        String htable_name = "blog_163_post";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            Blog163PostEntity blog163Post = new Blog163PostEntity();
            i++;
            for (KeyValue rowKV : result.raw()) {
                //字段名
                String qualifer = new String(rowKV.getQualifier());
                //值：字段对应的值
                String value = new String(rowKV.getValue());
                //将4字节表情或特殊字符去掉
                value = value.replaceAll("[\\x{10000}-\\x{10FFFF}]", "");
                switch (qualifer){
                    case "author_id":
                        blog163Post.setAuthorId(value);
                        break;
                    case "title":
                        blog163Post.setTitle(value);
                        break;
                    case "date_time":
                        blog163Post.setDateTime(value);
                        break;
                    case "category":
                        blog163Post.setCategory(value);
                        break;
                    case "key_words":
                        blog163Post.setKeyWords(value);
                        break;
                    case "author_name":
                        blog163Post.setAuthorName(value);
                        break;
                    case "author_href":
                        blog163Post.setAuthorHref(value);
                        break;
                    case "content":
                        String content_value = String.valueOf((new BASE64Decoder()).decodeBuffer(value));
                        blog163Post.setContent(content_value);
                        break;
                    case "hrefs_in_post":
                        blog163Post.setHrefsInPost(value);
                        break;
                    case "read_num":
                        if(value.equals("")){
                            blog163Post.setReadNum(0);
                        }else {
                            blog163Post.setReadNum(Integer.parseInt(value));
                        }
                        break;
                    case "comment_num":
                        if(value.equals("")){
                            blog163Post.setCommentNum(0);
                        }else {
                            blog163Post.setCommentNum(Integer.parseInt(value));
                        }
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                blog163Post.setTimeStamp(new Timestamp(time));
            }
            blog163PostService.saveBLOG163Post(blog163Post);
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
