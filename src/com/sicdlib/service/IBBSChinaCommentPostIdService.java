package com.sicdlib.service;

import com.sicdlib.dto.entity.BbsChinaCommentPostIdEntity;
import com.sicdlib.dto.entity.DoubanGroupComentPostIdEntity;

/**
 * Created by init on 2017/5/31.
 */
public interface IBBSChinaCommentPostIdService {
    //新增or更新
    public  boolean saveBBSChinaCommentPostId(BbsChinaCommentPostIdEntity bbsChinaCommentPostId);
}

