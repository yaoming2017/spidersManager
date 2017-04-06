package com.sicdlib.controller;

import com.sicdlib.dto.User;
import com.sicdlib.service.ILoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Yh on 2016/9/8.
 */
@Controller
public class LoginController {
    @Autowired
    @Qualifier("loginService")
    private ILoginService loginService;

    @RequestMapping("login")
    public String login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("u_name");
        String password = req.getParameter("u_pwd");
 		// 得到角色类型
        User user = loginService.validateLogin(name, password);

        if (user != null) {
            return "success";
        }
        return "failure";
    }

}