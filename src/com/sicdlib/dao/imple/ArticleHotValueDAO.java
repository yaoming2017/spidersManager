package com.sicdlib.dao.imple;

import com.sicdlib.dao.IArticleHotValueDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.ILoginDAO;
import com.sicdlib.dto.ArticleHotValueEntity;
import com.sicdlib.dto.UserEntity;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Yh on 2016/9/8.
 */
@Repository("articleHotValueDAO")
public class ArticleHotValueDAO implements IArticleHotValueDAO {
    @Autowired
    private IBaseDAO baseDAO;

    @Override
    public boolean addArticleHotValueByEventID(ArticleHotValueEntity articleHotValue) {
        if (articleHotValue.getId() == null){
            String uuid = UUIDUtil.getUUID();
            articleHotValue.setId(uuid);
        }
        try {
            baseDAO.save(articleHotValue);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
