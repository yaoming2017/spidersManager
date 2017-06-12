package com.sicdlib.dao;

import com.sicdlib.dto.WebsiteEntity;
import java.util.List;

/**
 * Created by haoyang on 2017/4/20.
 */
public interface IWebsiteDAO {
    boolean saveWebsite(WebsiteEntity website);
    List<WebsiteEntity> listWebsite();
    WebsiteEntity getWebsiteByName(String websiteName);
    WebsiteEntity getWebsiteByUrl(String url);

    /**
     * 获取事件所在的网站
     * @param eventID
     * @return
     */
    List<WebsiteEntity> getWebsiteByEventID(String eventID);

    /**
     * 根据表ID获取所属网站
     * @param tableID
     * @return
     */
    WebsiteEntity getWebsiteByTableID(String tableID);
}
