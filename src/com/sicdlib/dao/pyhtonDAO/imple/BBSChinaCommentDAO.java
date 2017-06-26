package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.pyhtonDAO.IBBSChinaCommentDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BbsChinaCommentEntity;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/5/25.
 */
@Repository("bbsChinaCommentDAO")
public class BBSChinaCommentDAO implements IBBSChinaCommentDAO {
    @Autowired
    private IBaseDAO baseDAO;

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Boolean saveBBSChinaComment(BbsChinaCommentEntity bbsChinaComment) {
        try {
            baseDAO.save(bbsChinaComment);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void batchNormalizeAuthorNameAndContent() {
        StatelessSession session = sessionFactory.openStatelessSession();
        Transaction tx = session.beginTransaction();

        ScrollableResults comments = session.createQuery("from BbsChinaCommentEntity")
                .scroll(ScrollMode.FORWARD_ONLY);
        while (comments.next()) {
            BbsChinaCommentEntity comment = (BbsChinaCommentEntity)comments.get(0);

            //更新用户名，去除标签，去除文本“以下是XX在XXXX发表的：”
            comment.setContent(comment.getContent()
                    .replaceAll("<[^>]*>", "")
                    .replaceFirst("^引用.*?发表的：", ""));

            //更新内容，去除标签
            comment.setAuthorName(comment.getAuthorName().replaceAll("<[^>]*>", ""));
            session.update(comment);
        }

        tx.commit();
        session.close();
    }
}
