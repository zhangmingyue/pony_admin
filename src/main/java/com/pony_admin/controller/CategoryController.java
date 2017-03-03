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
 * @created:17/3/3
 */
@Controller
@RequestMapping(value = "category")
public class CategoryController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showCategory(Model model,
                               HttpServletRequest request,
                               HttpServletResponse response) {
        return "category";

    }
}
