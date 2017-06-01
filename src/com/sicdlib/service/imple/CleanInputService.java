package com.sicdlib.service.imple;

import com.sicdlib.dao.ICleanInputDAO;
import com.sicdlib.dto.CleanInputEntity;
import com.sicdlib.service.ICleanInputService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("cleanInputService")
public class CleanInputService implements ICleanInputService{
    @Autowired
    @Qualifier("cleanInputDAO")
    private ICleanInputDAO cleanInputDAO;

    @Override
    public boolean addCleanInput(CleanInputEntity cleanInput) {
        if (cleanInput.getId() == null){
            String uuid = UUIDUtil.getUUID();
            cleanInput.setId(uuid);
        }
        return cleanInputDAO.addCleanInput(cleanInput);
    }
}
