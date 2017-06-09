package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.pyhtonDAO.IMOEDataDAO;
import com.sicdlib.dto.entity.MoeDataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/4.
 */
@Repository("moeDataDAO")
public class MOEDataDAO  implements IMOEDataDAO{
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveMOEData(MoeDataEntity moeData) {
        try{
            baseDAO.save(moeData);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
