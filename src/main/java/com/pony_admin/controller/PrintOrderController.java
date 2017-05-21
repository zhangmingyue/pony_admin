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
 * @created:17/5/10
 */
@Controller
@RequestMapping(value = "print")
public class PrintOrderController {

    @RequestMapping(value = "print_order", method = RequestMethod.GET)
    public String getAdminPage(Model model,
                               HttpServletRequest request,
                               HttpServletResponse response) {
        return "print_order";
    }
}
