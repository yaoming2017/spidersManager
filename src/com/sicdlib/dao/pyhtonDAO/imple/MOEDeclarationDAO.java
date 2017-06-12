package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.pyhtonDAO.IMOEDeclarationDAO;
import com.sicdlib.dto.entity.MoeDeclarationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/4.
 */
@Repository("moeDeclarationDAO")
public class MOEDeclarationDAO  implements IMOEDeclarationDAO{
    @Autowired
    private IBaseDAO baseDAO;

    @Override
    public Boolean saveMOEDeclaration(MoeDeclarationEntity moeDeclaration) {
        try{
            baseDAO.save(moeDeclaration);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
