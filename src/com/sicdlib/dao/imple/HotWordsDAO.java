package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.IHotWordsDAO;
import com.sicdlib.dto.TbHotWordEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by YH on 2017/6/1.
 */
@Repository("hotWordsDAO")
public class HotWordsDAO implements IHotWordsDAO {
    @Autowired
    @Qualifier("baseDAO")
    private IBaseDAO baseDAO;

    @Override
    public List<TbHotWordEntity> getHotWordsEntityList(String eventID) {
        String hql = "FROM TbHotWordEntity hotWords WHERE hotWords.eventId = '" + eventID + "' order by hotWords.heat desc";

        return baseDAO.find(hql);
    }

    @Override
    public void batchSaveHotWords(List<TbHotWordEntity> hotWordsList) {
        baseDAO.batchSave(hotWordsList);
    }
}
