package com.sicdlib.controller;

import com.sicdlib.service.IRunSpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by YH on 2017/5/8.
 */
@Controller
public class RunSpiderController {
    @Autowired
    @Qualifier("runSpiderService")
    private IRunSpiderService runSpiderService;

    @RequestMapping("runSpider")
    public void runSpider(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String spiderID = req.getParameter("spiderID");
        String configID = req.getParameter("configID");

        String result = runSpiderService.runSpider(spiderID, configID);

        PrintWriter out = resp.getWriter();
        if(result.equals("ERROR")) {
            out.write("error");
        } else {
            out.write(result);
        }

        out.flush();
        out.close();
    }
}
