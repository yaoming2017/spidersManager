package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.IKDNETAuthorDAO;
import com.sicdlib.dto.entity.KdnetAuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/5.
 */
@Repository("kdnetAuthorDAO")
public class KDNETAuthorDAO  implements IKDNETAuthorDAO{
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveKDNETAuthor(KdnetAuthorEntity kdnetAuthor) {
        try{
            baseDAO.save(kdnetAuthor);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
