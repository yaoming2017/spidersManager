package com.sicdlib.service.imple;

import com.sicdlib.dao.IBBSPeopleAuthorDAO;
import com.sicdlib.dto.entity.BbsPeopleAuthorEntity;
import com.sicdlib.service.IBBSPeopleAuthorService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/5/30.
 */
@Service("bbsPeopleAuthorService")
public class BBSPeopleAuthorService  implements IBBSPeopleAuthorService{
    @Autowired
    @Qualifier("bbsPeopleAuthorDAO")
    private IBBSPeopleAuthorDAO bbsPeopleAuthorDAO;
    @Override
    public boolean saveBBSPeopleAuthor(BbsPeopleAuthorEntity bbsPeopleAuthor) {
        if(bbsPeopleAuthor.getId() ==null){
           String uuid = UUIDUtil.getUUID();
           bbsPeopleAuthor.setId(uuid);
        }
        return bbsPeopleAuthorDAO.saveBBSPeopleAuthor(bbsPeopleAuthor);
    }
}
