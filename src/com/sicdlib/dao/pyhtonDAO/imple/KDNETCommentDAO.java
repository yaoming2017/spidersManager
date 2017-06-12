package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.pyhtonDAO.IKDNETCommentDAO;
import com.sicdlib.dto.entity.KdnetCommentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/5.
 */
@Repository("kdnetCommentDAO")
public class KDNETCommentDAO  implements IKDNETCommentDAO{
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveKDNETComment(KdnetCommentEntity kdnetComment) {
        try{
            baseDAO.save(kdnetComment);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return true;
        }
    }
}
