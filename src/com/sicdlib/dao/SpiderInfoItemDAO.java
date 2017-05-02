package com.sicdlib.dao;

import com.sicdlib.dao.imple.ISpiderInfoItemDAO;
import com.sicdlib.dto.SpiderConfigItemTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by YH on 2017/5/1.
 */
@Repository("spiderInfoDAO")
public class SpiderInfoItemDAO implements ISpiderInfoItemDAO {
    @Autowired
    @Qualifier("baseDAO")
    private IBaseDAO baseDAO;

    @Override
    public List<SpiderConfigItemTypeEntity> getAllSpiderInfoItemType() {
        String hql = "from SpiderConfigItemTypeEntity e";
        List<SpiderConfigItemTypeEntity> result = baseDAO.find(hql);

        return result;
    }
}
