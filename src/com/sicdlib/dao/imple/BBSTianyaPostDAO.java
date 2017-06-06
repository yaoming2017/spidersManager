package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBBSTianyaPostDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BbsTianyaPostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/2.
 */
@Repository("bbsTianyaPostDAO")
public class BBSTianyaPostDAO implements IBBSTianyaPostDAO {
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveBBSTianyaPost(BbsTianyaPostEntity bbsTianyaPost) {
        try{
            baseDAO.save(bbsTianyaPost);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
