package com.sicdlib.service;

import java.util.Map;

/**
 * Created by YH on 2017/6/15.
 */
public interface IAuthorService {
    void setAuthorAttributes(String eventID);
    Map<String, Map> getAuthorInfluenceAndActiveness(String eventID);
}
