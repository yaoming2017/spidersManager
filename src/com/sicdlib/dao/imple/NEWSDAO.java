package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.INEWSDAO;
import com.sicdlib.dto.entity.NewsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/6.
 */
@Repository("newsDAO")
public class NEWSDAO  implements INEWSDAO{
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveNEWS(NewsEntity news) {
        try{
            baseDAO.save(news);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
