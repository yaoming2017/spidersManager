package com.sicdlib.dao;

import com.sicdlib.dto.TbEventArticleEntity;
import com.sicdlib.dto.TbEventEntity;

import java.util.List;

/**
 * Created by YH on 2017/5/26.
 */
public interface IEventArticleDAO {
    String getArticleTitle(String tableID, String articleID);
    String getArticleDateTime(String tableID, String articleID);
    Boolean saveOrUpdateEventArticle(TbEventArticleEntity eventArticle);
    TbEventArticleEntity getEventArticleEntity(String id);
}
