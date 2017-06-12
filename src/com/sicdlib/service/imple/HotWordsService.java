package com.sicdlib.service.imple;

import com.sicdlib.dao.IHotWordsDAO;
import com.sicdlib.dao.IStopWordsDAO;
import com.sicdlib.dao.ITableDAO;
import com.sicdlib.dto.TbHotWordEntity;
import com.sicdlib.dto.TbTableEntity;
import com.sicdlib.service.IHotWordsService;
import com.sicdlib.util.KeyWordsUtil.KeyWordsExtract;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
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

    @Autowired
    @Qualifier("stopWordsDAO")
    private IStopWordsDAO stopWordsDAO;

    @Autowired
    @Qualifier("tableDAO")
    private ITableDAO tableDAO;

    @Override
    public List<Map> getHotWordsMap(String eventID) {
        int limit = 100;
        List<TbHotWordEntity> hotWordsList = hotWordsDAO.getHotWordsEntityList(eventID, limit);

        List<Map> mapList = new ArrayList<>();
        for(TbHotWordEntity hotWords: hotWordsList) {
            Map<String, String> hotWordsMap = new HashMap<>();
            hotWordsMap.put("name", hotWords.getName());
            hotWordsMap.put("value", String.valueOf(hotWords.getHeat()));
            mapList.add(hotWordsMap);
        }

        return mapList;
    }

    @Override
    public void setHotWords(String eventID) {
        List<String> stops = stopWordsDAO.getAllStopWords();
        List<TbTableEntity> tableList = tableDAO.getTableByEventID(eventID);
        List<String> contentList = new ArrayList<>();

        for(TbTableEntity table: tableList) {
            List<String> contents = tableDAO.getArticleContent(eventID, table.getId(), table.getTableName());
            contentList.addAll(contents);
        }

        KeyWordsExtract key =  new KeyWordsExtract();
        List<Map.Entry<String, Float>> hotWordsMap = key.getKeyword(contentList, stops);

        //将数据存入数据库
        List<TbHotWordEntity> hotWordsList = new ArrayList<>();

        for (Map.Entry<String, Float> hotWordsEntry: hotWordsMap) {
            TbHotWordEntity hotWords = new TbHotWordEntity();

            hotWords.setId(UUIDUtil.getUUID());
            hotWords.setEventId(eventID);
            hotWords.setHeat(hotWordsEntry.getValue().doubleValue());
            hotWords.setName(hotWordsEntry.getKey());

            hotWordsList.add(hotWords);
        }

        hotWordsDAO.batchSaveHotWords(hotWordsList);
    }
}
