package com.sicdlib.service;

import com.sicdlib.dto.entity.BbsXinhuaPostEntity;

/**
 * Created by init on 2017/6/3.
 */
public interface IBBSXinhuaPostService {
    //更新或新增新华网
    public boolean saveBBSXinhuaPost(BbsXinhuaPostEntity bbsXinhuaPost);
}
