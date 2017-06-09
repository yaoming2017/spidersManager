package com.sicdlib.service.pythonService.imple;

import com.sicdlib.dao.pyhtonDAO.IBLOGSinaCommentDAO;
import com.sicdlib.dto.entity.BlogSinaCommentEntity;
import com.sicdlib.service.pythonService.IBLOGSinaCommentService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/3.
 */
@Service("blogSinaCommentService")
public class BLOGSinaCommentService implements IBLOGSinaCommentService{
   @Autowired
   @Qualifier("blogSinaCommentDAO")
   private IBLOGSinaCommentDAO blogSinaCommentDAO;
    @Override
    public boolean saveBLOGSinaComment(BlogSinaCommentEntity blogSinaComment) {
        if(blogSinaComment.getId() ==null){
            String uuid = UUIDUtil.getUUID();
            blogSinaComment.setId(uuid);
        }
        return blogSinaCommentDAO.saveBLOGSinaComment(blogSinaComment);
}
}