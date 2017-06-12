package com.sicdlib.util.HTableToMysqlUtil;

import com.sicdlib.dto.entity.*;
import com.sicdlib.service.pythonService.IBBSXinhuaAuthorService;
import com.sicdlib.service.pythonService.IBBSXinhuaCommentService;
import com.sicdlib.service.pythonService.IBBSXinhuaPostService;
import com.sicdlib.util.HBaseUtil.HBaseData;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by init on 2017/6/3.
 */
public class BBSXinhuaUtil {
    static ApplicationContext apx = new ClassPathXmlApplicationContext("beans.xml");

    /**
     * 新华网htable_作者转换到Mysql中
     */
    @Test
    public void test_bbsXinhuaAuthor_HTableToMysql() throws Exception{
        IBBSXinhuaAuthorService bbsXinhuaAuthorService = (IBBSXinhuaAuthorService) apx.getBean("bbsXinhuaAuthorService");
        Long beginTime = new Date().getTime();
        /**
         * 新华网
         */
        //新华网 - 作者
        String htable_name = "bbs_xinhua_author";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            BbsXinhuaAuthorEntity bbsXinhuaAuthor = new BbsXinhuaAuthorEntity();
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
                        bbsXinhuaAuthor.setAuthorId(value);
                        break;
                    case "author_href":
                        bbsXinhuaAuthor.setAuthorHref(value);
                        break;
                    case "author_name":
                        bbsXinhuaAuthor.setAuthorName(value);
                        break;
                    case "post_num":
                        int postNum =0;
                        if(value.contains("万")){
                            double doublePostNum = Double.parseDouble(value.substring(0,value.length()-1));
                            postNum =(int)(doublePostNum * 10000);
                        }else{
                            postNum =Integer.parseInt(value);
                        }
                        bbsXinhuaAuthor.setPostNum(postNum);
                        break;
                    case "level":
                        bbsXinhuaAuthor.setLevel(value);
                        break;
                    case "url":
                        bbsXinhuaAuthor.setUrl(value);
                        break;
                    case "login_num":
                        bbsXinhuaAuthor.setLoginNum(Integer.parseInt(value));
                        break;
                    case "register_time":
                        bbsXinhuaAuthor.setRegisterTime(value);
                        break;
                    case  "parse_time":
                        Double time = Double.parseDouble(value) * 1000;
                        Long longTime = new Long(time.longValue());
                        bbsXinhuaAuthor.setParseTime(new Timestamp(longTime));
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                bbsXinhuaAuthor.setTimeStamp(new Timestamp(time));
            }
            bbsXinhuaAuthorService.saveBBSXinhuaAuthor(bbsXinhuaAuthor);
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
     * 新华网htable_评论转换到Mysql中
     */
    @Test
    public void test_bbsXinhuaComment_HTableToMysql() throws Exception{
       IBBSXinhuaCommentService bbsXinhuaCommentService = (IBBSXinhuaCommentService) apx.getBean("bbsXinhuaCommentService");
        Long beginTime = new Date().getTime();
        /**
         * 新华网
         */
        //新华网 - 评论
        String htable_name = "bbs_xinhua_comment";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            BbsXinhuaCommentEntity bbsXinhuaComment = new BbsXinhuaCommentEntity();
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
                        bbsXinhuaComment.setCommentId(value);
                        break;
                    case "post_id":
                        bbsXinhuaComment.setPostId(value);
                        break;
                    case "author_id":
                        bbsXinhuaComment.setAuthorId(value);
                        break;
                    case "author_name":
                        bbsXinhuaComment.setAuthorName(value);
                        break;
                    case "author_href":
                        bbsXinhuaComment.setAuthorHref(value);
                        break;
                    case "date_time":
                        bbsXinhuaComment.setDateTime(value);
                        break;
                    case "content":
                        bbsXinhuaComment.setContent(value);
                        break;
                    case "floor":
                        bbsXinhuaComment.setFloor(value);
                        break;
                    case "refer":
                        bbsXinhuaComment.setRefer(value);
                        break;
                    case "prise_num":
                        bbsXinhuaComment.setPriseNum(Integer.parseInt(value));
                        break;
                    case "parse_time":
                        Double time = Double.parseDouble(value) * 1000;
                        Long longTime = new Long(time.longValue());
                        bbsXinhuaComment.setParseTime(new Timestamp(longTime));
                        break;
                }
                // 获取爬取数据时间戳
                Long time = new Long(rowKV.getTimestamp());
                bbsXinhuaComment.setTimeStamp(new Timestamp(time));
            }
            bbsXinhuaCommentService.saveBBSXinhuaComment(bbsXinhuaComment);
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
     * 新华网htable_发布信息转换到Mysql中
     */
    @Test
    public void test_bbsXinhuaPost_HTableToMysql() throws Exception{
        IBBSXinhuaPostService bbsXinhuaPostService = (IBBSXinhuaPostService) apx.getBean("bbsXinhuaPostService");
        Long beginTime = new Date().getTime();
        /**
         * 新华网
         */
        //新华网 -文章
        String htable_name = "bbs_xinhua_post";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
           BbsXinhuaPostEntity bbsXinhuaPost = new BbsXinhuaPostEntity();
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
                        bbsXinhuaPost.setPostId(value);
                        break;
                    case "author_id":
                        bbsXinhuaPost.setAuthorId(value);
                        break;
                    case "author_name":
                        bbsXinhuaPost.setAuthorName(value);
                        break;
                    case "author_url":
                        bbsXinhuaPost.setAuthorUrl(value);
                        break;
                    case "title":
                        bbsXinhuaPost.setTitle(value);
                        break;
                    case "path_href":
                        bbsXinhuaPost.setPathHref(value);
                        break;
                    case "date_time":
                        bbsXinhuaPost.setDateTime(value);
                        break;
                    case "path_text":
                        bbsXinhuaPost.setPathText(value);
                        break;
                    case "read_num":
                        bbsXinhuaPost.setReadNum(Integer.parseInt(value));
                        break;
                    case "comment_num":
                        bbsXinhuaPost.setCommentNum(Integer.parseInt(value));
                        break;
                    case "like_num":
                        bbsXinhuaPost.setLikeNum(Integer.parseInt(value));
                        break;
                    case "detail_href":
                        bbsXinhuaPost.setDetailHref(value);
                        break;
                    case "content":
                        bbsXinhuaPost.setContent(value);
                        break;
                    case "url":
                        bbsXinhuaPost.setUrl(value);
                        break;
                    case  "parse_time":
                        Double time = Double.parseDouble(value) * 1000;
                        Long longTime =new Long(time.longValue());
                        bbsXinhuaPost.setParseTime(new Timestamp(longTime));
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                bbsXinhuaPost.setTimeStamp(new Timestamp(time));
            }
            bbsXinhuaPostService.saveBBSXinhuaPost(bbsXinhuaPost);
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
