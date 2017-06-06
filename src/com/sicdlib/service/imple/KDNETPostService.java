package com.sicdlib.service.imple;

import com.sicdlib.dao.IKDNETPostDAO;
import com.sicdlib.dto.entity.KdnetPostEntity;
import com.sicdlib.service.IKDNETPostService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/5.
 */
@Service("kdnetPostService")
public class KDNETPostService  implements IKDNETPostService{
    @Autowired
    @Qualifier("kdnetPostDAO")
    private IKDNETPostDAO kdnetPostDAO;
    @Override
    public boolean saveKDNETPost(KdnetPostEntity kdnetPost) {
        if(kdnetPost.getId() ==null){
            String uuid = UUIDUtil.getUUID();
            kdnetPost.setId(uuid);
        }
        return kdnetPostDAO.saveKDNETPost(kdnetPost);
    }
}
