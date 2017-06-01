package com.sicdlib.service.imple;

import com.sicdlib.dao.IBBSPeoplePostDAO;
import com.sicdlib.dto.entity.BbsPeoplePostEntity;
import com.sicdlib.service.IBBSPeoplePostService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/5/31.
 */
@Service("bbsPeoplePostService")
public class BBSPeoplePostService implements IBBSPeoplePostService {
    @Autowired
    @Qualifier("bbsPeoplePostDAO")
    private IBBSPeoplePostDAO bbsPeoplePostDAO;


    @Override
    public boolean saveBBSPeoplePost(BbsPeoplePostEntity bbsPeoplePost) {
        if(bbsPeoplePost.getId()==null){
            String uuid = UUIDUtil.getUUID();
            bbsPeoplePost.setId(uuid);
        }
        return bbsPeoplePostDAO.saveBBSPeoplePost(bbsPeoplePost);
    }
}
