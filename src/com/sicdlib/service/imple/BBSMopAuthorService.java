package com.sicdlib.service.imple;

import com.sicdlib.dao.IBBSMopAuthorDAO;
import com.sicdlib.dto.entity.BbsMopAuthorEntity;
import com.sicdlib.service.IBBSMopAuthorService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;



/**
 * Created by init on 2017/5/26.
 */
@Service("bbsMopAuthorService")
public class BBSMopAuthorService implements IBBSMopAuthorService {
    @Autowired
    @Qualifier("bbsMopAuthorDAO")
    private IBBSMopAuthorDAO bbsMopAuthorDAO;

    @Override
    public boolean saveBBSMopAuthor(BbsMopAuthorEntity bbsMopAuthor) {
        if(bbsMopAuthor.getId()==null){
            String uuid = UUIDUtil.getUUID();
            bbsMopAuthor.setId(uuid);
        }
        return bbsMopAuthorDAO.saveBBSMopAuthor(bbsMopAuthor);
    }
}
