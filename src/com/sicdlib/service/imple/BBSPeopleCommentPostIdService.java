package com.sicdlib.service.imple;

import com.sicdlib.dao.IBBSPeopleCommentPostIdDAO;
import com.sicdlib.dto.entity.BbsPeopleCommentPostIdEntity;
import com.sicdlib.service.IBBSPeopleCommentPostIdService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/5/31.
 */
@Service("bbsPeopleCommentPostIdService")
public class BBSPeopleCommentPostIdService implements IBBSPeopleCommentPostIdService {
    @Autowired
    @Qualifier("bbsPeopleCommentPostIdDAO")
    private IBBSPeopleCommentPostIdDAO bbsPeopleCommentPostIdDAO;
    @Override
    public boolean saveBBSPeopleCommentPostId(BbsPeopleCommentPostIdEntity bbsPeopleCommentPostId) {
        if(bbsPeopleCommentPostId.getId() ==null){
            String uuid = UUIDUtil.getUUID();
            bbsPeopleCommentPostId.setId(uuid);
        }
        return bbsPeopleCommentPostIdDAO.saveBBSPeopleCommentPostId(bbsPeopleCommentPostId);
    }
}
