package com.sicdlib.dao;

import com.sicdlib.dto.TbHotWordEntity;
import com.sicdlib.dto.entity.DoubanGroupPostEntity;

import java.util.List;

/**
 * Created by init on 2017/6/14.
 */
public interface ISentimentInflucenceDAO {
    //得到豆瓣群组文章
    List<DoubanGroupPostEntity> getDoubanGroupPostEntityList(String postId, int limit);
}
