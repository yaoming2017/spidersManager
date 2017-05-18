package com.sicdlib.service;

import com.jcraft.jsch.Session;
import com.sicdlib.dto.Constant;

import java.util.Map;

/**
 * Created by YH on 2017/5/9.
 */
public interface ISCHSessionService {
    Session getSession() throws Exception;

    Session getSession(Constant.VM vm) throws Exception;

    int getTimeout();
    Map<String, String> getSftpDetail();
}
