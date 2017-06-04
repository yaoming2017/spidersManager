package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.IEventStatisticsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by YH on 2017/6/2.
 */
@Repository("eventStatisticsDAO")
public class EventStatisticsDAO implements IEventStatisticsDAO {
    @Autowired
    @Qualifier("baseDAO")
    private IBaseDAO baseDAO;

    @Override
    public List<Object[]> getEventWebsiteArticleNum(String eventID) {
        String hql = "SELECT website.websiteName, SUM(articleNum.num) " +
                "FROM WebsiteEntity website, TbTableEntity table, TbSourceArticleNumEntity articleNum " +
                "WHERE website.id = table.websiteId AND table.id = articleNum.table.id AND articleNum.event.id = '" +
                eventID + "' " +
                "GROUP BY website.websiteName";
        return baseDAO.find(hql);
    }
}
