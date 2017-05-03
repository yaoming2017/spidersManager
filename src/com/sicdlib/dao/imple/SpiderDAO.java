package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.ISpiderDAO;
import com.sicdlib.dto.SpiderInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

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
}
