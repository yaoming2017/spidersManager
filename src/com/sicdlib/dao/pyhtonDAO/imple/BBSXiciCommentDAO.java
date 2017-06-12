package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.pyhtonDAO.IBBSXiciCommentDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BbsXiciCommentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/2.
 */
@Repository("bbsXiciCommentDAO")
public class BBSXiciCommentDAO implements IBBSXiciCommentDAO {
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveBBSXiciComment(BbsXiciCommentEntity bbsXiciComment) {
        try{
            baseDAO.save(bbsXiciComment);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
