package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.pyhtonDAO.INormalizeData;
import com.sicdlib.dto.entity.BbsMopPostEntity;
import com.sicdlib.util.HTableToMysqlUtil.INormalizeProcess;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by YH on 2017/6/22.
 */
@Repository("normalizeDataDAO")
public class NormalizeDataDAO implements INormalizeData {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void normalizeData(INormalizeProcess process, String entityName) {
//        StatelessSession session = sessionFactory.openStatelessSession();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        ScrollableResults posts = session.createQuery("from " + entityName)
                .setCacheMode(CacheMode.IGNORE)
                .scroll(ScrollMode.FORWARD_ONLY);
        int i = 0;
        while (posts.next()) {
            session.update(process.processData(posts.get(0)));
            if(i++ % 20 == 0){
                session.flush();
                session.clear();
                i = 0;
            }
        }

        tx.commit();
        session.close();
    }
}
