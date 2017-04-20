package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.IWebsiteDAO;
import com.sicdlib.dto.WebsiteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

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
        return null;
    }
}
