package com.sicdlib.service;

import com.sicdlib.dto.entity.SanqinNewsEntity;

/**
 * Created by init on 2017/6/6.
 */
public interface ISANQINNewsService {
    //更新或新增三秦网
    public  boolean saveSANQINNews(SanqinNewsEntity sanqinNews);
}
