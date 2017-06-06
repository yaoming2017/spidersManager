package com.sicdlib.service;

import com.sicdlib.dto.entity.BbsMopAuthorEntity;

/**
 * Created by init on 2017/5/26.
 */
public interface IBBSMopAuthorService {
    //新增or更新猫扑社区
    public boolean saveBBSMopAuthor(BbsMopAuthorEntity bbsMopAuthor);
}
