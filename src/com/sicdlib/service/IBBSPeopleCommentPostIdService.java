package com.sicdlib.service;

import com.sicdlib.dto.entity.BbsChinaCommentPostIdEntity;
import com.sicdlib.dto.entity.BbsPeopleCommentPostIdEntity;

/**
 * Created by init on 2017/5/31.
 */
public interface IBBSPeopleCommentPostIdService {
    //新增or更新
    public  boolean saveBBSPeopleCommentPostId(BbsPeopleCommentPostIdEntity bbsPeopleCommentPostId);
}
