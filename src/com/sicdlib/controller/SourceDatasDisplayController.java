package com.sicdlib.controller;

import com.sicdlib.dto.KeyMeaningEntity;
import com.sicdlib.service.IKeyMeaningService;
import com.sicdlib.service.IWebsiteService;
import com.sicdlib.util.HBaseUtil.HBPage;
import com.sicdlib.util.HBaseUtil.HBaseData;
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
import java.util.ArrayList;
import java.util.List;

@Controller
public class SourceDatasDisplayController {

    @Autowired
    @Qualifier("keyMeaningService")
    public IKeyMeaningService keyMeaningService;

    /**
     * 源数据的展示
     * @param req
     * @param model
     * @return
     */
    @RequestMapping("source_datas")
    public String source_datas(HttpServletRequest req, Model model) {
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
        return "source_datas";
    }

    /**
     * 单表多字段展示
     * @param req
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("choose_datas")
    public String choose_datas(HttpServletRequest req, Model model) throws Exception{
        //获得hbase中的表名
        String htable = req.getParameter("htable");
        HBaseData hBaseData = new HBaseData(htable);
        //获取选中的值
        String [] show_field_ids = req.getParameterValues("show_field_id");
        //字段名
        List<String> field_list = new ArrayList<String>();
        //字段名释义
        List<String> field_meanings = new ArrayList<String>();
        for (String show_id : show_field_ids){
            KeyMeaningEntity km = keyMeaningService.getKeyMeaningById(show_id);
            String keyname = km.getKeyName();
            field_list.add(keyname);
            String keyname_meaning = km.getMeaning();
            field_meanings.add(keyname_meaning);
        }
        int pageNo = 1;
        req.getSession().setAttribute("currentPageNo", 1);
        HBPage page = new HBPage();
        page.setNextPage(1);
        //第1页，200条数据
        List list = hBaseData.getFirstPage(page);
        //存放字段名（键）
        List<String> field = new ArrayList<String>();
        //存放值
        List<List<String>> values_list = new ArrayList<List<String>>();
        //获得字段名、源数据
        for (int i = 0; i < list.size(); i++){
            Result result = (Result) list.get(i);
            List<String> values_row = new ArrayList<String>();
            for (KeyValue kv : result.list()){
                String kv_field = new String(kv.getQualifier(), "utf-8");
                for (String kname : field_list){
                    if(kv_field.equals(kname)){
                        if (i<1){
                            field.add(kv_field);
                        }
                        values_row.add(new String(kv.getValue(), "utf-8"));
                    }
                }
            }
            values_list.add(values_row);
        }
        //保存Htable表名
        req.getSession().setAttribute("htable", htable);
        //保存当前页
        model.addAttribute("curPageNo",pageNo);
        //保存开始行
        model.addAttribute("startRow", new String(hBaseData.getStartRow()));
        //获取总行数
        model.addAttribute("rowCount", hBaseData.getRowCount());
        //保存字段名
        model.addAttribute("field", field);
        req.getSession().setAttribute("field", field);
        req.getSession().setAttribute("field_meanings", field_meanings);
        //保存字段释义
        model.addAttribute("field_meanings", field_meanings);
        //保存值的数据
        model.addAttribute("values_list", values_list);
        //从首页进入，设置下一页之前的动作为-1
        model.addAttribute("nextPageFlag", -1);
        return "source_datas_display";
    }

    /**
     * 源数据——首页展示
     * @param req
     * @param model
     * @return
     */
    @RequestMapping("source_datas_display")
    public String source_datas_display(HttpServletRequest req, Model model){
        try {
            String htable = (String) req.getSession().getAttribute("htable");
            HBaseData hBaseData = new HBaseData(htable);
            int pageNo = 1;
            req.getSession().setAttribute("currentPageNo", 1);
            HBPage page = new HBPage();
            page.setNextPage(1);
            //第1页，200条数据
            List list = hBaseData.getFirstPage(page);
            //字段名
            List<String> field_list = new ArrayList<String>();
            field_list = (List<String>) req.getSession().getAttribute("field");
            List<List<String>> values_list = new ArrayList<List<String>>();
            //获得字段名、源数据
            for (int i = 0; i < list.size(); i++){
                Result result = (Result) list.get(i);
                List<String> values_row = new ArrayList<String>();
                for (KeyValue kv : result.list()){
                    String kv_field = new String(kv.getQualifier(), "utf-8");
                    for (String kname : field_list){
                        if(kv_field.equals(kname)){
                           values_row.add(new String(kv.getValue(), "utf-8"));
                        }
                    }
                }
                values_list.add(values_row);
            }

            //保存当前页
            model.addAttribute("curPageNo",pageNo);
            //保存开始行
            model.addAttribute("startRow", new String(hBaseData.getStartRow()));
            //获取总行数
            model.addAttribute("rowCount", hBaseData.getRowCount());
            model.addAttribute("field", field_list);
            model.addAttribute("values_list", values_list);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "source_datas_display";
    }

    /**
     * 源数据——前一页、下一页、最后一页的展示
     * @param req
     * @param model
     * @return
     */
    @RequestMapping("get_cur_pre_next_page")
    public String get_cur_pre_next_page(HttpServletRequest req, Model model){
        String htable = (String) req.getSession().getAttribute("htable");
        String next_page_flag = req.getParameter("nextPageFlag");
        HBPage page = new HBPage();
        byte [] pageStartRowKey = null;
        try {
            Integer curPage = Integer.valueOf(req.getParameter("curPage").toString());
            page.setNextPage(curPage);
            String startRow = req.getParameter("startRow");
            page.setPageStartRowKey(startRow.getBytes());
            HBaseData hBaseData = new HBaseData(htable);
            List list = null;
            int currentPageNo = Integer.parseInt(req.getSession().getAttribute("currentPageNo").toString());
            System.out.println("上一次页数："+currentPageNo+",当前页："+curPage);
            //下一页
            if(curPage > currentPageNo && curPage > 0) {
                list = hBaseData.getNext(page);
                pageStartRowKey = hBaseData.getStartRow();
                System.out.println("下一页开始："+ new String(page.getPageStartRowKey()));
                req.getSession().setAttribute("currentPageNo", curPage);
                //保存当前页
                model.addAttribute("curPageNo",curPage);
                //保存开始行
                model.addAttribute("startRow", new String(pageStartRowKey));
                //设置下一页标志，1为点击下一页，0为点击上一页
                model.addAttribute("nextPageFlag", 1);
            }
            //上一页
            if(curPage < currentPageNo && curPage >= 0){
                if(next_page_flag.equals("1")){
                    //前一个动作点击的是下一页
                    page.setNextPage(1);
                }
                if(next_page_flag.equals("0")){
                    //前一个动作点击的是前一页
                    page.setNextPage(0);
                }
                list = hBaseData.getPrePage(page);
                pageStartRowKey = hBaseData.getStartRow();
                req.getSession().setAttribute("currentPageNo", curPage);
                //保存当前页
                model.addAttribute("curPageNo",curPage);
                //保存开始行
                model.addAttribute("startRow", new String(pageStartRowKey));
                //设置下一页标志，1为点击下一页，0为点击上一页
                model.addAttribute("nextPageFlag", 0);
            }
            //设curPage为-1时，为最后一页，pageSize为最后一页大小
            if(curPage == -1){
                int pageSize = (int)hBaseData.getRowCount() % 200;
                int lastPageNo = (int)hBaseData.getRowCount() / 200 + 1;
                list = hBaseData.getlastData(pageSize);
                //保存当前页
                model.addAttribute("curPageNo",lastPageNo);
                //保存开始行
                model.addAttribute("startRow", new String(hBaseData.getStartRow()));
            }
            //字段名
            List<String> field_list = new ArrayList<String>();
            field_list = (List<String>) req.getSession().getAttribute("field");
            List<List<String>> values_list = new ArrayList<List<String>>();
            //获得字段名、源数据
            for (int i = 0; i < list.size(); i++){
                Result result = (Result) list.get(i);
                List<String> values_row = new ArrayList<String>();
                for (KeyValue kv : result.list()){
                    String kv_field = new String(kv.getQualifier(), "utf-8");
                    for (String kname : field_list){
                        if(kv_field.equals(kname)){
                            values_row.add(new String(kv.getValue(), "utf-8"));
                        }
                    }
                }
                values_list.add(values_row);
            }
            //获取总行数
            model.addAttribute("rowCount", hBaseData.getRowCount());
            model.addAttribute("field", field_list);
            model.addAttribute("values_list", values_list);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "source_datas_display";
    }


}
