package com.sicdlib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by YH on 2017/5/24.
 */
@Controller
public class EventController {

    @RequestMapping("event")
    public String event(HttpServletRequest req, HttpServletResponse resp) {

        return "event";
    }
}
