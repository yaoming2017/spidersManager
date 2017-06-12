package com.sicdlib.service.pythonService.imple;

import com.sicdlib.dao.pyhtonDAO.IBBSTianyaCommentDAO;
import com.sicdlib.dto.entity.BbsTianyaCommentEntity;
import com.sicdlib.service.pythonService.IBBSTianyaCommentService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/2.
 */
@Service("bbsTianyaCommentService")
public class BBSTianyaCommentService  implements IBBSTianyaCommentService{
    @Autowired
    @Qualifier("bbsTianyaCommentDAO")
    private IBBSTianyaCommentDAO bbsTianyaCommentDAO;
    @Override
    public boolean saveBBSTianyaComment(BbsTianyaCommentEntity bbsTianyaComment) {
        if(bbsTianyaComment.getId() ==null){
            String uuid = UUIDUtil.getUUID();
            bbsTianyaComment.setId(uuid);
        }
        return bbsTianyaCommentDAO.saveBBSTianyaComment(bbsTianyaComment);
    }
}
