package com.sicdlib.service.pythonService.imple;

import com.sicdlib.dao.pyhtonDAO.IKDNETCommentDAO;
import com.sicdlib.dto.entity.KdnetCommentEntity;
import com.sicdlib.service.pythonService.IKDNETCommentService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/5.
 */
@Service("kdnetCommentService")
public class KDNETCommentService  implements IKDNETCommentService{
    @Autowired
    @Qualifier("kdnetCommentDAO")
    private IKDNETCommentDAO  kdnetCommentDAO;
    @Override
    public boolean saveKDNETComment(KdnetCommentEntity kdnetComment) {
        if(kdnetComment.getId() ==null){
            String uuid = UUIDUtil.getUUID();
            kdnetComment.setId(uuid);
        }
        return kdnetCommentDAO.saveKDNETComment(kdnetComment);
    }
}
