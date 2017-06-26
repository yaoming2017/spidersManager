package com.sicdlib.util.HTableToMysqlUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by YH on 2017/6/22.
 */
public class FormatDate {
    public static String format(String sourceDate, String sourceFormatStr) throws ParseException {
        DateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        if (sourceDate != null && !sourceDate.equals("") && !sourceDate.equals("无")) {
            DateFormat sourceFormat = new SimpleDateFormat(sourceFormatStr);

            return destFormat.format(sourceFormat.parse(sourceDate));
        } else {
            return "";
        }
    }

    public static String format(String sourceDate, String sourceFormatStr, Locale locale) throws ParseException {
        DateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        if (sourceDate != null && !sourceDate.equals("") && !sourceDate.equals("无")) {
            DateFormat sourceFormat = new SimpleDateFormat(sourceFormatStr, locale);
            return destFormat.format(sourceFormat.parse(sourceDate));
        } else {
            return "";
        }
    }
}
