package com.sicdlib.dao;

import com.sicdlib.dto.CleanDataProcessEntity;

import java.util.List;

public interface ICleanDataProcessDAO {
    //得到所有的清洗数据策略命名
    List<CleanDataProcessEntity> getCleanDataProcessByCleanDataId(String cid);
    //通过Id获得一个对象
    CleanDataProcessEntity getCleanDataProcessById(String id);
}
