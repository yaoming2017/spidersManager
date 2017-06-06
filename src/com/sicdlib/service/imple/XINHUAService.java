package com.sicdlib.service.imple;

import com.sicdlib.dao.IXINHUADAO;
import com.sicdlib.dto.entity.XinhuaEntity;
import com.sicdlib.service.IXINHUAService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/5.
 */
@Service("xinhuaService")
public class XINHUAService  implements IXINHUAService{
    @Autowired
    @Qualifier("xinhuaDAO")
    private IXINHUADAO xinhuaDAO;
    @Override
    public boolean saveXINHUA(XinhuaEntity xinhua) {
        if(xinhua.getId() == null){
         String uuid = UUIDUtil.getUUID();
         xinhua.setId(uuid);
        }
        return xinhuaDAO.saveXINHUA(xinhua);
    }
}
