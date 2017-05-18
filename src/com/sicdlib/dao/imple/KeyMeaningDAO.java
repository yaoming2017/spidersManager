package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.IKeyMeaningDAO;
import com.sicdlib.dao.ILoginDAO;
import com.sicdlib.dto.KeyMeaningEntity;
import com.sicdlib.dto.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("keyMeaningDAO")
public class KeyMeaningDAO implements IKeyMeaningDAO {
    @Autowired
    private IBaseDAO baseDAO;

    @Override
    public List<KeyMeaningEntity> getKeyMeaningsBykeyname(String keyname) {
        String hql = "from KeyMeaningEntity km where km.fid = (select km.id from KeyMeaningEntity km where km.keyName ='"+keyname+"')";
        List<KeyMeaningEntity> keymeanings = (List<KeyMeaningEntity>)baseDAO.find(hql);
        System.out.println(keymeanings);
        return keymeanings;
    }

    @Override
    public KeyMeaningEntity getKeyMeaningById(String id) {
        String hql = "from KeyMeaningEntity km where km.id = '"+id+"'";
        return (KeyMeaningEntity) baseDAO.get(hql);
    }
}
