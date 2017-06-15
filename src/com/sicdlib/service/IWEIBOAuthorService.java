package com.sicdlib.service;

import com.sicdlib.dto.WeiboAuthorEntity;

/**
 * Created by init on 2017/6/5.
 */
public interface IWEIBOAuthorService {
    //更新或新增微博作者
    public  boolean saveWEIBOAuthor(WeiboAuthorEntity weiboAuthor);
}
