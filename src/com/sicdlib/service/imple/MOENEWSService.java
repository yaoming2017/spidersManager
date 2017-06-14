package com.sicdlib.service.imple;

import com.sicdlib.dao.pyhtonDAO.IMOENewsDAO;
import com.sicdlib.dto.entity.MoeNewsEntity;
import com.sicdlib.service.pythonService.IMOENewsService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/4.
 */
@Service("moeNewsService")
public class MOENEWSService  implements IMOENewsService{
    @Autowired
    @Qualifier("moeNewsDAO")
    private IMOENewsDAO moeNewsDAO;
    @Override
    public boolean saveMOENews(MoeNewsEntity moeNews) {
        if(moeNews.getId() == null){
           String uuid = UUIDUtil.getUUID();
           moeNews.setId(uuid);
        }
        return moeNewsDAO.saveMOENews(moeNews);
    }
}
