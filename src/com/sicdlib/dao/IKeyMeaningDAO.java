package com.sicdlib.dao;

import com.sicdlib.dto.KeyMeaningEntity;
import com.sicdlib.dto.UserEntity;

import java.util.List;

public interface IKeyMeaningDAO {
    List<KeyMeaningEntity> getKeyMeaningsBykeyname(String keyname);
    KeyMeaningEntity getKeyMeaningById(String id);
}
