package com.sicdlib.dao;

import com.sicdlib.dto.TbSentimentInflucenceEntity;

/**
 * Created by init on 2017/6/16.
 */
public interface IArticleCommentNumDAO {
    //获得一篇文章的评论量
    boolean getArticleCommentNumByEventID(TbSentimentInflucenceEntity tbSentimentInflucenceEntity);
}
