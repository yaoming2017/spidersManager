package com.sicdlib.service;

import com.sicdlib.dto.SpiderConfigItemTypeEntity;

import java.util.List;

/**
 * Created by YH on 2017/5/1.
 */
public interface ISpiderInfoService {
    /**
     * 获取所有的爬虫配置项
     * @return
     */
    List<SpiderConfigItemTypeEntity> getAllSpiderConfItemType();
}
