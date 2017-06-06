package com.sicdlib.service.imple;

import com.sicdlib.dao.IBBSTianyaPostDAO;
import com.sicdlib.dto.entity.BbsTianyaPostEntity;
import com.sicdlib.service.IBBSTianyaPostService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/2.
 */
@Service("bbsTianyaPostService ")
public class BBSTianyaPostService  implements IBBSTianyaPostService{
    @Autowired
    @Qualifier("bbsTianyaPostDAO")
    private IBBSTianyaPostDAO bbsTianyaPostDAO;
    @Override
    public boolean saveBBSTianyaPost(BbsTianyaPostEntity bbsTianyaPost) {
        if(bbsTianyaPost.getId() ==null){
            String uuid = UUIDUtil.getUUID();
            bbsTianyaPost.setId(uuid);
        }
        return bbsTianyaPostDAO.saveBBSTianyaPost(bbsTianyaPost);
    }
}
