package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.IKDNETPostDAO;
import com.sicdlib.dto.entity.KdnetPostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/5.
 */
@Repository("kdnetPostDAO")
public class KDNETPostDAO  implements IKDNETPostDAO{
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveKDNETPost(KdnetPostEntity kdnetPost) {
        try{
          baseDAO.save(kdnetPost);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
