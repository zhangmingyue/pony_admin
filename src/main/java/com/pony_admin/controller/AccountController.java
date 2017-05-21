package com.pony_admin.controller;

import com.pony_admin.domain.SelfServiceUser;
import com.pony_admin.domain.User;
import com.pony_admin.service.PermissionService;
import com.pony_admin.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/5/10
 */
@Controller
@RequestMapping(value = "account")
public class AccountController {

    @Autowired
    PermissionService permissionService;
    @Autowired
    SelfService selfService;

    @RequestMapping(value = "admin", method = RequestMethod.GET)
    public String getAdminPage(Model model,
                               HttpServletRequest request,
                               HttpServletResponse response) {
        return "account_admin";
    }

    @RequestMapping(value = "admin", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getData(HttpServletRequest request,
                                       HttpServletResponse response) {
        Map<String, Object> model = new HashMap<>();
        String nickname = request.getParameter("nickname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Date now = new Date();
        User user = new User();
        user.setNickname(nickname);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPassword(password);
        user.setCreate_time(now);
        user.setLast_login_time(now);
        user.setStatus(0);
        user.setRole(0);

        if (permissionService.insert(user) >= 1) {
            model.put("result", true);
            return model;
        }

        model.put("result", false);
        model.put("msg", "服务器未知错误");
        return model;
    }

    @RequestMapping(value = "self_service_admin", method = RequestMethod.GET)
    public String getSelfServiceAdminPage(Model model,
                               HttpServletRequest request,
                               HttpServletResponse response) {
        return "self_service_account_admin";
    }

    @RequestMapping(value = "self_service_admin", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getSelfSeriveData(HttpServletRequest request,
                                       HttpServletResponse response) {
        Map<String, Object> model = new HashMap<>();
        String nickname = request.getParameter("nickname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Date now = new Date();
        SelfServiceUser user = new SelfServiceUser();
        user.setNickname(nickname);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPassword(password);
        user.setCreate_time(now);
        user.setLast_login_time(now);
        user.setStatus(0);
        user.setRole(0);

        if (selfService.insert(user) >= 1) {
            model.put("result", true);
            return model;
        }

        model.put("result", false);
        model.put("msg", "服务器未知错误");
        return model;
    }

}
