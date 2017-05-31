package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.ICleanDataProcessDAO;
import com.sicdlib.dto.CleanDataProcessEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("cleanDataProcessDAO")
public class CleanDataProcessDAO implements ICleanDataProcessDAO {
    @Autowired
    private IBaseDAO baseDAO;

    @Override
    public List<CleanDataProcessEntity> getCleanDataProcessByCleanDataId(String cid) {
        String hql = "from CleanDataProcessEntity cdp where cdp.cleanDataEntity.id="+cid;
        return (List<CleanDataProcessEntity>)baseDAO.find(hql);
    }

    @Override
    public CleanDataProcessEntity getCleanDataProcessById(String id) {
        String hql = "from CleanDataProcessEntity cdp where cdp.id = "+id;
        return (CleanDataProcessEntity)baseDAO.get(hql);
    }
}
