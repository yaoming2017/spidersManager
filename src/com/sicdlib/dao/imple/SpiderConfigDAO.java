package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.ISpiderConfigDAO;
import com.sicdlib.dto.SpiderConfigEntity;
import com.sicdlib.dto.SpiderConfigItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

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
}
