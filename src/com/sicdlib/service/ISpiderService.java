package com.sicdlib.service;

import com.sicdlib.dto.SpiderInfoEntity;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by haoyang on 2017/4/24.
 */
public interface ISpiderService {
    boolean saveSpiderInfo(HttpServletRequest req, SpiderInfoEntity spiderInfo) throws Exception;
}
