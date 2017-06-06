package com.sicdlib.service;

import com.sicdlib.dto.entity.BbsPeopleAuthorEntity;

/**
 * Created by init on 2017/5/30.
 */
public interface IBBSPeopleAuthorService {
    //新增或更新bbsPeople
    public  boolean saveBBSPeopleAuthor(BbsPeopleAuthorEntity bbsPeopleAuthor);
}
