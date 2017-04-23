package com.sicdlib.controller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sicdlib.dto.WebsiteEntity;
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
    @Qualifier("websiteService")
    private IWebsiteService websiteService;

    @RequestMapping("addNewSpider")
    public String listWebsites(Model model) {
        List<WebsiteEntity> wsList = websiteService.listAllWebsite();
        model.addAttribute("wsList", wsList);

        return "addNewSpider";
    }

    @RequestMapping(value = "saveSpider", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String sync(
            @RequestParam(value = "file", required = false) MultipartFile file,
            HttpServletRequest request, HttpServletResponse response)
            throws IOException {


        if (request.getParameter("chunk") == null) {

            String realPath = request.getSession().getServletContext()
                    .getRealPath("/Upload/");
            String fileName = file.getOriginalFilename();

            File targetFile = new File(realPath, fileName);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            file.transferTo(targetFile); // 小文件，直接拷贝

            return "";
        } else {
            int chunk = Integer.parseInt(request.getParameter("chunk")); // 当前分片
            int chunks = Integer.parseInt(request.getParameter("chunks")); // 分片总计

            String realPath = request.getSession().getServletContext()
                    .getRealPath("/Upload/");

            String Ogfilename = file.getOriginalFilename();

            File tempFile = new File(realPath, Ogfilename);
            OutputStream outputStream = new FileOutputStream(tempFile, true);
            InputStream inputStream = file.getInputStream();

            byte buffer[] = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, len);
            }
            inputStream.close();
            outputStream.close();

            return "";
        }

    }
}
