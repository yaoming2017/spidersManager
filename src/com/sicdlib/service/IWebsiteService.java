package com.sicdlib.service;

<<<<<<< HEAD
import com.sicdlib.dto.entity.WebsiteEntity;

import java.util.List;
=======
>>>>>>> cf1ab372ee131539d3bb702620fcd9db195c71a0

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
