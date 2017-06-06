package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.IMOENewsDAO;
import com.sicdlib.dto.entity.MoeNewsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/4.
 */
@Repository("moeNewsDAO")
public class MOENewsDAO  implements IMOENewsDAO{
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveMOENews(MoeNewsEntity moeNews) {
        try{
            baseDAO.save(moeNews);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
