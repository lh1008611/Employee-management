package com.chuangyi.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        登陆成功后存用户session
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser == null) {    //没有登录
            request.setAttribute("msg", "无权限，请先登录");
            System.out.println("进入拦截器且未登录");
            request.getRequestDispatcher("/login.html").forward(request, response);
            System.out.println("已转发");
            return false;
        } else {
            System.out.println("进入拦截器,已登录");
            return true;
        }
    }

}
