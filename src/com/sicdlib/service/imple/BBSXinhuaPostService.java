package com.sicdlib.service.imple;

import com.sicdlib.dao.IBBSXinhuaPostDAO;
import com.sicdlib.dto.entity.BbsXinhuaPostEntity;
import com.sicdlib.service.IBBSXinhuaPostService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/3.
 */
@Service("bbsXinhuaPostService")
public class BBSXinhuaPostService implements IBBSXinhuaPostService{
    @Autowired
    @Qualifier("bbsXinhuaPostDAO")
    private IBBSXinhuaPostDAO bbsXinhuaPostDAO;
    @Override
    public boolean saveBBSXinhuaPost(BbsXinhuaPostEntity bbsXinhuaPost) {
        if(bbsXinhuaPost.getId() ==null){
           String uuid = UUIDUtil.getUUID();
           bbsXinhuaPost.setId(uuid);
        }
        return bbsXinhuaPostDAO.saveBBSXinhuaPost(bbsXinhuaPost

         );
    }
}
