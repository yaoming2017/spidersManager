package com.sicdlib.service.pythonService.imple;

import com.sicdlib.dao.pyhtonDAO.INEWSSinaDAO;
import com.sicdlib.dto.entity.NewsSinaEntity;
import com.sicdlib.service.pythonService.INEWSSinaService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/6.
 */
@Service("newsSinaService")
public class NEWSSinaService  implements INEWSSinaService{
    @Autowired
    @Qualifier("newsSinaDAO")
    private INEWSSinaDAO newsSinaDAO;

    @Override
    public boolean saveNEWSSina(NewsSinaEntity newsSina) {
        if(newsSina.getId() ==null){
          String uuid = UUIDUtil.getUUID();
          newsSina.setId(uuid);
        }
        return newsSinaDAO.saveNEWSSina(newsSina);
    }
}
