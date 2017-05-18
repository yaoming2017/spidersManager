package com.sicdlib.service.imple;

import com.jcraft.jsch.Session;
import com.sicdlib.service.ISCHSessionService;
import com.sicdlib.util.JSCHUtil.ExecUtils;
import com.sicdlib.util.JSCHUtil.JSCHConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by YH on 2017/5/9.
 */
@Service("schSessionService")
public class SCHSessionService implements ISCHSessionService {
    @Value("${sftp.port}")
    private String port;

    @Value("${sftp.username}")
    private String userName;

    @Value("${sftp.passwd}")
    private String password;

    @Value("${sftp.host}")
    private String host;

    @Value("${sftp.timeout}")
    private int timeout;

    @Override
    public Session getSession() throws Exception {
        Map<String, String> sftpDetails = new HashMap<String, String>();
        // 设置主机ip，端口，用户名，密码
        sftpDetails.put(JSCHConstants.SFTP_REQ_HOST, host);
        sftpDetails.put(JSCHConstants.SFTP_REQ_USERNAME, userName);
        sftpDetails.put(JSCHConstants.SFTP_REQ_PASSWORD, password);
        sftpDetails.put(JSCHConstants.SFTP_REQ_PORT, port);

        Session execSession = ExecUtils.getInstance().connect(sftpDetails);

        return execSession;
    }

    @Override
    public int getTimeout() {
        return timeout;
    }

    @Override
    public Map<String, String> getSftpDetail() {
        Map<String, String> sftpDetails = new HashMap<String, String>();
        // 设置主机ip，端口，用户名，密码
        sftpDetails.put(JSCHConstants.SFTP_REQ_HOST, host);
        sftpDetails.put(JSCHConstants.SFTP_REQ_USERNAME, userName);
        sftpDetails.put(JSCHConstants.SFTP_REQ_PASSWORD, password);
        sftpDetails.put(JSCHConstants.SFTP_REQ_PORT, port);

        return sftpDetails;
    }


}
