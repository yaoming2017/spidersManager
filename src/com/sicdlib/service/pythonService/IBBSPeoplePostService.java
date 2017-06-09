package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.BbsPeoplePostEntity;

/**
 * Created by init on 2017/5/31.
 */
public interface IBBSPeoplePostService {
    //更新或新增bbsPeoplePost
    public  boolean saveBBSPeoplePost(BbsPeoplePostEntity bbsPeoplePost);
}
