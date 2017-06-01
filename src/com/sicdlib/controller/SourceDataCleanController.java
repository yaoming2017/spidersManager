package com.sicdlib.controller;

import com.sicdlib.dto.*;
import com.sicdlib.dto.CleanDataEntity;
import com.sicdlib.dto.CleanDataProcessEntity;
import com.sicdlib.dto.CleanDataProcessUserEntity;
import com.sicdlib.service.ICleanDataProcessService;
import com.sicdlib.service.ICleanDataProcessUserService;
import com.sicdlib.service.ICleanDataService;
import com.sicdlib.service.IKeyMeaningService;
import com.sicdlib.util.CleanDataUtil.CleanInputUtil;
import com.sicdlib.util.HBaseUtil.HBPage;
import com.sicdlib.util.HBaseUtil.HBaseData;
import net.sf.json.JsonConfig;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class SourceDataCleanController {

    @Autowired
    @Qualifier("keyMeaningService")
    public IKeyMeaningService keyMeaningService;

    @Autowired
    @Qualifier("cleanDataService")
    public ICleanDataService cleanDataService;

    @Autowired
    @Qualifier("cleanDataProcessService")
    public ICleanDataProcessService cleanDataProcessService;

    @Autowired
    @Qualifier("cleanDataProcessUserService")
    public ICleanDataProcessUserService cleanDataProcessUserService;

    /**
     * 清洗时源数据的展示
     * @param req
     * @param model
     * @return
     */
    @RequestMapping("source_data")
    public String source_data(HttpServletRequest req, Model model) {
        try {
            /**
             * 中华网
             */
            //中华网 - 作者
            String htable_name = "bbs_china_author";
            HBaseData hBaseData = new HBaseData(htable_name);
            List<String> bbs_china_author_fields = hBaseData.getKeys(htable_name);
            model.addAttribute("bbs_china_author_fields", bbs_china_author_fields);
            List<KeyMeaningEntity> bbs_china_author_keyMeaningEntities = keyMeaningService.getKeyMeanings(htable_name);
            model.addAttribute("bbs_china_author_keyMeanings", bbs_china_author_keyMeaningEntities);

            //中华网 - 评论
            htable_name = "bbs_china_comment";
            hBaseData = new HBaseData(htable_name);
            List<String> bbs_china_comment_fields = hBaseData.getKeys(htable_name);
            model.addAttribute("bbs_china_comment_fields", bbs_china_comment_fields);
            List<KeyMeaningEntity> bbs_china_comment_keyMeaningEntities = keyMeaningService.getKeyMeanings(htable_name);
            model.addAttribute("bbs_china_comment_keyMeanings", bbs_china_comment_keyMeaningEntities);

            //中华网 - 发布
            htable_name = "bbs_china_post";
            hBaseData = new HBaseData(htable_name);
            List<String> bbs_china_post_fields = hBaseData.getKeys(htable_name);
            model.addAttribute("bbs_china_post_fields", bbs_china_post_fields);
            List<KeyMeaningEntity> bbs_china_post_keyMeaningEntities = keyMeaningService.getKeyMeanings(htable_name);
            model.addAttribute("bbs_china_post_keyMeanings", bbs_china_post_keyMeaningEntities);

            /**
             * 豆瓣小组
             */
            //豆瓣小组 - 作者
            htable_name = "douban_group_author";
            hBaseData = new HBaseData(htable_name);
            List<String> douban_group_author_fields = hBaseData.getKeys(htable_name);
            model.addAttribute("douban_group_author_fields", douban_group_author_fields);
            List<KeyMeaningEntity> douban_group_author_keyMeaningEntities = keyMeaningService.getKeyMeanings(htable_name);
            model.addAttribute("douban_group_author_keyMeanings", douban_group_author_keyMeaningEntities);

            //豆瓣小组 - 评论
            htable_name = "douban_group_comment";
            hBaseData = new HBaseData(htable_name);
            List<String> douban_group_comment_fields = hBaseData.getKeys(htable_name);
            model.addAttribute("douban_group_comment_fields", douban_group_comment_fields);
            List<KeyMeaningEntity> douban_group_comment_keyMeaningEntities = keyMeaningService.getKeyMeanings(htable_name);
            model.addAttribute("douban_group_comment_keyMeanings", douban_group_comment_keyMeaningEntities);

            //豆瓣小组 - 粉丝
            htable_name = "douban_group_fans";
            hBaseData = new HBaseData(htable_name);
            List<String> douban_group_fans_fields = hBaseData.getKeys(htable_name);
            model.addAttribute("douban_group_fans_fields", douban_group_fans_fields);
            List<KeyMeaningEntity> douban_group_fans_keyMeaningEntities = keyMeaningService.getKeyMeanings(htable_name);
            model.addAttribute("douban_group_fans_keyMeanings", douban_group_fans_keyMeaningEntities);

            //豆瓣小组 - 发布
            htable_name = "douban_group_post";
            hBaseData = new HBaseData(htable_name);
            List<String> douban_group_post_fields = hBaseData.getKeys(htable_name);
            model.addAttribute("douban_group_post_fields", douban_group_post_fields);
            List<KeyMeaningEntity> douban_group_post_keyMeaningEntities = keyMeaningService.getKeyMeanings(htable_name);
            model.addAttribute("douban_group_post_keyMeanings", douban_group_post_keyMeaningEntities);

            /**
             * 人民网
             */
            htable_name = "people_news";
            hBaseData = new HBaseData(htable_name);
            List<String> people_news_fields = hBaseData.getKeys(htable_name);
            System.out.println("人民网:"+people_news_fields);
            model.addAttribute("people_news_fields", people_news_fields);
            List<KeyMeaningEntity> people_news_keyMeaningEntities = keyMeaningService.getKeyMeanings(htable_name);
            model.addAttribute("people_news_keyMeanings", people_news_keyMeaningEntities);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "source_data";
    }

    /**
     * 最新的多表多字段展示
     * @param req
     * @param model
     * @return
     */
    @RequestMapping("choose_data")
    public String choose_data(HttpServletRequest req, Model model) throws Exception{
        String [] show_field_ids = req.getParameterValues("show_field_id");
        /**
         * 获得多表多字段数据
         */
        //表与字段名（父ID和字段名）
        //先得到FID，存入list中，然后遍历list，将km存入kms中
        List<TableFields> tableFieldsList = new ArrayList<TableFields>();
        //首先从show_field_id获得选中的字段的父IDs
        List<String> fids = new ArrayList<String>();
        for (int i = 0 ;i<show_field_ids.length; i++) {
            String id = show_field_ids[i];
            KeyMeaningEntity km = keyMeaningService.getKeyMeaningById(id);
            if (!fids.contains(km.getFid())) {
                fids.add(km.getFid());
            }
        }
        for (int i = 0; i<fids.size(); i++){
            TableFields tableFields = new TableFields();
            List<KeyMeaningEntity> keyMeaningEntities = new ArrayList<KeyMeaningEntity>();
            tableFields.setFid(fids.get(i));
            for (String show_id : show_field_ids) {
                KeyMeaningEntity km = keyMeaningService.getKeyMeaningById(show_id);
                if (tableFields.getFid().equals(km.getFid())) {
                    keyMeaningEntities.add(km);
                }
            }
            //设置fields
            tableFields.setFields(keyMeaningEntities);
            KeyMeaningEntity fid_km = keyMeaningService.getKeyMeaningById(fids.get(i));
            //设置htable
            tableFields.setHtable(fid_km);
            //添加到list中
            tableFieldsList.add(tableFields);
        }
        //获得TableFields中的htable中的表名
        for (TableFields tableFields : tableFieldsList){
           String htable = tableFields.getHtable().getKeyName();
            HBaseData hBaseData = new HBaseData(htable);
            //获取hbase中的值
            HBPage page = new HBPage();
            page.setNextPage(1);
            //第1页，200条数据
            List list = hBaseData.getFirstPage(page);
            //存放值
            List<List<String>> values_list = new ArrayList<List<String>>();
            //获得字段名、源数据
            for (int i = 0; i < list.size(); i++){
                Result result = (Result) list.get(i);
                List<String> values_row = new ArrayList<String>();
                for (KeyValue kv : result.list()){
                    String kv_field = new String(kv.getQualifier(), "utf-8");
                    //获得相关的Htable
                    for (KeyMeaningEntity keymeaning : tableFields.getFields()){
                        if (keymeaning.getKeyName().equals(kv_field)){
                            values_row.add(new String(kv.getValue(), "utf-8"));
                        }
                    }
                }
                values_list.add(values_row);
            }
            tableFields.setValues(values_list);
        }
        model.addAttribute("tableFieldsList", tableFieldsList);
        /**
         * 获得数据清洗策略表中数据（CleanData和CleanDataProcess）
         */
        List<CleanDataEntity> cleanDataEntityList = cleanDataService.getAllCleanData();
        model.addAttribute("cleanDataEntityList", cleanDataEntityList);

        return "source_data_display";
    }

    /**
     * 通过CleanDataId获得CleanDataProcess
     * @param req
     * @param resp
     * @throws IOException
     */
    @RequestMapping("getcleanDataProcessByCleanDataId")
    public void getcleanDataProcessByCleanDataId(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String cid = req.getParameter("cid");
        List<CleanDataProcessEntity> cleanDataProcessEntityList = cleanDataProcessService.getCleanDataProcessByCleanDataId(cid);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
//        //利用阿里的Json包，fastjson.jar
//        String jsonStr = JSON.toJSONString(cleanDataProcessEntityList);
//        System.out.println("获得的Json："+jsonStr);
        JsonConfig config = new JsonConfig();
//        config.setJsonPropertyFilter(new PropertyFilter() {
//            @Override
//            public boolean apply(Object source, String name, Object value) {
//                if (name.equals("cleanDataEntity")||name.equals("cleanDataEntity")){
//                    return true;
//                }else{
//                    return false;
//                }
//
//            }
//        });
        config.setIgnoreDefaultExcludes(false);     //设置默认忽略
        config.setExcludes(new String [] {"cleanDataEntity", "cleanDataProcessUserEntitySet"}); //除去“cleanDataEntity”,“cleanDataProcessUserEntitySet”属性
        String jsonStr = net.sf.json.JSONArray.fromObject(cleanDataProcessEntityList, config).toString();
        out.print(jsonStr);
        System.out.println("获得的Json："+jsonStr);
        out.flush();
        out.close();
    }

    @RequestMapping("clean_detailed_method")
    public String clean_detail_method(HttpServletRequest req, Model model){
        //获得htable中数据的fields
        String chose_fields = req.getParameter("chose_fields");
        System.out.println(chose_fields);
        //获得选中的清洗数据方法clean_data_process中的值
        String process_id = req.getParameter("process_id");
        String custom_value = "";
        System.out.println(chose_fields + ":" + process_id);
        //截取chose_fields字符串：
        String [] table_fields = chose_fields.split(",");
        CleanInputUtil.insertCleanInput(table_fields);
//        for (String tf : table_fields){
//            System.out.println(tf);
//            String [] fields = tf.split(":");
//            CleanInputEntity cleanInput = new CleanInputEntity();
//
//        }
        UserEntity user = (UserEntity)req.getSession().getAttribute("user");
        CleanDataProcessEntity cleanDataProcess = cleanDataProcessService.getCleanDataProcessById(process_id);
        if(cleanDataProcess.getName().equals("自定义方法")){
            custom_value = req.getParameter("custom_value");
        }
        //保存cleanDataProcessUser
        CleanDataProcessUserEntity cleanDataProcessUser = new CleanDataProcessUserEntity();
        cleanDataProcessUser.setUser(user);
        cleanDataProcessUser.setCleanDataProcess(cleanDataProcess);
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = formatter.format(currentTime);
        cleanDataProcessUser.setCustomTime(date);
        cleanDataProcessUser.setCustomValue(custom_value);
        cleanDataProcessUser.setUserProcessLogUrl("logUrl");
        Boolean flag = cleanDataProcessUserService.addCleanDataProcessUser(cleanDataProcessUser);
        return "";
    }

    @RequestMapping("test")
    public String test(HttpServletRequest req, Model model){
        /**
         * 获得数据清洗策略表中数据（CleanData和CleanDataProcess）
         */
        List<CleanDataEntity> cleanDataEntityList = cleanDataService.getAllCleanData();
        model.addAttribute("cleanDataEntityList", cleanDataEntityList);
        return "source_data_display";
    }

}
