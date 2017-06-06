package com.sicdlib.dao;

import com.sicdlib.dto.TbArticleSimilarityEntity;

import java.util.List;

/**
 * Created by YH on 2017/6/5.
 */
public interface IArticleSimiDAO {
    void batchSaveSimiEntity(List<TbArticleSimilarityEntity> simiList);
}
