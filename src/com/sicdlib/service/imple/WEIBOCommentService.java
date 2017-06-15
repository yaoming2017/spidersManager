package com.sicdlib.service.imple;

import com.sicdlib.dao.IWEIBOCommentDAO;
import com.sicdlib.dto.WeiboCommentEntity;
import com.sicdlib.service.IWEIBOCommentService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/5.
 */
@Service("weiboCommentService")
public class WEIBOCommentService  implements IWEIBOCommentService{
    @Autowired
    @Qualifier("weiboCommentDAO")
    private IWEIBOCommentDAO weiboCommentDAO;
    @Override
    public boolean saveWEIBOComment(WeiboCommentEntity weiboComment) {
        if(weiboComment.getId() ==null){
            String uuid = UUIDUtil.getUUID();
            weiboComment.setId(uuid);
        }
        return weiboCommentDAO.saveWEIBOComment(weiboComment);
    }
}
