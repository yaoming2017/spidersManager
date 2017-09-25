package com.sicdlib.service.imple;

import com.sicdlib.dao.IAuthorDAO;
import com.sicdlib.dao.ICalendarDao;
import com.sicdlib.service.ICalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("calendarService")
public class CalendarService implements ICalendarService {
//    @Autowired
//    @Qualifier("calendarDao")
//    private ICalendarDao calendarDao;
    @Autowired
    @Qualifier("calendarDao")
    private ICalendarDao calendarDao;
    @Override
    public List getThead(String tablename) {
        List tHead =calendarDao.getThead(tablename);
        return tHead;
    }

    @Override
    public List getTbody(String tablename) {
        List tBody=calendarDao.getTbody(tablename);
        return null;
    }
}
