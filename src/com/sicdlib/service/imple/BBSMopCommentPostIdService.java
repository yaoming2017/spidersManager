package com.sicdlib.service.imple;

import com.sicdlib.dao.IBBSMopCommentPostIdDAO;
import com.sicdlib.dto.entity.BbsMopCommentPostIdEntity;
import com.sicdlib.service.IBBSMopCommentPostIdService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/5/30.
 */
@Service("bbsMopCommentPostIdService")
public class BBSMopCommentPostIdService implements IBBSMopCommentPostIdService{
    @Autowired
    @Qualifier("bbsMopCommentPostIdDAO")
    private IBBSMopCommentPostIdDAO bbsMopCommentPostIdDAO;

    @Override
    public boolean savebbsMopCommentPostId(BbsMopCommentPostIdEntity bbsMopCommentPostId) {
        if(bbsMopCommentPostId.getId()==null){
         String uuid = UUIDUtil.getUUID();
         bbsMopCommentPostId.setId(uuid);
        }
        return bbsMopCommentPostIdDAO.saveBBSMopCommentPostId(bbsMopCommentPostId);
    }
}
