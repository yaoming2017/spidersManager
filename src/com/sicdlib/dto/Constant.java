package com.sicdlib.dto;

/**
 * Created by Yh on 2016/9/12.
 */
//数据库中的常量定义
public class Constant {
    public static final String ROLE_NORMAL_USER = "USER";
    public static final String ROLE_ADMINISTRATOR = "ADMIN";
    public static final String ROLE_SUPER_ADMINISTRATOR = "SUPADMIN";
    public static final String GROUP_NORMAL_USER = "USERGROUP";
    public static final String PARAM_SEX = "USER_SEX";//用户性别字段
    public static final String SPIDER_LOG_BASE = "SPIDER_LOGS_PATH"; //爬虫日志的根目录
    public static final String SPIDER_SOURCE_BASE = "SPIDER_SOURCE_DEST"; //爬虫源文件的根目录
    public static final String SPIDER_FILE_BASE = "SPIDER_FILES_PATH"; //爬虫图片文件的根目录
}
