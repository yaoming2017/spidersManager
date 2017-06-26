package com.sicdlib.util.HTableToMysqlUtil;

import com.sicdlib.dto.entity.XinhuaNewsEntity;

import java.text.ParseException;

/**
 * Created by YH on 2017/6/23.
 */
public class NormalizeXinhuaNews implements INormalizeProcess {
    @Override
    public Object processData(Object object) {
        XinhuaNewsEntity xinhuaNews = (XinhuaNewsEntity) object;
        String dateTime = xinhuaNews.getDateTime();
        if (dateTime.length() < 19) {
            xinhuaNews.setDateTime("1970-01-01 01:00:00");
        } else {
            String fmt = "yyyy年MM月dd日 hh:mm:ss";
            try {
                xinhuaNews.setDateTime(FormatDate.format(dateTime, fmt));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return xinhuaNews;
    }
}
