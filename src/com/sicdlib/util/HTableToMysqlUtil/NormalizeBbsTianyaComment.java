package com.sicdlib.util.HTableToMysqlUtil;

import com.sicdlib.dto.entity.BbsTianyaCommentEntity;

/**
 * Created by YH on 2017/6/22.
 */
public class NormalizeBbsTianyaComment implements INormalizeProcess {
    @Override
    public Object processData(Object object) {
        BbsTianyaCommentEntity tianyaComment = (BbsTianyaCommentEntity) object;
        tianyaComment.setContent(tianyaComment.getContent().replaceAll("[\\uE5F1]", "").trim());
        return tianyaComment;
    }
}
