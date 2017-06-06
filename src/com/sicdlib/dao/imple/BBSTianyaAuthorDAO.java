package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBBSTianyaAuthorDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BbsTianyaAuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/2.
 */
@Repository("bbsTianyaAuthorDAO")
public class BBSTianyaAuthorDAO  implements IBBSTianyaAuthorDAO{
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveBBSTianyaAuthor(BbsTianyaAuthorEntity bbsTianyaAuthor) {
        try{
            baseDAO.save(bbsTianyaAuthor);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
