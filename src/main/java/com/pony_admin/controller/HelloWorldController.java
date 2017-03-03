package com.pony_admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author: qiaoyi
 * @edit:
 * @created:17/2/23
 */
@Controller
@RequestMapping("/")
public class HelloWorldController {

    @GetMapping("/index")
    String index(Model model) {
        return "index";
    }
}