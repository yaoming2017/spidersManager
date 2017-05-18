package com.sicdlib.service.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.ILoginDAO;
import com.sicdlib.dto.UserEntity;
import com.sicdlib.service.ILoginService;

import com.sicdlib.util.MD5Util.MD5Util;
import com.sicdlib.util.MD5Util.RandNumUtil;
import com.sicdlib.util.MailUtil.SendMail;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * Created by Yh on 2016/9/8.
 */
@Service("loginService")
public class LoginService implements ILoginService{
    @Autowired
    @Qualifier("loginDAO")
    private ILoginDAO loginDAO;

    @Override
    public UserEntity validateLogin(String name, String password) {
        UserEntity user = loginDAO.getUserByName(name);
        if(user != null && MD5Util.validatePassword(user.getPasswd(), password)) {
            return user;
        }
        return null;
    }

    //新增用户
    public boolean addUser(UserEntity user){
        String password = MD5Util.generatePassword(user.getPasswd());
        user.setPasswd(password);
        if(user.getId() == null){
            String id = UUIDUtil.getUUID();
            user.setId(id);
        }
        return loginDAO.addUser(user);
    }

    @Override
    public UserEntity getUserByName(String name) {
        return loginDAO.getUserByName(name);
    }

    //发送邮件
    @Override
    public void emailActivation(UserEntity user, String validateCode, String content, String url) {
        ///邮件的内容
        StringBuffer sb=new StringBuffer(content+"</br>");
        //sb.append("<a href=\"http://localhost:8080/spidersmanager/emailActivation?email=");
        sb.append("<a href=\""+url+"?email=");
        sb.append(user.geteMail());
        sb.append("&validateCode=");
        //sb.append(user.getValidateCode());
        sb.append(validateCode);
        //sb.append("\">http://localhost:8080/spidersmanager/emailActivation?email=");
        sb.append("\">"+url+"?email=");
        sb.append(user.geteMail());
        sb.append("&validateCode=");
        //sb.append(user.getValidateCode());
        sb.append(validateCode);
        sb.append("</a>");

        //发送邮件
        SendMail.send(user.geteMail(), sb.toString());
        System.out.println("发送邮件");
    }

    //通过邮箱得到用户
    @Override
    public UserEntity getUserByEmail(String email) {
        return loginDAO.getUserByEmail(email);
    }

}
