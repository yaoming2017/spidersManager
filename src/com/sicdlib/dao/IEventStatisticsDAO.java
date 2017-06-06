package com.sicdlib.dao;

import java.util.List;

/**
 * Created by YH on 2017/6/2.
 */
public interface IEventStatisticsDAO {
    /**
     * 获取事件在各个网站下的文章数量
     * @param eventID
     * @return
     */
    List<Object[]> getEventWebsiteArticleNum(String eventID);
}
