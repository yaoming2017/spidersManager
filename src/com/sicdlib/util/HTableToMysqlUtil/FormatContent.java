package com.sicdlib.util.HTableToMysqlUtil;

/**
 * Created by YH on 2017/6/23.
 */
public class FormatContent {
    public static String removeTag(String source) {
        return source.replaceAll("<[^>]*>", "");
    }
}
