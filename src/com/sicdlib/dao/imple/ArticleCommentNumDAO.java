package com.sicdlib.dao.imple;

import com.sicdlib.dao.IArticleCommentNumDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.TbSentimentInflucenceEntity;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/16.
 */
@Repository("articleCommentNumDAO")
public class ArticleCommentNumDAO implements IArticleCommentNumDAO{
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public boolean getArticleCommentNumByEventID(TbSentimentInflucenceEntity tbSentimentInflucenceEntity) {
        if(tbSentimentInflucenceEntity.getId() == null){
          String uuid = UUIDUtil.getUUID();
          tbSentimentInflucenceEntity.setId(uuid);
        }try{
            baseDAO.save(tbSentimentInflucenceEntity);
            return true;
        }catch (Exception e){
           e.printStackTrace();
            return false;
        }
    }
}
