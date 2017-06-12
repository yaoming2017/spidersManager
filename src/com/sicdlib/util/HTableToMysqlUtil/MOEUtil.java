package com.sicdlib.util.HTableToMysqlUtil;

import com.sicdlib.dto.entity.*;
import com.sicdlib.service.pythonService.IMOEConferenceService;
import com.sicdlib.service.pythonService.IMOEDataService;
import com.sicdlib.service.pythonService.IMOEDeclarationService;
import com.sicdlib.service.pythonService.IMOENewsService;
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
 * Created by init on 2017/6/4.
 */
public class MOEUtil {
    static ApplicationContext apx = new ClassPathXmlApplicationContext("beans.xml");

    /**
     * 教育部htable_作者转换到Mysql中
     */
    @Test
    public void test_MOEConference_HTableToMysql() throws Exception{
       IMOEConferenceService moeConferenceService = (IMOEConferenceService) apx.getBean("moeConferenceService ");
        Long beginTime = new Date().getTime();
        /**
         * 教育部
         */
        //教育部- 会议
        String htable_name = "moe_conference";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            MoeConferenceEntity moeConference = new MoeConferenceEntity();
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
                        moeConference.setUrl(value);
                        break;
                    case "spider_path":
                        moeConference.setSpiderPath(value);
                        break;
                    case "position":
                        moeConference.setPosition(value);
                        break;
                    case "title":
                        moeConference.setTitle(value);
                        break;
                    case "date_time":
                        moeConference.setDateTime(value);
                        break;
                    case "author":
                        moeConference.setAuthor(value);
                        break;
                    case "source":
                        moeConference.setSource(value);
                        break;
                    case "time":
                        moeConference.setTime(value);
                        break;
                    case "site":
                        moeConference.setSite(value);
                        break;
                    case "compere":
                        moeConference.setCompere(value);
                        break;
                    case "member":
                        moeConference.setMember(value);
                        break;
                    case "content":
                        moeConference.setContent(value);
                        break;
                    case "agenda_url":
                        moeConference.setAgendaUrl(value);
                        break;
                    case "material_urls":
                        moeConference.setMaterialUrls(value);
                        break;
                    case "picture_news_url":
                        moeConference.setPictureNewsUrl(value);
                        break;
                    case "files_url":
                        moeConference.setFilesUrl(value);
                        break;
                    case "news_urls":
                        moeConference.setNewsUrls(value);
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                moeConference.setTimeStamp(new Timestamp(time));
            }
            moeConferenceService.saveMOEConference(moeConference);
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
     * 教育部htable_转换到Mysql中
     */
    @Test
    public void test_MOEData_HTableToMysql() throws Exception{
        IMOEDataService moeDataService = (IMOEDataService) apx.getBean("moeDataService");
        Long beginTime = new Date().getTime();
        /**
         * 教育部
         */
        //教育部数据
        String htable_name = "moe_data";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            MoeDataEntity moeData = new MoeDataEntity();
            i++;
            for (KeyValue rowKV : result.raw()) {
                //字段名
                String qualifer = new String(rowKV.getQualifier());
                //值：字段对应的值
                String value = new String(rowKV.getValue());
                //将4字节表情或特殊字符去掉
                value = value.replaceAll("[\\x{10000}-\\x{10FFFF}]", "");
                switch (qualifer){
                    case "url":
                        moeData.setUrl(value);
                        break;
                    case "spider_path":
                        moeData.setSpiderPath(value);
                        break;
                    case "position":
                        moeData.setPosition(value);
                        break;
                    case "date_time":
                        String dateTime = "";
                        DateFormat sourceFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
                        DateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        dateTime = destFormat.format(sourceFormat.parse(value));
                        moeData.setDateTime(dateTime);
                        break;
                    case "title_yt":
                        moeData.setTitleYt(value);
                        break;
                    case "title":
                        moeData.setTitle(value);
                        break;
                    case "sub_title":
                        moeData.setSubTitle(value);
                        break;
                    case "title_fwzh":
                        moeData.setTitleFwzh(value);
                        break;
                    case "content":
                        moeData.setContent(value);
                        break;
                    case "editor":
                        moeData.setEditor(value);
                        break;
                    case "file_url_names":
                        moeData.setFileUrlNames(value);
                        break;
                    case "QRCode_url":
                        moeData.setQrCodeUrl(value);
                        break;
                    case "b_files":
                        moeData.setbFiles(value);
                        break;
                    case "b_QRCode":
                        moeData.setbQrCode(value);
                        break;
                }
                // 获取爬取数据时间戳
                Long time = new Long(rowKV.getTimestamp());
                moeData.setTimeStamp(new Timestamp(time));
            }
           moeDataService.saveMOEData(moeData);
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
     * 教育网公告htable_发布信息转换到Mysql中
     */
    @Test
    public void test_MOEDeclaration_HTableToMysql() throws Exception{
        IMOEDeclarationService moeDeclarationService = (IMOEDeclarationService) apx.getBean("moeDeclarationService");
        Long beginTime = new Date().getTime();
        /**
         * 教育网公告
         */
        //教育网公告
        String htable_name = "moe_declaration";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            MoeDeclarationEntity moeDeclaration = new MoeDeclarationEntity();
            i++;
            for (KeyValue rowKV : result.raw()) {
                //字段名
                String qualifer = new String(rowKV.getQualifier());
                //值：字段对应的值
                String value = new String(rowKV.getValue());
                //将4字节表情或特殊字符去掉
                value = value.replaceAll("[\\x{10000}-\\x{10FFFF}]", "");
                switch (qualifer){
                    case "url":
                        moeDeclaration.setUrl(value);
                        break;
                    case "spider_path":
                        moeDeclaration.setSpiderPath(value);
                        break;
                    case "position":
                        moeDeclaration.setPosition(value);
                        break;
                    case "info_title":
                        moeDeclaration.setInfoTitle(value);
                        break;
                    case "info_index":
                        moeDeclaration.setInfoIndex(value);
                        break;
                    case "info_date":
                        moeDeclaration.setInfoDate(value);
                        break;
                    case "info_institution":
                        moeDeclaration.setInfoInstitution(value);
                        break;
                    case "document_num":
                        moeDeclaration.setDocumentNum(Integer.parseInt(value));
                        break;
                    case "info_category":
                        moeDeclaration.setInfoCategory(value);
                        break;
                    case "info_abstract":
                        moeDeclaration.setInfoAbstract(value);
                        break;
                    case "info_content":
                        moeDeclaration.setInfoContent(value);
                        break;
                    case "publish_date":
                        moeDeclaration.setDateTime(value);
                        break;
                    case "author":
                        moeDeclaration.setAuthor(value);
                        break;
                    case "QRCode_url":
                        moeDeclaration.setQrCodeUrl(value);
                        break;
                    case "QRCode_base64":
                        moeDeclaration.setQrCodeBase64(value);
                        break;
                    case "b_QRCode":
                        moeDeclaration.setbQrCode(value);
                        break;
                    case "file_url_names":
                        moeDeclaration.setFileUrlNames(value);
                        break;
                    case "b_files":
                        moeDeclaration.setbFiles(value);
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                moeDeclaration.setTimeStamp(new Timestamp(time));
            }
           moeDeclarationService.saveMOEDeclaration(moeDeclaration);
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
     * 教育网新闻htable_发布信息转换到Mysql中
     */
    @Test
    public void test_MOENews_HTableToMysql() throws Exception{
        IMOENewsService moeNewsService = (IMOENewsService) apx.getBean("moeNewsService");
        Long beginTime = new Date().getTime();
        /**
         * 教育网新闻
         */
        //教育网新闻
        String htable_name = "moe_news";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            MoeNewsEntity moeNews = new MoeNewsEntity();
            i++;
            for (KeyValue rowKV : result.raw()) {
                //字段名
                String qualifer = new String(rowKV.getQualifier());
                //值：字段对应的值
                String value = new String(rowKV.getValue());
                //将4字节表情或特殊字符去掉
                value = value.replaceAll("[\\x{10000}-\\x{10FFFF}]", "");
                switch (qualifer){
                    case "url":
                        moeNews.setUrl(value);
                        break;
                    case "spider_path":
                        moeNews.setSpiderPath(value);
                        break;
                    case "position":
                        moeNews.setPosition(value);
                        break;
                    case "news_yt":
                        moeNews.setNewsYt(value);
                        break;
                    case "news_title":
                        moeNews.setNewsTitle(value);
                        break;
                    case "news_sub_title":
                        moeNews.setNewsSubTitle(value);
                        break;
                    case "news_fwzh":
                        moeNews.setNewsFwzh(value);
                        break;
                    case "news_time":
                        moeNews.setNewsTime(value);
                        break;
                    case "news_source":
                        moeNews.setNewsSource(value);
                        break;
                    case "news_editor":
                        moeNews.setNewsEditor(value);
                        break;
                    case "news_content":
                        moeNews.setNewsContent(value);
                        break;
                    case "file_url_names":
                        moeNews.setFileUrlNames(value);
                        break;
                    case "QRCode_url":
                        moeNews.setQrCodeUrl(value);
                        break;
                    case "b_files":
                        moeNews.setbFiles(value);
                        break;
                    case "b_QRCode":
                        moeNews.setbQrCode(value);
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                moeNews.setTimeStamp(new Timestamp(time));
            }
           moeNewsService.saveMOENews(moeNews);
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
