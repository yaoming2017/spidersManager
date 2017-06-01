package com.sicdlib.service.imple;

import com.sicdlib.dao.IEventDAO;
import com.sicdlib.dao.ISourceArticleNumDAO;
import com.sicdlib.dto.TbEventEntity;
import com.sicdlib.dto.TbSourceArticleNumEntity;
import com.sicdlib.dto.TbTableEntity;
import com.sicdlib.service.IEventService;
import com.sicdlib.service.ISourceArticleNumService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Yh on 2016/9/8.
 */
@Service("sourceArticleNumService")
public class SourceArticleNumService implements ISourceArticleNumService{
    @Autowired
    @Qualifier("sourceArticleNumDAO")
    private ISourceArticleNumDAO sourceArticleNumDAO;

    @Override
    public Boolean saveOrUpdateSourceArticleNum(TbSourceArticleNumEntity sourceArticleNum) {
        if (sourceArticleNum.getId() == null){
            String uuid = UUIDUtil.getUUID();
            sourceArticleNum.setId(uuid);
        }
        return sourceArticleNumDAO.saveOrUpdateSourceArticleNum(sourceArticleNum);
    }

    @Override
    public TbSourceArticleNumEntity getSourceArticleNum(TbEventEntity event, TbTableEntity table) {
        return sourceArticleNumDAO.getSourceArticleNum(event, table);
    }
}
