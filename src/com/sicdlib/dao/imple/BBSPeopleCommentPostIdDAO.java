package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBBSPeopleCommentPostIdDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BbsPeopleCommentPostIdEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/5/31.
 */
@Repository("bbsPeopleCommentPostIdDAO")
public class BBSPeopleCommentPostIdDAO implements IBBSPeopleCommentPostIdDAO {
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveBBSPeopleCommentPostId(BbsPeopleCommentPostIdEntity bbsPeopleCommentPostId) {
        try{
            baseDAO.save(bbsPeopleCommentPostId);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
