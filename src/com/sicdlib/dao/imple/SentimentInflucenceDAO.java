package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.ISentimentInflucenceDAO;
import com.sicdlib.dto.entity.DoubanGroupPostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by init on 2017/6/14.
 */
@Repository("sentimentInflucenceDAO")
public class SentimentInflucenceDAO  implements ISentimentInflucenceDAO{
    @Autowired
    @Qualifier("baseDAO")
    private IBaseDAO baseDAO;

    @Override
    public List<DoubanGroupPostEntity> getDoubanGroupPostEntityList(String postId, int limit) {
        String hql = "FROM DoubanGroupPostEntity doubanGroupPost WHERE doubanGroupPost.postId ='" + postId + "' order by doubanGroupPost.commentNum desc ";
         if(limit != 0){
             return baseDAO.find(hql,0,limit);
         }
        return  baseDAO.find(hql);
    }

    @Override
    public List<String> getCommentNumByPost(String eventID, String tableName, String websiteName) {
        return null;
    }
}
