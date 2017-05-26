package com.sicdlib.dao;

import com.sicdlib.dto.TbEventArticleEntity;
/**
 * Created by YH on 2017/5/26.
 */
public interface IEventArticleDAO {
    String getSourceArticleTitle(String tableID, String articleID);
    Boolean saveOrUpdateEventArticle(TbEventArticleEntity eventArticle);
}
