package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.IStopWordsDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("stopWordsDAO")
public class StopWordsDAO implements IStopWordsDAO {
    @Autowired
    private IBaseDAO baseDAO;

    @Override
    public List<String> getAllStopWords() {
        String hql = "select sw.word from TbStopWordsEntity sw";
        return baseDAO.find(hql);
    }
}