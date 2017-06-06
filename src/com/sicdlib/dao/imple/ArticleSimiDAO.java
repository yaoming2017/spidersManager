package com.sicdlib.dao.imple;

import com.sicdlib.dao.IArticleSimiDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.TbArticleSimilarityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by YH on 2017/6/5.
 */
@Repository("articleSimiDAO")
public class ArticleSimiDAO implements IArticleSimiDAO {
    @Autowired
    @Qualifier("baseDAO")
    private IBaseDAO baseDAO;

    @Override
    public void batchSaveSimiEntity(List<TbArticleSimilarityEntity> simiList) {
        baseDAO.batchSave(simiList);
    }
}
