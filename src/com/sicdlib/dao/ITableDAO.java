package com.sicdlib.dao;

import com.sicdlib.dto.TbEventEntity;
import com.sicdlib.dto.TbTableEntity;

public interface ITableDAO {
    Boolean saveOrUpdateTable(TbTableEntity table);
    TbTableEntity getTable(String name);
}
