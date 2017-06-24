package com.sicdlib.util.HTableToMysqlUtil;

import com.sicdlib.dto.entity.BbsMopPostEntity;

/**
 * Created by YH on 2017/6/22.
 */
public class NormalizeMopPost implements INormalizeProcess {
    @Override
    public Object processData(Object object) {
        BbsMopPostEntity mopPost = (BbsMopPostEntity) object;
        mopPost.setTags(mopPost.getTags().replace("暂无标签", ""));
        return mopPost;
    }
}
