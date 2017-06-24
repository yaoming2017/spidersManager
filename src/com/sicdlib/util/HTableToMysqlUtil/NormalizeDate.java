package com.sicdlib.util.HTableToMysqlUtil;

import com.sicdlib.dao.pyhtonDAO.INormalizeData;
import com.sicdlib.service.pythonService.IBBSChinaCommentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by YH on 2017/6/21.
 */
public class NormalizeDate {
    private static ApplicationContext apx = new ClassPathXmlApplicationContext("beans.xml");

    private static IBBSChinaCommentService bbsChinaCommentService = (IBBSChinaCommentService) apx.getBean("bbsChinaCommentService");

    public static void normalizeBbsChinaComment() {
        bbsChinaCommentService.normalizeAuthorNameAndContent();
    }

    public static void normalizeBbsMopAuthor() {

    }

}
