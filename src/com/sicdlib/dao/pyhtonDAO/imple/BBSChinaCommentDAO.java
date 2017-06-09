package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.pyhtonDAO.IBBSChinaCommentDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BbsChinaCommentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/5/25.
 */
@Repository("bbsChinaCommentDAO")
public class BBSChinaCommentDAO implements IBBSChinaCommentDAO {
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveBBSChinaComment(BbsChinaCommentEntity bbsChinaComment) {
        try {
            baseDAO.save(bbsChinaComment);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
