package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.ICleanDataProcessUserDAO;
import com.sicdlib.dto.CleanDataProcessUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Yh on 2016/9/8.
 */
@Repository("cleanDataProcessUserDAO")
public class CleanDataProcessUserDAO implements ICleanDataProcessUserDAO {
    @Autowired
    private IBaseDAO baseDAO;

    @Override
    public Boolean addCleanDataProcessUser(CleanDataProcessUserEntity cleanDataProcessUser) {
        try{
            baseDAO.save(cleanDataProcessUser);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
