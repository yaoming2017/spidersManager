package com.sicdlib.service.imple;

<<<<<<< HEAD


=======
>>>>>>> 13ba83711a945e51186219e98bf023f743f73915
import com.sicdlib.dao.IStopWordsDAO;

import com.sicdlib.service.IStopWordsService;

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
    public List<String> getAllStopWords() {
        return stopWordsDAO.getAllStopWords();
    }
}
