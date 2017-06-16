package com.sicdlib.service;

import com.sicdlib.dto.ArticleHotValueEntity;

/**
 * Created by YH on 2017/6/5.
 */
public interface IArticleHotValueService {
    boolean addArticleHotValueByEventID(ArticleHotValueEntity articleHotValue);
}
