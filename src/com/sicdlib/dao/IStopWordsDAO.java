package com.sicdlib.dao;

import com.sicdlib.dto.TbStopWordsEntity;

import java.util.List;

public interface IStopWordsDAO {
    List<String> getAllStopWords();
}
