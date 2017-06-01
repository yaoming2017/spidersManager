package com.sicdlib.service.imple;

import com.sicdlib.dao.IDoubanGroupCommentPostIdDAO;
import com.sicdlib.dto.entity.DoubanGroupComentPostIdEntity;
import com.sicdlib.service.IDoubanGroupCommentPostIdService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;



/**
 * Created by init on 2017/5/25.
 */
@Service("doubanGroupCommentPostIdService")
public class DoubanGroupCommentPostIdService implements IDoubanGroupCommentPostIdService{
    @Autowired
    @Qualifier("doubanGroupCommentPostIdDAO")
    private IDoubanGroupCommentPostIdDAO doubanGroupCommentPostIdDAO;

    @Override
    public boolean saveDoubanGroupCommentPostId(DoubanGroupComentPostIdEntity doubanGroupComentPostId) {
        if (doubanGroupComentPostId.getId() == null){
            String uuid = UUIDUtil.getUUID();
            doubanGroupComentPostId.setId(uuid);
        }
        return doubanGroupCommentPostIdDAO.saveDoubanGroupCommentPostId(doubanGroupComentPostId);

    }
}
