package com.sicdlib.service.imple;

import com.sicdlib.dao.IAuthorDAO;
import com.sicdlib.dao.ITableDAO;
import com.sicdlib.dto.TbAuthorEntity;
import com.sicdlib.dto.TbEventAuthorMappingEntity;
import com.sicdlib.dto.TbTableEntity;
import com.sicdlib.service.ITableService;
import com.sicdlib.util.TableUtil.ArticleAuthorTableMapping;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yh on 2016/9/8.
 */
@Service("tableService")
public class TableService implements ITableService{
    @Autowired
    @Qualifier("tableDAO")
    private ITableDAO tableDAO;

    @Autowired
    @Qualifier("authorDAO")
    private IAuthorDAO authorDAO;

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

    @Override
    public void setAuthorAttributes(String eventID) throws Exception {
        //存储不同网站信息的Map
//        Map<String, List<Object[]>> authorMap = new HashMap<>();

        //获取事件下记录作者的网站名，如果没有单独的作者表，则返回post表
        List<TbTableEntity> tableList = tableDAO.getTableByEventID(eventID);
        for (TbTableEntity articleTable: tableList) {
            String articleTableName = articleTable.getTableName();
            String authorTableName = ArticleAuthorTableMapping.getAuthorTable(articleTableName);
            String tableID = articleTable.getId();

            List<Object[]> authorInfoList;
            //如果作者表和文章表是同一张表
            if (authorTableName.equals(articleTableName)) {
                authorInfoList = authorDAO.getAuthorNameWithNonePost(eventID, tableID, articleTableName);

                //通过用户ID获取用户发布文章的浏览量、发布文章数、和文章回复数
                for (Object[] authorInfo: authorInfoList) {
                    TbAuthorEntity authorEntity = new TbAuthorEntity();
                    TbEventAuthorMappingEntity eventMapping = new TbEventAuthorMappingEntity();

                    String authorId = (String) authorInfo[0];
                    String authorName = (String) authorInfo[1];
                    long fansNum = (long) authorInfo[2];

                    authorEntity.setId(UUIDUtil.getUUID());
                    authorEntity.setSourceAuthorId(authorId);
                    authorEntity.setSourceAuthorName(authorName);
                    authorEntity.setAuthorFansNum((int) fansNum);

                    Object[] authorNumInfo = authorDAO.getAuthorReadArticleReplyNumInPostTable(authorName, articleTableName);
                    int postSum = (int) authorNumInfo[0];
                    int commentNum = (int) authorNumInfo[1];
                    long readNum = (long) authorNumInfo[2];

                    authorEntity.setAuthorPostNum(postSum);
                    authorEntity.setAuthorReplyNum(commentNum);
                    authorEntity.setAuthorPostReadNum(readNum);

                    authorEntity.setTable(articleTable);
                    eventMapping.setId(UUIDUtil.getUUID());
                    eventMapping.setAuthor(authorEntity);

                    authorDAO.saveAuthorEntity(authorEntity);
                    authorDAO.saveEventAuthorMapping(eventMapping, eventID);
                }
            } else { //如果不是同一张表
                authorInfoList = authorDAO.getAuthorIdAndNameAndFansNumWithPost(eventID, tableID, articleTableName, authorTableName);

                for (Object[] authorInfo: authorInfoList) {
                    TbAuthorEntity authorEntity = new TbAuthorEntity();
                    TbEventAuthorMappingEntity eventMapping = new TbEventAuthorMappingEntity();

                    String authorId = (String) authorInfo[0];
                    String sourceAuthorId = (String) authorInfo[1];
                    String authorName = (String) authorInfo[2];
                    long fansNum = (long) authorInfo[3];

                    authorEntity.setId(UUIDUtil.getUUID());
                    authorEntity.setSourceAuthorId(authorId);
                    authorEntity.setSourceAuthorName(authorName);
                    authorEntity.setAuthorFansNum((int) fansNum);

                    Object[] authorNumInfo = authorDAO.getAuthorReadArticleReplyNumInAuthorTable(sourceAuthorId, articleTableName);
                    int postSum = (int) authorNumInfo[0];
                    int commentNum = (int) authorNumInfo[1];
                    long readNum = (long) authorNumInfo[2];

                    authorEntity.setAuthorPostNum(postSum);
                    authorEntity.setAuthorReplyNum(commentNum);
                    authorEntity.setAuthorPostReadNum(readNum);

                    authorEntity.setTable(articleTable);
                    eventMapping.setId(UUIDUtil.getUUID());
                    eventMapping.setAuthor(authorEntity);

                    authorDAO.saveAuthorEntity(authorEntity);
                    authorDAO.saveEventAuthorMapping(eventMapping, eventID);
                }
            }

//            authorMap.put(tableID, authorInfoList);
        }

    }

}
