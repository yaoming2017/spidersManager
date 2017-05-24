package com.sicdlib.service.imple;

import com.sicdlib.dao.IDoubanGroupAuthorDAO;
import com.sicdlib.dao.ILoginDAO;
import com.sicdlib.dto.DoubanGroupAuthorEntity;
import com.sicdlib.dto.UserEntity;
import com.sicdlib.service.IDoubanGroupAuthorService;
import com.sicdlib.service.ILoginService;
import com.sicdlib.util.MD5Util.MD5Util;
import com.sicdlib.util.MailUtil.SendMail;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
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
        if (doubanGroupAuthor.getId() == null){
            String uuid = UUIDUtil.getUUID();
            doubanGroupAuthor.setId(uuid);
        }
        return doubanGroupAuthorDAO.saveDoubanGroupAuthor(doubanGroupAuthor);
    }
}
