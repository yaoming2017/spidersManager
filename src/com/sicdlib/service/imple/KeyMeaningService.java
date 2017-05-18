package com.sicdlib.service.imple;

import com.sicdlib.dao.IKeyMeaningDAO;
import com.sicdlib.dao.ILoginDAO;
import com.sicdlib.dto.KeyMeaningEntity;
import com.sicdlib.dto.UserEntity;
import com.sicdlib.service.IKeyMeaningService;
import com.sicdlib.service.ILoginService;
import com.sicdlib.util.MD5Util.MD5Util;
import com.sicdlib.util.MailUtil.SendMail;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yh on 2016/9/8.
 */
@Service("keyMeaningService")
public class KeyMeaningService implements IKeyMeaningService{
    @Autowired
    @Qualifier("keyMeaningDAO")
    private IKeyMeaningDAO keyMeaningDAO;

    @Override
    public List<KeyMeaningEntity> getKeyMeanings(String keyname) {
        List<KeyMeaningEntity> keyMeaningEntities = keyMeaningDAO.getKeyMeaningsBykeyname(keyname);
        return keyMeaningEntities;
    }

    @Override
    public KeyMeaningEntity getKeyMeaningById(String id) {
        return keyMeaningDAO.getKeyMeaningById(id);
    }
}
