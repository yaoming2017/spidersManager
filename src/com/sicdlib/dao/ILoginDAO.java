package com.sicdlib.dao;

import com.sicdlib.dto.UserEntity;
import org.hibernate.mapping.Map;

import java.util.List;

public interface ILoginDAO {
    UserEntity getUserByName(String name);
    Boolean addUser(UserEntity user);
    UserEntity getUserByEmail(String email);
}
