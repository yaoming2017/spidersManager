package com.sicdlib.util.HTableToMysqlUtil;

import com.sicdlib.dto.entity.NewsSinaEntity;
import com.sicdlib.service.pythonService.INEWSSinaService;
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
public class NEWSSinaUtil {
    static ApplicationContext apx = new ClassPathXmlApplicationContext("beans.xml");

    /**
     * 新浪新闻htable_转换到Mysql中
     */
    @Test
    public void test_NEWSSina_HTableToMysql() throws Exception{
        INEWSSinaService newsSinaService = (INEWSSinaService) apx.getBean("newsSinaService");
        Long beginTime = new Date().getTime();
        /**
         * 新浪新闻
         */
        String htable_name = "news_sina";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            NewsSinaEntity newsSina = new NewsSinaEntity();
            i++;
            for (KeyValue rowKV : result.raw()) {
                //字段名
                String qualifer = new String(rowKV.getQualifier());
                //值：字段对应的值
                String value = new String(rowKV.getValue());
                //将4字节表情或特殊字符去掉
                value = value.replaceAll("[\\x{10000}-\\x{10FFFF}]", "");
                switch (qualifer) {
                    case "news_id":
                        newsSina.setNewsId(value);
                        break;
                    case "url":
                        newsSina.setUrl(value);
                        break;
                    case "news_type":
                        newsSina.setNewsType(value);
                        break;
                    case "path_text":
                        newsSina.setPathText(value);
                        break;
                    case "path_url":
                        newsSina.setPathUrl(value);
                        break;
                    case "key_words":
                        newsSina.setKeyWords(value);
                        break;
                    case "tags":
                        newsSina.setTags(value);
                        break;
                    case "title":
                        newsSina.setTitle(value);
                        break;
                    case  "description":
                        newsSina.setDescription(value);
                        break;
                    case "date_time":
                        String dateTime = " ";
                        DateFormat sourceFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
                        DateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        dateTime = destFormat.format(sourceFormat.parse(value));
                        newsSina.setDateTime(dateTime);
                        break;
                    case  "comment_id":
                        newsSina.setCommentId(value);
                        break;
                    case  "author":
                        newsSina.setAuthor(value);
                        break;
                    case  "editor":
                        newsSina.setEditor(value);
                        break;
                    case  "from_media":
                        newsSina.setFromMedia(value);
                        break;
                    case "from_media_url":
                        newsSina.setFromMediaUrl(value);
                        break;
                    case "content":
                        newsSina.setContent(value);
                        break;
                    case  "participant_num":
                        newsSina.setParticipantNum(Integer.parseInt(value));
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                newsSina.setTimeStamp(new Timestamp(time));
            }
            newsSinaService.saveNEWSSina(newsSina);
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
