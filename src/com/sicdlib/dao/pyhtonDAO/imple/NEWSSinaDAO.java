package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.pyhtonDAO.INEWSSinaDAO;
import com.sicdlib.dto.entity.NewsSinaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/6.
 */
@Repository("newsSinaDAO")
public class NEWSSinaDAO  implements INEWSSinaDAO{
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveNEWSSina(NewsSinaEntity newsSina) {
        try{
            baseDAO.save(newsSina);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
