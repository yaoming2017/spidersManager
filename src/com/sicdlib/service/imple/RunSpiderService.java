package com.sicdlib.service.imple;

import com.google.gson.Gson;
import com.jcraft.jsch.Session;
import com.sicdlib.dao.IDataDictDAO;
import com.sicdlib.dao.ISpiderConfigDAO;
import com.sicdlib.dao.ISpiderDAO;
import com.sicdlib.dto.*;
import com.sicdlib.service.IRunSpiderService;
import com.sicdlib.service.ISCHSessionService;
import com.sicdlib.util.JSCHUtil.ExecUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YH on 2017/5/9.
 */
@Service("runSpiderService")
public class RunSpiderService implements IRunSpiderService {
    @Autowired
    @Qualifier("dataDictDAO")
    private IDataDictDAO dataDictDAO;

    @Autowired
    @Qualifier("spiderDAO")
    private ISpiderDAO spiderDAO;

    @Autowired
    @Qualifier("spiderConfigDAO")
    private ISpiderConfigDAO spiderConfigDAO;

    @Autowired
    @Qualifier("schSessionService")
    private ISCHSessionService schSessionService;

    @Override
    public String runSpider(String spiderID, String configID) throws Exception {
        SpiderInfoEntity spiderInfo = spiderDAO.getSpiderInfo(spiderID);
        SpiderConfigEntity spiderConfig = spiderConfigDAO.getSpiderConfig(configID);

        String spiderSource = spiderInfo.getSpiderSourcePath();

        List<Object[]> configItemList = spiderConfigDAO.getSpiderConfigAndItem(configID);
        Map<String, String> configMap = new HashMap<>();
        Map<String, Object> resultMap = new HashMap<>();

        for(Object[] config: configItemList) {
            String name = ((SpiderConfigItemTypeEntity)config[1]).getName();
            String value = ((SpiderConfigItemEntity)config[0]).getConfigItemValue();
            configMap.put(name, value);
        }

        resultMap.put("name", spiderInfo.getSpiderName());
        resultMap.put("logPath", spiderConfig.getLogPath() + "scrapy.log");
        resultMap.put("filePath", spiderConfig.getFilePath());
        resultMap.put("configs", configMap);

        Gson gson = new Gson();
        String resultJSON = gson.toJson(resultMap).replace("\"", "\\\"");

        Session session = schSessionService.getSession(Constant.VM.VM01);

        //在爬虫目录中创建文件，写入配置ID
        String catCommand = "echo \"" + resultJSON + "\" > " + spiderSource + "config\n";
        String mkdirCommand = "mkdir -p " + spiderConfig.getLogPath() + " " + spiderConfig.getFilePath() + "\n";
        String runCommand = "python3 " + spiderSource + "run.py > log.log 2>&1 & \n";
        String catResult = "";
        String result;
        try {
            catResult = ExecUtils.getInstance().execCmd(session, catCommand);// 多条命令之间以;分隔
            catResult = ExecUtils.getInstance().execCmd(session, mkdirCommand);// 多条命令之间以;分隔
            catResult = ExecUtils.getInstance().execCmd(session, runCommand);// 多条命令之间以;分隔
//            catResult = ExecUtils.getInstance().execCmd(session, "mkdir -p /a");// 多条命令之间以;分隔
            spiderConfig.setStatus(dataDictDAO.getDictValue(Constant.SPIDER_STATUS_RUN).get(0));
            result = catResult;
        } catch (Exception e) {
            System.out.println(e + catResult);
            result = "ERROR";
            spiderConfig.setStatus(dataDictDAO.getDictValue(Constant.SPIDER_STATUS_STOP).get(0));
        } finally {
            ExecUtils.getInstance().clear(session);
        }

        spiderConfigDAO.updateSpiderConfig(spiderConfig);

        return result;

        //根绝绝对路径创建日志文件夹和图片文件夹
//        Session runSession = schSessionService.getSession(Constant.VM.VM01);
//        Session runSession = schSessionService.getSession();
//        String mkdirCommand = "mkdir -p " + spiderConfig.getLogPath() + " " + spiderConfig.getFilePath();
//        String runCommand = "cd " + spiderInfo.getSpiderSourcePath() + "; python3 "  + "run.py > log.log 2>&1 &";
//        String mkdirResult = "";
//        try {
//            mkdirResult = ExecUtils.getInstance().execCmd(runSession, mkdirCommand);// 多条命令之间以;分隔
//        } catch (Exception e) {
//            System.out.println(e + mkdirResult);
//        }

        //根据源文件路径运行爬虫

//        String runResult = "";
//        try {
//            runResult = ExecUtils.getInstance().execCmd(runSession, runCommand);// 多条命令之间以;分隔
//            ExecUtils.getInstance().clear(runSession);
//        } catch (Exception e) {
//            System.out.println(e + runResult);
//        }
    }
}
