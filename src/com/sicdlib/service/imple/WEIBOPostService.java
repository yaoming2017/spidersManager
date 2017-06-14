package com.sicdlib.service.imple;

import com.sicdlib.dao.IWEIBOPostDAO;
import com.sicdlib.dto.WeiboPostEntity;
import com.sicdlib.service.IWEIBOPostService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/5.
 */
@Service("weiboPostService")
public class WEIBOPostService  implements IWEIBOPostService{
    @Autowired
    @Qualifier("weiboPostDAO")
    private IWEIBOPostDAO weiboPostDAO;
    @Override
    public boolean saveWEIBOPost(WeiboPostEntity weiboPost) {
        if(weiboPost.getId() ==null){
            String uuid = UUIDUtil.getUUID();
            weiboPost.setId(uuid);
        }
        return weiboPostDAO.saveWEIBOPost(weiboPost);
    }
}
