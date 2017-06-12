package com.sicdlib.service.pythonService.imple;

import com.sicdlib.dao.pyhtonDAO.IBLOG163CommentDAO;
import com.sicdlib.dto.entity.Blog163CommentEntity;
import com.sicdlib.service.pythonService.IBLOG163CommentService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/3.
 */
@Service("blog163CommentService")
public class BLOG163CommentService  implements IBLOG163CommentService{
    @Autowired
    @Qualifier("blog163CommentDAO")
    private IBLOG163CommentDAO blog163CommentDAO;
    @Override
    public boolean saveBLOG163Comment(Blog163CommentEntity blog163Comment) {
        if(blog163Comment.getId() ==null){
            String uuid = UUIDUtil.getUUID();
            blog163Comment.setId(uuid);
        }
        return blog163CommentDAO.saveBLOG163Comment(blog163Comment);
    }
}
