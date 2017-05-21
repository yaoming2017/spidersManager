package com.sicdlib.service.imple;

import com.sicdlib.dao.IDoubanGroupCommentDAO;
import com.sicdlib.dao.IDoubanGroupPostDAO;
import com.sicdlib.dto.DoubanGroupCommentEntity;
import com.sicdlib.dto.DoubanGroupPostEntity;
import com.sicdlib.service.IDoubanGroupCommentService;
import com.sicdlib.service.IDoubanGroupPostService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
}
