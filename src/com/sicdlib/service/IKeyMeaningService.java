package com.sicdlib.service;

import com.sicdlib.dto.KeyMeaningEntity;
import com.sicdlib.dto.UserEntity;

import java.util.List;

public interface IKeyMeaningService {
    //通过KeyName
    List<KeyMeaningEntity> getKeyMeanings(String keyname);
    KeyMeaningEntity getKeyMeaningById(String id);
}
