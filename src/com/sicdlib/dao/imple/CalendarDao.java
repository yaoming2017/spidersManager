package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.ICalendarDao;
import com.sicdlib.dto.TbTableEntity;
import com.sicdlib.util.HBaseUtil.HBaseData;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.lang.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
@Repository("calendarDao")
public class CalendarDao implements ICalendarDao {
    @Autowired
    private IBaseDAO baseDAO;
    private TbTableEntity tbtableentity;
    //获取表名对应的实体类名,然后反射成实体类,得到其实例
    public Object getEntity(String tablename){
        //去掉传进来的字符串中的单引号
        String newTableEntity=tablename.replaceAll("\'","");
        System.out.println(newTableEntity);
        String sql ="SELECT entityName FROM tb_table WHERE table_name = '"+ newTableEntity +"'";
        List result = baseDAO.getSqlList(sql);
        String entityname=(String)result.get(0);
        //反射获得类的对象
        Object tbTableEntity = null;
        try {
            Class<?> TBTableEntityType =Class.forName("com.sicdlib.dto.entity."+entityname);
            tbTableEntity = TBTableEntityType.newInstance();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return tbTableEntity;
    }

    public List getThead(String tablename){
        //直接用getEntity(tablename);
        try {

            HBaseData hBaseData = new HBaseData(tablename.replaceAll("\'",""));
            List<String> fields = hBaseData.getKeys(tablename.replaceAll("\'",""));
            System.out.println(fields);
            return fields;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    public List getTbody(String tablename){
//        String entityname = getEntity(tablename);
        try {
//            String newTableName= tablename.replaceAll("\'","");
//            HBaseData hBaseData = new HBaseData(newTableName);
//            ResultScanner fields = hBaseData.getAllData();
//            System.out.println("111111111111");
//            System.out.println(fields);
//            for (Result res : fields) {
//                System.out.println(res);
//            }
//            System.out.println("222222222222");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
