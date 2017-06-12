package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.pyhtonDAO.IBBSXinhuaCommentDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BbsXinhuaCommentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/3.
 */
@Repository("bbsXinhuaCommentDAO")
public class BBSXinhuaCommentDAO  implements IBBSXinhuaCommentDAO{
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveBBSXinhuaComment(BbsXinhuaCommentEntity bbsXinhuaComment) {
        try{
            baseDAO.save(bbsXinhuaComment);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
