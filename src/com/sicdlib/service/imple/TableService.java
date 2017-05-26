package com.sicdlib.service.imple;

import com.sicdlib.dao.IEventDAO;
import com.sicdlib.dao.ITableDAO;
import com.sicdlib.dto.TbEventEntity;
import com.sicdlib.dto.TbTableEntity;
import com.sicdlib.service.IEventService;
import com.sicdlib.service.ITableService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Yh on 2016/9/8.
 */
@Service("tableService")
public class TableService implements ITableService{
    @Autowired
    @Qualifier("tableDAO")
    private ITableDAO tableDAO;

    @Override
    public Boolean saveOrUpdateTable(TbTableEntity table) {
        if (table.getId() == null){
            String uuid = UUIDUtil.getUUID();
            table.setId(uuid);
        }
        return tableDAO.saveOrUpdateTable(table);
    }

    @Override
    public TbTableEntity getTable(String name) {
        return tableDAO.getTable(name);
    }

}
