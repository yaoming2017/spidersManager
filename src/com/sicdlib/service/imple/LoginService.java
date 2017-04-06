package com.sicdlib.service.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.ILoginDAO;
import com.sicdlib.dto.User;
import com.sicdlib.service.ILoginService;

import com.sicdlib.util.MD5Util.MD5Util;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yh on 2016/9/8.
 */
@Service("loginService")
public class LoginService implements ILoginService{
    @Autowired
    @Qualifier("loginDAO")
    private ILoginDAO loginDAO;

    @Override
    public User validateLogin(String name, String password) {
        User user = loginDAO.getUserByName(name);
        if(user != null && user.getU_pwd().equals(password)) {
            return user;
        }
        return null;
    }
}
