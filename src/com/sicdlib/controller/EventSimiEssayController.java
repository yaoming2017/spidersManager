package com.sicdlib.controller;

import com.sicdlib.dto.entity.DoubanGroupPostEntity;
import com.sicdlib.service.IDoubanGroupPostService;
import com.sicdlib.util.NLPUtil.Word2VecUtil.OtherUtil.Segment;
import org.ansj.library.UserDefineLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Controller
public class EventSimiEssayController {
    @Autowired
    @Qualifier("doubanGroupPostService")
    private IDoubanGroupPostService doubanGroupPostService;

    @RequestMapping("eventSimiEssayList")
    public String eventSimiEssayList(HttpServletRequest req, Model model) {
        //1.获得豆瓣小组发布的所有信息
        List<DoubanGroupPostEntity> doubanGroupPostList = doubanGroupPostService.getAllDoubanGroupPost();
        //2.将所有信息分词并写入doubanpostNoPOS.txt文件中
        try {
            FileWriter writer = new FileWriter("D:\\project\\spidersManager\\data\\doubanpostNoPOS.txt", true);
            for (DoubanGroupPostEntity db : doubanGroupPostList){
                UserDefineLibrary.insertWord("一带一路", "n", 1000);
                String wordsStr = "";
                List<String> words = Segment.getWords(db.getContent());
                for (String s : words){
                    wordsStr = wordsStr + s + " ";
                }
                System.out.println(wordsStr+"\n");
                writer.write(wordsStr + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "success";
    }

}
