package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBBSXinhuaPostDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BbsXinhuaPostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/3.
 */
@Repository("bbsXinhuaPostDAO")
public class BBSXinhuaPostDAO  implements IBBSXinhuaPostDAO{
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveBBSXinhuaPost(BbsXinhuaPostEntity bbsXinhuaPost) {
        try{
            baseDAO.save(bbsXinhuaPost);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
