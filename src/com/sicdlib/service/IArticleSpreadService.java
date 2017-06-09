package com.sicdlib.service;

import java.util.List;
import java.util.Map;

/**
 * Created by YH on 2017/6/6.
 */
public interface IArticleSpreadService {
    /**
     * 获取文章的标题、相似都较高的文章数、所属网站
     * @param eventID
     * @return
     */
    Map<String, List> getNodeAndEdgeAttributes(String eventID);

    String getArticleContent(String articleID, String tableName);
}
