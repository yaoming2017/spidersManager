package com.sicdlib.service.imple;

import com.sicdlib.dao.IDoubanGroupGroupDAO;
import com.sicdlib.dto.entity.DoubanGroupGroupEntity;
import com.sicdlib.service.IDoubanGroupGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/5/25.
 */
@Service("doubanGroupGroupService")
public class DoubanGroupGroupService   implements IDoubanGroupGroupService {
    @Autowired
    @Qualifier("doubanGroupGroupDAO")
    private IDoubanGroupGroupDAO doubanGroupGroupDAO;

    @Override
    public boolean saveDoubanGroupGroup(DoubanGroupGroupEntity doubanGroupGroup) {
        return doubanGroupGroupDAO.saveDoubanGroupGroup(doubanGroupGroup);
    }
}
