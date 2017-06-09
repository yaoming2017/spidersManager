package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.pyhtonDAO.IDoubanGroupCommentDAO;
import com.sicdlib.dto.entity.DoubanGroupCommentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Yh on 2016/9/8.
 */
@Repository("doubanGroupCommentDAO")
public class DoubanGroupCommentDAO implements IDoubanGroupCommentDAO {
    @Autowired
    private IBaseDAO baseDAO;

    @Override
    public Boolean saveDoubanGroupAuthor(DoubanGroupCommentEntity doubanGroupComment) {
        try {
            baseDAO.save(doubanGroupComment);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
