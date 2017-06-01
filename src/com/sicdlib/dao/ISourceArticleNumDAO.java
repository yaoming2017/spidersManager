package com.sicdlib.dao;

import com.sicdlib.dto.TbEventEntity;
import com.sicdlib.dto.TbSourceArticleNumEntity;
import com.sicdlib.dto.TbTableEntity;

public interface ISourceArticleNumDAO {
    Boolean saveOrUpdateSourceArticleNum(TbSourceArticleNumEntity sourceArticleNum);
    TbSourceArticleNumEntity getSourceArticleNum(TbEventEntity event, TbTableEntity table);
}
