package com.sicdlib.service.imple;

import com.sicdlib.dao.IDoubanGroupPostDAO;
import com.sicdlib.dao.IStopWordsDAO;
import com.sicdlib.dto.DoubanGroupPostEntity;
import com.sicdlib.dto.TbStopWordsEntity;
import com.sicdlib.service.IDoubanGroupPostService;
import com.sicdlib.service.IStopWordsService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yh on 2016/9/8.
 */
@Service("stopWordsService")
public class StopWordsService implements IStopWordsService{
    @Autowired
    @Qualifier("stopWordsDAO")
    private IStopWordsDAO stopWordsDAO;

    @Override
    public List<TbStopWordsEntity> getAllStopWords() {
        return stopWordsDAO.getAllStopWords();
    }
}
