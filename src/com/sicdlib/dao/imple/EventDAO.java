package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.IEventDAO;
import com.sicdlib.dao.IStopWordsDAO;
import com.sicdlib.dto.TbEventEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("eventDAO")
public class EventDAO implements IEventDAO {
    @Autowired
    private IBaseDAO baseDAO;

    @Override
    public Boolean saveOrUpdateEvent(TbEventEntity event) {
        try {
            baseDAO.saveOrUpdate(event);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}