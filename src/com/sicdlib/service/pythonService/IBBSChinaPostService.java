package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.BbsChinaPostEntity;

/**
 * Created by init on 2017/5/26.
 */
public interface IBBSChinaPostService {
    //新增or更新中华网社区
    public boolean saveBBSChinaPost(BbsChinaPostEntity bbsChinaPost);
}
