package com.sicdlib.service;

import com.sicdlib.dto.entity.KdnetAuthorEntity;

/**
 * Created by init on 2017/6/5.
 */
public interface IKDNETAuthorService {
    //更新或新增凯迪社区
    public  boolean saveKDNETAuthor(KdnetAuthorEntity kdnetAuthor);
}
