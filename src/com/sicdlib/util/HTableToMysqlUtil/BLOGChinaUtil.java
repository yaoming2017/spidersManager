package com.sicdlib.util.HTableToMysqlUtil;

import com.sicdlib.dto.entity.*;
import com.sicdlib.service.pythonService.IBLOGChinaAuthorService;
import com.sicdlib.service.pythonService.IBLOGChinaBlogService;
import com.sicdlib.service.pythonService.IBLOGChinaCommentService;
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
 * Created by init on 2017/6/3.
 */
public class BLOGChinaUtil {
    static ApplicationContext apx = new ClassPathXmlApplicationContext("beans.xml");

    /**
     * 博客中国htable_作者转换到Mysql中
     */
    @Test
    public void test_BLOGChinaAuthor_HTableToMysql() throws Exception{
        IBLOGChinaAuthorService blogChinaAuthorService = (IBLOGChinaAuthorService) apx.getBean("blogChinaAuthorService");
        Long beginTime = new Date().getTime();
        /**
         * 博客中国
         */
        //博客中国- 作者
        String htable_name = "blog_china_author";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            BlogchinaAuthorEntity blogchinaAuthor = new BlogchinaAuthorEntity();
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
                        blogchinaAuthor.setAuthorId(value);
                        break;
                    case "author_name":
                        blogchinaAuthor.setAuthorName(value);
                        break;
                    case "author_blog_name":
                        blogchinaAuthor.setAuthorBlogName(value);
                        break;
                    case "introduce":
                        blogchinaAuthor.setIntroduce(value);
                        break;
                    case "image":
                        blogchinaAuthor.setImage(value);
                        break;
                    case "b_image":
                        blogchinaAuthor.setbImage(value);
                        break;
                    case "article_num":
                        blogchinaAuthor.setArticleNum(Integer.parseInt(value));
                        break;
                    case "read_num":
                        blogchinaAuthor.setReadNum(Integer.parseInt(value));
                        break;
                    case "fans_num":
                        blogchinaAuthor.setFansNum(Integer.parseInt(value));
                        break;
                    case "focuse_num":
                        blogchinaAuthor.setFocuseNum(Integer.parseInt(value));
                        break;
                    case "all_article_url":
                        blogchinaAuthor.setAllArticleUrl(value);
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                blogchinaAuthor.setTimeStamp(new Timestamp(time));
            }
            blogChinaAuthorService.saveBLOGChinaAuthor(blogchinaAuthor);
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
     * 博客中国htable_评论转换到Mysql中
     */
    @Test
    public void test_BLOGChinaComment_HTableToMysql() throws Exception{
        IBLOGChinaCommentService blogChinaCommentService = (IBLOGChinaCommentService) apx.getBean(" blogChinaCommentService");
        Long beginTime = new Date().getTime();
        /**
         * 博客中国
         */
        //博客中国 - 评论
        String htable_name = "blog_china_comment";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            BlogchinaCommentEntity blogchinaComment = new BlogchinaCommentEntity();
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
                        blogchinaComment.setCommentId(value);
                        break;
                    case "comment_user_id":
                        blogchinaComment.setCommentUserId(value);
                        break;
                    case "comment_blog_id":
                        blogchinaComment.setCommentBlogId(value);
                        break;
                    case "comment_content":
                        blogchinaComment.setCommentContent(value);
                        break;
                    case "praise_num":
                        blogchinaComment.setPraiseNum(Integer.parseInt(value));
                        break;
                    case "praise_ids":
                        blogchinaComment.setPraiseIds(value);
                        break;
                    case "replay_id":
                        blogchinaComment.setReplayId(value);
                        break;
                    case "ip":
                        blogchinaComment.setIp(value);
                        break;
                    case "last_ip":
                        blogchinaComment.setLastIp(value);
                        break;
                }
                // 获取爬取数据时间戳
                Long time = new Long(rowKV.getTimestamp());
                blogchinaComment.setTimeStamp(new Timestamp(time));
            }
            blogChinaCommentService.saveBLOGChinaComment(blogchinaComment);
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
     * 博客中国htable_发布信息转换到Mysql中
     */
    @Test
    public void test_BLOGChinaBlog_HTableToMysql() throws Exception{
        IBLOGChinaBlogService blogChinaBlogService = (IBLOGChinaBlogService) apx.getBean("blogChinaBlogService");
        Long beginTime = new Date().getTime();
        /**
         *博客中国
         */
        //博客中国 -文章
        String htable_name = "blog_china_blog";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            BlogchinaBlogEntity blogchinaBlog = new BlogchinaBlogEntity();
            i++;
            for (KeyValue rowKV : result.raw()) {
                //字段名
                String qualifer = new String(rowKV.getQualifier());
                //值：字段对应的值
                String value = new String(rowKV.getValue());
                //将4字节表情或特殊字符去掉
                value = value.replaceAll("[\\x{10000}-\\x{10FFFF}]", "");
                switch (qualifer){
                    case "blog_id":
                        blogchinaBlog.setBlogId(value);
                        break;
                    case "title":
                        blogchinaBlog.setTitle(value);
                        break;
                    case "sub_title":
                        blogchinaBlog.setSubTitle(value);
                        break;
                    case "date_time":
                        String dateTime = "";
                        DateFormat sourceFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
                        DateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        dateTime = destFormat.format(sourceFormat.parse(value));
                        blogchinaBlog.setDateTime(dateTime);
                        break;
                    case "author_id":
                        blogchinaBlog.setAuthorId(value);
                        break;
                    case "category":
                        blogchinaBlog.setCategory(value);
                        break;
                    case "read_num":
                        blogchinaBlog.setReadNum(Integer.parseInt(value));
                        break;
                    case "comment_num":
                        blogchinaBlog.setCommentNum(Integer.parseInt(value));
                        break;
                    case "hand_up_num":
                        blogchinaBlog.setHandUpNum(Integer.parseInt(value));
                        break;
                    case "hand_down_num":
                        blogchinaBlog.setHandDownNum(Integer.parseInt(value));
                        break;
                    case "content":
                        blogchinaBlog.setContent(value);
                        break;
                    case "url":
                        blogchinaBlog.setUrl(value);
                        break;
                    case "b_pictures_num":
                        blogchinaBlog.setbPicturesNum(Integer.parseInt(value));
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                blogchinaBlog .setTimeStamp(new Timestamp(time));
            }
            blogChinaBlogService.saveBLOGChinaBlog(blogchinaBlog);
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
