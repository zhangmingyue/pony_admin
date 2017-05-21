package com.pony_admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author: qiaoyi
 * @edit:
 * @created:17/2/23
 */
@Controller
@RequestMapping("")
public class HelloWorldController {

    @RequestMapping(value = {"", "/", "index"}, method = RequestMethod.GET)
    public String getAdminPage(Model model,
                               HttpServletRequest request,
                               HttpServletResponse response) {
        return "index";
    }

}