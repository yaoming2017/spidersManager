package com.sicdlib.service.imple;

import com.sicdlib.dao.IBBSSohuCommentDAO;
import com.sicdlib.dto.entity.BbsSohuCommentEntity;
import com.sicdlib.service.IBBSSohuCommentService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/2.
 */
@Service("bbsSohuCommentService")
public class BBSSohuCommentService implements IBBSSohuCommentService {
    @Autowired
    @Qualifier("bbsSohuCommentDAO")
    private IBBSSohuCommentDAO bbsSohuCommentDAO;
    @Override
    public boolean saveBBSSohuComment(BbsSohuCommentEntity bbsSohuComment) {
        if(bbsSohuComment.getId() ==null){
            String uuid = UUIDUtil.getUUID();
            bbsSohuComment.setId(uuid);
        }
        return bbsSohuCommentDAO.saveBBSSohuComment(bbsSohuComment);
    }
}
