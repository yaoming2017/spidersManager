package com.sicdlib.service.imple;

import com.sicdlib.dao.ITableDAO;
import com.sicdlib.dto.TbTableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by init on 2017/6/17.
 */
public class CommentNumByEventIDService {

    @Autowired
    @Qualifier("tableDAO")
    private ITableDAO tableDAO;
    public List getCommentNumberByEventID(String eventID) {
        List<TbTableEntity> tableList = tableDAO.getTableByEventID(eventID);
        List<Integer> comentNumList = new ArrayList<>();

        for (TbTableEntity table : tableList) {
            int CommentNumber= tableDAO.getCommentNumByTableName(table.getTableName());
            comentNumList.add(CommentNumber);
            }
        return comentNumList;
        }


    }
