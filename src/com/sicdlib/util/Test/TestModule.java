package com.sicdlib.util.Test;

import com.sicdlib.util.CleanDataUtil.CleanInputUtil;
import com.sicdlib.util.HBaseUtil.HBaseData;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by DeMH on 2017/5/17.
 */
public class TestModule {
    static ApplicationContext apx = new ClassPathXmlApplicationContext("beans.xml");

    @Test
    public void test(){

    }

    @Test
    public void test1(){
        String chose_fields = "bbs_china_author:author_id:5,bbs_china_author:fans_num:8,bbs_china_author:focuse_num:9,";
        String [] table_fields = chose_fields.split(",");
        CleanInputUtil.insertCleanInput(table_fields);
//        for (String tf : table_fields){
//            System.out.println(tf);
//            String [] fields = tf.split(":");
//
//        }
    }

    /**
     * 豆瓣htable内容转换到Mysql中
     */
    @Test
    public void test_HTableToMysql() throws Exception{
//        ICleanInputService cleanInputService = (ICleanInputService)apx.getBean("cleanInputService");
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

            for (KeyValue rowKV : result.raw()) {
                i++;
                //字段名
                String qualifer = new String(rowKV.getQualifier());
                //值：字段对应的值
                String value = new String(rowKV.getValue());

            }
            System.out.println();
        }

    }

}
