package com.sicdlib.service;

import com.sicdlib.dto.entity.BbsTianyaCommentEntity;

/**
 * Created by init on 2017/6/2.
 */
public interface IBBSTianyaCommentService {
    //更新或新增天涯
    public  boolean saveBBSTianyaComment(BbsTianyaCommentEntity bbsTianyaComment);
}
