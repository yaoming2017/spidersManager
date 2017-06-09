package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.pyhtonDAO.IDoubanGroupPostDAO;
import com.sicdlib.dto.entity.DoubanGroupPostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<DoubanGroupPostEntity> getAllDoubanGroupPosts() {
        String hql = "from DoubanGroupPostEntity db";
        return baseDAO.find(hql);
    }
}