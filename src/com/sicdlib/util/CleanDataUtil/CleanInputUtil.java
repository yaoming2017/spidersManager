package com.sicdlib.util.CleanDataUtil;

import com.sicdlib.dto.CleanInputEntity;
import com.sicdlib.service.ICleanInputService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by DeMH on 2017/5/17.
 */
public class CleanInputUtil {

    static ApplicationContext apx = new ClassPathXmlApplicationContext("beans.xml");
    //项目的输入：
    public static boolean insertCleanInput(String [] table_fields){
        ICleanInputService cleanInputService = (ICleanInputService)apx.getBean("cleanInputService");
        for (String tf : table_fields){
            System.out.println(tf);
            String [] fields = tf.split(":");
            CleanInputEntity cleanInput = new CleanInputEntity();
            cleanInput.setTableName(fields[0]);
            cleanInput.setFieldName(fields[1]);
            cleanInputService.addCleanInput(cleanInput);
        }
        return true;
    }

}
