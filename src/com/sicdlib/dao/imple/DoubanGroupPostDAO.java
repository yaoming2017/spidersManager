package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.IDoubanGroupCommentDAO;
import com.sicdlib.dao.IDoubanGroupPostDAO;
import com.sicdlib.dto.DoubanGroupCommentEntity;
import com.sicdlib.dto.DoubanGroupPostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Yh on 2016/9/8.
 */
@Repository("doubanGroupPostDAO")
public class DoubanGroupPostDAO implements IDoubanGroupPostDAO {
    @Autowired
    private IBaseDAO baseDAO;

    @Override
    public Boolean saveDoubanGroupPost(DoubanGroupPostEntity doubanGroupPost) {
        try {
            baseDAO.save(doubanGroupPost);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}