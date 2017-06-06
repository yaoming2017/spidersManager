package com.sicdlib.dao;

<<<<<<< HEAD

import com.sicdlib.dto.WebsiteEntity;

=======
import com.sicdlib.dto.WebsiteEntity;
>>>>>>> 13ba83711a945e51186219e98bf023f743f73915

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
