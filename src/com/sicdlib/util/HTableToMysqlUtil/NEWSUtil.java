package com.sicdlib.util.HTableToMysqlUtil;

import com.sicdlib.dto.entity.BbsMopAuthorEntity;
import com.sicdlib.dto.entity.NewsEntity;
import com.sicdlib.service.IBBSMopAuthorService;
import com.sicdlib.service.INEWSService;
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
 * Created by init on 2017/6/6.
 */
public class NEWSUtil {
    static ApplicationContext apx = new ClassPathXmlApplicationContext("beans.xml");

    /**
     * htable_转换到Mysql中
     */
    @Test
    public void test_NEWS_HTableToMysql() throws Exception{
        INEWSService newsService = (INEWSService) apx.getBean("newsService");
        Long beginTime = new Date().getTime();
        String htable_name = "news";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            NewsEntity news = new NewsEntity();
            i++;
            for (KeyValue rowKV : result.raw()) {
                //字段名
                String qualifer = new String(rowKV.getQualifier());
                //值：字段对应的值
                String value = new String(rowKV.getValue());
                //将4字节表情或特殊字符去掉
                value = value.replaceAll("[\\x{10000}-\\x{10FFFF}]", "");
                switch (qualifer) {
                    case "url":
                        news.setUrl(value);
                        break;
                    case "spider_time":
                        news.setSpiderTime(value);
                        break;
                    case "keywords":
                        news.setKeywords(value);
                        break;
                    case "description":
                        news.setDescription(value);
                        break;
                    case "author":
                        news.setAuthor(value);
                        break;
                    case "path_text":
                        news.setPathText(value);
                        break;
                    case "path_href":
                        news.setPathHref(value);
                        break;
                    case "title":
                        news.setTitle(value);
                        break;
                    case  "date_time":
                        String dateTime = " ";
                        DateFormat sourceFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
                        DateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        dateTime = destFormat.format(sourceFormat.parse(value));
                        news.setDateTime(dateTime);
                        break;
                    case "source_text":
                        news.setSourceText(value);
                        break;
                    case  "source_href":
                        news.setSourceHref(value);
                        break;
                    case  "content":
                        news.setContent(value);
                        break;
                    case "picture_hrefs":
                        news.setPictureHrefsNum(Integer.parseInt(value));
                        break;
                    case "editor":
                        news.setEditor(value);
                        break;
                    case  "comment_num":
                        news.setCommentNum(Integer.parseInt(value));
                        break;
                    case  "b_pictures":
                        news.setbPictures(value);
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                news.setTimeStamp(new Timestamp(time));
            }
           newsService.saveNEWS(news);
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
