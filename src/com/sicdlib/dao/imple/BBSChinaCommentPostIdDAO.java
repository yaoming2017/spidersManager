package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBBSChinaCommentPostIdDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BbsChinaCommentPostIdEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/5/31.
 */
@Repository("bbsChinaCommentPostIdDAO")
public class BBSChinaCommentPostIdDAO implements IBBSChinaCommentPostIdDAO {
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveBBSChinaCommentPostId(BbsChinaCommentPostIdEntity bbsChinaCommentPostId) {
        try{
            baseDAO.save(bbsChinaCommentPostId);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
