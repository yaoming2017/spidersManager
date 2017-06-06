package com.sicdlib.service.imple;

import com.sicdlib.dao.IBBSPeopleCommentDAO;
import com.sicdlib.dto.entity.BbsPeopleCommentEntity;
import com.sicdlib.service.IBBSPeopleCommentService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/5/31.
 */
@Service("bbsPeopleCommentService ")
public class BBSPeopleCommentService implements IBBSPeopleCommentService{
    @Autowired
    @Qualifier("bbsPeopleCommentDAO")
    private IBBSPeopleCommentDAO bbsPeopleCommentDAO;

    @Override
    public boolean saveBBSPeopleComment(BbsPeopleCommentEntity bbsPeopleComment) {
        if(bbsPeopleComment.getId()==null){
            String uuid =UUIDUtil.getUUID();
            bbsPeopleComment.setId(uuid);
        }
        return bbsPeopleCommentDAO.saveBBSPeopleComment(bbsPeopleComment);
    }
}
