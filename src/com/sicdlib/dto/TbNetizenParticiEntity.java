package com.sicdlib.dto;

import com.sicdlib.dto.entity.*;

import java.math.BigInteger;

/**
 * Created by init on 2017/6/21.
 */
public class TbNetizenParticiEntity {
    private String id;
    private String sourceAuthorName;
    private String sourceAuthorId;
    private Integer authorpostNum;
    private Integer participateCommentNum;
    //网民的参与度
    private Double engagement;
    //网站名称
    private String websiteName;
    //表名（对应tb_table的网站名称）
    private String tableName;

    //例如：豆瓣
    private DoubanGroupPostEntity doubanGroupPost ;
    //例如：人民网
    private BbsPeoplePostEntity bbsPeoplePost;
    //例如：搜狐社区
    private BbsSohuPostEntity bbsSohuPost;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSourceAuthorName() {
        return sourceAuthorName;
    }

    public void setSourceAuthorName(String sourceAuthorName) {
        this.sourceAuthorName = sourceAuthorName;
    }

    public String getSourceAuthorId() {
        return sourceAuthorId;
    }

    public void setSourceAuthorId(String sourceAuthorId) {
        this.sourceAuthorId = sourceAuthorId;
    }

    public Integer getAuthorpostNum() {
        return authorpostNum;
    }

    public void setAuthorpostNum(Integer authorpostNum) {
        this.authorpostNum = authorpostNum;
    }

    public Integer getParticipateCommentNum() {
        return participateCommentNum;
    }

    public void setParticipateCommentNum(Integer participateCommentNum) {
        this.participateCommentNum = participateCommentNum;
    }

    public Double getEngagement() {
        return engagement;
    }

    public void setEngagement(Double engagement) {
        this.engagement = engagement;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public DoubanGroupPostEntity getDoubanGroupPost() {
        return doubanGroupPost;
    }

    public void setDoubanGroupPost(DoubanGroupPostEntity doubanGroupPost) {
        this.doubanGroupPost = doubanGroupPost;
    }

    public BbsPeoplePostEntity getBbsPeoplePost() {
        return bbsPeoplePost;
    }

    public void setBbsPeoplePost(BbsPeoplePostEntity bbsPeoplePost) {
        this.bbsPeoplePost = bbsPeoplePost;
    }

    public BbsSohuPostEntity getBbsSohuPost() {
        return bbsSohuPost;
    }

    public void setBbsSohuPost(BbsSohuPostEntity bbsSohuPost) {
        this.bbsSohuPost = bbsSohuPost;
    }
}
