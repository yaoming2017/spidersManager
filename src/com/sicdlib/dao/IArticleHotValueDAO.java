package com.sicdlib.dao;

import com.sicdlib.dto.ArticleHotValueEntity;
import com.sicdlib.dto.UserEntity;

public interface IArticleHotValueDAO {
    //添加热度
    boolean addArticleHotValueByEventID(ArticleHotValueEntity articleHotValue);
}
