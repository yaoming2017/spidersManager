package com.sicdlib.service.imple;

import com.sicdlib.dao.ITableColumnDAO;
import com.sicdlib.service.IIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.PriorityQueue;

/**
 * Created by YH on 2017/6/15.
 */
@Service("indexService")
public class IndexService implements IIndexService {
    @Autowired
    @Qualifier("tableColumnDAO")
    private ITableColumnDAO tableColumnDAO;
    @Override
    public void test() {
        boolean test = tableColumnDAO.isExistColumn("bbs_china_author", "id");
        System.out.println(test);
    }


}
