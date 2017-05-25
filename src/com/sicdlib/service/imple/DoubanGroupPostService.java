package com.sicdlib.service.imple;

import com.sicdlib.dao.IDoubanGroupPostDAO;
import com.sicdlib.dto.entity.DoubanGroupPostEntity;
import com.sicdlib.service.IDoubanGroupPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yh on 2016/9/8.
 */
@Service("doubanGroupPostService")
public class DoubanGroupPostService implements IDoubanGroupPostService{
    @Autowired
    @Qualifier("doubanGroupPostDAO")
    private IDoubanGroupPostDAO doubanGroupPostDAO;

    @Override
    public boolean saveDoubanGroupPost(DoubanGroupPostEntity doubanGroupPost) {
        return doubanGroupPostDAO.saveDoubanGroupPost(doubanGroupPost);
    }

    @Override
    public List<DoubanGroupPostEntity> getAllDoubanGroupPost() {
        return doubanGroupPostDAO.getAllDoubanGroupPosts();
    }
}
