package com.sicdlib.util.HTableToMysqlUtil;

import com.sicdlib.dto.entity.BlogSinaPostEntity;

/**
 * Created by YH on 2017/6/23.
 */
public class NormalizeBlogSinaPost implements INormalizeProcess {
    @Override
    public Object processData(Object object) {
        BlogSinaPostEntity sinaPost = (BlogSinaPostEntity) object;
        String dateTime = sinaPost.getDateTime();
        if(dateTime.length() > 19){
            sinaPost.setDateTime(dateTime.substring(1, dateTime.length() - 1));
        }
        return sinaPost;
    }
}
