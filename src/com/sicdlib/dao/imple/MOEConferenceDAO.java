package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.IMOEConferenceDAO;
import com.sicdlib.dto.entity.MoeConferenceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/4.
 */
@Repository("moeConferenceDAO")
public class MOEConferenceDAO  implements IMOEConferenceDAO{
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveMOEConference(MoeConferenceEntity moeConference) {
        try{
            baseDAO.save(moeConference);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }

    }
}
