package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.BbsXinhuaAuthorEntity;

/**
 * Created by init on 2017/6/3.
 */
public interface IBBSXinhuaAuthorService {
    //更新或新增新华网
    public  boolean saveBBSXinhuaAuthor(BbsXinhuaAuthorEntity bbsXinhuaAuthor);
}
