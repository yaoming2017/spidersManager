package com.sicdlib.service;

import com.sicdlib.dto.entity.BbsSohuCommentEntity;

/**
 * Created by init on 2017/6/2.
 */
public interface IBBSSohuCommentService {
    //更新或新增搜狐
    public boolean saveBBSSohuComment(BbsSohuCommentEntity bbsSohuComment);
}
