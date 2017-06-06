package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.IXINHUANewsDAO;
import com.sicdlib.dto.entity.XinhuaNewsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/5.
 */
@Repository("xinhuaNewsDAO")
public class XINHUANewsDAO  implements IXINHUANewsDAO{
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveXINHUANews(XinhuaNewsEntity xinhuaNews) {
        try{
            baseDAO.save(xinhuaNews);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
