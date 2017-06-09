package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.pyhtonDAO.IBBSMopAuthorDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BbsMopAuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/5/26.
 */
@Repository("bbsMopAuthorDAO")
public class BBSMopAuthorDAO implements IBBSMopAuthorDAO{
    @Autowired
    private IBaseDAO baseDAO;

    @Override
    public Boolean saveBBSMopAuthor(BbsMopAuthorEntity bbsMopAuthor) {
       try{
           baseDAO.save(bbsMopAuthor);
           return true;
       }catch (Exception e){
           e.printStackTrace();
           return false;
       }
    }
}
