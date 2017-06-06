package com.sicdlib.service.imple;

import com.sicdlib.dao.INEWSDAO;
import com.sicdlib.dto.entity.NewsEntity;
import com.sicdlib.service.INEWSService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/6.
 */
@Service("newsService")
public class NEWSService implements INEWSService{
    @Autowired
    @Qualifier("newsDAO")
    private INEWSDAO newsDAO;
    @Override
    public boolean saveNEWS(NewsEntity news) {
        if(news.getId() == null){
            String uuid = UUIDUtil.getUUID();
            news.setId(uuid);
        }
        return newsDAO.saveNEWS(news);
    }
}
