package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.ISpiderConfigDAO;
import com.sicdlib.dto.SpiderConfigEntity;
import com.sicdlib.dto.SpiderConfigItemEntity;
import com.sicdlib.dto.SpiderConfigItemTypeEntity;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by YH on 2017/5/3.
 */
@Repository("spiderConfigDAO")
public class SpiderConfigDAO implements ISpiderConfigDAO{
    @Autowired
    @Qualifier("baseDAO")
    private IBaseDAO baseDAO;


    @Override
    public boolean saveSpiderConfigItem(SpiderConfigItemEntity spiderConfigItem) {
        try {
            baseDAO.save(spiderConfigItem);
            return true;
        } catch (Exception e) {
            System.err.println("save SpiderConfigItem error!!" + e);
            return false;
        }
    }

    @Override
    public boolean saveSpiderConfig(SpiderConfigEntity spiderConfig) {
        try {
            baseDAO.save(spiderConfig);
            return true;
        } catch (Exception e) {
            System.err.println("save spiderConfig error!!" + e);
            return false;
        }
    }

    @Override
    public List<Object[]> getSpiderConfigItem(String spiderID) {
        String sql = "SELECT {configItem.*}, {itemType.*} " +
                "FROM spider_config spiderConfig, spider_config_item configItem, spider_config_item_type itemType " +
                "WHERE spiderConfig.id = configItem.config_id and configItem.config_item_name = itemType.id and spiderConfig.spider_id='" + spiderID + "'";
        Session session = baseDAO.getCurrentSession();
        List result = session.createSQLQuery(sql)
                .addEntity("configItem", SpiderConfigItemEntity.class)
                .addEntity("itemType", SpiderConfigItemTypeEntity.class).list();

        return result;
    }

    @Override
    public List<Object[]> getSpiderConfigAndItem(String configID) {
        String sql = "SELECT {configItem.*}, {itemType.*} " +
                "FROM spider_config_item configItem, spider_config_item_type itemType " +
                "WHERE configItem.config_item_name = itemType.id and configItem.config_id='" + configID + "'";

        Session session = baseDAO.getCurrentSession();
        List result = session.createSQLQuery(sql)
                .addEntity("configItem", SpiderConfigItemEntity.class)
                .addEntity("itemType", SpiderConfigItemTypeEntity.class).list();
        return result;
    }

    @Override
    public SpiderConfigEntity getSpiderConfig(String configID) {
        return (SpiderConfigEntity) baseDAO.get(SpiderConfigEntity.class, configID);
    }

    @Override
    public void updateSpiderConfig(SpiderConfigEntity spiderConfig) {
        baseDAO.update(spiderConfig);
    }

    @Override
    public List<SpiderConfigEntity> getAllConfig() {
        String hql = "from SpiderConfigEntity s";
        return baseDAO.find(hql);
    }
}
