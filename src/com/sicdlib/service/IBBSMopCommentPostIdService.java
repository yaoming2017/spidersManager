package com.sicdlib.service;

import com.sicdlib.dto.entity.BbsMopCommentPostIdEntity;

/**
 * Created by init on 2017/5/26.
 */
public interface IBBSMopCommentPostIdService {
    //新增或更新BBS社区的评论和文章id之间的关系
    public  boolean savebbsMopCommentPostId(BbsMopCommentPostIdEntity bbsMopCommentPostId);
}
