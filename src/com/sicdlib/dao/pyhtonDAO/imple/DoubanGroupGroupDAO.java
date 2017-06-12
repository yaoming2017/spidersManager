package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.pyhtonDAO.IDoubanGroupGroupDAO;
import com.sicdlib.dto.entity.DoubanGroupGroupEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/5/25.
 */
@Repository("doubanGroupGroupDAO")
public class DoubanGroupGroupDAO implements IDoubanGroupGroupDAO {
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveDoubanGroupGroup(DoubanGroupGroupEntity doubanGroupGroup) {
        try {
            baseDAO.save(doubanGroupGroup);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
