package com.sicdlib.dao.imple;

import com.sicdlib.dao.IArticleSimiDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.TbArticleSimilarityEntity;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by YH on 2017/6/5.
 */
@Repository("articleSimiDAO")
public class ArticleSimiDAO implements IArticleSimiDAO {
    @Autowired
    @Qualifier("baseDAO")
    private IBaseDAO baseDAO;

    @Override
    public void batchSaveSimiEntity(List<TbArticleSimilarityEntity> simiList) {
        baseDAO.batchSave(simiList);
    }

    @Override
    public List<TbArticleSimilarityEntity> getSimiArticleEntityList(String eventID, double simi) {
        Session session = baseDAO.getCurrentSession();
        String sql = "SELECT {simi.*} " +
                "FROM tb_article_similarity simi " +
                "WHERE simi.article_a_id in (" +
                "SELECT " +
                "FROM tb_event_article event " +
                "WHERE event.id = '" + eventID +
                "') AND simi.similarity > '" + simi +"'";

        List result = session.createSQLQuery(sql)
                .addEntity("simi", TbArticleSimilarityEntity.class).list();

        return result;
    }

    @Override
    public List<TbArticleSimilarityEntity> getSimiArticleEntityList(String eventID) {
//        return baseDAO.find(hql);
        Session session = baseDAO.getCurrentSession();
        String sql = "SELECT {simi.*} " +
                "FROM tb_article_similarity simi " +
                "WHERE simi.article_a_id in (" +
                "SELECT event.id " +
                "FROM tb_event_article event " +
                "WHERE event.event_id = '" + eventID +
                "')";

        List result = session.createSQLQuery(sql)
                .addEntity("simi", TbArticleSimilarityEntity.class).list();

        return result;
    }
}
