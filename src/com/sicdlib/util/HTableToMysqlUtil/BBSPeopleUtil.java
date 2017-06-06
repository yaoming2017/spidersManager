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
import java.util.Date;
import java.util.List;

/**
 * Created by init on 2017/5/31.
 */
public class BBSPeopleUtil {
    static ApplicationContext apx = new ClassPathXmlApplicationContext("beans.xml");

    /**
     * 人民网htable_作者转换到Mysql中
     */
    @Test
    public void test_bbsPeopleAuthor_HTableToMysql() throws Exception{
        IBBSPeopleAuthorService bbsPeopleAuthorService = (IBBSPeopleAuthorService) apx.getBean("bbsPeopleAuthorService");
        Long beginTime = new Date().getTime();
        /**
         * 人民网
         */
        //人民网 - 作者
        String htable_name = "bbs_people_author";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
           BbsPeopleAuthorEntity bbsPeopleAuthor = new BbsPeopleAuthorEntity();
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
                        bbsPeopleAuthor.setAuthorId(value);
                        break;
                    case "author_name":
                        bbsPeopleAuthor.setAuthorName(value);
                        break;
                    case "url":
                        bbsPeopleAuthor.setUrl(value);
                        break;
                    case "post_num":
                        int postNum =0;
                        if(value.contains("万")){
                             double doublePostNum = Double.parseDouble(value.substring(0,value.length()-1));
                             postNum = (int)(doublePostNum*10000);
                        }else{
                            postNum =Integer.parseInt(value);
                        }
                        bbsPeopleAuthor.setPostNum(postNum);
                        break;
                    case "reply_num":
                        int replyNum=0;
                        if(value.contains("万")) {
                            double doubleReplyNum= Double.parseDouble(value.substring(0, value.length() - 1));
                            replyNum =(int)(doubleReplyNum* 10000);
                        }else{
                            replyNum =Integer.parseInt(value);
                        }
                        bbsPeopleAuthor.setReplyNum(replyNum);
                        break;
                    case "elite_num":
                        bbsPeopleAuthor.setEliteNum(Integer.parseInt(value));
                        break;
                    case "level":
                        bbsPeopleAuthor.setLevel(value);
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                bbsPeopleAuthor.setTimeStamp(new Timestamp(time));
            }
           bbsPeopleAuthorService.saveBBSPeopleAuthor(bbsPeopleAuthor);
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
     * 人民网htable_评论转换到Mysql中
     */
    @Test
    public void test_bbsPeopleComment_HTableToMysql() throws Exception{
        IBBSPeopleCommentService bbsPeopleCommentService = (IBBSPeopleCommentService) apx.getBean("bbsPeopleCommentService");
        Long beginTime = new Date().getTime();
        /**
         * 人民网
         */
        //人民网- 评论
        String htable_name = "bbs_people_comment";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
          BbsPeopleCommentEntity bbsPeopleComment = new BbsPeopleCommentEntity();
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
                       bbsPeopleComment.setId(value);
                        break;
                    case "post_id":
                       bbsPeopleComment.setPostId(value);
                        break;
                    case "author_id":
                        bbsPeopleComment.setAuthorId(value);
                        break;
                    case "author_name":
                        bbsPeopleComment.setAuthorName(value);
                        break;
                    case "author_href":
                        bbsPeopleComment.setAuthorHref(value);
                        break;
                    case "date_time":
                        String dateTime = "";
                        DateFormat sourceFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
                        DateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        dateTime = destFormat.format(sourceFormat.parse(value));
                        bbsPeopleComment.setDateTime(dateTime);
                        break;
                    case "floor":
                        bbsPeopleComment.setFloor(value);
                        break;
                    case "prise_num":
                       bbsPeopleComment.setPriseNum(Integer.parseInt(value));
                        break;
                    case "parent_comment_id":
                       bbsPeopleComment.setParentCommentId(value);
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                bbsPeopleComment.setTimeStamp(new Timestamp(time));
            }
            bbsPeopleCommentService.saveBBSPeopleComment(bbsPeopleComment);
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
     * 人民网htable_发布信息转换到Mysql中
     */
    @Test
    public void test_bbsPeoplePost_HTableToMysql() throws Exception{
        IBBSPeoplePostService bbsPeoplePostService = (IBBSPeoplePostService) apx.getBean("bbsPeoplePostService");
        Long beginTime = new Date().getTime();
        /**
         * 人民网
         */
        //人民网 -文章
        String htable_name = "bbs_people_post";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            BbsPeoplePostEntity bbsPeoplePost = new BbsPeoplePostEntity();
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
                        bbsPeoplePost.setPostId(value);
                        break;
                    case "author_id":
                        bbsPeoplePost.setAuthorId(value);
                        break;
                    case "comment_ids":
                        List<String> listString = this.getCommentId(value);
                        bbsPeoplePost.setCommentNum(listString.size());
                        break;
                    case "title":
                        bbsPeoplePost.setTitle(value);
                        break;
                    case "key_words":
                        bbsPeoplePost.setKeyWords(value);
                        break;
                    case "url":
                        bbsPeoplePost.setUrl(value);
                        break;
                    case "author_name":
                        bbsPeoplePost.setAuthorName(value);
                        break;
                    case "author_href":
                        bbsPeoplePost.setAuthorHref(value);
                        break;
                    case "date_time":
                        bbsPeoplePost.setDateTime(value);
                        break;
                    case "read_num":
                        bbsPeoplePost.setReadNum(Integer.parseInt(value));
                        break;
                    case "reply_num":
                        bbsPeoplePost.setReplyNum(Integer.parseInt(value));
                        break;
                    case "prise_num":
                        bbsPeoplePost.setPriseNum(Integer.parseInt(value));
                        break;
                    case "content_href":
                        bbsPeoplePost.setContentHref(value);
                        break;
                    case "content":
                        bbsPeoplePost.setContent(value);
                        break;
                    case "picture_hrefs":
                        bbsPeoplePost.setPictureHrefsNum(Integer.parseInt(value));
                        break;
                    case "parse_time":
                        Double time = Double.parseDouble(value) * 1000;
                        Long longTime = new Long(time.longValue());
                        bbsPeoplePost.setParseTime(new Timestamp(longTime));
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                bbsPeoplePost.setTimeStamp(new Timestamp(time));
            }
            bbsPeoplePostService.saveBBSPeoplePost(bbsPeoplePost);
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
