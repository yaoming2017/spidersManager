package com.sicdlib.util.Test;

import com.sicdlib.util.CleanDataUtil.CleanInputUtil;
import org.junit.Test;


/**
 * Created by DeMH on 2017/5/17.
 */
public class TestModule {
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
}
