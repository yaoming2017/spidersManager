package com.sicdlib.service.imple;

import com.sicdlib.dao.IDoubanGroupCommentDAO;
import com.sicdlib.dto.entity.DoubanGroupCommentEntity;
import com.sicdlib.service.IDoubanGroupCommentService;
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
        return doubanGroupCommentDAO.saveDoubanGroupAuthor(doubanGroupComment);
    }
}
