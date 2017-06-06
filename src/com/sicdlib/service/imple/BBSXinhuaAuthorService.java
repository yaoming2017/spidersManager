package com.sicdlib.service.imple;

import com.sicdlib.dao.IBBSXinhuaAuthorDAO;
import com.sicdlib.dto.entity.BbsXinhuaAuthorEntity;
import com.sicdlib.service.IBBSXinhuaAuthorService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/3.
 */
@Service("bbsXinhuaAuthorService")
public class BBSXinhuaAuthorService implements IBBSXinhuaAuthorService{
    @Autowired
    @Qualifier("bbsXinhuaAuthorDAO")
    private IBBSXinhuaAuthorDAO bbsXinhuaAuthorDAO;
    @Override
    public boolean saveBBSXinhuaAuthor(BbsXinhuaAuthorEntity bbsXinhuaAuthor) {
        if(bbsXinhuaAuthor.getId() ==null){
            String uuid = UUIDUtil.getUUID();
            bbsXinhuaAuthor.setId(uuid);
        }
        return bbsXinhuaAuthorDAO.saveBBSXinhuaAuthor(bbsXinhuaAuthor);
    }
}
