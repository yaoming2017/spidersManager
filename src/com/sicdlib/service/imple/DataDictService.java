package com.sicdlib.service.imple;

import com.sicdlib.dao.IDataDictDAO;
import com.sicdlib.service.IDataDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by haoyang on 2017/4/20.
 */

@Service("dataDictService")
public class DataDictService implements IDataDictService{
    @Autowired
    @Qualifier("dataDictDAO")
    private IDataDictDAO dataDictDAO;

    @Override
    public List<String> getDataDictValue(String name) {
        List<String> dictValues = dataDictDAO.getDictValue(name);

        return dictValues;
    }
}
