package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBBSXinhuaAuthorDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BbsXinhuaAuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/3.
 */
@Repository("bbsXinhuaAuthorDAO")
public class BBSXinhuaAuthorDAO implements IBBSXinhuaAuthorDAO{
    @Autowired
    private IBaseDAO baseDAO;

    @Override
    public Boolean saveBBSXinhuaAuthor(BbsXinhuaAuthorEntity bbsXinhuaAuthor) {
        try{
            baseDAO.save(bbsXinhuaAuthor);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
