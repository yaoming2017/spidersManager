package com.sicdlib.service;

import com.sicdlib.dto.entity.NewsEntity;

/**
 * Created by init on 2017/6/6.
 */
public interface INEWSService {
    //更新或新增新闻
    public boolean saveNEWS(NewsEntity news);
}
