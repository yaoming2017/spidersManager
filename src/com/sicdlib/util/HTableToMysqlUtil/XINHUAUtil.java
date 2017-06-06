package com.sicdlib.util.HTableToMysqlUtil;

import com.sicdlib.dto.entity.XinhuaEntity;
import com.sicdlib.service.IXINHUAService;
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
 * Created by init on 2017/6/5.
 */
public class XINHUAUtil {
    static ApplicationContext apx = new ClassPathXmlApplicationContext("beans.xml");

    /**
     * 新华网htable_转换到Mysql中
     */
    @Test
    public void test_XINHUA_HTableToMysql() throws Exception{
        IXINHUAService xinhuaService = (IXINHUAService) apx.getBean("xinhuaService");
        Long beginTime = new Date().getTime();
        /**
         *
         */
        // 新闻
        String htable_name = "xinhua";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            XinhuaEntity xinhua = new XinhuaEntity();
            i++;
            for (KeyValue rowKV : result.raw()) {
                //字段名
                String qualifer = new String(rowKV.getQualifier());
                //值：字段对应的值
                String value = new String(rowKV.getValue());
                //将4字节表情或特殊字符去掉
                value = value.replaceAll("[\\x{10000}-\\x{10FFFF}]", "");
                switch (qualifer) {
                    case "article_id":
                        xinhua.setArticleId(value);
                        break;
                    case "url":
                        xinhua.setUrl(value);
                        break;
                    case  "category":
                        xinhua.setCategory(value);
                    case "sub_category":
                        xinhua.setSubCategory(value);
                        break;
                    case "title":
                        xinhua.setTitle(value);
                        break;
                    case "publish_time":
                        String dateTime = "";
                        DateFormat sourceFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
                        DateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        dateTime = destFormat.format(sourceFormat.parse(value));
                        xinhua.setDateTime(dateTime);
                        break;
                    case "origin":
                        xinhua.setOrigin(value);
                        break;
                    case "content":
                        xinhua.setContent(value);
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                xinhua.setTimeStamp(new Timestamp(time));
            }
           xinhuaService.saveXINHUA(xinhua);
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
