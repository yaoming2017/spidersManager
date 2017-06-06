package com.sicdlib.service.imple;

import com.sicdlib.dao.IBBSXiciCommentDAO;
import com.sicdlib.dto.entity.BbsXiciCommentEntity;
import com.sicdlib.service.IBBSXiciCommentService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/2.
 */
@Service("bbsXiciCommentService ")
public class BBSXiciCommentService  implements IBBSXiciCommentService{
    @Autowired
    @Qualifier("bbsXiciCommentDAO")
    private IBBSXiciCommentDAO bbsXiciCommentDAO;
    @Override
    public boolean saveBBSXiciComment(BbsXiciCommentEntity bbsXiciComment) {
        if(bbsXiciComment.getId() ==null){
            String uuid = UUIDUtil.getUUID();
            bbsXiciComment.setId(uuid);
        }
        return bbsXiciCommentDAO.saveBBSXiciComment(bbsXiciComment);
    }
}
