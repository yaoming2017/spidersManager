package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.WeiboCommentEntity;

/**
 * Created by init on 2017/6/5.
 */
public interface IWEIBOCommentService {
    //更新或新增微博评论
    public boolean saveWEIBOComment(WeiboCommentEntity weiboComment);
}
