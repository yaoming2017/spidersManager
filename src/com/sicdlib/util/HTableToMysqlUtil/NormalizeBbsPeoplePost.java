package com.sicdlib.util.HTableToMysqlUtil;

import com.sicdlib.dto.entity.BbsPeoplePostEntity;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by YH on 2017/6/22.
 */
public class NormalizeBbsPeoplePost implements INormalizeProcess {
    @Override
    public Object processData(Object object) {
        BbsPeoplePostEntity peoplePost = (BbsPeoplePostEntity) object;

        String formatStr = "EEE MMM d HH:mm:ss 'CST' yyyy";

        try {
            peoplePost.setDateTime(FormatDate.format(peoplePost.getDateTime(), formatStr, Locale.ENGLISH));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return peoplePost;
    }
}
