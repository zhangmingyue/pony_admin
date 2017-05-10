package com.pony_admin.controller;

import com.pony_admin.domain.User;
import com.pony_admin.service.PermissionService;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/5
 */
@Controller
@RequestMapping(value = "")
public class LoginController {
    private static final Logger logger = Logger.getLogger(LoginController.class);
    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginForm() {
        ModelAndView model = new ModelAndView();
        model.addObject("user", new User());
        model.setViewName("login");
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Valid User user, BindingResult bindingResult, RedirectAttributes redirectAttributes,
                        HttpServletRequest request,
                        HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            return "redirect:login";
        }

        String userName = request.getParameter("user");
        String password = request.getParameter("password");
        //验证
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        token.setRememberMe(true);
        //获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        try {
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
            currentUser.login(token);
        } catch (UnknownAccountException uae) {
            redirectAttributes.addFlashAttribute("message", "未知账户");
        } catch (IncorrectCredentialsException ice) {
            redirectAttributes.addFlashAttribute("message", "密码不正确");
        } catch (LockedAccountException lae) {
            redirectAttributes.addFlashAttribute("message", "账户已锁定");
        } catch (ExcessiveAttemptsException eae) {
            redirectAttributes.addFlashAttribute("message", "用户名或密码错误次数大于5次,账户已锁定");
        } catch (DisabledAccountException sae) {
            redirectAttributes.addFlashAttribute("message", "帐号已经禁止登录");
        } catch (AuthenticationException ae) {
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            ae.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "用户名或密码不正确");
        }
        //验证是否登录成功
        if (currentUser.isAuthenticated()) {
            //把当前用户放入session
            Session session = currentUser.getSession();
            User tUser = permissionService.getUserByUserNameAndPassword(userName, password);
            session.setAttribute("currentUser", tUser);
            return "index";
        } else {
            token.clear();
            return "redirect:login";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(RedirectAttributes redirectAttributes) {
        //使用权限管理工具进行用户的退出，跳出登录，给出提示信息
        SecurityUtils.getSubject().logout();
        redirectAttributes.addFlashAttribute("message", "您已安全退出");
        return "redirect:login";
    }

    @RequestMapping("/403")
    public String unauthorizedRole() {
        logger.info("------没有权限-------");
        return "403";
    }
}
