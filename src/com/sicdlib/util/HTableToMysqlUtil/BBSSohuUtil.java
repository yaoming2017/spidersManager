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
public class BBSSohuUtil {
    static ApplicationContext apx = new ClassPathXmlApplicationContext("beans.xml");

    /**
     * 搜狐htable_作者转换到Mysql中
     */
    @Test
    public void test_bbsSohuAuthor_HTableToMysql() throws Exception{
        IBBSSohuAuthorService bbsSohuAuthorService = (IBBSSohuAuthorService) apx.getBean("bbsSohuAuthorService");
        Long beginTime = new Date().getTime();
        /**
         * 搜狐
         */
        //搜狐 - 作者
        String htable_name = "bbs_sohu_author";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            BbsSohuAuthorEntity bbsSohuAuthor = new BbsSohuAuthorEntity();
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
                        bbsSohuAuthor.setAuthorId(value);
                        break;
                    case "nick_name":
                        bbsSohuAuthor.setNickName(value);
                        break;
                    case "sex":
                        bbsSohuAuthor.setSex(value);
                        break;
                    case "level":
                        bbsSohuAuthor.setLevel(value);
                        break;
                    case "title":
                        bbsSohuAuthor.setTitle(value);
                        break;
                    case "introduction":
                        bbsSohuAuthor.setIntroduction(value);
                        break;
                    case "duty":
                        bbsSohuAuthor.setDuty(value);
                        break;
                    case "post_num":
                        bbsSohuAuthor.setPostNum(Integer.parseInt(value));
                        break;
                    case "elite_num":
                        bbsSohuAuthor.setEliteNum(Integer.parseInt(value));
                        break;
                    case "point":
                        bbsSohuAuthor.setPoint(value);
                        break;
                    case "birthday":
                        bbsSohuAuthor.setBirthday(value);
                        break;
                    case "online_time":
                        bbsSohuAuthor.setOnlineTime(value);
                        break;
                    case "reputation":
                        bbsSohuAuthor.setReputation(value);
                        break;
                    case "last_login":
                        bbsSohuAuthor.setLastLogin(value);
                        break;
                    case "login_num":
                        bbsSohuAuthor.setLoginNum(Integer.parseInt(value));
                        break;
                    case "sport":
                        bbsSohuAuthor.setSport(value);
                        break;
                    case "movie":
                        bbsSohuAuthor.setMovie(value);
                        break;
                    case "music":
                        bbsSohuAuthor.setMusic(value);
                        break;
                    case "food":
                        bbsSohuAuthor.setFood(value);
                        break;
                    case "book":
                        bbsSohuAuthor.setBook(value);
                        break;
                    case "person":
                        bbsSohuAuthor.setPerson(value);
                        break;
                    case "education":
                        bbsSohuAuthor.setEducation(value);
                        break;
                    case "profession":
                        bbsSohuAuthor.setProfession(value);
                        break;
                    case "friends_num":
                        bbsSohuAuthor.setFriendsNum(Integer.parseInt(value));
                        break;
                    case "fans_num":
                        bbsSohuAuthor.setFansNum(Integer.parseInt(value));
                        break;
                    case "parse_time":
                        Double time = Double.parseDouble(value) * 1000;
                        Long longTime = new Long(time.longValue());
                        bbsSohuAuthor.setParseTime(new Timestamp(longTime));
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                bbsSohuAuthor.setTimeStamp(new Timestamp(time));
            }
            bbsSohuAuthorService.saveBBSSohuAuthor(bbsSohuAuthor);
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
     * 搜狐htable_评论转换到Mysql中
     */
    @Test
    public void test_bbsSohuComment_HTableToMysql() throws Exception{
        IBBSSohuCommentService bbsSohuCommentService = (IBBSSohuCommentService) apx.getBean(" bbsSohuCommentService");
        Long beginTime = new Date().getTime();
        /**
         * 搜狐
         */
        //搜狐 - 评论
        String htable_name = "bbs_sohu_comment";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            BbsSohuCommentEntity bbsSohuComment = new BbsSohuCommentEntity();
            i++;
            for (KeyValue rowKV : result.raw()) {
                //字段名
                String qualifer = new String(rowKV.getQualifier());
                //值：字段对应的值
                String value = new String(rowKV.getValue());
                //将4字节表情或特殊字符去掉
                value = value.replaceAll("[\\x{10000}-\\x{10FFFF}]", "");

                // 获取爬取数据时间戳
                Long time = new Long(rowKV.getTimestamp());
                bbsSohuComment.setTimeStamp(new Timestamp(time));
                switch (qualifer){
                    case "comment_id":
                       bbsSohuComment.setCommentId(value);
                        break;
                    case "post_id":
                        bbsSohuComment.setPostId(value);
                        break;
                    case "author_id":
                        bbsSohuComment.setAuthorId(value);
                        break;
                    case "author_name":
                        bbsSohuComment.setAuthorName(value);
                        break;
                    case "author_href":
                        bbsSohuComment.setAuthorHref(value);
                        break;
                    case "floor":
                        bbsSohuComment.setFloor(value);
                        break;
                    case "content":
                        bbsSohuComment.setContent(value);
                        break;
                    case "date_time":
                        String dateTime = "";
                        DateFormat sourceFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
                        DateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        dateTime = destFormat.format(sourceFormat.parse(value));
                        bbsSohuComment.setDateTime(dateTime);
                        break;
                    case "picture_hrefs":
                        bbsSohuComment.setPictureHrefsNum(Integer.parseInt(value));
                        break;
                    case "quote_floor":
                        bbsSohuComment.setQuoteFloor(value);
                        break;
                    case "parse_time":
                        Double doubleTime = Double.parseDouble(value) *1000;
                        Long longTime = new Long(doubleTime .longValue());
                        bbsSohuComment.setParseTime(new Timestamp(longTime));
                        break;
                }
            }
            bbsSohuCommentService.saveBBSSohuComment(bbsSohuComment);
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
             * 搜狐htable_发布信息转换到Mysql中
             */
            @Test
            public void test_bbsSohuPost_HTableToMysql() throws Exception{
                IBBSSohuPostService bbsSohuPostService = (IBBSSohuPostService) apx.getBean("bbsSohuPostService");
                Long beginTime = new Date().getTime();
                /**
                 * 搜狐
                 */
                //搜狐 -文章
                String htable_name = "bbs_sohu_post";
                HBaseData hBaseData = new HBaseData(htable_name);
                ResultScanner results = hBaseData.getAllData();
                int i = 0;
                //输出结果
                for (Result result : results) {
                    BbsSohuPostEntity bbsSohuPost = new BbsSohuPostEntity();
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
                                bbsSohuPost.setPostId(value);
                                break;
                            case "comment_ids":
                                List<String> listString = this.getCommentId(value);
                                bbsSohuPost.setCommentNum(listString.size());
                                break;
                            case "url":
                                bbsSohuPost.setUrl(value);
                                break;
                            case "title":
                                bbsSohuPost.setTitle(value);
                                break;
                            case "content":
                                bbsSohuPost.setContent(value);
                                break;
                            case "date_time":
                                String dateTime = "";
                                DateFormat sourceFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
                                DateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                                dateTime = destFormat.format(sourceFormat.parse(value));
                                bbsSohuPost.setDateTime(dateTime);
                                break;
                            case "picture_hrefs":
                                bbsSohuPost.setPictureHrefsNum(Integer.parseInt(value));
                                break;
                            case "author_id":
                                bbsSohuPost.setAuthorId(value);
                                break;
                            case "author_name":
                                bbsSohuPost.setAuthorName(value);
                                break;
                            case "author_href":
                                bbsSohuPost.setAuthorHref(value);
                                break;
                            case "read_num":
                                bbsSohuPost.setReadNum(Integer.parseInt(value));
                                break;
                            case "reply_num":
                                bbsSohuPost.setReplyNum(Integer.parseInt(value));
                                break;
                            case "parse_time":
                                Double doubleTime = Double.parseDouble(value) * 1000;
                                Long longTime = new Long(doubleTime.longValue());
                                bbsSohuPost.setParseTime(new Timestamp(longTime));
                                break;
                        }
                        Long time = new Long(rowKV.getTimestamp());
                        bbsSohuPost.setTimeStamp(new Timestamp(time));
                    }
                    bbsSohuPostService.saveBBSSohuPost(bbsSohuPost);
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
