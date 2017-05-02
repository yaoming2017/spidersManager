package com.sicdlib.service;

import com.sicdlib.dao.imple.ISpiderInfoItemDAO;
import com.sicdlib.dto.SpiderConfigItemTypeEntity;
import com.sicdlib.service.imple.ISpiderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YH on 2017/5/1.
 */
@Service("spiderInfoService")
public class spiderInfoService implements ISpiderInfoService {
    @Autowired
    @Qualifier("spiderInfoDAO")
    private ISpiderInfoItemDAO spiderInfoItemDAO;

    @Override
    public List<SpiderConfigItemTypeEntity> getAllSpiderConfItemType() {
        return spiderInfoItemDAO.getAllSpiderInfoItemType();
    }
}
