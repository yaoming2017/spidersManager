package com.sicdlib.util.HTableToMysqlUtil;

import com.sicdlib.dto.entity.Xinwen110NewsEntity;
import com.sicdlib.service.pythonService.IXINWEN110NewsService;
import com.sicdlib.util.HBaseUtil.HBaseData;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by init on 2017/6/5.
 */
public class XINWEN110Util {
    static ApplicationContext apx = new ClassPathXmlApplicationContext("beans.xml");

    /**
     * 中国社会网htable_新闻转换到Mysql中
     */
    @Test
    public void test_XINWEN110News_HTableToMysql() throws Exception{
        IXINWEN110NewsService xinwen110NewsService = (IXINWEN110NewsService) apx.getBean("xinwen110NewsService");
        Long beginTime = new Date().getTime();
        /**
         * 中国社会网
         */
        //中国社会网- 新闻
        String htable_name = "xinwen110_news";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            Xinwen110NewsEntity xinwen110News = new Xinwen110NewsEntity();
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
                        xinwen110News.setUrl(value);
                        break;
                    case "path_text":
                        xinwen110News.setPathText(value);
                        break;
                    case "path_href":
                        xinwen110News.setPathHref(value);
                        break;
                    case "title":
                        xinwen110News.setTitle(value);
                        break;
                    case "date_time":
                        xinwen110News.setDateTime(value);
                        break;
                    case "source":
                        xinwen110News.setSource(value);
                        break;
                    case "read_num":
                        xinwen110News.setReadNum(Integer.parseInt(value));
                        break;
                    case "comment_num":
                        xinwen110News.setCommentNum(Integer.parseInt(value));
                        break;
                    case "content":
                        xinwen110News.setContent(value);
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                xinwen110News.setTimeStamp(new Timestamp(time));
            }
            xinwen110NewsService.saveXINWEN110News(xinwen110News);
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
