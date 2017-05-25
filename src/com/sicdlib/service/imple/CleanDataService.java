package com.sicdlib.service.imple;

import com.sicdlib.dao.ICleanDataDAO;
import com.sicdlib.dto.entity.CleanDataEntity;
import com.sicdlib.service.ICleanDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cleanDataService")
public class CleanDataService implements ICleanDataService{
    @Autowired
    @Qualifier("cleanDataDAO")
    private ICleanDataDAO cleanDataDAO;

    /**
     * 得到所有的CleanData数据
     * @return
     */
    @Override
    public List<CleanDataEntity> getAllCleanData() {
        return cleanDataDAO.getAllCleanData();
    }
}
