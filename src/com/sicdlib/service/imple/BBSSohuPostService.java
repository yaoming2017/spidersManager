package com.sicdlib.service.imple;

import com.sicdlib.dao.IBBSSohuPostDAO;
import com.sicdlib.dto.entity.BbsSohuPostEntity;
import com.sicdlib.service.IBBSSohuPostService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/2.
 */
@Service("bbsSohuPostService")
public class BBSSohuPostService implements IBBSSohuPostService{
    @Autowired
    @Qualifier("bbsSohuPostDAO")
    private IBBSSohuPostDAO bbsSohuPostDAO;
    @Override
    public boolean saveBBSSohuPost(BbsSohuPostEntity bbsSohuPost) {
        if(bbsSohuPost.getId() ==null){
            String uuid = UUIDUtil.getUUID();
            bbsSohuPost.setId(uuid);
        }
        return bbsSohuPostDAO.saveBBSSohuPost(bbsSohuPost);
    }
}
