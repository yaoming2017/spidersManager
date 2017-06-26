package com.sicdlib.util.HTableToMysqlUtil;

import com.sicdlib.dto.entity.BbsSohuPostEntity;

import java.text.ParseException;

/**
 * Created by YH on 2017/6/22.
 */
public class NormalizeBbsSohuPost implements INormalizeProcess {
    @Override
    public Object processData(Object object) {
        BbsSohuPostEntity sohuPost = (BbsSohuPostEntity) object;

        sohuPost.setContent(sohuPost.getContent().trim());

        String date = sohuPost.getDateTime();
        String fmt = "yy-MM-dd hh:mm:ss";
        try {
            sohuPost.setDateTime(FormatDate.format(date, fmt));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sohuPost;
    }
}
