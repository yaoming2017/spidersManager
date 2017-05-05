package com.sicdlib.service;

import com.sicdlib.dto.SpiderInfoEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by haoyang on 2017/4/24.
 */
public interface ISpiderService {
    String saveSpiderInfo(HttpServletRequest req, SpiderInfoEntity spiderInfo) throws Exception;
    List<SpiderInfoEntity> getAllSpiderInfo();
    List<Object[]> getAllSpiderInfoWebsite();
}
