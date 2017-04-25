package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.ILoginDAO;
import com.sicdlib.dto.UserEntity;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Yh on 2016/9/8.
 */
@Repository("loginDAO")
public class LoginDAO implements ILoginDAO {
    @Autowired
    private IBaseDAO baseDAO;

    @Override
    public UserEntity getUserByName(String name) {
        String hql = "from UserEntity user where user.userName = '" + name + "'";
        return (UserEntity) baseDAO.get(hql);
    }

    @Override
    public Boolean addUser(UserEntity user) {
        try {
            baseDAO.save(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public UserEntity getUserByEmail(String email) {
        String hql = "from UserEntity user where user.eMail = '" + email + "'";
        return (UserEntity) baseDAO.get(hql);
    }

}
