package com.sicdlib.service;

import com.sicdlib.dto.TbEventEntity;
import com.sicdlib.dto.TbTableEntity;

public interface ITableService {
    Boolean saveOrUpdateTable(TbTableEntity table);
    TbTableEntity getTable(String name);
}
