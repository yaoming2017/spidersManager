package com.sicdlib.util.HBaseUtil;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.*;
import java.io.IOException;

/**
 * Created by init on 2017/4/18.
 */
public class Config {
    public static Configuration getConf() {

        //取得一个数据库连接的配置参数对象
        Configuration conf = HBaseConfiguration.create();
        //设置连接参数：HBase数据库所在的主机IP
        conf.set("hbase.zookeeper.quorum", "115.154.137.58");
        // 设置连接参数：HBase数据库使用的端口
        conf.set("hbase.zookeeper.property.clientPort", "2181");
        try {
        //取得一个数据库连接对象
        Connection connection = null;
            connection = (Connection) ConnectionFactory.createConnection(conf);
        //取得一个数据库元数据操作对象
        Admin admin = connection.getAdmin();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return conf;
    }
}
