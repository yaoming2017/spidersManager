package com.sicdlib.service.pythonService.imple;

import com.sicdlib.dao.pyhtonDAO.IBBSMopCommentDAO;
import com.sicdlib.dto.entity.BbsMopCommentEntity;
import com.sicdlib.service.pythonService.IBBSMopCommentService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;



/**
 * Created by init on 2017/5/26.
 */
@Service("bbsMopCommentService")
public class BBSMopCommentService  implements IBBSMopCommentService{
    @Autowired
    @Qualifier("bbsMopCommentDAO")
    private IBBSMopCommentDAO bbsMopCommentDAO;

    @Override
    public boolean saveBBSMopComment(BbsMopCommentEntity bbsMopComment) {
        if(bbsMopComment.getId() == null){
            String uuid = UUIDUtil.getUUID();
            bbsMopComment.setId(uuid);
        }
        return bbsMopCommentDAO.saveBBSMopComment(bbsMopComment);
    }
}
