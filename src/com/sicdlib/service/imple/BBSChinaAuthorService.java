package com.sicdlib.service.imple;

import com.sicdlib.dao.IBBSChinaAuthorDAO;
import com.sicdlib.dao.IDoubanGroupAuthorDAO;
import com.sicdlib.dto.entity.BbsChinaAuthorEntity;
import com.sicdlib.dto.entity.DoubanGroupAuthorEntity;
import com.sicdlib.service.IBBSChinaAuthorService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/5/25.
 */
@Service("bbsChinaAuthorService")
public class BBSChinaAuthorService implements IBBSChinaAuthorService {
     @Autowired
     @Qualifier("bbsChinaAuthorDAO")
      private IBBSChinaAuthorDAO bbsChinaAuthorDAO;

    @Override
    public boolean saveBBSChinaAuthor(BbsChinaAuthorEntity bbsChinaAuthor) {
        if (bbsChinaAuthor.getId() == null){
            String uuid = UUIDUtil.getUUID();
            bbsChinaAuthor.setId(uuid);
        }
        return bbsChinaAuthorDAO.savebbsChinaAuthor(bbsChinaAuthor);
    }
}
