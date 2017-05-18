package com.sicdlib.service;

import com.jcraft.jsch.Session;

import java.util.Map;

/**
 * Created by YH on 2017/5/9.
 */
public interface ISCHSessionService {
    Session getSession() throws Exception;
    int getTimeout();
    Map<String, String> getSftpDetail();
}
