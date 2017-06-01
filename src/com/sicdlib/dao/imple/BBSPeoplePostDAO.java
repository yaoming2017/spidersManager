package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBBSPeoplePostDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BbsPeoplePostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/5/31.
 */
@Repository("bbsPeoplePostDAO")
public class BBSPeoplePostDAO implements IBBSPeoplePostDAO{
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveBBSPeoplePost(BbsPeoplePostEntity bbsPeoplePost) {
        try{
         baseDAO.save(bbsPeoplePost);
         return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
