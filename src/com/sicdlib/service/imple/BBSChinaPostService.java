package com.sicdlib.service.imple;

import com.sicdlib.dao.IBBSChinaPostDAO;
import com.sicdlib.dto.entity.BbsChinaPostEntity;
import com.sicdlib.service.IBBSChinaPostService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;



/**
 * Created by init on 2017/5/26.
 */
@Service("bbsChinaPostService")
public class BBSChinaPostService implements IBBSChinaPostService{
    @Autowired
    @Qualifier("bbsChinaPostDAO")
    private IBBSChinaPostDAO bbsChinaPostDAO;
    @Override
    public boolean saveBBSChinaPost(BbsChinaPostEntity bbsChinaPost) {
        if(bbsChinaPost.getId() == null){
            String uuid = UUIDUtil.getUUID();
            bbsChinaPost.setId(uuid);
        }
        return bbsChinaPostDAO.saveBBSChinaPost(bbsChinaPost);
    }
}
