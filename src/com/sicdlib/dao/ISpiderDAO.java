package com.sicdlib.dao;

import com.sicdlib.dto.SpiderInfoEntity;

import java.util.List;

/**
 * Created by haoyang on 2017/4/24.
 */
public interface ISpiderDAO {
    String saveSpiderInfo(SpiderInfoEntity spiderInfo);
    List<SpiderInfoEntity> getAllSpiderInfo();

    /**
     * 获取爬虫和所怕爬站的信息
     * @return
     */
    List getAllSpiderInfoWebsite();
}
