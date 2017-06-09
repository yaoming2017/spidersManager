package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.BbsXinhuaCommentEntity;

/**
 * Created by init on 2017/6/3.
 */
public interface IBBSXinhuaCommentService {
    //更新或新增新华网
    public boolean saveBBSXinhuaComment(BbsXinhuaCommentEntity bbsXinhuaComment);
}
