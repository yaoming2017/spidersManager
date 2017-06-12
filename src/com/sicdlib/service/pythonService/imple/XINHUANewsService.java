package com.sicdlib.service.pythonService.imple;

import com.sicdlib.dao.pyhtonDAO.IXINHUANewsDAO;
import com.sicdlib.dto.entity.XinhuaNewsEntity;
import com.sicdlib.service.pythonService.IXINHUANewsService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/5.
 */
@Service("xinhuaNewsService")
public class XINHUANewsService  implements IXINHUANewsService{
    @Autowired
    @Qualifier("xinhuaNewsDAO")
    private IXINHUANewsDAO xinhuaNewsDAO;
    @Override
    public boolean saveXINHUANews(XinhuaNewsEntity xinhuaNews) {
        if(xinhuaNews.getId() == null){
            String uuid = UUIDUtil.getUUID();
            xinhuaNews.setId(uuid);
        }
        return  xinhuaNewsDAO.saveXINHUANews(xinhuaNews);
    }
}
