package com.pony_admin.controller;

import com.pony_admin.domain.RefundEntry;
import com.pony_admin.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/21
 */
@Controller
@RequestMapping(value = "/refund")
public class RefundController {
    @Autowired
    RefundService refundService;

    @RequestMapping(value = "/undoshow", method = RequestMethod.GET)
    public String showRefundPage(Model model) {
        List<RefundEntry> list = refundService.getAllRefund();
        model.addAttribute("refundList", list);
        return "refund";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> refundPage(HttpServletRequest request,
                                          HttpServletResponse response) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        return  modelMap;
    }
}
