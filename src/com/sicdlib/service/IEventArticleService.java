package com.sicdlib.service;

import com.sicdlib.dto.TbEventArticleEntity;
import com.sicdlib.dto.TbEventEntity;

public interface IEventArticleService {
    Boolean saveOrUpdateEventArticle(TbEventArticleEntity eventArticle);
}
