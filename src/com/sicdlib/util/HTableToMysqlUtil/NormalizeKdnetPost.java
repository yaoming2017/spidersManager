package com.sicdlib.util.HTableToMysqlUtil;

import com.sicdlib.dto.entity.KdnetPostEntity;

import java.text.ParseException;

/**
 * Created by YH on 2017/6/23.
 */
public class NormalizeKdnetPost implements INormalizeProcess {
    @Override
    public Object processData(Object object) {
        KdnetPostEntity kdnetPost = (KdnetPostEntity) object;
        String dateTime = kdnetPost.getDateTime();
        String sourceFormat = "yyyy/MM/dd h:m:ss";
        try {
            String destDate = FormatDate.format(dateTime, sourceFormat);
            kdnetPost.setDateTime(destDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return kdnetPost;
    }
}
