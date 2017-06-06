package com.sicdlib.dao;

import com.sicdlib.dto.entity.BbsChinaCommentEntity;
import com.sicdlib.dto.entity.DoubanGroupCommentEntity;
import com.sicdlib.util.HTableToMysqlUtil.BBSChinaUtil;

/**
 * Created by init on 2017/5/25.
 */
public interface IBBSChinaCommentDAO {
    Boolean saveBBSChinaComment(BbsChinaCommentEntity bbsChinaComment);
}
