package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.WeiboPostEntity;

/**
 * Created by init on 2017/6/5.
 */
public interface IWEIBOPostService {
    //更新或新增微博文章内容
    public  boolean saveWEIBOPost(WeiboPostEntity weiboPost);
}
