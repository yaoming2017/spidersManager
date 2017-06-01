package com.sicdlib.dao.imple;


import com.sicdlib.dao.IBBSMopCommentDAO;
import com.sicdlib.dao.IBaseDAO;

import com.sicdlib.dto.entity.BbsMopCommentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/5/26.
 */
@Repository("bbsMopCommentDAO")
public class BBSMopCommentDAO implements IBBSMopCommentDAO{
    @Autowired
    private IBaseDAO baseDAO;


    @Override
    public Boolean saveBBSMopComment(BbsMopCommentEntity bbsMopComment) {
        try{
            baseDAO.save(bbsMopComment);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
