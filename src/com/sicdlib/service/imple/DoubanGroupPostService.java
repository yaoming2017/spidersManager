package com.sicdlib.service.imple;

import com.sicdlib.dao.pyhtonDAO.IDoubanGroupPostDAO;
import com.sicdlib.dto.entity.DoubanGroupPostEntity;
import com.sicdlib.service.pythonService.IDoubanGroupPostService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
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
        if (doubanGroupPost.getId() == null){
            String uuid = UUIDUtil.getUUID();
           doubanGroupPost.setId(uuid);
        }
        return doubanGroupPostDAO.saveDoubanGroupPost(doubanGroupPost);
    }

    @Override
    public List<DoubanGroupPostEntity> getAllDoubanGroupPost() {
        return doubanGroupPostDAO.getAllDoubanGroupPosts();
    }

    @Override
    public DoubanGroupPostEntity getDoubanGroupPost(String id) {
        return doubanGroupPostDAO.getDoubangroupPost(id);
    }

}
