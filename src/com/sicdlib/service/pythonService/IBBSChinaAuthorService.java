package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.BbsChinaAuthorEntity;
import com.sicdlib.dto.entity.DoubanGroupAuthorEntity;

/**
 * Created by init on 2017/5/25.
 */
public interface IBBSChinaAuthorService {
    //新增or更新bbs作者
    public boolean saveBBSChinaAuthor(BbsChinaAuthorEntity bbsChinaAuthor);
}
