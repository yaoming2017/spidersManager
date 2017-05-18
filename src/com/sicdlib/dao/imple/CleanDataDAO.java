package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.ICleanDataDAO;
import com.sicdlib.dao.ILoginDAO;
import com.sicdlib.dto.CleanDataEntity;
import com.sicdlib.dto.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Yh on 2016/9/8.
 */
@Repository("cleanDataDAO")
public class CleanDataDAO implements ICleanDataDAO {
    @Autowired
    private IBaseDAO baseDAO;

    @Override
    public List<CleanDataEntity> getAllCleanData() {
        String hql = "from CleanDataEntity cd";
        return (List<CleanDataEntity>)baseDAO.find(hql);
    }
}
