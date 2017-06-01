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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by init on 2017/5/25.
 * 中华网社区
 */

public class BBSChinaUtil {
    static ApplicationContext apx = new ClassPathXmlApplicationContext("beans.xml");

    /**
     * 中华网社区htable_作者转换到Mysql中
     */
    @Test
    public void test_bbsChinaAuthor_HTableToMysql() throws Exception{
        IBBSChinaAuthorService bbsChinaAuthorService = (IBBSChinaAuthorService) apx.getBean("bbsChinaAuthorService");
        Long beginTime = new Date().getTime();
        /**
         * 中华网社区
         */
        //中华网社区 - 作者
        String htable_name = "bbs_china_author";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
           BbsChinaAuthorEntity bbsChinaAuthor = new BbsChinaAuthorEntity();
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
                        bbsChinaAuthor.setAuthorId(value);
                        break;
                    case "author_name":
                        bbsChinaAuthor.setAuthorName(value);
                        break;
                    case "name":
                        bbsChinaAuthor.setName(value);
                        break;
                    case "sex":
                        bbsChinaAuthor.setSex(value);
                        break;
                    case "birthday":
                        bbsChinaAuthor.setBirthday(value);
                        break;
                    case "address":
                        bbsChinaAuthor.setAddress(value);
                        break;
                    case "focuse_num":
                        bbsChinaAuthor.setFocuseNum(Integer.parseInt(value));
                        break;
                    case "fans_num":
                        bbsChinaAuthor.setFansNum(Integer.parseInt(value));
                        break;
                    case  "url":
                        bbsChinaAuthor.setUrl(value);
                    case  "parse_time":
                        //System.out.println(value);
                        //String intNumber = value.substring(0,value.indexOf("h"));
                        Double time = Double.parseDouble(value) * 1000;
                        Long longTime = new Long(time.longValue());
                        bbsChinaAuthor.setParseTime(new Timestamp(longTime));
                        break;
                  /*  case  "time_stamp":
                        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        bbsChinaAuthor.setTimeStamp(Timestamp.valueOf(df.format(value)));
                        break;*/
                }
                Long time = new Long(rowKV.getTimestamp());
               bbsChinaAuthor.setTimeStamp(new Timestamp(time));
            }
            bbsChinaAuthorService.saveBBSChinaAuthor(bbsChinaAuthor);
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
     * 中华网社区的评论信息转换到mysql中
     */
    @Test
    public  void test_bbsChinaComment_HTableMysql() throws  Exception{
        IBBSChinaCommentService bbsChinaCommentService = (IBBSChinaCommentService) apx.getBean("bbsChinaCommentService");
        Long beginTime = new Date().getTime();
        /**
         * 中华网社区
         */
        //评论
        String htable_name = "bbs_china_comment";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for(Result result : results){
            BbsChinaCommentEntity bbsChinaComment  = new BbsChinaCommentEntity();
            i++;
        for(KeyValue rowKV : result.raw()){
            //字段名
            String qualifer = new String(rowKV.getQualifier());
            //值，字段对应的值
            String value = new String(rowKV.getValue());
            //数据公共清理
            value = CleanPublicUtil.publicCleanMethods(value);
            switch (qualifer){
                case "comment_id":
                    bbsChinaComment.setCommentId(value);
                    break;
                case  "post_id":
                     bbsChinaComment.setPostId(value);
                     break;
                case  "author_id":
                     bbsChinaComment.setAuthorId(value);
                     break;
                case  "author_name":
                     bbsChinaComment.setAuthorName(value);
                     break;
                case  "praise_num":
                    bbsChinaComment.setPriseNum(Integer.parseInt(value));
                    break;
                case  "date_time":
                    bbsChinaComment.setDateTime(value);
                    break;
                case  "floor":
                    bbsChinaComment.setFloor(value);
                    break;
                case  "content":
                    bbsChinaComment.setFloor(value);
                    break;
               /* case  "time_stamp":
                    bbsChinaComment.setTimeStamp(Timestamp.valueOf(value));
                    break;*/
            }
            Long time = new Long(rowKV.getTimestamp());
            bbsChinaComment.setTimeStamp(new Timestamp(time));

        }
            bbsChinaCommentService.saveBBSChinaComment(bbsChinaComment);
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
     * 中华网社区的文章信息转换到mysql中
     */
    @Test
    public  void test_bbsChinaPost_HTableMysql() throws  Exception{
        IBBSChinaPostService bbsChinaPostService = (IBBSChinaPostService) apx.getBean("bbsChinaPostService");
        IBBSChinaCommentPostIdService bbsChinaCommentPostIdService = (IBBSChinaCommentPostIdService) apx.getBean("bbsChinaCommentPostIdService");
        Long beginTime = new Date().getTime();
        /**
         * 中华网社区
         */
        //文章
        String htable_name = "bbs_china_post";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for(Result result : results){
            BbsChinaPostEntity  bbsChinaPost = new BbsChinaPostEntity();
            i++;
            for(KeyValue rowKV : result.raw()){
                //字段名
                String qualifer = new String(rowKV.getQualifier());
                //值，字段对应的值
                String value = new String(rowKV.getValue());
                //定义postId
                String postID=null;
                //定义commentIds
                List<String> commentIds = new ArrayList<String>();
                //数据公共清理
                value = CleanPublicUtil.publicCleanMethods(value);
                switch (qualifer){
                    case "post_id":
                        postID = value;
                        bbsChinaPost.setPostId(value);
                        break;
                    case "comment_ids":
                        List<String> listString = this.getCommentId(value);
                        commentIds = listString;
                        bbsChinaPost.setCommentNum(listString.size());
                        break;
                    case  "author_id":
                        bbsChinaPost.setAuthorId(value);
                        break;
                    case  "path_text":
                        bbsChinaPost.setPathText(value);
                        break;
                    case  "path_href":
                        bbsChinaPost.setPathHref(value);
                        break;
                    case  "title":
                        bbsChinaPost.setTitle(value);
                        break;
                    case  "key_words":
                        bbsChinaPost.setKeyWords(value);
                        break;
                    case  "hot_words":
                        bbsChinaPost.setHotWords(value);
                        break;
                    case  "author_name":
                        bbsChinaPost.setAuthorName(value);
                        break;
                    case    "content":
                        bbsChinaPost.setContent(value);
                        break;
                    case    "level":
                        bbsChinaPost.setLevel(value);
                        break;
                    case    "point":
                        bbsChinaPost.setPoint(value);
                        break;
                    case   "date_time":
                        bbsChinaPost.setDateTime(value);
                        break;
                    case    "read_num":
                        bbsChinaPost.setReadNum(Integer.parseInt(value));
                        break;
                    case    "participant_num":
                        bbsChinaPost.setParticipantNum(Integer.parseInt(value));
                        break;
                    case    "reply_num":
                        bbsChinaPost.setReplyNum(Integer.parseInt(value));
                        break;
                    case    "picture_hrefs":
                        bbsChinaPost.setPictureHrefs(value);
                        break;
                    case    "url":
                        bbsChinaPost.setUrl(value);
                        break;
                    case    "parse_time":
                        Long time = new Long(String.valueOf(bbsChinaPost.getParseTime()).trim());
                        bbsChinaPost.setParseTime(new Timestamp(time));
                }
                Long time = new Long(rowKV.getTimestamp());
                bbsChinaPost.setTimeStamp(new Timestamp(time));
                if(postID !=null && commentIds!=null && commentIds.size()>0){
                    for(String commentId :commentIds){
                        BbsChinaCommentPostIdEntity commentPostId = new BbsChinaCommentPostIdEntity();
                        commentPostId.setPostId(postID);
                        commentPostId.setCommentId(commentId);
                        bbsChinaCommentPostIdService.saveBBSChinaCommentPostId(commentPostId);
                    }
                }
            }
            bbsChinaPostService.saveBBSChinaPost(bbsChinaPost);
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
     *评论id和文章id的处理
     */
        private List<String> getCommentId(String comment_ids){
            String[] commentIdsSplit = comment_ids.split("'");
            List<String> arrayList = new ArrayList<String>();
            for(int i = 1;i<commentIdsSplit.length;i+=2){
                 arrayList.add(commentIdsSplit[i]);
            }
            return arrayList;
        }

}