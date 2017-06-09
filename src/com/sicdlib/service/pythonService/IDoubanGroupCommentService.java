package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.DoubanGroupCommentEntity;

public interface IDoubanGroupCommentService {
    //新增or更新豆瓣小组评论
    public boolean saveDoubanGroupComment(DoubanGroupCommentEntity doubanGroupComment);
}
