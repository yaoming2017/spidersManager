package com.sicdlib.util.HTableToMysqlUtil;

import com.sicdlib.dto.entity.BbsXiciPostEntity;

import java.text.ParseException;

/**
 * Created by YH on 2017/6/23.
 */
public class NormalizeXiciPost implements INormalizeProcess {
    @Override
    public Object processData(Object object) {
        BbsXiciPostEntity xiciPost = (BbsXiciPostEntity) object;
        xiciPost.setContent(xiciPost.getContent().trim());

        String date = xiciPost.getDateTime();
        String fmt = "yy-MM-dd hh:mm";
        try {
            xiciPost.setDateTime(FormatDate.format(date, fmt));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return xiciPost;
    }
}
