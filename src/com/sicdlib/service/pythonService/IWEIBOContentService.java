package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.WeiboContentEntity;

/**
 * Created by init on 2017/6/5.
 */
public interface IWEIBOContentService {
    //更新或新增微博内容
    public boolean saveWEIBOContent(WeiboContentEntity weiboContent);
}
