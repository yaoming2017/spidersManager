package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.pyhtonDAO.IBBSXiciPostDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BbsXiciPostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/2.
 */
@Repository("bbsXiciPostDAO")
public class BBSXiciPostDAO  implements IBBSXiciPostDAO{
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveBBSXiciPost(BbsXiciPostEntity bbsXiciPost) {
        try{
            baseDAO.save(bbsXiciPost);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
