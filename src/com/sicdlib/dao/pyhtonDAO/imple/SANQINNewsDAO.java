package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.pyhtonDAO.ISANQINNewsDAO;
import com.sicdlib.dto.entity.SanqinNewsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/6.
 */
@Repository("sanqinNewsDAO")
public class SANQINNewsDAO  implements ISANQINNewsDAO{
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveSANQINNews(SanqinNewsEntity sanqinNews) {
        try{
            baseDAO.save(sanqinNews);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }
}
