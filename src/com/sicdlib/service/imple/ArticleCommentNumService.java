package com.sicdlib.service.imple;

import com.sicdlib.dao.IArticleCommentNumDAO;
import com.sicdlib.dto.TbSentimentInflucenceEntity;
import com.sicdlib.service.IArticleCommentNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/16.
 */
@Service("articleCommentNumService")
public class ArticleCommentNumService implements IArticleCommentNumService{
    @Autowired
    @Qualifier("articleCommentNumDAO")
    private IArticleCommentNumDAO articleCommentNumDAO;
    @Override
    public boolean getArticleCommentNumByEventID(TbSentimentInflucenceEntity tbSentimentInflucenceEntity) {
        return articleCommentNumDAO.getArticleCommentNumByEventID(tbSentimentInflucenceEntity);
    }
}
