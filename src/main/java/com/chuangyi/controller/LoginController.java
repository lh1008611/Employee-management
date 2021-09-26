package com.chuangyi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        HttpSession session, Model model) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {   //登陆成功
            session.setAttribute("loginUser", username);
            return "redirect:/index.html";
        } else {
            model.addAttribute("msg", "用户名或密码错误");
            return "login";
        }
    }
}
