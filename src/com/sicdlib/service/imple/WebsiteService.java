package com.sicdlib.service.imple;

import com.sicdlib.dao.IWebsiteDAO;
import com.sicdlib.dto.entity.WebsiteEntity;
import com.sicdlib.service.IWebsiteService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by haoyang on 2017/4/20.
 */
@Service("websiteService")
public class WebsiteService implements IWebsiteService {
    @Autowired
    @Qualifier("websiteDAO")
    private IWebsiteDAO websiteDAO;

    @Override
    public boolean saveNoIDWebsite(WebsiteEntity website) {
        String id = UUIDUtil.getUUID();
        website.setId(id);

        return this.saveWebsite(website);
    }

    @Override
    public boolean saveWebsite(WebsiteEntity website) {
        return websiteDAO.saveWebsite(website);
    }

    @Override
    public boolean isExistUrl(String url) {
        WebsiteEntity website = websiteDAO.getWebsiteByUrl(url);

        if(website == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isExistName(String name) {
        WebsiteEntity website = websiteDAO.getWebsiteByUrl(name);

        if(website == null) {
            return false;
        }
        return true;
    }

    @Override
    public List<WebsiteEntity> listAllWebsite() {
        List<WebsiteEntity> wsList = websiteDAO.listWebsite();

        return wsList;
    }
}
