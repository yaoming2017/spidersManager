package com.sicdlib.service;

import java.util.List;
import java.util.Map;

/**
 * Created by init on 2017/6/14.
 */
public interface ISentimentInflucenceService {
    List<Map> getSentimentInflucenceMap(String postId);
}
