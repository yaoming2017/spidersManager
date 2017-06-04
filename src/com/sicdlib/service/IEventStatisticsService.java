package com.sicdlib.service;

import java.util.List;
import java.util.Map;

/**
 * Created by YH on 2017/6/2.
 */
public interface IEventStatisticsService {
    List<Map> getMediaSourceStatistics(String eventID);
}
