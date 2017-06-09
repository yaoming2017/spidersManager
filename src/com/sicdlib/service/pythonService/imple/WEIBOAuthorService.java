package com.sicdlib.service.pythonService.imple;

import com.sicdlib.dao.pyhtonDAO.IWEIBOAuthorDAO;
import com.sicdlib.dto.entity.WeiboAuthorEntity;
import com.sicdlib.service.pythonService.IWEIBOAuthorService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/5.
 */
@Service("weiboAuthorService")
public class WEIBOAuthorService  implements IWEIBOAuthorService{
    @Autowired
    @Qualifier("weiboAuthorDAO")
    private IWEIBOAuthorDAO  weiboAuthorDAO;
    @Override
    public boolean saveWEIBOAuthor(WeiboAuthorEntity weiboAuthor) {
        if(weiboAuthor.getId() == null){
            String uuid = UUIDUtil.getUUID();
            weiboAuthor.setId(uuid);
        }
        return weiboAuthorDAO.saveWEIBOAuthor(weiboAuthor);
    }
}
