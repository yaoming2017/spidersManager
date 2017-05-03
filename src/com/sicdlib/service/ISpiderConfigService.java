package com.sicdlib.service;

import java.util.Map;

/**
 * Created by YH on 2017/5/3.
 */
public interface ISpiderConfigService {
    boolean addConfig(String spiderID, Map<String, String> config);
}
