package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.pyhtonDAO.IWEIBOPostDAO;
import com.sicdlib.dto.entity.WeiboPostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/5.
 */
@Repository("weiboPostDAO")
public class WEIBOPostDAO  implements IWEIBOPostDAO{
    @Autowired
    private IBaseDAO  baseDAO;
    @Override
    public Boolean saveWEIBOPost(WeiboPostEntity weiboPost) {
        try{
            baseDAO.save(weiboPost);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
