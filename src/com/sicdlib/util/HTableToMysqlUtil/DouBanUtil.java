package com.sicdlib.util.HTableToMysqlUtil;

import com.sicdlib.dto.entity.DoubanGroupAuthorEntity;
import com.sicdlib.dto.entity.DoubanGroupCommentEntity;
import com.sicdlib.dto.entity.DoubanGroupGroupEntity;
import com.sicdlib.dto.entity.DoubanGroupPostEntity;
import com.sicdlib.service.pythonService.IDoubanGroupAuthorService;
import com.sicdlib.service.pythonService.IDoubanGroupCommentService;
import com.sicdlib.service.pythonService.IDoubanGroupGroupService;
import com.sicdlib.service.pythonService.IDoubanGroupPostService;
import com.sicdlib.util.HBaseUtil.HBaseData;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
                    case "comment_id":
                        doubanGroupComment.setCommentId(value);
                        break;
                    case "content":
                        doubanGroupComment.setContent(value);
                        break;
                    case "post_id":
                        doubanGroupComment.setPostId(value);
                        break;
                    case "prise_num":
                        doubanGroupComment.setPriseNum(Integer.valueOf(value));
                        break;
//                    case "pub_time":
//                        doubanGroupComment.setPubTime(value);
//                        break;
//                    case "quote_author_href":
//                        doubanGroupComment.setQuoteAuthorHref(value);
//                        break;
                    case "quote_content":
                        doubanGroupComment.setQuoteContent(value);
                        break;
                    case "url":
                        doubanGroupComment.setUrl(value);
                        break;
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
                        doubanGrouppost.setPostId(value);
                        break;
                    case "comment_ids":
                        List<String> listString = this.getCommentId(value);
                        doubanGrouppost.setCommentNum(listString.size());
                        break;
                    case "date_time":
                        String dateTime = " ";
                        DateFormat sourceFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
                        DateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        dateTime = destFormat.format(sourceFormat.parse(value));
                        doubanGrouppost.setDateTime(dateTime);
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
//                    case "picture_hrefs":
//                        doubanGrouppost.setPictureHrefsNum(Integer.parseInt(value));
//                        break;
                    case "url":
                        doubanGrouppost.setUrl(value);
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                doubanGrouppost.setTimeStamp(new Timestamp(time));

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

    private List<String> getCommentId(String comment_ids) {
        String[] commentIdsSplit = comment_ids.split("'");
        List<String> arrayList = new ArrayList<>();
        for (int i = 1; i < commentIdsSplit.length; i = i + 2) {
            arrayList.add(commentIdsSplit[i]);
        }
        return arrayList;
    }

        /**
         * 豆瓣组的组信息转换到Mysql中
         */
        @Test
        public void test_doubanGroupGroup_HTableToMysql () throws IOException {
            IDoubanGroupGroupService doubanGroupGroupService = (IDoubanGroupGroupService) apx.getBean("doubanGroupGroupService");
            Long beginTime = new Date().getTime();
            /**
             * 豆瓣小组
             */
            //群组
            String htable_name = "douban_group_group";
            HBaseData hBaseData = null;
            try {
                hBaseData = new HBaseData(htable_name);
            } catch (IOException e) {
                e.printStackTrace();
            }
            ResultScanner results = null;
            try {
                results = hBaseData.getAllData();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int i = 0;
            //输出结果
            for (Result result : results) {
                DoubanGroupGroupEntity doubanGroupGroup = new DoubanGroupGroupEntity();
                i++;
                for (KeyValue rowKV : result.raw()) {
                    //字段名
                    String qualifer = new String(rowKV.getQualifier());
                    //值,字段对应的值
                    String value = new String(rowKV.getValue());
                    //数据公共清理
                    value = CleanPublicUtil.publicCleanMethods(value);
                    switch (qualifer) {
                        case "group_id":
                            doubanGroupGroup.setGroupId(value);
                            break;
                        case "group_name":
                            doubanGroupGroup.setGroupName(value);
                            break;
                        case "group_tags":
                            doubanGroupGroup.setGroupTags(value);
                            break;
                        case "url":
                            doubanGroupGroup.setUrl(value);
                            break;
                        case "content":
                            doubanGroupGroup.setContent(value);
                            break;
                        case "create_time":
                            doubanGroupGroup.setCreateTime(value);
                            break;
                        case "leader_name":
                            doubanGroupGroup.setLeaderName(value);
                            break;
                        case "leader_href":
                            doubanGroupGroup.setLeaderHref(value);
                            break;
                    }
                    Long time = new Long(rowKV.getTimestamp());
                    doubanGroupGroup.setTimeStamp(new Timestamp(time));

                }
                doubanGroupGroupService.saveDoubanGroupGroup(doubanGroupGroup);
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
}
