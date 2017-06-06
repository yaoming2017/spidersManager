package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.ISpiderDAO;
import com.sicdlib.dto.SpiderInfoEntity;
import com.sicdlib.dto.WebsiteEntity;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by haoyang on 2017/4/24.
 */
@Repository("spiderDAO")
public class SpiderDAO implements ISpiderDAO {
    @Autowired
    @Qualifier("baseDAO")
    private IBaseDAO baseDAO;

    @Override
    public String saveSpiderInfo(SpiderInfoEntity spiderInfo) {
        try {
            String spiderID = (String) baseDAO.save(spiderInfo);
            return spiderID;
        } catch (Exception e) {
            return "";
        }
    }

    @Override
    public List<SpiderInfoEntity> getAllSpiderInfo() {
        String hql = "from SpiderInfoEntity spiderInfo";
        return (List<SpiderInfoEntity>) baseDAO.find(hql);
    }

    @Override
    public List<Object[]> getAllSpiderInfoWebsite() {
        Session session = baseDAO.getCurrentSession();
        String sql = "SELECT {spiderInfo.*}, {website.*} from spider_info spiderInfo, website website where spiderInfo.website_id = website.id";
        List result = session.createSQLQuery(sql)
                .addEntity("spiderInfo", SpiderInfoEntity.class)
                .addEntity("website", WebsiteEntity.class).list();

        return result;
    }

    @Override
    public List<Object[]> getSpiderInfoWebsite(String spiderID) {
        Session session = baseDAO.getCurrentSession();
        String sql = "SELECT {spiderInfo.*}, {website.*} " +
                "FROM spider_info spiderInfo, website website " +
                "WHERE spiderInfo.website_id = website.id AND spiderInfo.id = '" + spiderID + "'";
        List result = session.createSQLQuery(sql)
                .addEntity("spiderInfo", SpiderInfoEntity.class)
                .addEntity("website", WebsiteEntity.class).list();

        return result;
    }

    @Override
    public void updateSpiderInfo(SpiderInfoEntity spiderInfo) {
        baseDAO.update(spiderInfo);
    }

    @Override
    public SpiderInfoEntity getSpiderInfo(String spiderID) {
        return (SpiderInfoEntity) baseDAO.get(SpiderInfoEntity.class,  spiderID);
    }
}
