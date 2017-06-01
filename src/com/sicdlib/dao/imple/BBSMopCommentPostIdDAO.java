package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBBSMopCommentPostIdDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BbsMopCommentPostIdEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/5/26.
 */
@Repository("bbsMopCommentPostIdDAO")
public class BBSMopCommentPostIdDAO  implements IBBSMopCommentPostIdDAO{
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveBBSMopCommentPostId(BbsMopCommentPostIdEntity bbsMopCommentPostId) {
       try{
           baseDAO.save(bbsMopCommentPostId);
           return  true;
       }catch (Exception e){
           e.printStackTrace();
       }
        return false;
    }
}
