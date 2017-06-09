package com.sicdlib.service.pythonService.imple;

import com.sicdlib.dao.pyhtonDAO.IMOEDataDAO;
import com.sicdlib.dto.entity.MoeDataEntity;
import com.sicdlib.service.pythonService.IMOEDataService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/4.
 */
@Service("moeDataService")
public class MOEDataService  implements IMOEDataService{
    @Autowired
    @Qualifier("moeDataDAO")
    private IMOEDataDAO moeDataDAO;
    @Override
    public boolean saveMOEData(MoeDataEntity moeData) {
        if(moeData.getId() == null){
            String uuid = UUIDUtil.getUUID();
            moeData.setId(uuid);
        }
        return moeDataDAO.saveMOEData(moeData);
    }
}
