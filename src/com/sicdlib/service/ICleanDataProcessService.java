package com.sicdlib.service;

import com.sicdlib.dto.CleanDataProcessEntity;

import java.util.List;

public interface ICleanDataProcessService {
    public List<CleanDataProcessEntity> getCleanDataProcessByCleanDataId(String cid);
    public CleanDataProcessEntity getCleanDataProcessById(String id);
}
