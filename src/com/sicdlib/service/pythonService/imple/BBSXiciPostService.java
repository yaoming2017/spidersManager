package com.sicdlib.service.pythonService.imple;

import com.sicdlib.dao.pyhtonDAO.IBBSXiciPostDAO;
import com.sicdlib.dto.entity.BbsXiciPostEntity;
import com.sicdlib.service.pythonService.IBBSXiciPostService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/2.
 */
@Service("bbsXiciPostService")
public class BBSXiciPostService  implements IBBSXiciPostService{
    @Autowired
    @Qualifier("bbsXiciPostDAO")
    private IBBSXiciPostDAO bbsXiciPostDAO;
    @Override
    public boolean saveBBSXiciPost(BbsXiciPostEntity bbsXiciPost) {
        if(bbsXiciPost.getId() ==null){
            String uuid = UUIDUtil.getUUID();
            bbsXiciPost.setId(uuid);
        }
        return bbsXiciPostDAO.saveBBSXiciPost(bbsXiciPost);
    }

    @Override
    public BbsXiciPostEntity getBbsXiciPost(String id) {
        return bbsXiciPostDAO.getBbsXiciPost(id);
    }
}
