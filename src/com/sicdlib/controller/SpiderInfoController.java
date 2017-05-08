package com.sicdlib.controller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;
import com.sicdlib.dto.Constant;
import com.sicdlib.dto.SpiderInfoEntity;
import com.sicdlib.dto.WebsiteEntity;
import com.sicdlib.service.IDataDictService;
import com.sicdlib.service.ISpiderService;
import com.sicdlib.service.IWebsiteService;
import com.sicdlib.service.imple.DataDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by haoyang on 2017/4/23.
 */
@Controller
public class SpiderInfoController {
    @Autowired
    @Qualifier("dataDictService")
    private IDataDictService dataDictService;

    @Autowired
    @Qualifier("websiteService")
    private IWebsiteService websiteService;

    @Autowired
    @Qualifier("spiderService")
    private ISpiderService spiderService;

    @RequestMapping("addNewSpider")
    public String listWebsites(Model model) {
        List<WebsiteEntity> wsList = websiteService.listAllWebsite();
        model.addAttribute("wsList", wsList);

        return "addNewSpider";
    }

    @RequestMapping(value = "saveSpiderFile", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String sync(
            @RequestParam(value = "file", required = false) MultipartFile file,
            HttpServletRequest req)
            throws IOException {
        String filePath = dataDictService.getDataDictValue("SPIDER_SOURCE_TMP").get(0);
        String realPath = req.getSession().getServletContext().getRealPath(filePath);
//        String fileName = file.getOriginalFilename();
        String fileName = req.getParameter("uid");
        File targetFile = new File(realPath, fileName);

        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        
        if (req.getParameter("chunk") == null) {
            file.transferTo(targetFile); // 小文件，直接拷贝
        } else {
            OutputStream outputStream = new FileOutputStream(targetFile, true);
            InputStream inputStream = file.getInputStream();

            byte buffer[] = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, len);
            }
            inputStream.close();
            outputStream.close();
        }
        return "";
    }

    @RequestMapping("saveSpiderInfo")
    public void saveSpider(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String spiderName = req.getParameter("spiderName");
        String websiteID = req.getParameter("websiteID");
        String fileID = req.getParameter("fileID");
        String fileName = req.getParameter("fileName");
        if(fileName.endsWith(".zip")) {
            fileName = fileName.substring(0, fileName.length() - 4);
        }

        SpiderInfoEntity spiderInfo = new SpiderInfoEntity();
        spiderInfo.setSpiderName(spiderName);
        spiderInfo.setWebsiteId(websiteID);
        spiderInfo.setFileId(fileID);
        spiderInfo.setFileName(fileName);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDate = df.format(new Date());
        spiderInfo.setAddTime(currentDate);

        String spiderID = spiderService.saveSpiderInfo(req, spiderInfo);

        Map<String, String> param = new HashMap<>();

        PrintWriter out = res.getWriter();
        if(!spiderID.equals("")) {
            param.put("result", "success");
            param.put("spiderID", spiderID);
        } else {
            param.put("result", "failure");
            param.put("spiderID", spiderID);
        }
        Gson gson = new Gson();
        String paramJson = gson.toJson(param);

        out.write(paramJson);
        out.flush();
        out.close();
    }

    @RequestMapping("viewSpiderConfig")
    public String getSpiderInfo(Model model) {
        List<Object[]> infoList = spiderService.getAllSpiderInfoWebsite();

        model.addAttribute("spiderInfoList", infoList);

        return "viewSpiderConfig";
    }

    @RequestMapping("updateSpiderConfig")
    public String updateSpiderConfig(HttpServletRequest req, Model model) {
        String spiderID = req.getParameter("spiderID");

        //获取spider和website的信息
        List<Object[]> spiderInfo = spiderService.getSpiderInfoWebsite(spiderID);

        //获取所有的website的信息
        List<WebsiteEntity> websites = websiteService.listAllWebsite();

        model.addAttribute("spiderID", spiderID);
        model.addAttribute("spiderInfo", spiderInfo.get(0));
        model.addAttribute("websiteList", websites);

        return "update-spider";
    }

    @RequestMapping("updateSpider")
    public String updateSpider(HttpServletRequest req, Model model) {
        String spiderID = req.getParameter("spiderID");
        String spiderName = req.getParameter("spiderName");
        String websiteId = req.getParameter("website-name");

        spiderService.updateSpiderInfo(spiderID, spiderName, websiteId);

        List<Object[]> infoList = spiderService.getAllSpiderInfoWebsite();

        model.addAttribute("spiderInfoList", infoList);

        return "viewSpiderConfig";
    }
}
