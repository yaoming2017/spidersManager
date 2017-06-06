package com.sicdlib.service.imple;

import com.sicdlib.dao.ISANQINNewsDAO;
import com.sicdlib.dto.entity.SanqinNewsEntity;
import com.sicdlib.service.ISANQINNewsService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/6.
 */
@Service("sanqinNewsService")
public class SANQINNewsService  implements ISANQINNewsService{
    @Autowired
    @Qualifier("sanqinNewsDAO")
    private ISANQINNewsDAO sanqinNewsDAO;
    @Override
    public boolean saveSANQINNews(SanqinNewsEntity sanqinNews) {
        if(sanqinNews.getId() == null){
            String uuid = UUIDUtil.getUUID();
            sanqinNews.setId(uuid);
        }
        return sanqinNewsDAO.saveSANQINNews(sanqinNews);
    }
}
