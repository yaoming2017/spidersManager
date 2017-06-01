package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBBSChinaPostDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BbsChinaPostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/5/26.
 */
@Repository("bbsChinaPostDAO")
public class BBSChinaPostDAO implements IBBSChinaPostDAO {
    @Autowired
    private IBaseDAO baseDAO;


    @Override
    public Boolean saveBBSChinaPost(BbsChinaPostEntity bbsChinaPost) {
        try {
            baseDAO.save(bbsChinaPost);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
