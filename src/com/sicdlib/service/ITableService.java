package com.sicdlib.service;

import com.sicdlib.dto.TbEventEntity;
import com.sicdlib.dto.TbTableEntity;

<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> c446901adf06ccbb65a79d026d6619dab7f18793
import java.util.Map;

public interface ITableService {
    Boolean saveOrUpdateTable(TbTableEntity table);
    TbTableEntity getTable(String name);
<<<<<<< HEAD
    Map<String,Integer> getCommentNumByTableName(String eventname);


=======

    /**
     * 返回需要的发布者属性，包括文章浏览量，文章回复数和粉丝数
     * @param eventID 事件ID
     * @return key为tableID,value为[articleID, dateTime, authorID, authorName, postNum, replyNum, fansNum]
     */
    void setAuthorAttributes(String eventID) throws Exception;
>>>>>>> c446901adf06ccbb65a79d026d6619dab7f18793
}
