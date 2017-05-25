package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.ICleanInputDAO;
import com.sicdlib.dto.entity.CleanInputEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Yh on 2016/9/8.
 */
@Repository("cleanInputDAO")
public class CleanInputDAO implements ICleanInputDAO {
    @Autowired
    private IBaseDAO baseDAO;

    @Override
    public Boolean addCleanInput(CleanInputEntity cleanInput) {
        try {
            baseDAO.save(cleanInput);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
