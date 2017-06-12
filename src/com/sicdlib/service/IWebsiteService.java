package com.sicdlib.service;

import com.sicdlib.dto.WebsiteEntity;

import java.util.List;
/**
 * Created by haoyang on 2017/4/20.
 */
public interface IWebsiteService {
    boolean saveNoIDWebsite(WebsiteEntity website);
    boolean saveWebsite(WebsiteEntity website);
    boolean isExistUrl(String url);
    boolean isExistName(String name);
    List<WebsiteEntity> listAllWebsite();
    List<String> listAllWebsiteName();

    /**
     * 获取某个事件下的所有网站名
     * @param eventID
     * @return
     */
    List<String> getWebsiteNameByEvent(String eventID);
}
