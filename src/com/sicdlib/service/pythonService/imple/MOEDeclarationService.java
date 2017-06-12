package com.sicdlib.service.pythonService.imple;

import com.sicdlib.dao.pyhtonDAO.IMOEDeclarationDAO;
import com.sicdlib.dto.entity.MoeDeclarationEntity;
import com.sicdlib.service.pythonService.IMOEDeclarationService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/4.
 */
@Service("moeDeclarationService")
public class MOEDeclarationService  implements IMOEDeclarationService{
    @Autowired
    @Qualifier("moeDeclarationDAO")
    private IMOEDeclarationDAO moeDeclarationDAO;

    @Override
    public boolean saveMOEDeclaration(MoeDeclarationEntity moeDeclaration) {
        if(moeDeclaration.getId()  ==null){
          String uuid = UUIDUtil.getUUID();
          moeDeclaration.setId(uuid);
        }
        return moeDeclarationDAO.saveMOEDeclaration(moeDeclaration);
    }
}
