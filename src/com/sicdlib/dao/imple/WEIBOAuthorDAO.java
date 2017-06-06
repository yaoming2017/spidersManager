package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.IWEIBOAuthorDAO;
import com.sicdlib.dto.entity.WeiboAuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/5.
 */
@Repository("weiboAuthorDAO")
public class WEIBOAuthorDAO  implements IWEIBOAuthorDAO{
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveWEIBOAuthor(WeiboAuthorEntity weiboAuthor) {
       try{
           baseDAO.save(weiboAuthor);
           return true;
       }catch (Exception e){
           e.printStackTrace();
           return false;
       }
    }
}
