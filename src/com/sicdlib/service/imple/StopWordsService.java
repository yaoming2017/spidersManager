package com.sicdlib.service.imple;

<<<<<<< HEAD

import com.sicdlib.dao.IStopWordsDAO;

import com.sicdlib.service.IStopWordsService;

=======
import com.sicdlib.dao.IStopWordsDAO;
import com.sicdlib.service.IStopWordsService;
>>>>>>> cf1ab372ee131539d3bb702620fcd9db195c71a0
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
