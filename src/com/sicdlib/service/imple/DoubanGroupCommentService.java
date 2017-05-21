package com.sicdlib.service.imple;

import com.sicdlib.dao.IDoubanGroupAuthorDAO;
import com.sicdlib.dao.IDoubanGroupCommentDAO;
import com.sicdlib.dto.DoubanGroupAuthorEntity;
import com.sicdlib.dto.DoubanGroupCommentEntity;
import com.sicdlib.service.IDoubanGroupAuthorService;
import com.sicdlib.service.IDoubanGroupCommentService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Yh on 2016/9/8.
 */
@Service("doubanGroupCommentService")
public class DoubanGroupCommentService implements IDoubanGroupCommentService{
    @Autowired
    @Qualifier("doubanGroupCommentDAO")
    private IDoubanGroupCommentDAO doubanGroupCommentDAO;

    @Override
    public boolean saveDoubanGroupComment(DoubanGroupCommentEntity doubanGroupComment) {
        if (doubanGroupComment.getId() == null){
            String uuid = UUIDUtil.getUUID();
            doubanGroupComment.setId(uuid);
        }
        return doubanGroupCommentDAO.saveDoubanGroupAuthor(doubanGroupComment);
    }
}
