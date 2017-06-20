package com.sicdlib.service.imple;

import com.sicdlib.dao.imple.SentimentInflucenceDAO;
import com.sicdlib.dto.TbHotWordEntity;
import com.sicdlib.dto.entity.DoubanGroupPostEntity;
import com.sicdlib.service.ISentimentInflucenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by init on 2017/6/14.
 */
@Service("sentimentInflucenceService")
public class SentimentInflucenceService implements ISentimentInflucenceService{
    @Autowired
    @Qualifier("sentimentInflucenceDAO")
    private SentimentInflucenceDAO sentimentInflucenceDAO;

    @Override
    public List<Map> getSentimentInflucenceMap(String postId) {
        int limit = 200;
        List<DoubanGroupPostEntity> commentNumList = sentimentInflucenceDAO.getDoubanGroupPostEntityList(postId,limit);
        List<Map> mapList = new ArrayList<>();
        for(DoubanGroupPostEntity commentNum: commentNumList){
            Map<String,String> commentNumMap = new HashMap<>();
            commentNumMap.put("value",String.valueOf(commentNum.getCommentNum()));
            mapList.add(commentNumMap);
        }
        return mapList;
    }
}
