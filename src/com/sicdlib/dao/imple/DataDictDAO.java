package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.IDataDictDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by haoyang on 2017/4/20.
 */
@Repository("dataDictDAO")
public class DataDictDAO implements IDataDictDAO{
    @Autowired
    @Qualifier("baseDAO")
    private IBaseDAO baseDAO;

    @Override
    public List<String> getDictValue(String name) {
        String hql = "select d.value from DataDictEntity d where d.name = '" + name + "'";
        List<String> result = baseDAO.find(hql);

        return result;
    }
}
