package com.sicdlib.service.imple;

import com.sicdlib.dao.IBBSXinhuaCommentDAO;
import com.sicdlib.dto.entity.BbsXinhuaCommentEntity;
import com.sicdlib.service.IBBSXinhuaCommentService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/3.
 */
@Service("bbsXinhuaCommentService")
public class BBSXinhuaCommentService implements IBBSXinhuaCommentService{
    @Autowired
    @Qualifier("bbsXinhuaCommentDAO")
    private IBBSXinhuaCommentDAO bbsXinhuaCommentDAO;
    @Override
    public boolean saveBBSXinhuaComment(BbsXinhuaCommentEntity bbsXinhuaComment) {
        if(bbsXinhuaComment.getId() ==null){
            String uuid = UUIDUtil.getUUID();
            bbsXinhuaComment.setId(uuid);
        }
        return bbsXinhuaCommentDAO.saveBBSXinhuaComment(bbsXinhuaComment);
    }
}
