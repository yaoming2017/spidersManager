package com.sicdlib.service.imple;

import com.sicdlib.dao.IWEIBOContentDAO;
import com.sicdlib.dto.entity.WeiboContentEntity;
import com.sicdlib.service.IWEIBOContentService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/5.
 */
@Service("weiboContentService")
public class WEIBOContentService  implements IWEIBOContentService{
    @Autowired
    @Qualifier("weiboContentDAO")
    private IWEIBOContentDAO  weiboContentDAO;
    @Override
    public boolean saveWEIBOContent(WeiboContentEntity weiboContent) {
       if(weiboContent.getId() == null){
        String uuid = UUIDUtil.getUUID();
        weiboContent.setId(uuid);
       }
        return weiboContentDAO.saveWEIBOContent(weiboContent);
    }
}
