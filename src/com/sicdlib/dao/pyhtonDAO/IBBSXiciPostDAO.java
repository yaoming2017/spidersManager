package com.sicdlib.dao.pyhtonDAO;

import com.sicdlib.dto.entity.BbsXiciPostEntity;

/**
 * Created by init on 2017/6/2.
 */
public interface IBBSXiciPostDAO {
    Boolean saveBBSXiciPost(BbsXiciPostEntity bbsXiciPost);
    BbsXiciPostEntity getBbsXiciPost(String id);
}
