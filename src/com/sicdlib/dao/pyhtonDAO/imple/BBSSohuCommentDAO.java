package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.pyhtonDAO.IBBSSohuCommentDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BbsSohuCommentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/2.
 */
@Repository("bbsSohuCommentDAO")
public class BBSSohuCommentDAO implements IBBSSohuCommentDAO{
    @Autowired
    private IBaseDAO baseDAO;

    @Override
    public Boolean saveBBSSohuComment(BbsSohuCommentEntity bbsSohuComment) {
        try{
           baseDAO.save(bbsSohuComment);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
