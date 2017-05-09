package com.sicdlib.service.imple;

import com.jcraft.jsch.Session;
import com.sicdlib.dao.ISpiderDAO;
import com.sicdlib.dto.SpiderInfoEntity;
import com.sicdlib.service.IRunSpiderService;
import com.sicdlib.service.ISCHSessionService;
import com.sicdlib.util.JSCHUtil.ExecUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by YH on 2017/5/9.
 */
@Service("runSpiderService")
public class RunSpiderService implements IRunSpiderService {
    @Autowired
    @Qualifier("spiderDAO")
    private ISpiderDAO spiderDAO;

    @Autowired
    @Qualifier("schSessionService")
    private ISCHSessionService schSessionService;

    @Override
    public void runSpider(String spiderID, String configID) throws Exception {
        SpiderInfoEntity spiderInfo = spiderDAO.getSpiderInfo(spiderID);
        String spiderSource = spiderInfo.getSpiderSourcePath();

        Session session = schSessionService.getSession();

        //在爬虫目录中创建文件，写入配置ID
        String catCommand = "cat " + configID + " " + spiderSource;
        String catResult = "";
        try {
            catResult = ExecUtils.getInstance().execCmd(session, catCommand);// 多条命令之间以;分隔
            ExecUtils.getInstance().clear(session);
        } catch (Exception e) {
            System.out.println(e + catResult);
        }
    }
}
