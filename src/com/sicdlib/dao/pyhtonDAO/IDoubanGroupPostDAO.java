package com.sicdlib.dao.pyhtonDAO;

import com.sicdlib.dto.entity.DoubanGroupPostEntity;

import java.util.List;

public interface IDoubanGroupPostDAO {
    Boolean saveDoubanGroupPost(DoubanGroupPostEntity doubanGroupPost);
    List<DoubanGroupPostEntity> getAllDoubanGroupPosts();
    DoubanGroupPostEntity getDoubangroupPost(String id);
}
