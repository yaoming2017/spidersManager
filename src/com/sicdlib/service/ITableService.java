package com.sicdlib.service;

import com.sicdlib.dto.TbEventEntity;
import com.sicdlib.dto.TbTableEntity;

import java.util.Map;

public interface ITableService {
    Boolean saveOrUpdateTable(TbTableEntity table);
    TbTableEntity getTable(String name);
    Map<String,Integer> getCommentNumByTableName(String eventname);


}
