package com.sicdlib.service.imple;

import com.sicdlib.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by YH on 2017/6/20.
 */
@Service("preCalService")
public class PreCalService implements IPreCalService {
    @Autowired
    @Qualifier("hotWordsService")
    private IHotWordsService hotWordsService;

    @Autowired
    @Qualifier("eventService")
    private IEventService eventService;

    @Autowired
    @Qualifier("articleSimiService")
    private IArticleSimiService articleSimiService;

    @Autowired
    @Qualifier("tableService")
    private ITableService tableService;

    @Override
    public void cal(String eventID) {
        //计算热词
        hotWordsService.setHotWords(eventID);

        //计算时间属性
        eventService.setEventAttributes(eventID);

        //计算文章相似度
        articleSimiService.setEventArticleSimi(eventID);

        //计算发布者指标
        try {
            tableService.setAuthorAttributes(eventID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
