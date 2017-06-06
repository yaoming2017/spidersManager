package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBBSMopPostDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BbsMopPostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/5/26.
 */
@Repository("bbsMopPostDAO")
public class BBSMopPostDAO implements IBBSMopPostDAO {
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveBBSMopPost(BbsMopPostEntity bbsMopPost) {
        try{
           baseDAO.save(bbsMopPost);
           return  true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }
}
