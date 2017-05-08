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

    /**
     * 根据爬虫ID获取爬虫信息和对应的网站信息
     * @param spiderID
     * @return
     */
    List<Object[]> getSpiderInfoWebsite(String spiderID);

    /**
     * 更新爬虫信息
     * @param spiderInfo
     * @return
     */
    void updateSpiderInfo(SpiderInfoEntity spiderInfo);

    SpiderInfoEntity getSpiderInfo(String spiderID);
}
