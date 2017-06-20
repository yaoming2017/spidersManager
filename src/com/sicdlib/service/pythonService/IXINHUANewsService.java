package com.sicdlib.service.pythonService;


import com.sicdlib.dto.entity.XinhuaNewsEntity;

import java.util.List;

/**
 * Created by init on 2017/6/5.
 */
public interface IXINHUANewsService {
    //更新或新增
    public  boolean saveXINHUANews(XinhuaNewsEntity xinhuaNews);
    //得到所有数据
    List<XinhuaNewsEntity> getAllXinHuaNews();
    XinhuaNewsEntity getAllXinHuaNewsByArticleID(String id);
}
