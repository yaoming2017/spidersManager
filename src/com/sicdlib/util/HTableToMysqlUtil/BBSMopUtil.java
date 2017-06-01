package com.sicdlib.util.HTableToMysqlUtil;


import com.sicdlib.dto.entity.BbsMopAuthorEntity;
import com.sicdlib.dto.entity.BbsMopCommentEntity;
import com.sicdlib.dto.entity.BbsMopCommentPostIdEntity;
import com.sicdlib.dto.entity.BbsMopPostEntity;
import com.sicdlib.service.IBBSMopAuthorService;
import com.sicdlib.service.IBBSMopCommentPostIdService;
import com.sicdlib.service.IBBSMopCommentService;
import com.sicdlib.service.IBBSMopPostService;
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
 * Created by init on 2017/5/26.
 */
public class BBSMopUtil {
    static ApplicationContext apx = new ClassPathXmlApplicationContext("beans.xml");

    /**
     * 豆瓣htable_作者转换到Mysql中
     */
    @Test
    public void test_bbsMopAuthor_HTableToMysql() throws Exception{
        IBBSMopAuthorService bbsMopAuthorService =(IBBSMopAuthorService) apx.getBean("bbsMopAuthorService");
        Long beginTime = new Date().getTime();
        /**
         * 豆瓣小组
         */
        //豆瓣小组 - 作者
        String htable_name = "bbs_mop_author";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            BbsMopAuthorEntity bbsMopAuthor = new BbsMopAuthorEntity();
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
                        bbsMopAuthor.setAuthorId(value);
                        break;
                    case "author_name":
                       bbsMopAuthor.setAuthorName(value);
                        break;
                    case "sex":
                        bbsMopAuthor.setSex(value);
                        break;
                    case "location":
                        bbsMopAuthor.setLocation(value);
                        break;
                    case "age":
                        bbsMopAuthor.setAge(value);
                        break;
                    case "level":
                        bbsMopAuthor.setLocation(value);
                        break;
                    case "level_nick":
                        bbsMopAuthor.setLevelNick(value);
                        break;
                    case "friends_num":
                       bbsMopAuthor.setFriendsNum(Integer.parseInt(value));
                        break;
                    case    "fans_num":
                        bbsMopAuthor.setFansNum(Integer.parseInt(value));
                        break;
                    case    "point":
                        bbsMopAuthor.setPoint(value);
                        break;
                    case    "post_num":
                        bbsMopAuthor.setPostNum(Integer.parseInt(value));
                        break;
                    case   "reply_num":
                        bbsMopAuthor.setReplyNum(Integer.parseInt(value));
                        break;
                    case    "hits":
                        bbsMopAuthor.setHits(Integer.parseInt(value));
                        break;
                    case    "birthday":
                        bbsMopAuthor.setBirthday(value);
                        break;
                    case    "login_num":
                        bbsMopAuthor.setLoginNum(Integer.parseInt(value));
                        break;
                    case    "url":
                        bbsMopAuthor.setUrl(value);
                        break;
                    case    "introduce":
                        bbsMopAuthor.setIntroduce(value);
                        break;
                    case    "register_date":
                        bbsMopAuthor.setRegisterDate(value);
                        break;
                    case    "league":
                        bbsMopAuthor.setLeague(value);
                        break;
                    case    "contact_way":
                        bbsMopAuthor.setContactWay(value);
                        break;
                    case    "education":
                        bbsMopAuthor.setEducation(value);
                        break;
                    case    "career":
                        bbsMopAuthor.setCareer(value);
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                bbsMopAuthor.setTimeStamp(new Timestamp(time));
            }
            bbsMopAuthorService.saveBBSMopAuthor(bbsMopAuthor);
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
    public void test_bbsMopComment_HTableToMysql() throws Exception{
        IBBSMopCommentService bbsMopCommentService =(IBBSMopCommentService) apx.getBean("bbsMopCommentService");
        Long beginTime = new Date().getTime();
        /**
         * 豆瓣小组
         */
        //豆瓣小组 - 评论
        String htable_name = "bbs_mop_comment";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            BbsMopCommentEntity bbsMopComment  = new BbsMopCommentEntity();
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
                        bbsMopComment.setCommentId(value);
                        break;
                    case "post_id":
                         bbsMopComment.setPostId(value);
                        break;
                    case "user_id":
                         bbsMopComment.setUserId(value);
                        break;
                    case "user_href":
                        bbsMopComment.setUserHref(value);
                        break;
                    case "user_name":
                        bbsMopComment.setUserName(value);
                        break;
                    case "date_time":


                        bbsMopComment.setDateTime(value);
                        break;
                    case "content":
                        bbsMopComment.setContent(value);
                        break;
                    case "picture_hrefs_num":
                       bbsMopComment.setPictureHrefsNum(Integer.parseInt(value));
                        break;
                    case "praise_num":
                        bbsMopComment.setPraiseNum(Integer.parseInt(value));
                        break;
                    case "reply_num":
                        bbsMopComment.setReplyNum(Integer.parseInt(value));
                        break;
                    case "floor_num":
                        bbsMopComment.setFloorNum(Integer.parseInt(value));
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                bbsMopComment.setTimeStamp(new Timestamp(time));
            }
            bbsMopCommentService.saveBBSMopComment(bbsMopComment);
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
    public void test_bbsMopPost_HTableToMysql() throws Exception{
        IBBSMopPostService bbsMopPostService =(IBBSMopPostService) apx.getBean("bbsMopPostService");
        IBBSMopCommentPostIdService bbsMopCommentPostIdService = (IBBSMopCommentPostIdService) apx.getBean("bbsMopCommentPostIdService");
        Long beginTime = new Date().getTime();
        /**
         * 豆瓣小组
         */
        //豆瓣小组 -文章
        String htable_name = "bbs_mop_post";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            BbsMopPostEntity bbsMopPost = new BbsMopPostEntity();
            i++;
            for (KeyValue rowKV : result.raw()) {
                //字段名
                String qualifer = new String(rowKV.getQualifier());
                //值：字段对应的值
                String value = new String(rowKV.getValue());
                //将4字节表情或特殊字符去掉
                value = value.replaceAll("[\\x{10000}-\\x{10FFFF}]", "");
                String postID = null;
                List<String> commentIds =new ArrayList<>();
                switch (qualifer){
                    case "post_id":
                        postID = value;
                        bbsMopPost.setPostId(value);
                        break;
                    case "author_id":
                        bbsMopPost.setAuthorId(value);
                        break;
                    case "comment_ids":
                        List<String> listString = this.getCommentId(value);
                        commentIds = listString;
                        bbsMopPost.setCommentNum(listString.size());
                        break;
                    case "path_text":
                        bbsMopPost.setPathText(value);
                        break;
                    case "path_href":
                        bbsMopPost.setPathHref(value);
                        break;
                    case "title":
                        bbsMopPost.setTitle(value);
                        break;
                    case "publish_date":
                        bbsMopPost.setPublishDate(value);
                        break;
                    case "hits":
                        bbsMopPost.setHits(Integer.parseInt(value));
                        break;
                    case "reply_num":
                        bbsMopPost.setReplyNum(Integer.parseInt(value));
                        break;
                    case "author_name":
                        bbsMopPost.setAuthorName(value);
                        break;
                    case "author_href":
                        bbsMopPost.setAuthorHref(value);
                        break;
                    case "content":
                        bbsMopPost.setContent(value);
                        break;
                    case "picture_hrefs_num":
                        bbsMopPost.setPictureHrefsNum(Integer.parseInt(value));
                        System.out.println(value);
                        break;
                    case "tags":
                        bbsMopPost.setTags(value);
                        break;
                    case "praise_num":
                        bbsMopPost.setPraiseNum(Integer.parseInt(value));
                        break;
                    case  "recommend_num":
                        bbsMopPost.setRecommendNum(Integer.parseInt(value));
                        break;
                    case    "collect_num":
                        bbsMopPost.setCollectNum(Integer.parseInt(value));
                }
                if(postID != null && commentIds != null && commentIds.size() > 0) {
                    for(String commentId: commentIds){
                        BbsMopCommentPostIdEntity commentPostId = new  BbsMopCommentPostIdEntity();
                        commentPostId.setPostId(postID);
                        commentPostId.setCommentId(commentId);
                        bbsMopCommentPostIdService.savebbsMopCommentPostId(commentPostId);
                    }
                }
                Long time = new Long(rowKV.getTimestamp());
                bbsMopPost.setTimeStamp(new Timestamp(time));
            }
                    bbsMopPostService.saveBBSMopPost(bbsMopPost);
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
    private List<String> getCommentId(String comment_ids){
        String[] commentIdsSplit = comment_ids.split("'");
        List<String> arrayList = new ArrayList<>();
        for(int i=1;i<commentIdsSplit.length;i=i+2){
            arrayList.add(commentIdsSplit[i]);
        }
        return  arrayList;

    }
}
