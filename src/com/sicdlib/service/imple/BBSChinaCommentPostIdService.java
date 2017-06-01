package com.sicdlib.service.imple;

import com.sicdlib.dao.IBBSChinaCommentPostIdDAO;
import com.sicdlib.dto.entity.BbsChinaCommentPostIdEntity;
import com.sicdlib.service.IBBSChinaCommentPostIdService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/5/31.
 */
@Service("bbsChinaCommentPostIdService")
public class BBSChinaCommentPostIdService implements IBBSChinaCommentPostIdService {
    @Autowired
    @Qualifier("bbsChinaCommentPostIdDAO")
    private IBBSChinaCommentPostIdDAO bbsChinaCommentPostIdDAO;
    @Override
    public boolean saveBBSChinaCommentPostId(BbsChinaCommentPostIdEntity bbsChinaCommentPostId) {
        if(bbsChinaCommentPostId.getId() ==null){
            String uuid = UUIDUtil.getUUID();
            bbsChinaCommentPostId.setId(uuid);
        }
        return bbsChinaCommentPostIdDAO.saveBBSChinaCommentPostId(bbsChinaCommentPostId);
    }
}
