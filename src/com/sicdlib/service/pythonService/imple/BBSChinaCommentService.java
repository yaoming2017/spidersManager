package com.sicdlib.service.pythonService.imple;

import com.sicdlib.dao.pyhtonDAO.IBBSChinaCommentDAO;
import com.sicdlib.dto.entity.BbsChinaCommentEntity;
import com.sicdlib.service.pythonService.IBBSChinaCommentService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/5/25.
 */
@Service("bbsChinaCommentService")
public class BBSChinaCommentService implements IBBSChinaCommentService {
    @Autowired
    @Qualifier("bbsChinaCommentDAO")
    private IBBSChinaCommentDAO bbsChinaCommentDAO;

    @Override
    public boolean saveBBSChinaComment(BbsChinaCommentEntity bbsChinaComment) {
        if(bbsChinaComment.getId() == null){
            String uuid = UUIDUtil.getUUID();
            bbsChinaComment.setId(uuid);
        }
        return bbsChinaCommentDAO.saveBBSChinaComment(bbsChinaComment);
    }
}
