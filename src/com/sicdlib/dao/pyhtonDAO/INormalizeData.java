package com.sicdlib.dao.pyhtonDAO;

import com.sicdlib.util.HTableToMysqlUtil.INormalizeProcess;

/**
 * Created by YH on 2017/6/22.
 */
public interface INormalizeData {
    void normalizeData(INormalizeProcess process, String entityName);
}
