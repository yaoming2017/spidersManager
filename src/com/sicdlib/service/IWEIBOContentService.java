package com.sicdlib.service;

import com.sicdlib.dto.WeiboContentEntity;

/**
 * Created by init on 2017/6/5.
 */
public interface IWEIBOContentService {
    //更新或新增微博内容
    public boolean saveWEIBOContent(WeiboContentEntity weiboContent);
}
