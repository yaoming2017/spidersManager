package com.sicdlib.service.imple;

import com.sicdlib.dao.ICleanDataDAO;
import com.sicdlib.dao.ICleanDataProcessDAO;
import com.sicdlib.dto.CleanDataEntity;
import com.sicdlib.dto.CleanDataProcessEntity;
import com.sicdlib.service.ICleanDataProcessService;
import com.sicdlib.service.ICleanDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cleanDataProcessService")
public class CleanDataProcessService implements ICleanDataProcessService{
    @Autowired
    @Qualifier("cleanDataProcessDAO")
    private ICleanDataProcessDAO cleanDataProcessDAO;

    @Override
    public List<CleanDataProcessEntity> getCleanDataProcessByCleanDataId(String cid) {

        return cleanDataProcessDAO.getCleanDataProcessByCleanDataId(cid);
    }

    @Override
    public CleanDataProcessEntity getCleanDataProcessById(String id) {
        return cleanDataProcessDAO.getCleanDataProcessById(id);
    }
}
