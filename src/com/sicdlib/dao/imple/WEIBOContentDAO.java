package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.IWEIBOContentDAO;
import com.sicdlib.dto.entity.WeiboContentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/5.
 */
@Repository("weiboContentDAO")
public class WEIBOContentDAO  implements IWEIBOContentDAO{
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveWEIBOContent(WeiboContentEntity weiboContent) {
        try{
            baseDAO.save(weiboContent);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
