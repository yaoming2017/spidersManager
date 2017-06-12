package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.BbsTianyaPostEntity;

/**
 * Created by init on 2017/6/2.
 */
public interface IBBSTianyaPostService {
    //更新或新增天涯
    public  boolean saveBBSTianyaPost(BbsTianyaPostEntity bbsTianyaPost);
}
