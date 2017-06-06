package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.IXINHUADAO;
import com.sicdlib.dto.entity.XinhuaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/5.
 */
@Repository("xinhuaDAO")
public class XINHUADAO  implements IXINHUADAO{
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveXINHUA(XinhuaEntity xinhua) {
        try{
            baseDAO.save(xinhua);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
