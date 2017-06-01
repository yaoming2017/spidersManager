package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.IDoubanGroupCommentPostIdDAO;
import com.sicdlib.dto.entity.DoubanGroupComentPostIdEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/5/25.
 */
@Repository("doubanGroupCommentPostIdDAO")
public class DoubanGroupCommentPostIdDAO implements IDoubanGroupCommentPostIdDAO{
    @Autowired
    private IBaseDAO baseDAO;

    @Override
    public Boolean saveDoubanGroupCommentPostId(DoubanGroupComentPostIdEntity doubanGroupComentPostId) {
        try {
            baseDAO.save(doubanGroupComentPostId);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
