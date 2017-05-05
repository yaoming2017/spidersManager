package com.sicdlib.service;

import java.util.List;
import java.util.Map;

/**
 * Created by YH on 2017/5/3.
 */
public interface ISpiderConfigService {
    boolean addConfig(String spiderID, Map<String, String> config);

    /**
     * 获取spider ID下所有配置项的信息
     * @param spiderID
     * @return
     */
    Map<String, List<Object[]>> getSpiderConfigItem(String spiderID);
}
