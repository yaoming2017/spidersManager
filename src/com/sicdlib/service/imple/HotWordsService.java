package com.sicdlib.service.imple;

import com.sicdlib.dao.IHotWordsDAO;
import com.sicdlib.dto.TbHotWordEntity;
import com.sicdlib.service.IHotWordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YH on 2017/6/1.
 */
@Service("hotWordsService")
public class HotWordsService implements IHotWordsService {
    @Autowired
    @Qualifier("hotWordsDAO")
    private IHotWordsDAO hotWordsDAO;

    @Override
    public List<Map> getHotWordsMap(String eventID) {
        List<TbHotWordEntity> hotWordsList = hotWordsDAO.getHotWordsEntityList(eventID);

        List<Map> mapList = new ArrayList<>();
        for(TbHotWordEntity hotWords: hotWordsList) {
            Map<String, String> hotWordsMap = new HashMap<>();
            hotWordsMap.put("key", hotWords.getName());
            hotWordsMap.put("value", String.valueOf(hotWords.getHeat()));
            mapList.add(hotWordsMap);
        }

        return mapList;
    }
}
