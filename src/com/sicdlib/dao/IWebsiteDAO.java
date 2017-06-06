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
}
