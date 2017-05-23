package com.sicdlib.service;

import com.sicdlib.dto.DoubanGroupPostEntity;
import com.sicdlib.dto.TbStopWordsEntity;

import java.util.List;

public interface IStopWordsService {
    public List<TbStopWordsEntity> getAllStopWords();
}
