package com.sicdlib.dao;

import com.sicdlib.dto.TbEventArticleEntity;
import com.sicdlib.dto.TbEventEntity;

public interface IEventArticleDAO {
    Boolean saveOrUpdateEventArticle(TbEventArticleEntity eventArticle);
}
