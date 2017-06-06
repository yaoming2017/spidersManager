package com.sicdlib.service;

import com.sicdlib.dto.entity.KdnetPostEntity;

/**
 * Created by init on 2017/6/5.
 */
public interface IKDNETPostService {
    //更新或新增凯迪社区
    public  boolean saveKDNETPost(KdnetPostEntity kdnetPost);
}
