package com.sicdlib.service;

import com.sicdlib.dto.entity.NewsSinaEntity;

/**
 * Created by init on 2017/6/6.
 */
public interface INEWSSinaService {
    //更新或新增新浪新闻
    public  boolean saveNEWSSina(NewsSinaEntity newsSina);
}
