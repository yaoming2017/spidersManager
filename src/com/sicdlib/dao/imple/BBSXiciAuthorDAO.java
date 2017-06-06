package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBBSXiciAuthorDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BbsXiciAuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/2.
 */
@Repository("bbsXiciAuthorDAO")
public class BBSXiciAuthorDAO implements IBBSXiciAuthorDAO{
    @Autowired
    private IBaseDAO baseDAO;

    @Override
    public Boolean saveBBSXiciAuthor(BbsXiciAuthorEntity bbsXiciAuthor) {
        try{
            baseDAO.save(bbsXiciAuthor);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
