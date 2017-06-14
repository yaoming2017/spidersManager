package com.sicdlib.service.imple;

import com.sicdlib.dao.*;
import com.sicdlib.dto.TbArticleSimilarityEntity;
import com.sicdlib.dto.TbEventArticleEntity;
import com.sicdlib.dto.TbTableEntity;
import com.sicdlib.service.IArticleSimiService;
import com.sicdlib.util.KeyWordsUtil.Segmentation;
import com.sicdlib.util.SimilarityUtil.CosSimilarity;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YH on 2017/6/5.
 */
@Service("articleSimiService")
public class ArticleSimiService implements IArticleSimiService {
    @Autowired
    @Qualifier("eventArticleDAO")
    private IEventArticleDAO eventArticleDAO;

    @Autowired
    @Qualifier("tableDAO")
    private ITableDAO tableDAO;

    @Autowired
    @Qualifier("articleSimiDAO")
    private IArticleSimiDAO articleSimiDAO;

    @Override
    public void setEventArticleSimi(String eventID) {
//        List<String> stops = stopWordsDAO.getAllStopWords();
        List<TbTableEntity> tableList = tableDAO.getTableByEventID(eventID);
        List<String> idList = new ArrayList<>();
        List<List<String>> wordsList = new ArrayList<>();

        for (TbTableEntity table : tableList) {
            List<String[]> contents = tableDAO.getArticleIdAndContent(eventID, table.getId(), table.getTableName());
            for (Object[] content : contents) {
                //将文章ID加入队列
                idList.add((String) content[0]);

                //分词，并将分词后的结果加入队列，暂不去除停用词，看效果
                Segmentation seg = new Segmentation((String) content[1]);
                List<String> words = seg.getWordsList();

                wordsList.add(words);
            }
        }

        //计算两两之间的相似度
        List<TbArticleSimilarityEntity> simiEntityList = new ArrayList<>();
        for (int i = 1; i < wordsList.size(); i++) {
            for (int j = 0; j < i; j++) {
                double simi = CosSimilarity.calculate(wordsList.get(i), wordsList.get(j));

                TbArticleSimilarityEntity simiEntity = new TbArticleSimilarityEntity();
                simiEntity.setId(UUIDUtil.getUUID());
                simiEntity.setArticleA(eventArticleDAO.getEventArticleEntity(idList.get(i)));
                simiEntity.setArticleB(eventArticleDAO.getEventArticleEntity(idList.get(j)));
                simiEntity.setSimilarity(simi);

                simiEntityList.add(simiEntity);
            }
        }



        articleSimiDAO.batchSaveSimiEntity(simiEntityList);
    }
}
