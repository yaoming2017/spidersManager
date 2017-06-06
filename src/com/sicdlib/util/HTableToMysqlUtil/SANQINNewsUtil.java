package com.sicdlib.util.HTableToMysqlUtil;

import com.sicdlib.dto.entity.SanqinNewsEntity;
import com.sicdlib.service.ISANQINNewsService;
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
public class SANQINNewsUtil {
    static ApplicationContext apx = new ClassPathXmlApplicationContext("beans.xml");

    /**
     * 三秦网htable_作者转换到Mysql中
     */
    @Test
    public void test_SANQINNews_HTableToMysql() throws Exception{
        ISANQINNewsService sanqinNewsService = (ISANQINNewsService) apx.getBean("sanqinNewsService");
        Long beginTime = new Date().getTime();
        /**
         * 三秦网
         */
        String htable_name = "sanqin_news";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            SanqinNewsEntity sanqinNews = new SanqinNewsEntity();
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
                        sanqinNews.setUrl(value);
                        break;
                    case "path_url":
                        sanqinNews.setPathUrl(value);
                        break;
                    case "path_text":
                        sanqinNews.setPathText(value);
                        break;
                    case "title":
                        sanqinNews.setTitle(value);
                        break;
                    case "date_time":
                        String dateTime = " ";
                        DateFormat sourceFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
                        DateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        dateTime = destFormat.format(sourceFormat.parse(value));
                        sanqinNews.setDateTime(dateTime);
                        break;
                    case "editor":
                        sanqinNews.setEditor(value);
                        break;
                    case "source_text":
                        sanqinNews.setSourceText(value);
                        break;
                    case "source_href":
                        sanqinNews.setSourceHref(value);
                        break;
                    case  "picture_hrefs":
                        sanqinNews.setPictureHrefsNum(Integer.parseInt(value));
                        break;
                    case "content":
                        sanqinNews.setContent(value);
                        break;
                    case  "key_words":
                        sanqinNews.setKeyWords(value);
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                sanqinNews.setTimeStamp(new Timestamp(time));
            }
            sanqinNewsService.saveSANQINNews(sanqinNews);
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
