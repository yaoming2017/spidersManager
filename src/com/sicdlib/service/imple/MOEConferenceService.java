package com.sicdlib.service.imple;

import com.sicdlib.dao.IMOEConferenceDAO;
import com.sicdlib.dto.entity.MoeConferenceEntity;
import com.sicdlib.service.IMOEConferenceService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/4.
 */
@Service("moeConferenceService")
public class MOEConferenceService  implements IMOEConferenceService{
    @Autowired
    @Qualifier("moeConferenceDAO")
    private IMOEConferenceDAO moeConferenceDAO;
    @Override
    public boolean saveMOEConference(MoeConferenceEntity moeConference) {
        if(moeConference.getId() == null){
            String uuid = UUIDUtil.getUUID();
            moeConference.setId(uuid);
        }
        return moeConferenceDAO.saveMOEConference(moeConference);
    }
}
