package com.sicdlib.service.imple;

import com.sicdlib.dao.IArticleSimiDAO;
import com.sicdlib.dao.IEventArticleDAO;
import com.sicdlib.dao.ITableDAO;
import com.sicdlib.dao.IWebsiteDAO;
import com.sicdlib.dto.TbArticleSimilarityEntity;
import com.sicdlib.service.IArticleSpreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by YH on 2017/6/6.
 */
@Service("articleSpreadService")
public class ArticleSpreadService implements IArticleSpreadService {
    @Autowired
    @Qualifier("articleSimiDAO")
    private IArticleSimiDAO articleSimiDAO;

    @Autowired
    @Qualifier("eventArticleDAO")
    private IEventArticleDAO eventArticleDAO;

    @Autowired
    @Qualifier("websiteDAO")
    private IWebsiteDAO websiteDAO;

    @Autowired
    @Qualifier("tableDAO")
    private ITableDAO tableDAO;

    @Override
    public Map<String, List> getNodeAndEdgeAttributes(String eventID) {
        double simi = 0.35;
        List<TbArticleSimilarityEntity> articleSimiList = articleSimiDAO.getSimiArticleEntityList(eventID);
        Map<String, Integer> articleSimiNumMap = new ConcurrentHashMap<>();
        Map<String, String> articleTitleMap = new ConcurrentHashMap<>();
        Map<String, String> articleWebsite = new ConcurrentHashMap<>();
        Map<String, String> tableNameMap = new ConcurrentHashMap<>();

        Vector<Map<String, String>> edgeList = new Vector<>();

        articleSimiList
                .parallelStream().forEach(articleSimi->{
                    String articleAID = articleSimi.getArticleA().getSourceArticleId();
                    String articleBID = articleSimi.getArticleB().getSourceArticleId();

            //初始化节点相关节点的个数
            if (!articleSimiNumMap.containsKey(articleAID)) {
                //获取文章标题
                String articleATitle = eventArticleDAO.getArticleTitle(
                        articleSimi.getArticleA().getTable().getId(),
                        articleAID
                );

                articleSimiNumMap.put(articleAID, 0);

                articleTitleMap.put(articleAID, articleATitle);

                //来源网站
                String sourceWebsite = websiteDAO.getWebsiteByTableID(
                        articleSimi.getArticleA().getTable().getId()).getWebsiteName();
                articleWebsite.put(articleAID, sourceWebsite);

                //文章来源表
                tableNameMap.put(articleAID, articleSimi.getArticleA().getTable().getTableName());
            }
            if(!articleSimiNumMap.containsKey(articleBID)) {
                //获取文章标题
                String articleBTitle = eventArticleDAO.getArticleTitle(
                        articleSimi.getArticleB().getTable().getId(),
                        articleBID
                );

                articleSimiNumMap.put(articleBID, 0);

                //文章标题
                articleTitleMap.put(articleBID, articleBTitle);

                //来源网站
                String sourceWebsite = websiteDAO.getWebsiteByTableID(
                        articleSimi.getArticleB().getTable().getId()).getWebsiteName();
                articleWebsite.put(articleBID, sourceWebsite);

                //文章来源表
                tableNameMap.put(articleBID, articleSimi.getArticleB().getTable().getTableName());

            }

            //时间早的作为source，晚的为target
            //如果相似度高于simi，连接两个节点
            if(articleSimi.getSimilarity() > simi) {
                Map<String, String> edgeMap = new HashMap<>();
                articleSimiNumMap.put(articleAID, articleSimiNumMap.get(articleAID) + 1);
                articleSimiNumMap.put(articleBID, articleSimiNumMap.get(articleBID) + 1);

                if(articleTitleMap.get(articleAID).compareTo(articleTitleMap.get(articleBID)) > 0) {
                    edgeMap.put("source", articleBID);
                    edgeMap.put("target", articleAID);
                } else {
                    edgeMap.put("source", articleAID);
                    edgeMap.put("target", articleBID);
                }
                edgeList.add(edgeMap);
            }
        });

        List<Map> nodeList = new ArrayList<>();
        articleTitleMap.forEach((articleID, articleTitle)->{
            Map<String, Object> element = new HashMap<>();
            element.put("title", articleTitle);
            element.put("num", articleSimiNumMap.get(articleID));
            element.put("website", articleWebsite.get(articleID));
            element.put("id", articleID);
            element.put("table", tableNameMap.get(articleID));

            nodeList.add(element);
        });

        Map<String, List> result = new HashMap<>();
        result.put("nodes", nodeList);
        result.put("edges", edgeList);

        return result;
    }

    @Override
    public String getArticleContent(String articleID, String tableName) {
        return tableDAO.getArticleContent(articleID, tableName);
    }
}
