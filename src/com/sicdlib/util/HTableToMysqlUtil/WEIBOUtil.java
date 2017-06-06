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
import sun.awt.SunHints;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by init on 2017/6/5.
 */
public class WEIBOUtil {
    static ApplicationContext apx = new ClassPathXmlApplicationContext("beans.xml");

    /**
     * 微博htable_作者转换到Mysql中
     */
    @Test
    public void test_doubanGroupAuthor_HTableToMysql() throws Exception{
        IWEIBOAuthorService weiboAuthorService = (IWEIBOAuthorService) apx.getBean("weiboAuthorService ");
        Long beginTime = new Date().getTime();
        /**
         * 微博
         */
        //微博 - 作者
        String htable_name = "weibo_author";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            WeiboAuthorEntity weiboAuthor = new WeiboAuthorEntity();
            i++;
            for (KeyValue rowKV : result.raw()) {
                //字段名
                String qualifer = new String(rowKV.getQualifier());
                //值：字段对应的值
                String value = new String(rowKV.getValue());
                //将4字节表情或特殊字符去掉
                value = value.replaceAll("[\\x{10000}-\\x{10FFFF}]", "");
                switch (qualifer) {
                    case "user_id":
                        weiboAuthor.setUserId(value);
                        break;
                    case "url":
                        weiboAuthor.setUrl(value);
                        break;
                    case "page_id":
                        weiboAuthor.setPageId(value);
                        break;
                    case "head_img_url":
                        weiboAuthor.setHeadImgUrl(value);
                        break;
                    case "nick_name":
                        weiboAuthor.setNickName(value);
                        break;
                    case "real_name":
                        weiboAuthor.setRealName(value);
                        break;
                    case "location":
                        weiboAuthor.setLocation(value);
                        break;
                    case "sex":
                        weiboAuthor.setSex(value);
                        break;
                    case "sexual_orientation":
                        weiboAuthor.setSexualOrientation(value);
                        break;
                    case "relationship_status":
                        weiboAuthor.setRelationshipStatus(value);
                        break;
                    case "birthday":
                        weiboAuthor.setBirthday(value);
                        break;
                    case "blog_address":
                        weiboAuthor.setBlogAddress(value);
                        break;
                    case "personal_url":
                        weiboAuthor.setPersonalUrl(value);
                        break;
                    case "description":
                        weiboAuthor.setDescription(value);
                        break;
                    case "register_date":
                        weiboAuthor.setRegisterDate(value);
                        break;
                    case "mail":
                        weiboAuthor.setMail(value);
                        break;
                    case "qq":
                        weiboAuthor.setQq(value);
                        break;
                    case "blood_type":
                        weiboAuthor.setBloodType(value);
                        break;
                    case "company":
                        weiboAuthor.setCompany(value);
                        break;
                    case "education":
                        weiboAuthor.setEducation(value);
                        break;
                    case "tag":
                        weiboAuthor.setTag(value);
                        break;
                    case "friends_num":
                        weiboAuthor.setFriendsNum(Integer.parseInt(value));
                        break;
                    case "fans_num":
                        weiboAuthor.setFansNum(Integer.parseInt(value));
                        break;
                    case "blog_num":
                        weiboAuthor.setBlogNum(Integer.parseInt(value));
                        break;
                    case "rank":
                        weiboAuthor.setRank(value);
                        break;
                    case "is_v":
                        weiboAuthor.setIsV(value);
                        break;
                    case "b_head_img_url":
                        weiboAuthor.setbHeadImgUrl(value);
                        break;
                    case "parse_time":
                        Double time = Double.parseDouble(value) * 1000;
                        Long longTime = new Long(time.longValue());
                        weiboAuthor.setParseTime(new Timestamp(longTime));
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                weiboAuthor.setTimeStamp(new Timestamp(time));
            }
           weiboAuthorService.saveWEIBOAuthor(weiboAuthor);
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
     * 微博htable_评论转换到Mysql中
     */
    @Test
    public void test_WEIBOComment_HTableToMysql() throws Exception{
     IWEIBOCommentService weiboCommentService = (IWEIBOCommentService) apx.getBean("weiboCommentService");
        Long beginTime = new Date().getTime();
        /**
         * 微博
         */
        //微博- 评论
        String htable_name = "weibo_comment";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            WeiboCommentEntity weiboComment = new WeiboCommentEntity();
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
                        weiboComment.setCommentId(value);
                        break;
                    case "blog_id":
                        weiboComment.setBlogId(value);
                        break;
                    case "comment_user_nick":
                        weiboComment.setCommentUserNick(value);
                        break;
                    case "comment_user_id":
                        weiboComment.setCommentUserId(value);
                        break;
                    case "comment_user_page":
                        weiboComment.setCommentUserPage(value);
                        break;
                    case "comment_date_time":
                        weiboComment.setCommentDateTime(value);
                        break;
                    case "praise_num":
                        weiboComment.setPraiseNum(Integer.parseInt(value));
                        break;
                    case "at_name_list":
                        weiboComment.setAtNameList(value);
                        break;
                    case "at_url_list":
                        weiboComment.setAtUrlList(value);
                        break;
                    case "content":
                        weiboComment.setContent(value);
                        break;
                    case "child_comment_ids":
                        weiboComment.setChildCommentIds(value);
                        break;
                    case "parent_comment_id":
                        weiboComment.setParentCommentId(value);
                        break;
                    case "topic_url_list":
                        weiboComment.setTopicUrlList(value);
                        break;
                    case "topic_text_list":
                        weiboComment.setTopicTextList(value);
                        break;
                    case "img_url_list":
                        weiboComment.setImgUrlList(value);
                        break;
                    case "parse_time":
                        Double time = Double.parseDouble(value) * 1000;
                        Long longTime = new Long(time.longValue());
                        weiboComment.setParseTime(new Timestamp(longTime));
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                weiboComment.setTimeStamp(new Timestamp(time));
            }
            weiboCommentService.saveWEIBOComment(weiboComment);
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
     * 微博htable_内容转换到Mysql中
     */
    @Test
    public void test_WEIBOContent_HTableToMysql() throws Exception{
       IWEIBOContentService weiboContentService = (IWEIBOContentService) apx.getBean("weiboContentService");
        Long beginTime = new Date().getTime();
        /**
         * 微博
         */
        //微博 -内容
        String htable_name = "weibo_content";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            WeiboContentEntity weiboContent = new WeiboContentEntity();
            i++;
            for (KeyValue rowKV : result.raw()) {
                //字段名
                String qualifer = new String(rowKV.getQualifier());
                //值：字段对应的值
                String value = new String(rowKV.getValue());
                //将4字节表情或特殊字符去掉
                value = value.replaceAll("[\\x{10000}-\\x{10FFFF}]", "");
                switch (qualifer){
                    case "mid":
                        weiboContent.setMid(value);
                        break;
                    case "user_id":
                        weiboContent.setUserId(value);
                        break;
                    case "is_forward":
                        weiboContent.setIsForward(value);
                        break;
                    case "o_mid":
                        weiboContent.setoMid(value);
                        break;
                    case "o_user_id":
                        weiboContent.setoUserId(value);
                        break;
                    case "blog_info":
                        weiboContent.setBlogInfo(value);
                        break;
                    case "date_time":
                        String dateTime = " ";
                        DateFormat sourceFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
                        DateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        dateTime = destFormat.format(sourceFormat.parse(value));
                        weiboContent.setDateTime(dateTime);
                        break;
                    case "exact_time":
                        weiboContent.setExactTime(value);
                        break;
                    case "data_from":
                        weiboContent.setDataFrom(value);
                        break;
                    case "at_list":
                        weiboContent.setAtList(value);
                        break;
                    case "at_url_list":
                        weiboContent.setAtUrlList(value);
                        break;
                    case "topic_list":
                        weiboContent.setTopicList(value);
                        break;
                    case "topic_url_list":
                        weiboContent.setTopicUrlList(value);
                        break;
                    case "picture_hrefs":
                        weiboContent.setPictureHrefsNum(Integer.parseInt(value));
                        break;
                    case "praise_time":
                        Double time = Double.parseDouble(value) * 1000;
                        Long longTime = new Long(time.longValue());
                        weiboContent.setPraiseTime(new Timestamp(longTime));
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                weiboContent.setTimeStamp(new Timestamp(time));

            }
            weiboContentService.saveWEIBOContent(weiboContent);
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
    /**
     * 微博的文章信息转换到Mysql中
     */
    @Test
    public void test_WEIBOPost_HTableToMysql() throws Exception {
        IWEIBOPostService weiboPostService = (IWEIBOPostService) apx.getBean("weiboPostService");
        Long beginTime = new Date().getTime();
        /**
         * 微博
         */
        //文章
        String htable_name ="weibo_post";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for(Result result : results){
            WeiboPostEntity weiboPost = new WeiboPostEntity();
            i++;
            for(KeyValue rowKV : result.raw()){
                //字段名
                String qualifer = new String(rowKV.getQualifier());
                //值,字段对应的值
                String value = new String(rowKV.getValue());
                //数据公共清理
                value = CleanPublicUtil.publicCleanMethods(value);
                switch(qualifer){
                    case "article_url":
                        weiboPost.setArticleUrl(value);
                        break;
                    case "article_date_time":
                        String dateTime = " ";
                        DateFormat sourceFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
                        DateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        dateTime = destFormat.format(sourceFormat.parse(value));
                        weiboPost.setArticleDateTime(dateTime);
                        break;
                    case  "article_title":
                        weiboPost.setArticleTitle(value);
                        break;
                    case  "article_preface":
                        weiboPost.setArticlePreface(value);
                        break;
                    case   "article_content":
                        weiboPost.setArticleContent(value);
                        break;
                    case  "article_pic_url_desc":
                        weiboPost.setArticlePicUrlDesc(value);
                        break;
                    case   "article_media_url":
                        weiboPost.setArticleMediaUrl(value);
                        break;
                    case    "article_read_num":
                        weiboPost.setArticleReadNum(Integer.parseInt(value));
                        break;
                    case    "prise_num":
                        weiboPost.setPriseNum(Integer.parseInt(value));
                        break;
                    case    "comment_num":
                        weiboPost.setCommentNum(Integer.parseInt(value));
                        break;
                    case    "forward_num":
                        weiboPost.setForwardNum(Integer.parseInt(value));
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                weiboPost.setTimeStamp(new Timestamp(time));

            }
            weiboPostService.saveWEIBOPost(weiboPost);
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
