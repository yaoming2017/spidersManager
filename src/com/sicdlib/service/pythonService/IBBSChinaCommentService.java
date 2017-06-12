package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.BbsChinaCommentEntity;
import com.sicdlib.dto.entity.DoubanGroupCommentEntity;

/**
 * Created by init on 2017/5/25.
 */
public interface IBBSChinaCommentService {
    //新增or更新中华网社区
    public boolean saveBBSChinaComment(BbsChinaCommentEntity bbsChinaComment);

}
