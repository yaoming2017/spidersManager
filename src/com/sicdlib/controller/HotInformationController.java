package com.sicdlib.controller;

import com.sicdlib.dto.TableHotValue;
import com.sicdlib.dto.TbEventArticleEntity;
import com.sicdlib.dto.entity.DoubanGroupPostEntity;
import com.sicdlib.service.IArticleSimiService;
import com.sicdlib.service.IEventArticleService;
import com.sicdlib.service.IEventService;
import com.sicdlib.service.IHotWordsService;
import com.sicdlib.service.pythonService.IDoubanGroupPostService;
import com.sicdlib.util.ForeUtil.HotValueUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by YH on 2017/5/24.
 */
@Controller
public class HotInformationController {
    @Autowired
    @Qualifier("eventService")
    private IEventService eventService;

    @Autowired
    @Qualifier("hotWordsService")
    private IHotWordsService hotWordsService;

    @Autowired
    @Qualifier("articleSimiService")
    private IArticleSimiService articleSimiService;

    @Autowired
    @Qualifier("eventArticleService")
    private IEventArticleService eventArticleService;

    @Autowired
    @Qualifier("doubanGroupPostService")
    private IDoubanGroupPostService doubanGroupPostService;

    @RequestMapping("hotInformation")
    public String hotInformation(HttpServletRequest req, Model model) {
        String eventID = "0b5bea37-d934-4a7a-850c-8e08eab25d54";
        eventID = req.getParameter("eventID");
        List<TbEventArticleEntity> eventArticles = eventArticleService.getEventArticleByEventID(eventID);
        //获得热度值
        List<TableHotValue> tableHotValues = HotValueUtil.getTableHotValueByArticles(eventArticles);
        List<TableHotValue> tableHotValuestop10 = new ArrayList<TableHotValue>();
        List<TableHotValue> tableHotValuestop10_doubans = new ArrayList<TableHotValue>();
        List<TableHotValue> tableHotValuestop10_bbsPeoples = new ArrayList<TableHotValue>();
//        List<TableHotValue> tableHotValuestop10_xinhuanews = new ArrayList<TableHotValue>();
        int top10flag = 0;
        int top10_doubanflag = 0;
        int top10_bbsPeopleflag = 0;
//        int top10_xinhuanewsflag = 0;
        for (int i = 0;top10flag < 10 && top10_doubanflag < 10 && top10_bbsPeopleflag < 10|| i < tableHotValues.size(); i++){
            //获得所有网站热度前10条信息
            if(top10flag < 10){
                tableHotValuestop10.add(tableHotValues.get(i));
                top10flag++;
            }
            //豆瓣小组：热度前10条
            if (top10_doubanflag < 10 && tableHotValues.get(i).getDoubanGroupPost() != null) {
                tableHotValuestop10_doubans.add(tableHotValues.get(i));
                top10_doubanflag ++;
            }
            //人民网bbs：热度前10条
            if (top10_bbsPeopleflag < 10 && tableHotValues.get(i).getBbsPeoplePost() != null) {
                tableHotValuestop10_bbsPeoples.add(tableHotValues.get(i));
                top10_bbsPeopleflag ++;
            }
//            //新华网：热度前10条
//            if (top10_xinhuanewsflag < 10 && tableHotValues.get(i).getXinhuaNews() != null) {
//                tableHotValuestop10_xinhuanews.add(tableHotValues.get(i));
//                top10_xinhuanewsflag ++;
//            }
        }
        System.out.println(tableHotValuestop10.size() + ":" + tableHotValuestop10_doubans.size() + ":" + tableHotValuestop10_bbsPeoples.size());
        model.addAttribute("tableHotValuestop10", tableHotValuestop10);
        model.addAttribute("tableHotValuestop10_doubans", tableHotValuestop10_doubans);
        model.addAttribute("tableHotValuestop10_bbsPeoples", tableHotValuestop10_bbsPeoples);
//        model.addAttribute("tableHotValuestop10_xinhuanews", tableHotValuestop10_xinhuanews);
        return "hotInformation";
    }

}
