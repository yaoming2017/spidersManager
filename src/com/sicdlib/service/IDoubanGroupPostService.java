package com.sicdlib.service;

import com.sicdlib.dto.DoubanGroupCommentEntity;
import com.sicdlib.dto.DoubanGroupPostEntity;

public interface IDoubanGroupPostService {
    //新增or更新豆瓣小组发布
    public boolean saveDoubanGroupPost(DoubanGroupPostEntity doubanGroupPost);
}
