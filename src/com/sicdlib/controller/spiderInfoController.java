package com.sicdlib.controller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sicdlib.dto.SpiderInfoEntity;
import com.sicdlib.dto.WebsiteEntity;
import com.sicdlib.service.IDataDictService;
import com.sicdlib.service.ISpiderService;
import com.sicdlib.service.IWebsiteService;
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
import java.util.List;

/**
 * Created by haoyang on 2017/4/23.
 */
@Controller
public class spiderInfoController {
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

        boolean result = spiderService.saveSpiderInfo(req, spiderInfo);

        PrintWriter out = res.getWriter();
        if(result) {
            out.print("success");
        } else {
            out.print("failure");
        }
    }
}
