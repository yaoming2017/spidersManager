package com.sicdlib.service;

import com.sicdlib.dto.entity.DoubanGroupComentPostIdEntity;
import com.sicdlib.dto.entity.DoubanGroupCommentEntity;

/**
 * Created by init on 2017/5/25.
 */
public interface IDoubanGroupCommentPostIdService {
    //新增or更新豆瓣小组文章和评论
    public boolean saveDoubanGroupCommentPostId(DoubanGroupComentPostIdEntity doubanGroupComentPostId);
}
