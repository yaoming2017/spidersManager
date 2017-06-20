package com.sicdlib.service.imple;

import com.sicdlib.dao.IArticleHotValueDAO;
import com.sicdlib.dao.IArticleSimiDAO;
import com.sicdlib.dao.IEventArticleDAO;
import com.sicdlib.dao.ITableDAO;
import com.sicdlib.dto.ArticleHotValueEntity;
import com.sicdlib.dto.TbArticleSimilarityEntity;
import com.sicdlib.dto.TbTableEntity;
import com.sicdlib.service.IArticleHotValueService;
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
@Service("articleHotValueService")
public class ArticleHotValueService implements IArticleHotValueService {
    @Autowired
    @Qualifier("articleHotValueDAO")
    private IArticleHotValueDAO articleHotValueDAO;

    @Override
    public boolean addArticleHotValueByEventID(ArticleHotValueEntity articleHotValue) {
        return articleHotValueDAO.addArticleHotValueByEventID(articleHotValue);
    }

}
