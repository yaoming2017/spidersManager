package com.sicdlib.dao;

import com.sicdlib.dto.TbHotWordEntity;

import java.util.List;

/**
 * Created by YH on 2017/6/1.
 */
public interface IHotWordsDAO {
    List<TbHotWordEntity> getHotWordsEntityList(String eventID, int limit);
    void batchSaveHotWords(List<TbHotWordEntity> hotWordsList);
}
