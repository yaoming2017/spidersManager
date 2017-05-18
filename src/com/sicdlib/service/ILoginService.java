package com.sicdlib.service;

import com.sicdlib.dto.UserEntity;
import org.hibernate.mapping.Map;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;

public interface ILoginService {
    //用户登陆
    UserEntity validateLogin(String name, String password);
    //新增用户
    public boolean addUser(UserEntity user);
    //通过用户名查询用户
    public UserEntity getUserByName(String name);
    //邮箱激活
    public void emailActivation(UserEntity user, String validateCode, String content, String url);
    //通过邮箱查询用户
    public UserEntity getUserByEmail(String email);
}
