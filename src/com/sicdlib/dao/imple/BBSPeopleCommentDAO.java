package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBBSPeopleCommentDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BbsPeopleCommentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/5/31.
 */
@Repository("bbsPeopleCommentDAO")
public class BBSPeopleCommentDAO implements IBBSPeopleCommentDAO{
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveBBSPeopleComment(BbsPeopleCommentEntity bbsPeopleComment) {
        try{
            baseDAO.save(bbsPeopleComment);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
