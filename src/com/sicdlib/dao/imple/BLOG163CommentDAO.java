package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBLOG163CommentDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.Blog163CommentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/3.
 */
@Repository("blog163CommentDAO")
public class BLOG163CommentDAO  implements IBLOG163CommentDAO{
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveBLOG163Comment(Blog163CommentEntity blog163Comment) {
        try{
            baseDAO.save(blog163Comment);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
