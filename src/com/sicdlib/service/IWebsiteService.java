package com.sicdlib.service;


import java.util.List;

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
}
