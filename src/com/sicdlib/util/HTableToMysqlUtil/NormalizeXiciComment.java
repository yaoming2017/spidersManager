package com.sicdlib.util.HTableToMysqlUtil;

import com.sicdlib.dto.entity.BbsXiciCommentEntity;

import java.text.ParseException;

/**
 * Created by YH on 2017/6/23.
 */
public class NormalizeXiciComment implements INormalizeProcess {
    @Override
    public Object processData(Object object) {
        BbsXiciCommentEntity comment = (BbsXiciCommentEntity) object;
        comment.setContent(comment.getContent().replaceAll("[\\uE5F1]", "").trim());

        String date = comment.getDateTime();
        String fmt = "yy-MM-dd hh:mm";
        try {
            comment.setDateTime(FormatDate.format(date, fmt));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return comment;
    }
}
