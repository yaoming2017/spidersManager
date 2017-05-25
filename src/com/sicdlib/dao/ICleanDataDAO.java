package com.sicdlib.dao;


import com.sicdlib.dto.entity.CleanDataEntity;

import java.util.List;

public interface ICleanDataDAO {
    //得到所有的清洗数据策略命名
    List<CleanDataEntity> getAllCleanData();
    //得到所有的清洗数据策略详情
}
