package com.sicdlib.service.imple;

import com.sicdlib.dao.IBLOGSinaAuthorDAO;
import com.sicdlib.dto.entity.BlogSinaAuthorEntity;
import com.sicdlib.service.IBLOGSinaAuthorService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/3.
 */
@Service("blogSinaAuthorService")
public class BLOGSinaAuthorService  implements IBLOGSinaAuthorService{
    @Autowired
    @Qualifier("blogSinaAuthorDAO")
    private IBLOGSinaAuthorDAO blogSinaAuthorDAO;
    @Override
    public boolean saveBLOGSinaAuthor(BlogSinaAuthorEntity blogSinaAuthor) {
        if(blogSinaAuthor.getId() ==null){
           String uuid = UUIDUtil.getUUID();
           blogSinaAuthor.setId(uuid);
        }
        return blogSinaAuthorDAO.saveBLOGSinaAuthor(blogSinaAuthor);
    }
}
