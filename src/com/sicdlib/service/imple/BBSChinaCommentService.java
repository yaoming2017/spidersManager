package com.sicdlib.service.imple;

import com.sicdlib.dao.IBBSChinaCommentDAO;
import com.sicdlib.dao.IDoubanGroupCommentDAO;
import com.sicdlib.dto.entity.BbsChinaCommentEntity;
import com.sicdlib.dto.entity.DoubanGroupCommentEntity;
import com.sicdlib.service.IBBSChinaCommentService;
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
