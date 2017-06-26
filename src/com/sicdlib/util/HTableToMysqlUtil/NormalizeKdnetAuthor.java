package com.sicdlib.util.HTableToMysqlUtil;

import com.sicdlib.dto.entity.KdnetAuthorEntity;

import java.text.ParseException;

/**
 * Created by YH on 2017/6/23.
 */
public class NormalizeKdnetAuthor implements INormalizeProcess {
    @Override
    public Object processData(Object object) {
        KdnetAuthorEntity kdAuthor = (KdnetAuthorEntity) object;
        if(kdAuthor.getLevel().equals("-1")) {
            kdAuthor.setLevel("0");
        }
        if(kdAuthor.getInfluence() == -1) {
            kdAuthor.setInfluence(0.0);
        }
        if (kdAuthor.getHits() == -1) {
            kdAuthor.setHits(0);
        }
        if (kdAuthor.getPostNum() == -1) {
            kdAuthor.setPostNum(0);
        }
        if (kdAuthor.getFansNum() == -1) {
            kdAuthor.setFansNum(0);
        }
        if (kdAuthor.getFriendsNum() == -1) {
            kdAuthor.setFriendsNum(0);
        }
        String registerTime = kdAuthor.getRegisterTime();
        if (registerTime.equals("-1")) {
            kdAuthor.setRegisterTime("1970-01-01 01:00:00");
        } else {
            String dateFmt = "yyyy-M-dd h:mm";
            try {
                kdAuthor.setRegisterTime(FormatDate.format(registerTime, dateFmt));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (kdAuthor.getLoginNum() == -1) {
            kdAuthor.setLoginNum(0);
        }
        return kdAuthor;
    }
}
