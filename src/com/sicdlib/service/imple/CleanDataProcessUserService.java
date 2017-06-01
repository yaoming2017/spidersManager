package com.sicdlib.service.imple;

import com.sicdlib.dao.ICleanDataProcessUserDAO;
import com.sicdlib.dto.CleanDataProcessUserEntity;
import com.sicdlib.service.ICleanDataProcessUserService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("cleanDataProcessUserService")
public class CleanDataProcessUserService implements ICleanDataProcessUserService{
    @Autowired
    @Qualifier("cleanDataProcessUserDAO")
    private ICleanDataProcessUserDAO cleanDataProcessUserDAO;

    @Override
    public Boolean addCleanDataProcessUser(CleanDataProcessUserEntity cleanDataProcessUser) {
        if(cleanDataProcessUser.getId() == null){
            String id = UUIDUtil.getUUID();
            cleanDataProcessUser.setId(id);
        }
        return cleanDataProcessUserDAO.addCleanDataProcessUser(cleanDataProcessUser);
    }
}
