package com.sicdlib.service;

import java.util.List;
import java.util.Map;

/**
 * Created by YH on 2017/6/1.
 */
public interface IHotWordsService {
    List<Map> getHotWordsMap(String eventID);
}
