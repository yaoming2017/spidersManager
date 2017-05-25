package com.sicdlib.dao;

import com.sicdlib.dto.entity.DoubanGroupCommentEntity;

public interface IDoubanGroupCommentDAO {
    Boolean saveDoubanGroupAuthor(DoubanGroupCommentEntity doubanGroupComment);
}
