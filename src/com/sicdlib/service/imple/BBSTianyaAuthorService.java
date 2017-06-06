package com.sicdlib.service.imple;

import com.sicdlib.dao.IBBSTianyaAuthorDAO;
import com.sicdlib.dto.entity.BbsTianyaAuthorEntity;
import com.sicdlib.service.IBBSTianyaAuthorService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/2.
 */
@Service("bbsTianyaAuthorService")
public class BBSTianyaAuthorService implements IBBSTianyaAuthorService{
    @Autowired
    @Qualifier("bbsTianyaAuthorDAO")
    private IBBSTianyaAuthorDAO bbsTianyaAuthorDAO;

    @Override
    public boolean saveBBSTianyaAuthor(BbsTianyaAuthorEntity bbsTianyaAuthor) {
        if(bbsTianyaAuthor.getId() ==null){
            String uuid = UUIDUtil.getUUID();
            bbsTianyaAuthor.setId(uuid);
        }
        return bbsTianyaAuthorDAO.saveBBSTianyaAuthor(bbsTianyaAuthor);
    }
}
