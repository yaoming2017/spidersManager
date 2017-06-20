package com.sicdlib.service;

import com.sicdlib.dto.TbSentimentInflucenceEntity;

/**
 * Created by init on 2017/6/16.
 */
public interface IArticleCommentNumService {
    boolean getArticleCommentNumByEventID(TbSentimentInflucenceEntity tbSentimentInflucenceEntity);
}
