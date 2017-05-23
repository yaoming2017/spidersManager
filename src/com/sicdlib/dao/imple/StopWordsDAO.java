package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.IDoubanGroupPostDAO;
import com.sicdlib.dao.IStopWordsDAO;
import com.sicdlib.dto.DoubanGroupPostEntity;
import com.sicdlib.dto.TbStopWordsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("stopWordsDAO")
public class StopWordsDAO implements IStopWordsDAO {
    @Autowired
    private IBaseDAO baseDAO;

    @Override
    public List<TbStopWordsEntity> getAllStopWords() {
        String hql = "from TbStopWordsEntity sw";
        return baseDAO.find(hql);
    }
}