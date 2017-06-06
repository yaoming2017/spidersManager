package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBBSSohuPostDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BbsSohuPostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/2.
 */
@Repository("bbsSohuPostDAO")
public class BBSSohuPostDAO  implements IBBSSohuPostDAO {
    @Autowired
    private IBaseDAO baseDAO;

    @Override
    public Boolean saveBBSSohuPost(BbsSohuPostEntity bbsSohuPost) {
        try{
            baseDAO.save(bbsSohuPost);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }
}
