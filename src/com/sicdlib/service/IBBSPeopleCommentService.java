package com.sicdlib.service;

import com.sicdlib.dto.entity.BbsPeopleCommentEntity;

/**
 * Created by init on 2017/5/31.
 */
public interface IBBSPeopleCommentService {
    //更新或新增bbsPeople
    public  boolean saveBBSPeopleComment(BbsPeopleCommentEntity bbsPeopleComment);
}
