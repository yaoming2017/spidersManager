package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.pyhtonDAO.IBBSChinaAuthorDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BbsChinaAuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/5/25.
 */
@Repository("bbsChinaAuthorDAO")
public class BBSChinaAuthorDAO implements IBBSChinaAuthorDAO {
    @Autowired
    private IBaseDAO baseDAO;

    @Override
    public Boolean savebbsChinaAuthor(BbsChinaAuthorEntity bbsChinaAuthor) {
        try {
            baseDAO.save(bbsChinaAuthor);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
