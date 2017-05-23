package com.sicdlib.dao;

import com.sicdlib.dto.DoubanGroupCommentEntity;
import com.sicdlib.dto.DoubanGroupPostEntity;

import java.util.List;

public interface IDoubanGroupPostDAO {
    Boolean saveDoubanGroupPost(DoubanGroupPostEntity doubanGroupPost);
    List<DoubanGroupPostEntity> getAllDoubanGroupPosts();
}
