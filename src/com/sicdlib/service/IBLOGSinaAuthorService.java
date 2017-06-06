package com.sicdlib.service;

import com.sicdlib.dto.entity.BlogSinaAuthorEntity;

/**
 * Created by init on 2017/6/3.
 */
public interface IBLOGSinaAuthorService {
    //更新或新增微博
    public boolean saveBLOGSinaAuthor(BlogSinaAuthorEntity blogSinaAuthor);
}
