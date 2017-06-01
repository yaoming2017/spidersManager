package com.sicdlib.dao;

<<<<<<< HEAD
import com.sicdlib.dto.entity.WebsiteEntity;
=======
import com.sicdlib.dto.WebsiteEntity;
>>>>>>> cf1ab372ee131539d3bb702620fcd9db195c71a0

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
