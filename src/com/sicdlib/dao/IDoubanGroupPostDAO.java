package com.sicdlib.dao;

import com.sicdlib.dto.DoubanGroupCommentEntity;
import com.sicdlib.dto.DoubanGroupPostEntity;

public interface IDoubanGroupPostDAO {
    Boolean saveDoubanGroupPost(DoubanGroupPostEntity doubanGroupPost);
}
