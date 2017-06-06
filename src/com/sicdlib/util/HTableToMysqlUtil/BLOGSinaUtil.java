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
 * Created by init on 2017/6/3.
 */
public class BLOGSinaUtil {
    static ApplicationContext apx = new ClassPathXmlApplicationContext("beans.xml");

    /**
     * 新浪博客htable_作者转换到Mysql中
     */
    @Test
    public void test_BLOGSinaAuthor_HTableToMysql() throws Exception{
        IBLOGSinaAuthorService blogSinaAuthorService = (IBLOGSinaAuthorService) apx.getBean("blogSinaAuthorService");
        Long beginTime = new Date().getTime();
        /**
         * 新浪博客
         */
        //新浪博客 - 作者
        String htable_name = "blog_sina_author";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            BlogSinaAuthorEntity blogSinaAuthor = new BlogSinaAuthorEntity();
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
                        blogSinaAuthor.setAuthorId(value);
                        break;
                    case "author_name":
                        blogSinaAuthor.setAuthorName(value);
                        break;
                    case "picture_head_url":
                        blogSinaAuthor.setPictureHeadUrl(value);
                        break;
                    case "url":
                        blogSinaAuthor.setUrl(value);
                        break;
                    case "level":
                        blogSinaAuthor.setLevel(value);
                        break;
                    case "point":
                        blogSinaAuthor.setPoint(value);
                        break;
                    case "visit_num":
                        String  content_value=value.replaceAll(",","");
                        blogSinaAuthor.setVisitNum(Integer.parseInt(content_value));
                        break;
                    case "popularity":
                        blogSinaAuthor.setPopularity(value);
                        break;
                    case "get_golden":
                        blogSinaAuthor.setGetGolden(value);
                        break;
                    case "give_golden":
                        blogSinaAuthor.setGiveGolden(value);
                        break;
                    case "info":
                        blogSinaAuthor.setInfo(value);
                        break;
                    case "experience":
                        blogSinaAuthor.setExperience(value);
                        break;
                    case "introduction":
                        blogSinaAuthor.setIntroduction(value);
                        break;
                    case "certification":
                        blogSinaAuthor.setCertification(value);
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                blogSinaAuthor.setTimeStamp(new Timestamp(time));
            }
            blogSinaAuthorService.saveBLOGSinaAuthor(blogSinaAuthor);
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
     * 新浪博客htable_评论转换到Mysql中
     */
    @Test
    public void test_BLOGSinaComment_HTableToMysql() throws Exception{
        IBLOGSinaCommentService blogSinaCommentService = (IBLOGSinaCommentService) apx.getBean("blogSinaCommentService");
        Long beginTime = new Date().getTime();
        /**
         * 新浪博客
         */
        //新浪博客- 评论
        String htable_name = "blog_sina_comment";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            BlogSinaCommentEntity blogSinaComment = new BlogSinaCommentEntity();
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
                        blogSinaComment.setCommentId(value);
                        break;
                    case "post_id":
                        blogSinaComment.setPostId(value);
                        break;
                    case "author_id":
                        blogSinaComment.setAuthorId(value);
                        break;
                    case "author_name":
                        blogSinaComment.setAuthorName(value);
                        break;
                    case "author_href":
                        blogSinaComment.setAuthorHref(value);
                        break;
                    case "date_time":
                        String dateTime = "";
                        DateFormat sourceFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
                        DateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        dateTime = destFormat.format(sourceFormat.parse(value));
                        blogSinaComment.setDateTime(dateTime);
                        break;
                    case "content":
                        String   content_value = java.net.URLDecoder.decode(value,"utf-8");
                        blogSinaComment.setContent(content_value );
                        break;
                    case "replay_num":
                        blogSinaComment.setReplayNum(Integer.parseInt(value));
                        break;
                }
                //获取爬取数据时间戳
                Long time = new Long(rowKV.getTimestamp());
                blogSinaComment.setTimeStamp(new Timestamp(time));
            }
            blogSinaCommentService.saveBLOGSinaComment(blogSinaComment);
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
     * 新浪博客htable_发布信息转换到Mysql中
     */
    @Test
    public void test_BLOGSinaPost_HTableToMysql() throws Exception{
       IBLOGSinaPostService blogSinaPostService = (IBLOGSinaPostService) apx.getBean("blogSinaPostService");
        Long beginTime = new Date().getTime();
        /**
         * 新浪博客
         */
        //新浪博客 -文章
        String htable_name = "blog_sina_post";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
           BlogSinaPostEntity blogSinaPost = new BlogSinaPostEntity();
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
                        blogSinaPost.setPostId(value);
                        break;
                    case "author_id":
                        blogSinaPost.setAuthorId(value);
                        break;
                    case "author_name":
                        blogSinaPost.setAuthorName(value);
                        break;
                    case "author_href":
                        blogSinaPost.setAuthorHref(value);
                        break;
                    case "url":
                        blogSinaPost.setUrl(value);
                        break;
                    case "title":
                        blogSinaPost.setTitle(value);
                        break;
                    case "key_words":
                        blogSinaPost.setKeyWords(value);
                        break;
                    case "date_time":
                        String dateTime = "";
                        DateFormat sourceFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
                        DateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        dateTime = destFormat.format(sourceFormat.parse(value));
                        blogSinaPost.setDateTime(dateTime);
                        break;
                    case "tags":
                        blogSinaPost.setTags(value);
                        break;
                    case "content":
                        blogSinaPost.setContent(value);
                        break;
                    case "picture_hrefs":
                        blogSinaPost.setPictureHrefsNum(Integer.parseInt(value));
                        break;
                    case "url_in_content":
                        blogSinaPost.setUrlInContent(value);
                        break;
                    case "enjoy_num":
                        blogSinaPost.setEnjoyNum(Integer.parseInt(value));
                        break;
                    case "get_golden_num":
                        blogSinaPost.setGetGoldenNum(Integer.parseInt(value));
                        break;
                    case "read_num":
                        blogSinaPost.setReadNum(Integer.parseInt(value));
                        break;
                    case "comment_num":
                        blogSinaPost.setCommentNum(Integer.parseInt(value));
                        break;
                    case "collect_num":
                        blogSinaPost.setCollectNum(Integer.parseInt(value));
                        break;
                    case "forward_num":
                        blogSinaPost.setForwardNum(Integer.parseInt(value));
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                blogSinaPost.setTimeStamp(new Timestamp(time));
            }
            blogSinaPostService.saveBLOGSinaPost(blogSinaPost);
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
