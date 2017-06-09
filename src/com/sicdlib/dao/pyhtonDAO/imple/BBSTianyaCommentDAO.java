package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.pyhtonDAO.IBBSTianyaCommentDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BbsTianyaCommentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/2.
 */
@Repository("bbsTianyaCommentDAO")
public class BBSTianyaCommentDAO implements IBBSTianyaCommentDAO{
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveBBSTianyaComment(BbsTianyaCommentEntity bbsTianyaComment) {
        try{
            baseDAO.save(bbsTianyaComment);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
