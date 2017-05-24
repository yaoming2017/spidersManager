package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.IStopWordsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by YH on 2017/5/22.
 */
@Repository("stopWordsDAO")
public class StopWordsDAO implements IStopWordsDAO{
    @Autowired
    @Qualifier("baseDAO")
    private IBaseDAO baseDAO;

    @Override
    public List<String> getStopWords() {
        String hql = "Select stopWords.word from TbStopWordsEntity stopWords";
        return baseDAO.find(hql);
    }
}
