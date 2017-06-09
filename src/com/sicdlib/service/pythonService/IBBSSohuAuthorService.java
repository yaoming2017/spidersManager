package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.BbsSohuAuthorEntity;

/**
 * Created by init on 2017/6/2.
 */
public interface IBBSSohuAuthorService {
   //新增或更新搜狐
    public boolean saveBBSSohuAuthor(BbsSohuAuthorEntity bbsSohuAuthor);
}
