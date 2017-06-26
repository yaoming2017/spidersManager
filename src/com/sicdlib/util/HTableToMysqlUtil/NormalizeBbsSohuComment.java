package com.sicdlib.util.HTableToMysqlUtil;

import com.sicdlib.dto.entity.BbsSohuCommentEntity;

import java.text.ParseException;

/**
 * Created by YH on 2017/6/22.
 */
public class NormalizeBbsSohuComment implements INormalizeProcess {
    @Override
    public Object processData(Object object) {
        BbsSohuCommentEntity sohuComment = (BbsSohuCommentEntity) object;
        sohuComment.setContent(sohuComment.getContent().trim());

        String date = sohuComment.getDateTime();
        String fmt = "yy-MM-dd hh:mm:ss";
        try {
            sohuComment.setDateTime(FormatDate.format(date, fmt));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return sohuComment;
    }
}
