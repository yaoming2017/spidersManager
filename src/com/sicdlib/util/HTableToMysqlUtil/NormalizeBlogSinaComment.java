package com.sicdlib.util.HTableToMysqlUtil;

import com.sicdlib.dto.entity.BlogSinaCommentEntity;

/**
 * Created by YH on 2017/6/23.
 */
public class NormalizeBlogSinaComment implements INormalizeProcess {
    @Override
    public Object processData(Object object) {
        BlogSinaCommentEntity bsComment = (BlogSinaCommentEntity) object;
        bsComment.setContent(FormatContent.removeTag(bsComment.getContent()));
        return bsComment;
    }
}
