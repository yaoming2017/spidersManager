package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBLOGSinaCommentDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BlogSinaCommentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/3.
 */
@Repository("blogSinaCommentDAO")
public class BLOGSinaCommentDAO  implements IBLOGSinaCommentDAO{
    @Autowired
    private IBaseDAO baseDAO;

    @Override
    public Boolean saveBLOGSinaComment(BlogSinaCommentEntity blogSinaComment) {
        try{
            baseDAO.save(blogSinaComment);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
