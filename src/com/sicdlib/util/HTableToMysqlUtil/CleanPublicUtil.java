package com.sicdlib.util.HTableToMysqlUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DeMH on 2017/5/24.
 */
public class CleanPublicUtil {
    //数据公共清洗
    public static String publicCleanMethods(String value){
        //将4字节表情或特殊字符去掉
        value = value.replaceAll("[\\x{10000}-\\x{10FFFF}]", "");
        //去掉所有空格，以及换行符,制表符等。
        value.replaceAll(" ","");
        value.replaceAll("　","");
        Pattern pattern = Pattern.compile("\\s*|\t|\r|\n");
        Matcher matcher = pattern.matcher(value);
        value = matcher.replaceAll("");
        value.trim();
        return value;
    }
}
