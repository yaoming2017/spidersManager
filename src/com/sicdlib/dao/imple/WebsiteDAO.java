package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.IWebsiteDAO;

import com.sicdlib.dto.WebsiteEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by haoyang on 2017/4/20.
 */
@Repository("websiteDAO")
public class WebsiteDAO implements IWebsiteDAO{
    @Autowired
    @Qualifier("baseDAO")
    private IBaseDAO baseDAO;

    @Override
    public boolean saveWebsite(WebsiteEntity website) {
        try {
            baseDAO.save(website);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<WebsiteEntity> listWebsite() {
        String hql = "from WebsiteEntity ws";
        List<WebsiteEntity> wsList = (List<WebsiteEntity>)baseDAO.find(hql);

        return wsList;
    }

    @Override
    public WebsiteEntity getWebsiteByName(String websiteName) {
        String hql = "from WebsiteEntity ws where ws.websiteName = '" + websiteName + "'";
        WebsiteEntity website = (WebsiteEntity) baseDAO.get(hql);

        return website;
    }

    @Override
    public WebsiteEntity getWebsiteByUrl(String url) {
        String hql = "from WebsiteEntity ws where ws.websiteUrl = '" + url + "'";
        WebsiteEntity website = (WebsiteEntity) baseDAO.get(hql);

        return website;
    }

    @Override
    public List<WebsiteEntity> getWebsiteByEventID(String eventID) {
        String hql = "FROM WebsiteEntity ws " +
                "WHERE ws.id in (" +
                "SELECT tb.websiteId " +
                "FROM TbTableEntity tb, TbEventArticleEntity ea " +
                "WHERE tb.id = ea.table.id AND ea.event.id = '" + eventID + "' " +
                ") ";
        return baseDAO.find(hql);
    }

    @Override
    public WebsiteEntity getWebsiteByTableID(String tableID) {
        String hql = "FROM WebsiteEntity ws " +
                "WHERE ws.id in (" +
                "SELECT tb.websiteId " +
                "FROM TbTableEntity tb " +
                "WHERE tb.id = '" + tableID + "'" +
                ")";
        return (WebsiteEntity) baseDAO.get(hql);
    }
}
