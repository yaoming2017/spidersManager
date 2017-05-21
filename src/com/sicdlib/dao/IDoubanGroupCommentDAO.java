package com.sicdlib.dao;

import com.sicdlib.dto.DoubanGroupAuthorEntity;
import com.sicdlib.dto.DoubanGroupCommentEntity;

public interface IDoubanGroupCommentDAO {
    Boolean saveDoubanGroupAuthor(DoubanGroupCommentEntity doubanGroupComment);
}
