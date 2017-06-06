package com.sicdlib.service;

import com.sicdlib.dto.entity.Blog163AuthorEntity;

/**
 * Created by init on 2017/6/3.
 */
public interface IBLOG163AuthorService {
    //更新或新增网易博客
    public  boolean saveBLOG163Author(Blog163AuthorEntity blog163Author);
}
