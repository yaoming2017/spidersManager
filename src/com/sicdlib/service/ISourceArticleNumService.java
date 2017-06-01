package com.sicdlib.service;

import com.sicdlib.dto.TbEventEntity;
import com.sicdlib.dto.TbSourceArticleNumEntity;
import com.sicdlib.dto.TbTableEntity;

public interface ISourceArticleNumService {
    Boolean saveOrUpdateSourceArticleNum(TbSourceArticleNumEntity sourceArticleNum);
    TbSourceArticleNumEntity getSourceArticleNum(TbEventEntity event, TbTableEntity table);
}
