package com.sicdlib.dao;

import com.sicdlib.dto.SpiderConfigEntity;
import com.sicdlib.dto.SpiderConfigItemEntity;

import java.util.List;

/**
 * Created by YH on 2017/5/3.
 */
public interface ISpiderConfigDAO {
    boolean saveSpiderConfigItem(SpiderConfigItemEntity spiderConfigItem);
    boolean saveSpiderConfig(SpiderConfigEntity spiderConfig);
    List<Object[]> getSpiderConfigItem(String spiderID);
}
