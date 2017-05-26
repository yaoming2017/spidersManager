package com.sicdlib.service.imple;

import com.sicdlib.dao.IDoubanGroupAuthorDAO;
import com.sicdlib.dto.entity.DoubanGroupAuthorEntity;
import com.sicdlib.service.IDoubanGroupAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Yh on 2016/9/8.
 */
@Service("doubanGroupAuthorService")
public class DoubanGroupAuthorService implements IDoubanGroupAuthorService{
    @Autowired
    @Qualifier("doubanGroupAuthorDAO")
    private IDoubanGroupAuthorDAO doubanGroupAuthorDAO;

    @Override
    public boolean saveDoubanGroupAuthor(DoubanGroupAuthorEntity doubanGroupAuthor) {
        return doubanGroupAuthorDAO.saveDoubanGroupAuthor(doubanGroupAuthor);
    }
}
