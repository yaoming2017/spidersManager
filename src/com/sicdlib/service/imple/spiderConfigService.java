package com.sicdlib.service.imple;

import com.sicdlib.dao.IDataDictDAO;
import com.sicdlib.dao.ISpiderConfigDAO;
import com.sicdlib.dto.Constant;
import com.sicdlib.dto.SpiderConfigEntity;
import com.sicdlib.dto.SpiderConfigItemEntity;
import com.sicdlib.service.ISpiderConfigService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by YH on 2017/5/3.
 */
@Service("spiderConfigService")
public class spiderConfigService implements ISpiderConfigService {
    @Autowired
    @Qualifier("spiderConfigDAO")
    private ISpiderConfigDAO spiderConfigDAO;

    @Autowired
    @Qualifier("dataDictDAO")
    private IDataDictDAO dataDictDAO;

    @Override
    public boolean addConfig(String spiderID, Map<String, String> config) {
        SpiderConfigEntity spiderConfig = new SpiderConfigEntity();
        String configID = UUIDUtil.getUUID();
        spiderConfig.setId(configID);
        spiderConfig.setSpiderId(spiderID);
        //获取当前的日期时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDate = df.format(new Date());
        spiderConfig.setConfigTime(currentDate);

        //设置日志目录和存储的文件目录，目录在爬虫运行前进行创建
        String logPathBase = dataDictDAO.getDictValue(Constant.SPIDER_LOG_BASE).get(0);
        String filePathBase = dataDictDAO.getDictValue(Constant.SPIDER_FILE_BASE).get(0);
        spiderConfig.setLogPath(logPathBase + configID + "/");
        spiderConfig.setFilePath(filePathBase + filePathBase + "/");

        boolean configResult = spiderConfigDAO.saveSpiderConfig(spiderConfig);
        if(!configResult) {
            System.err.println("保存SpiderConfigEntity失败");
            return false;
        }

        for (Map.Entry entry: config.entrySet()) {
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            if(value != null && !value.trim().equals("")) {
                SpiderConfigItemEntity spiderConfigItem = new SpiderConfigItemEntity();
                spiderConfigItem.setId(UUIDUtil.getUUID());
                spiderConfigItem.setConfigId(configID);
                spiderConfigItem.setConfigItemName(key);
                spiderConfigItem.setConfigItemValue(value);

                boolean configItemResult = spiderConfigDAO.saveSpiderConfigItem(spiderConfigItem);
                if(!configItemResult) {
                    System.err.println("保存SpiderConfigItemEntity失败");
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public Map<String, List<Object[]>> getSpiderConfigItem(String spiderID) {
        List<Object[]> configList = spiderConfigDAO.getSpiderConfigItem(spiderID);
        Map<String, List<Object[]>> resultMap = new HashMap<>();
        for(Object[] config:  configList) {
            String configID = ((SpiderConfigItemEntity)config[0]).getConfigId();
            if(resultMap.containsKey(configID)) {
                resultMap.get(configID).add(config);
            } else {
                List<Object[]> tmp = new ArrayList<>();
                tmp.add(config);
                resultMap.put(configID, tmp);
            }
        }
        return resultMap;
    }
}
